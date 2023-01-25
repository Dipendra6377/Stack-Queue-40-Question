// time complexity O(N)

class Solution {
    public int trap(int[] height) {
        int n=height.length;
        int l=0;
        int r=n-1; int res=0;
        int leftmaxheight=0;int rightmaxheight=0;

        while(l<=r){
            if(height[l]<=height[r]){
                if(height[l]>=leftmaxheight){
                    leftmaxheight=height[l];
                }
                else{
                    res+=leftmaxheight-height[l];
                }
                l++;
            }
            else{
                if(height[r]>=rightmaxheight){
                    rightmaxheight=height[r];
                }
                else{
                    res+=rightmaxheight-height[r];
                }
                r--;
            }
        }
        return res;
    }
}


// using Stack


class Solution {
    public int trap(int[] height) {
        int n=height.length;
        int l=0;
        int r=n-1; int water=0;
        int leftmaxheight=height[l];int rightmaxheight=height[r];

        Stack<Integer> st=new Stack<>();
        while(l<r){
            if(height[l]>=leftmaxheight){
                leftmaxheight=height[l];
            }
            else{
                st.push(leftmaxheight-height[l]);
            }

            if(height[r]>=rightmaxheight){
                rightmaxheight=height[r];
            }
            else{
                st.push(rightmaxheight-height[r]);
            }
            if(rightmaxheight>leftmaxheight){
                l++;
            }
            else{
                r--;
            }
        }
        while(!st.isEmpty()){
            water+=st.pop();
        }
        return water;
    }
}
