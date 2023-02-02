// Naive
class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea=0;
        int n=heights.length;
        for(int i=0;i<n;i++){
            int min =Integer.MAX_VALUE;
            for(int j=i;j<n;j++){
                min =Math.min(min,heights[j]);
                maxArea=Math.max(maxArea,min*(j-i+1));
            }
        }
        return maxArea;
    }
}
