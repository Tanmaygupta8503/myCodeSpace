package linkedlist;

import java.util.Scanner;

public  class LinkedListUse{
	
	public static Node<Integer> takeInput()
	{
		Node<Integer> head=null,tail=null;
		Scanner sc=new Scanner(System.in);
		int data=sc.nextInt();
		//sc.close();
		while(data!=-1)
		{
			Node<Integer> newNode= new Node<Integer> (data);
			if(head==null)
			{
				head=newNode;
				tail=newNode;
			}
			else {
				tail.next=newNode;
				tail=tail.next;//tail=newNode;
			}
			data=sc.nextInt();
		}
		return head;
	}
	public static Node<Integer> takeInput1()
	{
		Node<Integer>head=null;
		Scanner sc=new Scanner(System.in);
		int data=sc.nextInt();
		//sc.close();
		while(data!=-1)
		{
			Node<Integer> newNode=new Node<>(data);
			if(head==null)
			{
				head=newNode;
			}
			else
			{
				Node<Integer> temp=head;
				while(temp.next!=null)
				{
					temp=temp.next;
				}
				temp.next=newNode;
			}
			data=sc.nextInt();
		} 
		
		return head;
		
	}
	public static void increment(Node<Integer> head)
	{
		while(head!=null)
		{
			head.data++;
			head=head.next;
		}
	}
	 public static void print(Node<Integer> head){
	    Node<Integer> temp = head;

	    while(temp != null){
	        System.out.print(temp.data +" ");
	        temp = temp.next;
	    }
	    System.out.println();
	}
	 public static Node<Integer> reverseRecursive(Node<Integer> head)
	 {
		 if(head==null||head.next==null)
			 return head;
		 Node<Integer> newNode=reverseRecursive(head.next);
		 head.next.next=head;
		 head.next=null;
		 return newNode;
	 }
	 public static Node<Integer> reverseIterator(Node<Integer> head)
	 {
		 if(head==null||head.next==null)
		 {
			 return head;
		 }
		 Node<Integer> prev = head;
		 Node<Integer> curr=head.next;
		 while(curr!=null)
		 {
			 Node<Integer> next=curr.next;
			 curr.next=prev;
			 //update
			 prev=curr;
			 curr=next;
		 }
		 head.next=null;
		 head=prev;
		 return head;
	 }
	 public static Node<Integer> insert(Node<Integer> head,int data,int pos)
	 {
		 Node<Integer>  newNode=new Node<>(data);
		 if(pos==0)
		 {
			 newNode.next=head;
			 return newNode;
		 }
		 int i=0;
		 Node<Integer> temp=head;
		 while(i<pos-1)
		 {
			 temp=temp.next;
			 i++;
		 }
		 newNode.next=temp.next;
		 temp.next=newNode;
		 return head;
	 }
	 public static Node<Integer> deleteNode(Node<Integer> head, int pos) {
			// Write your code here.
			Node<Integer> temp=head;
			if(temp==null)
			return temp;
			int i=0;
			if(pos==0)
			{	if(head.next==null)
				return head;
				return head.next; 
			}
			while(i<pos-1 && temp!=null)
			{
				temp=temp.next;
				i++;
			}
			if(temp==null)
			return head;
			if(temp.next==null)
			{
				return head;
			}
			temp.next=temp.next.next;
			return head;
		}
	 public static boolean isPalindrome( Node<Integer> head) {
		 Node<Integer> mid = getMid(head);
		 Node<Integer> headSecond = reverseList(mid);

	        while(head != null && headSecond != null){
	            if(head.data != headSecond.data){
	                return false;
	            }
	            head = head.next;
	            headSecond = headSecond.next;
	        }
	        return true;
	    }

	    public static Node<Integer> getMid(Node<Integer> head){
	    	if(head==null||head.next==null)
	            return head;
	            Node<Integer> slow=head;
	            Node<Integer> fast=head.next;
	            while(fast!=null && fast.next!=null)
	            {
	                fast=fast.next.next;
	                slow=slow.next;
	            }
	            return slow;
	    }

	    public static Node<Integer> reverseList(Node<Integer> node){
	    	Node<Integer> prev = null;
	        Node<Integer> current = node;
	        Node<Integer> next = current.next;

	        while(current != null){
	            current.next = prev;
	            prev = current;
	            current = next;

	            if(next != null){
	                next = next.next;
	            }
	        }

	        return prev;
	    }
	    public static Node<Integer> mergeTwoSortedLinkedLists(Node<Integer> h1, Node<Integer> h2) {
	        //Your code goes here
	        if(h1==null && h2==null)
	        {
	            return h1;
	        }
	        if(h1==null)
	        return h2;
	        if(h2==null)
	        return h1;
	        Node<Integer> h3=null,t3=null;
	        if(h1.data>=h2.data)
	        {
	            h3=h2;
	            t3=h2;
	            h2=h2.next;
	        }
	        else //if(h2.data>h1.data)
	        {
	            h3=h1;
	            t3=h1;
	            h1=h1.next;
	        }
	        while(h1!=null && h2!=null)
	        {
	            if(h1.data>=h2.data)
	            {
	                t3.next=h2;
	                t3=h2;
	                h2=h2.next;

	            }
	            else if(h2.data>=h1.data)
	            {
	                
	                t3.next=h1;
	                t3=h1;
	                h1=h1.next;
	            }
	        }
	        if(h1!=null)
	        {
	            t3.next=h1;
	        }
	        else if(h2!=null)
	        {
	            t3.next=h2;
	        }
	        return h3;
	    }
	    public static Node<Integer> mergeSort(Node<Integer> head) {
			//Your code goes here
	        if(head==null || head.next==null)
	        {
	            return head;
	        }
	        Node<Integer> mid=getMid(head);
	        Node<Integer> midnext=mid.next;
	        mid.next=null;
	        Node<Integer> head1=mergeSort(head);
	        Node<Integer> head2=mergeSort(midnext);
	        Node<Integer> sorted= mergeTwoSortedLinkedLists(head1,head2);
	        return sorted;
	        
	        
		}
	    public static void printrecursivilyreverse(Node<Integer> head)
	    {
	    	if(head==null)
	    		return;
	    	printrecursivily(head.next);
	    	System.out.print(head.data+" ");
	    	//printrecursivily(head.next);
	    	//System.out.println();
	    }
	    public static void printrecursivily(Node<Integer> head)
	    {
	    	if(head==null)
	    		return;
	    	System.out.print(head.data+" ");
	    	printrecursivily(head.next);
	    	//System.out.println();
	    }
	    public static Node<Integer> insertR(Node<Integer> head , int pos , int elem)
	    {
	    	if(pos==0)
	    	{
	    		Node<Integer> ele=new Node<Integer>(elem);
	    		ele.next=head;
	    		return ele;
	    	}
	    	head.next=insertR(head.next,pos-1,elem);
	    	return head;
	    }
	    public static void fun(Node<Integer> start)
	    {
	      if(start == null)
	        return;
	      System.out.print( start.data); 

	      if(start.next != null )
	        fun(start.next.next);
	      System.out.print(start.data);
	    }
	    public static Node<Integer> deleteNodeRec(Node<Integer> head, int pos) {
	    	//Your code goes here
	        if(head==null)
	        return head;
	        if(pos==0)
	        {
	            return head.next;
	        }
	        head.next=deleteNodeRec(head.next,pos-1);
	        return head;
		}
	    public static DoubleNode reverserec(Node<Integer> head)
	    {
	    	if(head==null||head.next==null)
	    	{
	    		DoubleNode ans=new DoubleNode();
	    		ans.tail=head;
	    		ans.head=head;
	    		return ans;
	    	}
	    	DoubleNode smallans=reverserec (head.next);
	    	smallans.tail.next=head;
	    	head.next=null;
	    	DoubleNode ans=new DoubleNode();
	    	ans.head=smallans.head;
	    	ans.tail=head;
	    	return ans;
	    }
	    public static void main(String args[])
	    {
		Node<Integer> head1=takeInput();
    	//Node<Integer> head2=mergeSort(head1);
//		Node<Integer> head3=mergeTwoSortedLinkedLists(head1, head2);
//		print(head3);
//		Node<Integer> head2=insertR(head1,2,10);
//    	printrecursivily(head2);
		DoubleNode ans=reverserec(head1);
		print(ans.head);
//		fun(head1);
//		head=insert(head,80,2);
//		head=deleteNode(head,3);
//		increment(head);
//	    print(head);
//	    head=reverseRecursive(head);
//	    print(head);
//	    head=reverseIterator(head);
//	    print(head);
//	    System.out.println(isPalindrome(head));
	   }
	}

