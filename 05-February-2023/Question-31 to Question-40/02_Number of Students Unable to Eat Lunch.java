class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> q=new LinkedList<>();
        int count=0;
        int i=0;

        for(int x:students){
            q.add(x);
        }
        while(q.size()!=count && !q.isEmpty()){
            if(q.peek()==sandwiches[i]){
                i++;
                count=0;
                q.remove();
            }
            else{
                count++;
                q.offer(q.remove());
            }
        }
        return q.size();
    }
}
