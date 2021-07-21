public class T_offer_52 {
    public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            ListNode a = headA, b = headB;
            //当没有交点时，a和b最后都为 null
            //因为 a 和 b 都走了 lengthA +  lengthB 步，都到了结尾～
            while (a != b) {
                a = a == null? headB: a.next;
                b = b == null? headA: b.next;
            }
            return a;
        }

        public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
            int lengthA = 0, lengthB = 0;
            ListNode a = headA;
            ListNode b = headB;
            while (a != null) {
                a = a.next;
                lengthA++;
            }
            while (b != null) {
                b = b.next;
                lengthB++;
            }

            int d = lengthA- lengthB;
            a = headA;
            b = headB;
            if (d >= 0) {
                while (d-- > 0) {
                    a = a.next;
                }
            } else {
                d = -d;
                while (d-- > 0) {
                    b = b.next;
                }
            }

            while (a != b) {
                a = a.next;
                b = b.next;
            }

            return a;
        }
    }


     public class ListNode {
         int val;
         ListNode next;
         ListNode(int x) {
             val = x;
             next = null;
         }
     }
}
