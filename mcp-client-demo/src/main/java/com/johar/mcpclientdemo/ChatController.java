package com.johar.mcpclientdemo;

import com.alibaba.cloud.ai.dashscope.chat.DashScopeChatModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.messages.SystemMessage;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;


/**
 * @author : [johar]
 * @description : [一句话描述该类的功能]
 * @createTime : [2025/9/21 18:06]
 * @updateUser : [johar]
 * @updateTime : [2025/9/21 18:06]
 * @updateRemark : [说明本次修改内容]
 * @since : [v1.0]
 */
@Slf4j
@RestController
@RequestMapping("/api")
public class ChatController {

    @Autowired
    private DashScopeChatModel dashScopeAiChatModel;

    @Autowired
    private ChatClient.Builder chatClientBuilder;

    @Autowired
    private ToolCallbackProvider tools;

//    @PostMapping(value = "chat/stream", produces = MediaType.TEXT_PLAIN_VALUE)
//    public Mono<String> chatStream(@RequestParam String prompt) {
//        return Mono.just(chatClientBuilder.build())
//                .map(client -> client.prompt()
//                        .toolCallbacks(tools)
//                        .messages(
//                                new SystemMessage("你是一个Java智能助手，应用你的Java知识帮助用户解决问题或者编写程序"),
//                                new UserMessage(prompt))
//                        .call()
//                        .content())
//                .onErrorReturn("Error occurred while processing the request");
//    }

    @GetMapping("chat")
    public String chat(@RequestParam String prompt) {
        ChatClient chatClient = ChatClient.create(dashScopeAiChatModel);
        return chatClient.prompt()
                .toolCallbacks(tools)
                // 输入单条提示词
                .user(prompt)
                // call代表非流式问答，返回的结果可以是ChatResponse，也可以是Entity（转成java类型），也可以是字符串直接提取回答结果。
                .call()
                .content();
    }


    @GetMapping(value = "chat/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<ServerSentEvent<String>> chatStream(@RequestParam String prompt) {
        return chatClientBuilder.build()
                .prompt()
                .toolCallbacks(tools)
                // 输入多条消息，可以将历史记录传入
                .messages(new SystemMessage("你是一个Java智能助手，应用你的Java知识帮助用户解决问题或者编写程序"),
                        new UserMessage(prompt))
                // 流式返回
                .stream()
                // 构造SSE（ServerSendEvent）格式返回结果
                .chatResponse().map(chatResponse -> ServerSentEvent.builder(toJson(chatResponse))
                        .event("message")
                        .build());
    }

    /**
     * 将流式回答结果转json字符串
     *
     * @param chatResponse 流式回答结果
     * @return String json字符串
     */
    public String toJson(ChatResponse chatResponse) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.registerModule(new JavaTimeModule());
            return objectMapper.writeValueAsString(chatResponse);
        } catch (Exception e){
            //log.error("Error occurred while converting chatResponse to json, input:{},error：{}", chatResponse, e.getMessage(), e);
            return e.getMessage();
        }
    }
}