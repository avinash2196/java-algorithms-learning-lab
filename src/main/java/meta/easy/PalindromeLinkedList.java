package meta.easy;

public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        if(head==null)
            return true;
        ListNode firstHalfEnd=endFirstHalf(head);
        ListNode secondHalfStart=reverseList(firstHalfEnd.next);
        ListNode p1=head;
        ListNode p2=secondHalfStart;
        boolean isPalindromeFlag=true;
        while(isPalindromeFlag && p2!=null){
            if(p1.val!=p2.val){
                isPalindromeFlag=false;
            }
            p1=p1.next;
            p2=p2.next;
        }
        firstHalfEnd.next=reverseList(secondHalfStart);
        return isPalindromeFlag;
    }

    ListNode endFirstHalf(ListNode node){
        ListNode slow=node;
        ListNode fast=node;
        while(fast.next!=null && fast.next.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }

    ListNode reverseList(ListNode node){
        ListNode next=null,prev=null,curr=node;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }
    class ListNode{
        int val;
        ListNode next;
        ListNode(int val){
            this.val=val;
        }
        ListNode(int val,ListNode next){
            this.val=val;
            this.next=next;
        }
    }
}

// Time complexity :O(n)
// Space Complexity :O(1)

