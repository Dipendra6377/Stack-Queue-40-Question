

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
     
// iterative approach

class Solution {
  public static int[] count_NGEs(int n, int a[], int q, int ind[]) {
    // code here
     int ngr[]=new int[q];
    for(int i=0;i<q;i++)
     {
         int idx=ind[i];
         int c=0;
         for(int j=idx+1;j<n;j++)
          {
              if(a[j]>a[idx])
               c++;
          }
        ngr[i]=c;
     }
    return ngr;

  }
}
