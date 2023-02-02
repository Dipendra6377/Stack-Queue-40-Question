// using Time complexity O(N*N)  Space complexity O(N)

class Solution
{ 
    //Function to find if there is a celebrity in the party or not.
    int celebrity(int M[][], int n)
    {
    	// code here 
    	int[] whoknowceleb=new int[n];
    	int[] whocelebknow=new int[n];
    	
    	for(int i=0;i<n;i++){
    	    for(int j=0;j<n;j++){
    	        if(M[i][j]==1){
    	            whoknowceleb[j]++;
    	            whocelebknow[i]++;
    	        }
    	    }
    	}
    	for(int i=0;i<n;i++){
    	    if(whoknowceleb[i]==n-1&& whocelebknow[i]==0){
    	        return i;
    	    }
    	}
    	return -1;
    }
}


// Using Time complexity O(N)
class Solution
{ 
    //Function to find if there is a celebrity in the party or not.
    int celebrity(int arr[][], int n)
    {
    	// code here 
        Stack<Integer> st=new Stack<>();
        
        for(int i=0;i<n;i++){
            st.push(i);
        }
        
        while(st.size()>1){
            int a=st.peek();
            st.pop();
            int b=st.peek();
            st.pop();
            
            if(aknowsb(a,b,arr,n)){
                st.push(b);
            }
            else{
                st.push(a);
            }
        }
        int celeb=st.peek();
        
        int whocelebknows=0;
        int whoknowsceleb=0;
        for(int i=0;i<n;i++){
            
            if(arr[celeb][i]!=0){
                whocelebknows++;
            }
            if(arr[i][celeb]==1){
                whoknowsceleb++;
            }
        }
        
        if(whocelebknows==0 && whoknowsceleb==n-1){
            return celeb;
        }
        return -1;
    }
    boolean aknowsb(int a,int b,int[][] arr,int n){
        if(arr[a][b]==1){
            return true;
        }
        else{
            return false;
        }
    }
}

// using array in O(N) time complexity



//User function Template for Java


class Solution
{ 
    //Function to find if there is a celebrity in the party or not.
    int celebrity(int arr[][], int n)
    {
    	// code here 
    	int celebrity=0;

        for(int i=0;i<n;i++){
            if(arr[celebrity][i]==1){
                celebrity=i; // phle hm dekhenge ki kya celebrity --> i ko pehechanta h ==1
                //to celebrity i ho gya kyuki usko jante h
            }
        }

        for(int i=0;i<n;i++){
            if(celebrity!=i && (arr[celebrity][i]==1 || arr[i][celebrity]==0)){
                // phir dekhenge ki agr celebrity i ko pehenchata h 
                return -1;
            }
        }
        return celebrity;
    }
}
