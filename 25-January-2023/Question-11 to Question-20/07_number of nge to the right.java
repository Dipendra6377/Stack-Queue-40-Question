//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    while (T-- > 0) {
      int n = sc.nextInt();
      int a[] = new int[n];
      for(int i=0;i<n;i++){
        a[i]=sc.nextInt();
      }
      int q = sc.nextInt();
      int ind[]=new int[q]; 
      for(int i=0;i<q;i++) ind[i]=sc.nextInt();
      Solution obj = new Solution();
      int ans[] = obj.count_NGEs(n,a,q,ind);
      for(int e : ans)
      System.out.print(e+" ");
      System.out.println();
    }
  }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
  public static int[] count_NGEs(int n, int arr[], int queries, int indices[]) {
    // code here
     Stack<Integer> st = new Stack<>();
     int[] ans=new int[queries];
     int ind=0;
     int count=0;
     if(indices[queries-1]==n-1){
         ans[queries-1]=-1;
     }
     while(ind<queries){
         count=0;
        for(int i=n-1;i>=indices[ind];i--){
            while(!st.isEmpty() && arr[indices[ind]]<st.peek()){
                count++;
                st.pop();
            }
            st.push(arr[i]);
        }
        while(!st.isEmpty()){
            st.pop();
        }
        ans[ind]=count;
        ind++;
     }
     return ans;
  }
}
     
