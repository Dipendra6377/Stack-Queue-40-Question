

/*The structure of the node of the queue is
class QueueNode
{
	int data;
	QueueNode next;
	QueueNode(int a)
	{
	    data = a;
	    next = null;
	}
}*/

class MyQueue
{
    QueueNode front, rear;
    
    //Function to push an element into the queue.
	void push(int a)
	{
        // Your code here
        QueueNode head =new QueueNode(a);
        if(front ==null){
            front=head;
            rear=head;
            return;
        }

            front.next=head;
            front=head;
	}
	
    //Function to pop front element from the queue.
	int pop()
	{
        // Your code here
        
        if(rear==null){
            return -1;
        }
        QueueNode curr=rear;
        
       rear=rear.next;
       if(rear==null){
           front=null;
       }
       return curr.data;
        
	}
}


