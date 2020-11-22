public class T146 {

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    class Solution {
        public ListNode insertionSortList(ListNode head) {

            // 如果head为空，则直接返回head
            if (head == null)
                return head;

            // 使用一个哑节点，用来应对需要在头节点前插入节点的情况，哑节点的值随意设置，next为head
            ListNode dummyHead = new ListNode(0);
            dummyHead.next = head;

            // lastSorted表示已排序链表部分的最后一个节点，初始值为head
            ListNode lastSorted = head;
            // current表示当前的待排序节点，初始值为head.next
            ListNode current = head.next;

            // 外层遍历，遍历整个链表
            while (current != null){
                // 当当前待排序节点的值比已排序的最后一个节点（最大的值） 还大的时候，
                // 表示已经是有序状态，不需要插入，直接将当前节点标记为最后的已排序节点即可
                if (lastSorted.val <= current.val) {
                    lastSorted = current;
                } else {
                    // 此时表示需要进行插入操作
                    // 使用prev表示插入点的前一个节点，初始值设为哑节点
                    ListNode prev = dummyHead;
                    // 内层遍历，遍历已排序部分，通过比较prev的下一个节点的值 和 待插入节点的值的大小
                    // 找到插入位置
                    while (prev.next.val <= current.val) {
                        prev = prev.next;
                    }
                    // 完成插入操作
                    // 剥离待排序节点
                    lastSorted.next = current.next;
                    // 从插入点切开已排序部分，连接后半段
                    current.next = prev.next;
                    // 连接前半段
                    prev.next = current;
                }
                // 移动待排序节点
                current = lastSorted.next;
            }
            return dummyHead.next;
        }
    }
}
