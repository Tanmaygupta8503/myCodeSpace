/**
 * implement a Stack Data Structure specifically to store integer data using two Queues. You have to implement it in such a way that the push operation is done in O(1) time and the pop and top operations are done in O(N) time.
There should be two data members, both being Queues to store the data internally. You may use the inbuilt Queue.
Implement the following public functions :
1. Constructor:
It initialises the data members as required.
2. push(data) :
This function should take one argument of type integer. It pushes the element into the stack and returns nothing.
3. pop() :
It pops the element from the top of the stack and in turn, returns the element being popped or deleted. In case the stack is empty, it returns -1.
4. top :
It returns the element being kept at the top of the stack. In case the stack is empty, it returns -1.
5. size() :
It returns the size of the stack at any given instance of time.
6. isEmpty() :
It returns a boolean value indicating whether the stack is empty or not.*/


import java.util.Queue;
import java.util.LinkedList;
public class StackUsingTwoQueues {
    //Define the data members
Queue <Integer> q1;
Queue <Integer> q2;
    public StackUsingTwoQueues() {
        //Implement the Constructor
        q1=new LinkedList<>();
        q2=new LinkedList<>();
    }



    /*----------------- Public Functions of Stack -----------------*/


    public int getSize() { 
        //Implement the getSize() function
        return q1.size()+q2.size();
    }

    public boolean isEmpty() {
        //Implement the isEmpty() function
        return getSize()==0;
    }
    
    public void push(int element) {
        //Implement the push(element) function
        q1.add(element);
    }

    public int pop() {
        //Implement the pop() function
         if(q1.isEmpty())
        return -1;
        int i=1;
        while(i<=getSize()-1)
        {
            q2.add(q1.poll());
            i++;
        }
        int tmp=q1.poll();
        while(!q2.isEmpty())
        {
            q1.add(q2.poll());
        }
        return tmp;
    }
    
    public int top() {
        //Implement the top() function
        if(q1.isEmpty())
        return -1;
         int i=1;
        while(i<=getSize()-1)
        {
            q2.add(q1.poll());
            i++;
        }
        int tmp=q1.poll();
        q2.add(tmp);
        while(!q2.isEmpty())
        {
            q1.add(q2.poll());
        }
        return tmp;
    }
}