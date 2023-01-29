//using iterations

class Solution {
    public int calPoints(String[] ops) {
        int[] a =  new int[1000];
        int index = 0;
        int sum = 0;
        for(String op : ops){
            switch (op){
                case "C":
                    sum -= a[index-1];
                    index--;
                    break;
                case "D":
                    a[index] = 2*a[index-1];
                    sum+=a[index];
                    index++;
                    break;
                case "+":
                    a[index] = a[index-1] + a[index-2];
                    sum+=a[index];
                    index++;
                    break;
                default:
                    a[index] = Integer.parseInt(op);
                    sum+=a[index];
                    index++;
                    break;
            }
        }
        return sum;
    }
}

//using stack

class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> st=new Stack<>();

        for(int i=0;i<operations.length;i++){
            if("+".equals(operations[i])){
                int op1 =st.pop();
                int op2 = op1+st.peek();
                st.push(op1);
                st.push(op2);
            }
            else if("C".equals(operations[i])){
                st.pop();
            }
            else if("D".equals(operations[i])){
                st.push(2*st.peek());
            }
            else{
                st.push(Integer.parseInt(operations[i]));
            }
        }
        int res=0;
        while(!st.isEmpty()){
            res+=st.pop();
        }
        return res;
    }
}
