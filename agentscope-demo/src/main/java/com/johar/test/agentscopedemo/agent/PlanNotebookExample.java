package com.johar.test.agentscopedemo.agent;

import com.johar.test.agentscopedemo.tool.PlanNotebookToolExample;
import com.johar.test.agentscopedemo.utils.ExampleUtils;
import com.johar.test.agentscopedemo.utils.MsgUtils;
import io.agentscope.core.ReActAgent;
import io.agentscope.core.formatter.dashscope.DashScopeChatFormatter;
import io.agentscope.core.hook.Hook;
import io.agentscope.core.hook.HookEvent;
import io.agentscope.core.hook.PostActingEvent;
import io.agentscope.core.memory.InMemoryMemory;
import io.agentscope.core.message.Msg;
import io.agentscope.core.message.MsgRole;
import io.agentscope.core.message.TextBlock;
import io.agentscope.core.model.DashScopeChatModel;
import io.agentscope.core.plan.PlanNotebook;
import io.agentscope.core.plan.model.Plan;
import io.agentscope.core.plan.model.SubTask;
import io.agentscope.core.tool.Toolkit;
import reactor.core.publisher.Mono;

import java.util.List;

import static com.johar.test.agentscopedemo.tool.PlanNotebookToolExample.fileStorage;
import static io.agentscope.core.plan.model.SubTaskState.TODO;

/**
 * @author : [johar]
 * @description : [一句话描述该类的功能]
 * @createTime : [2026/3/29 12:07]
 * @updateUser : [johar]
 * @updateTime : [2026/3/29 12:07]
 * @updateRemark : [说明本次修改内容]
 * @since : [v1.0]
 */
public class PlanNotebookExample {

    public static void main(String[] args) throws Exception {
        ExampleUtils.printWelcome(
                "PlanNotebook Example",
                "Watch how the agent creates and executes a plan step-by-step!");

        String apiKey = ExampleUtils.getDashScopeApiKey();

        // Setup tools and PlanNotebook
        Toolkit toolkit = new Toolkit();
        toolkit.registerTool(new PlanNotebookToolExample());

        PlanNotebook planNotebook = PlanNotebook.builder().build();

        // Create hook to visualize plan changes
        Hook planVisualizationHook =
                new Hook() {
                    @Override
                    public <T extends HookEvent> Mono<T> onEvent(T event) {
                        if (event instanceof PostActingEvent postActing) {
                            // Print plan state after each planning tool call
                            //String toolName = postActing.getToolUse().getName();
                            String toolName = postActing.getToolUse().getName();
                            printPlanState(planNotebook, "After " + toolName);
                        }
                        return Mono.just(event);
                    }
                };

        // Create agent with PlanNotebook and hook
        ReActAgent agent =
                ReActAgent.builder()
                        .name("PlanAgent")
                        .sysPrompt(
                                "You are a systematic assistant. For multi-step tasks:\n"
                                        + "1. Create a plan with create_plan tool\n"
                                        + "2. Execute subtasks one by one\n"
                                        + "3. Use finish_subtask after completing each\n"
                                        + "4. Call finish_plan when all done")
                        .model(
                                DashScopeChatModel.builder()
                                        .apiKey(apiKey)
                                        .modelName("qwen-plus")
                                        .stream(false)
                                        .formatter(new DashScopeChatFormatter())
                                        .build())
                        .memory(new InMemoryMemory())
                        .toolkit(toolkit)
                        .maxIters(100)
                        .hooks(List.of(planVisualizationHook))
                        .planNotebook(planNotebook)
                        .build();

        System.out.println("\n" + "=".repeat(70));
        System.out.println("TASK");
        System.out.println("=".repeat(70));
        String userInput =
                "Calculate the area of a rectangle (length=10, width=5), then save the result to"
                        + " 'result.txt' and verify by reading it back. This is a multi-step task -"
                        + " please organize with a plan.";
        System.out.println(userInput);
        System.out.println("=".repeat(70) + "\n");

        Msg userMsg =
                Msg.builder()
                        .role(MsgRole.USER)
                        .content(TextBlock.builder().text(userInput).build())
                        .build();

        System.out.println("🚀 Starting execution...\n");

        Msg response = agent.call(userMsg).block();

        System.out.println("\n" + "=".repeat(70));
        System.out.println("FINAL RESPONSE");
        System.out.println("=".repeat(70));
        String finalText = MsgUtils.getTextContent(response);
        System.out.println(finalText != null ? finalText : "(No response)");
        System.out.println("=".repeat(70) + "\n");

        Msg userMsg1 =
                Msg.builder()
                        .role(MsgRole.USER)
                        .content(TextBlock.builder().text("yes").build())
                        .build();

        System.out.println("🚀 Starting execution...\n");

        Msg answer = agent.call(userMsg1).block();
        System.out.println("\n" + "=".repeat(70));
        System.out.println("FINAL RESPONSE");
        System.out.println("=".repeat(70));
        String result = MsgUtils.getTextContent(answer);
        System.out.println(result != null ? result : "(No response)");
        System.out.println("=".repeat(70) + "\n");

        // Show saved file
        if (fileStorage.containsKey("result.txt")) {
            System.out.println("📄 Saved File Content:");
            System.out.println("  " + fileStorage.get("result.txt") + "\n");
        }
    }

    private static void printPlanState(PlanNotebook notebook, String event) {
        Plan currentPlan = notebook.getCurrentPlan();
        if (currentPlan == null) {
            System.out.println("\n📋 [" + event + "] No active plan");
            return;
        }

        System.out.println("\n" + "=".repeat(70));
        System.out.println("📋 PLAN STATE [" + event + "]");
        System.out.println("=".repeat(70));
        System.out.println("Plan: " + currentPlan.getName());
        System.out.println("State: " + currentPlan.getState());
        System.out.println("\nSubtasks:");

        for (int i = 0; i < currentPlan.getSubtasks().size(); i++) {
            SubTask subtask = currentPlan.getSubtasks().get(i);
            String icon =
                    switch (subtask.getState()) {
                        case TODO -> "⏸️";
                        case IN_PROGRESS -> "▶️";
                        case DONE -> "✅";
                        case ABANDONED -> "❌";
                    };
            System.out.printf(
                    "  %s [%d] %s - %s%n", icon, i, subtask.getName(), subtask.getState());
        }
        System.out.println("=".repeat(70) + "\n");
    }
}
