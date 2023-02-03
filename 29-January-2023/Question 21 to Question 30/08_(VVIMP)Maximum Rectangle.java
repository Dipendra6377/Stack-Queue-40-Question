class Solution {
    public int maximalRectangle(char[][] matrix) {
        int n=matrix[0].length;
        int height[] =new int[n];

        for(int i=0;i<n;i++){
            if(matrix[0][i]=='1') height[i]=1;
        }
        int result = findmaxheight(height);

        for(int i=1;i<matrix.length;i++){
            nextRow(matrix,height,i);
            result=Math.max(result,findmaxheight(height));
        }
        return result;
    }
///////////////////////////////////////////////////////////////////////////////////////
  
  // cODE SAME FOR CALCULATING LARGEST RECTANGLE IN HISTOGRAM DISCUSS IN 07 POSITION IN THIS REPO
    public int findmaxheight(int[] heights){
        Stack<Integer> st=new Stack<>();
        int n=heights.length;
        int max=0;
        for(int i=0;i<=n;i++){
            while(!st.isEmpty() && (i==n || heights[st.peek()]>=heights[i])){
                int h = heights[st.peek()];
                st.pop();
                int width=0;
                if(st.isEmpty()) width=i;
                else width=i-st.peek()-1;

                max=Math.max(max,width*h);

            }
            st.push(i);
            
        }
        return max;
    }
  ///////////////////////////////////////////////////////////////////////////////////////
    public void nextRow(char[][] matrix,int[] height,int index){
        for(int i=0;i<matrix[0].length;i++){
            if(matrix[index][i]=='1')height[i] +=1;
            else height[i]=0;
        }
    }
}
