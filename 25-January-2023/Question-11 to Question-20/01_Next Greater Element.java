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





// less run time
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer>stack=new Stack<Integer>();
        Map<Integer,Integer>map=new HashMap<Integer,Integer>();                    //            i      
        int[]ans=new int[nums1.length];                                               // nums={1,3,4,2}
        
        for(int i:nums2){                                                            // |         |       if(st.peek()<i)  1<3
            while(!stack.isEmpty()){                                                 // |__1______|        map.put(1,3)
                if(stack.peek()<i){                                                  //    st^                st.pop()
                    
                    map.put(stack.peek(),i);                                          //    st.push(i)=push 3 in stack
                    stack.pop();                                                   //   |         |       
                }else break;                                                       //   |____3____|         st.peek()<i    3<4
            }                                                                       //                       map.put(3,4)
            stack.push(i);
        }
        for(int i=0;i<nums1.length;i++){
            if(map.containsKey(nums1[i]))
            ans[i]=map.get(nums1[i]);
            else ans[i]=-1;
        }
        return ans;
        
    }
}
