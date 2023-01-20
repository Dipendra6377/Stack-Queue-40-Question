class MyStack
{
    int top;
	int arr[] = new int[1000];

    MyStack()
	{
		top = -1;
	}
	
	//Function to push an integer into the stack.
    void push(int a)
	{
	    // Your code here
	    if(top==arr.length-1){
	        return;
	    }
	    top++;
	    arr[top]=a;
	} 
	
    //Function to remove an item from top of the stack.
	int pop()
	{
        // Your code here
        int a=-1;
        if(top<=-1){
            return -1;
        }
        a=arr[top];
        top--;
        return a;
	}
}
