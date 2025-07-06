package com.johar.test.algorithm.linkedlist;

/**
 * @ClassName: MergeKList
 * @Description: TODO
 * @Author: Johar
 * @Date: 2023/5/3 17:24
 * @Since: 1.0.0
 */
public class MergeKList {
    /**
     * 给定一个链表数组，每个链表都已经按升序排列。
     * 请将所有链表合并到一个升序链表中，返回合并后的链表。
     *
     * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
     * 输出：[1,1,2,3,4,4,5,6]
     * 解释：链表数组如下：
     * [
     *   1->4->5,
     *   1->3->4,
     *   2->6
     * ]
     * 将它们合并到一个有序链表中得到。
     * 1->1->2->3->4->4->5->6
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/vvXgSW
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0){
            return null;
        }

        if (lists.length == 1){
            return lists[0];
        }

        int length = lists.length;
        ListNode temp = lists[0];
        for (int i = 1; i < length; i++){
            temp = merge(temp, lists[i]);
        }

        return temp;
    }

    public ListNode merge(ListNode head1, ListNode head2){
        if (head1 == null && head2 == null){
            return null;
        }
        if (head1 == null){
            return head2;
        }
        if (head2 == null){
            return head1;
        }

        ListNode result = new ListNode();
        ListNode dummyHead = result;
        ListNode temp1 = head1, temp2 = head2;
        while (temp1 != null && temp2 != null){
            if (temp1.val <= temp2.val){
                dummyHead.next = temp1;
                temp1 = temp1.next;
            } else {
                dummyHead.next = temp2;
                temp2 = temp2.next;
            }
            dummyHead = dummyHead.next;
        }
        if (temp1 != null){
            dummyHead.next = temp1;
        }
        if (temp2 != null){
            dummyHead.next = temp2;
        }

        return result.next;
    }

    public boolean hasNode(ListNode[] lists){
        if (lists == null || lists.length == 0){
            return false;
        }

        boolean result = false;
        for (ListNode listNode : lists){
            if (listNode != null){
                result = true;
                break;
            }
        }

        return result;
    }
}