class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> map =new HashMap<>();
        Stack<Integer> st = new Stack<>();
        int n1=nums1.length; int n2=nums2.length;
        map.put(nums2[n2-1],-1);
        st.push(nums2[n2-1]);
        for(int i=n2-2;i>=0;i--){
            while(!st.isEmpty() && nums2[i]>=st.peek()){
                st.pop();
            }
            if(st.isEmpty()){
                map.put(nums2[i],-1);
            }
            else{
                map.put(nums2[i],st.peek());
            }
            st.push(nums2[i]);
        }

        int[] res=new int[n1];
        int ind=0;
        for(int key:nums1){
            if(map.containsKey(key)){
                res[ind++]=map.get(key);
            }
            // else{
            //     res[ind++]=-1;
            // }
        }
        return res;
    }
}
