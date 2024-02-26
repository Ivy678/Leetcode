
//24. Swap Nodes in Pairs

class Solution {
    //   Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode swapPairs(ListNode head) {
          ListNode dumyhead = new ListNode(-1); // 设置一个虚拟头结点
          dumyhead.next = head; // 将虚拟头结点指向head，这样方便后面做删除操作
          ListNode cur = dumyhead;
          ListNode temp; // 临时节点，保存两个节点后面的节点
          ListNode firstnode; // 临时节点，保存两个节点之中的第一个节点
          ListNode secondnode; // 临时节点，保存两个节点之中的第二个节点
          while (cur.next != null && cur.next.next != null) {
              temp = cur.next.next.next;
              firstnode = cur.next;
              secondnode = cur.next.next;
              cur.next = secondnode;       // 步骤一
              secondnode.next = firstnode; // 步骤二
              firstnode.next = temp;      // 步骤三
              cur = firstnode; // cur移动，准备下一轮交换
          }
          return dumyhead.next;  
      }

        public static void main(String[] args) {
            Solution s = new Solution();
            ListNode l1 = s.new ListNode(1);
            ListNode l2 = s.new ListNode(2);
            ListNode l3 = s.new ListNode(3);
            ListNode l4 = s.new ListNode(4);
            l1.next = l2;
            l2.next = l3;
            l3.next = l4;
            ListNode res = s.swapPairs(l1);
            while (res != null) {
                System.out.println(res.val);
                res = res.next;
            }
        }
  }