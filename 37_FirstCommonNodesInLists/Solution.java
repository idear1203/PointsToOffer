class ListNode{
    ListNode next;
    int val;
    ListNode(int x){
        this.val = x;
    }
}

public class Solution{
    public ListNode findFirstCommonNode(ListNode head1, ListNode head2){
        int len1 = getLength(head1);
        int len2 = getLength(head2);
        if (len2 > len1){
            return findFirstCommonNode(head2, head1);
        }

        while (len1 > len2){
            head1 = head1.next;
            len1--;
        }

        while (head1 != null && head2 != null && head1 != head2){
            head1 = head1.next;
            head2 = head2.next;
        }

        return head1;
    }

    private int getLength(ListNode head){
        int count = 0;
        while (head != null){
            head = head.next;
            count++;
        }

        return count;
    }

    public static void main(String[] args){
        // Prepare data.
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        ListNode head2 = new ListNode(4);
        head2.next = new ListNode(5);
        ListNode merge = new ListNode(6);
        merge.next = new ListNode(7);
        head1.next.next.next = merge;
        head2.next.next = merge;

        Solution sol = new Solution();

        ListNode result = sol.findFirstCommonNode(head1, head2);
        System.out.println(result.val);
    }
}
