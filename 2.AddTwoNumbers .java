/**
  * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
  * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
  * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
  * Output: 7 -> 0 -> 8
  * 类似于加法进位，没有太好的想法。
  */

  //循环往后查找，先把把长度相同的算完，之后的把长的往后接上
 public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int x = l1.val + l2.val;
		ListNode l3 = new ListNode( x % 10);

		ListNode nx1 = l1.next, nx2 = l2.next;
		int y = x/10;
		List<Integer> list = new ArrayList<Integer>();
		while (nx1 != null || nx2 != null) {
			if (nx1 == null) {
				nx1 = new ListNode(0);
			}else if (nx2 == null) {
				nx2 = new ListNode(0);
			}
			int sum = nx1.val + nx2.val + y;
			list.add(sum % 10);

			nx1 = nx1.next;
			nx2 = nx2.next;
			y = sum / 10;
		}
		if (y > 0) {
			list.add(y);
		}
		ListNode l4 = l3;
		for (Integer n : list) {
			l4.next = new ListNode(n);
			l4 = l4.next;
		}
		return  l3;
    }

//简练的代码，思路感觉上是一样的，就是代码比我的好看多了
public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode prev = new ListNode(0);
    ListNode head = prev;
    int carry = 0;
    while (l1 != null || l2 != null || carry != 0) {
        ListNode cur = new ListNode(0);
        int sum = ((l2 == null) ? 0 : l2.val) + ((l1 == null) ? 0 : l1.val) + carry;
        cur.val = sum % 10;
        carry = sum / 10;
        prev.next = cur;
        prev = cur;
        
        l1 = (l1 == null) ? l1 : l1.next;
        l2 = (l2 == null) ? l2 : l2.next;
    }
    return head.next;
}