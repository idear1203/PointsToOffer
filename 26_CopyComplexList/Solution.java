class RandomListNode{
    int val;
    RandomListNode next;
    RandomListNode random;
    RandomListNode(int x){
        this.val = x;
    }
}

public class Solution{
    public RandomListNode clone(RandomListNode head){
        if (head == null){
            return null;
        }

        // For each node in original list, copy it and link the new node behind it.
        for (RandomListNode curNode = head; curNode != null; curNode = curNode.next.next){
            RandomListNode node = new RandomListNode(curNode.val);
            node.next = curNode.next;
            curNode.next = node;
        }

        // Set `random` field.
        // If `random` field of node N in original list points to S, the copied node N' will be set to `next` field of S.
        for (RandomListNode curNode = head; curNode != null; curNode = curNode.next.next){
            if (curNode.random != null){
                curNode.next.random = curNode.random.next;
            }
        }

        // Split the list to two part.
        // Original list consists nodes in odd position, while the copied list consists of nodes in even position.
        RandomListNode dummyForCopy = new RandomListNode(0);
        RandomListNode tailForCopy = dummyForCopy;
        for (RandomListNode curNode = head; curNode != null; curNode = curNode.next){
            tailForCopy.next = curNode.next;
            tailForCopy = tailForCopy.next;
            curNode.next = curNode.next.next;
        }

        return dummyForCopy.next;
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        RandomListNode head = null;
        RandomListNode copyHead = null;

        head = null;
        printRandomList(head);
        copyHead = sol.clone(head);
        printRandomList(copyHead);

        /*
         *   +----+            +------------+
         *   |    |            |            |
         *   |    |            |            v
         *   | +-----+      +-----+      +-----+
         *   | |  1  | ---> |  2  | ---> |  3  |
         *   | +-----+      +-----+      +-----+
         *   |    ^            ^            |
         *   |    |            |            |
         *   +----+            +------------+
         */
        head = new RandomListNode(1);
        head.next = new RandomListNode(2);
        head.next.next = new RandomListNode(3);
        head.random = head;
        head.next.random = head.next.next;
        head.next.next.random = head.next;
        printRandomList(head);
        copyHead = sol.clone(head);
        printRandomList(copyHead);
    }

    private static void printRandomList(RandomListNode head){
        StringBuilder sb = new StringBuilder();
        for (RandomListNode curNode = head; curNode != null; curNode = curNode.next){
            sb.append(printRandomListNode(curNode));
        }

        System.out.println(sb.toString());
    }

    private static String printRandomListNode(RandomListNode node){
        StringBuilder sb = new StringBuilder();
        if (node == null){
            sb.append(getLabel(node)).append("\n");
        } else {
            sb.append(String.format("Node: %s\n", getLabel(node)));
            sb.append(String.format("Node.next: %s\n", getLabel(node.next)));
            sb.append(String.format("Node.random: %s\n", getLabel(node.random)));
        }

        return sb.toString();
    }

    private static String getLabel(RandomListNode node){
        if (node == null){
            return "null";
        } else {
            return String.valueOf(node.val);
        }
    }
}
