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
