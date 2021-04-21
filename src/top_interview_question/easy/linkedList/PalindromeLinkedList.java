package top_interview_question.easy.linkedList;

/**
 * RemoveDuplicatesfromSortedArraySolution
 */
public class PalindromeLinkedList {

    /**
     * //刪除3 1->2->'3'->4->5->x
     * 
     * //先複製下一個點 1->2->'4'->4->5->x | ------>5
     * 
     * //然後刪除下一個點 1->2->'4'---->5->x
     */
    public void deleteNode(ListNode node) {
        // 因為是single linklist, 所以...
        // 當要刪除一個點, 因為無法讀取前一個node, 所以先複製下一個點, 然後刪除下一個點
        node.val = node.next.val;
        node.next = node.next.next;
        // 刪除下一個點

    }

    void printNode(ListNode node) {

        System.out.print(node.val + " ");

        if (node.next != null) {
            printNode(node.next);
        }

    }

    int listSize(ListNode node) {
        int size = 1;
        while (node.next != null) {
            size++;
            node = node.next;
        }
        return size;
    }

    public ListNode reverseList(ListNode head) {
        // 1 → 2 → 3 → Ø
        // Ø ← 1 ← 2 ← 3.

        // 第一輪的pre 跟 cur
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null) {
            ListNode nextTemp = cur.next;
            // 指往前一個
            cur.next = pre;
            // 下一輪的pre 跟 cur
            pre = cur;
            cur = nextTemp;

        }

        return pre;
    }

    public ListNode reverseList2(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        // 1 → 2 → 3 → Ø
        // Ø ← 1 ← 2 ← 3.
        while (cur != null) {
            ListNode nextTemp = cur.next;
            cur.next = pre;

            pre = cur;
            cur = nextTemp;            
        }

        return pre;

    }

    public boolean isPalindrome(ListNode head) {
        boolean isPalindrome = true;
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        // 1 2 3 4 5
        // sf
        // s f
        // s f
        // s f
        if (fast != null) { // odd length
            slow = slow.next;
        }
        // 4->5->null, 5(s)->4->null;
        slow = reverseList(slow);
        // 1(f)->2->3->null
        fast = head;

        while (slow != null) {
            if (slow.val != fast.val) {
                isPalindrome = false;
                break;
            }
            slow = slow.next;
            fast = fast.next;
        }

        return isPalindrome;
    }

    public static void main(String[] args) {

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

        PalindromeLinkedList aa = new PalindromeLinkedList();
        aa.printNode(node1);
        System.out.println("");
        System.out.println("size: " + aa.listSize(node1));
        System.out.println("isPalindrome");
        System.out.println(aa.isPalindrome(node1));
        // aa.deleteNode(node3);
        // aa.printNode(node1);

    }
}

// /**
// * Definition for singly-linked list.
// * */
// class ListNode {
// int val;
// ListNode next;

// public ListNode(int x) {
// this.val = x;
// this.next = null;
// }
// }