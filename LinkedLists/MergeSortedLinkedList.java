// Using Recurssion
SinglyLinkedList mergeLists(SinglyLinkedList head1, SinglyLinkedList head2)
{ 
	if(head1 == null)
            return head2;
        if(head2 == null)
            return head1;

       if(head1.data<head2.data)
       {
            head1.next = mergeLists(head1.next,head2);
            return head1;
       }
      else
       {
            head2.next = mergeLists(head1,head2.next);
            return head2;
       }
}

// At Place without recurssion
SinglyLinkedList mergeLists(SinglyLinkedList head1, SinglyLinkedList head2)
{ 
	  if(head1 == null)
            return head2;
        if(head2 == null)
            return head1;

        SinglyLinkedListNode head;
        
        if(head1.data<head2.data)
            head=head1;
        else
        {
            head=head2;
            head2=head1;
            head1=head;
        }
        while(head1.next!=null)
        {
            if(head1.next.data>head2.data)
            {
                SinglyLinkedListNode tmp = head1.next;
                head1.next = head2;
                head2=tmp;
            }
            head1=head1.next;
        }
        head1.next=head2;
        return head;
}
