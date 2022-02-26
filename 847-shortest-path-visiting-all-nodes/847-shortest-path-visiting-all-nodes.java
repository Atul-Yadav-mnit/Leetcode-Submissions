class Solution {
    public int shortestPathLength(int[][] graph) {
        if (graph.length == 1) {
            return 0;
        }
        
        int n = graph.length;
        int endingMask = (1 << n) - 1;
        boolean[][] seen = new boolean[n][endingMask];
        ArrayList<int[]> queue = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            queue.add(new int[] {i, 1 << i});
            seen[i][1 << i] = true;
        }
        
        int steps = 0;
        while (!queue.isEmpty()) {
            ArrayList<int[]> nextQueue = new ArrayList<>();
            for (int i = 0; i < queue.size(); i++) {
                int[] currentPair = queue.get(i);
                int node = currentPair[0];
                int mask = currentPair[1];
                for (int neighbor : graph[node]) {
                    int nextMask = mask | (1 << neighbor);
                    if (nextMask == endingMask) {
                        return 1 + steps;
                    }
                    
                    if (!seen[neighbor][nextMask]) {
                        seen[neighbor][nextMask] = true;
                        nextQueue.add(new int[] {neighbor, nextMask});
                    }
                }
            }
            steps++;
            queue = nextQueue;
        }
        
        return -1;
    }
}
/*
class Solution {
    public int n;
    public int adj[][];
    
    class Node
    {
        int vis[];
        int cur;
        int score;
        Node(int cur, int score, int vis[])
        {
            this.cur = cur;
            this.score =score;
            this.vis = new int[n];
            for(int i=0;i<n;i++)
            {
                this.vis[i] = vis[i];
            }
        }
    }
    public int fun(int s)
    {
        int vis[] = new int[n];
        vis[s] = 1;
        ArrayDeque<Node> arr = new ArrayDeque<Node>();
        arr.add(new Node(s,0,vis));
        while(arr.size()>0)
        {
            Node temp = arr.removeFirst();
            for(int i=0;i<n;i++)
            {
                if(adj[temp.cur][i] == 1)
                {
                    int v[] = new int[n];
                    int count =0;
                    for(int j=0;j<n;j++)
                    {
                        v[j] = temp.vis[j];
                        count+=v[j];
                    }
                    if(v[i] == 0)
                    {
                        count++;
                    }
                    
                    if(count == n)
                    {
                        return temp.score;
                    }
                    v[i] = 1;
                    arr.add(new Node(i,temp.score+1,v));
                }
            }
            
        }
        return -1;
        
    }
    public int shortestPathLength(int[][] graph) {
        n = graph.length;
        adj = new int[n][n];
        for(int i=0;i<graph.length;i++)
        {
            for(int j=0;j<graph[i].length;j++)
            {
                adj[graph[i][j]][i]=1;
                adj[i][graph[i][j]]=1;
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i=0;i<n;i++)
        {
            int x  =fun(i);
            System.out.println(x+" "+i);
            min = Math.min(x,min);
        }
        return min;
    }
}*/