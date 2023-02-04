class pair{
    int f=0;
    int s=0;
    int time=0;

    pair(int f,int s,int time){
        this.f=f;
        this.s=s;
        this.time=time;
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        Queue<pair> q=new LinkedList<>();
        int n=grid.length;
        int m=grid[0].length;
        int vis[][] =new int[n][m];
        int countfresh=0;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    q.offer(new pair(i,j,0));
                    vis[i][j]=2;
                }
                else{
                    vis[i][j]=0;
                }
                if(grid[i][j]==1) countfresh++;
            }
        }

       

        int cnt=0;int tm=0;
        int dx[]={-1,0,1,0};
        int dy[]={0,1,0,-1};

        while(!q.isEmpty()){
            int x=q.peek().f;
            int y=q.peek().s;
            int t=q.peek().time;
            tm=Math.max(tm,t);
            q.remove();

            for(int i=0;i<4;i++){
                int nrow=x+dx[i];
                int ncol=y+dy[i];

                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && grid[nrow][ncol]==1 && vis[nrow][ncol]==0){
                    q.offer(new pair(nrow,ncol,t+1));
                    vis[nrow][ncol]=2;
                    cnt++;
                }
            }
        }
        if(cnt!=countfresh) return -1;
        return tm;
    }
}
