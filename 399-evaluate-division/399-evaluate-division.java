class Solution {
    public double[] calcEquation(List<List<String>> e, double[] v, List<List<String>> q) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        ArrayList<ArrayList<Double>> val = new ArrayList<ArrayList<Double>>();
        HashMap<String,Integer> h = new HashMap<String,Integer>();
        for(int i=0;i<e.size();i++)
        {
            String a = e.get(i).get(0);
            String b = e.get(i).get(1);
            if(h.containsKey(a))
            {
                if(h.containsKey(b))
                {
                    int x = h.get(a);
                    int y = h.get(b);
                    adj.get(x).add(y);
                    adj.get(y).add(x);
                    val.get(x).add(v[i]);
                    val.get(y).add(1/v[i]);
                }
                else
                {
                    int x = h.get(a);
                    h.put(b,h.size());
                    ArrayList<Integer> t1 = new ArrayList<Integer>();
                    ArrayList<Double> t2 = new ArrayList<Double>();
                    adj.add(t1);
                    val.add(t2);
                    int y = h.get(b);
                    adj.get(x).add(y);
                    adj.get(y).add(x);
                    val.get(x).add(v[i]);
                    val.get(y).add(1.0/v[i]);
                }
            }
            else
            {
                if(h.containsKey(b))
                {
                    int y = h.get(b);
                    h.put(a,h.size());
                    ArrayList<Integer> t1 = new ArrayList<Integer>();
                    ArrayList<Double> t2 = new ArrayList<Double>();
                    adj.add(t1);
                    val.add(t2);
                    int x = h.get(a);
                    adj.get(x).add(y);
                    adj.get(y).add(x);
                    val.get(x).add(v[i]);
                    val.get(y).add(1.0/v[i]);
                }
                else
                {
                    h.put(a,h.size());
                    ArrayList<Integer> t1 = new ArrayList<Integer>();
                    ArrayList<Double> t2 = new ArrayList<Double>();
                    adj.add(t1);
                    val.add(t2);
                    int x = h.get(a);
                    h.put(b,h.size());
                    ArrayList<Integer> t3 = new ArrayList<Integer>();
                    ArrayList<Double> t4 = new ArrayList<Double>();
                    adj.add(t3);
                    val.add(t4);
                    int y = h.get(b);
                    adj.get(x).add(y);
                    adj.get(y).add(x);
                    val.get(x).add(v[i]);
                    val.get(y).add(1/v[i]);
                }
            }
        }
        double ans[] = new double[q.size()];
        Arrays.fill(ans,-1.0);
        for(int i=0;i<q.size();i++)
        {
            if( h.containsKey(q.get(i).get(0)) && h.containsKey(q.get(i).get(1)) )
            {
                int x = h.get(q.get(i).get(0));
                int y = h.get(q.get(i).get(1));
                
                if(x == y)
                {
                    ans[i]*=-1;
                }
                else
                {
                    ArrayList<Integer> arr = new ArrayList<Integer>();
                    ArrayList<Double> varr = new ArrayList<Double>();
                    int vis[] = new int[h.size()];
                    arr.add(x);
                    varr.add(1.0);
                    vis[x] = 1;
                    while(arr.size()>0)
                    {
                        if(ans[i]!=-1)
                        {
                            break;
                        }
                        int a = arr.remove(0);
                        double b = varr.remove(0);
                        for(int j=0;j<adj.get(a).size();j++)
                        {
                            
                            int p = adj.get(a).get(j);
                            double qq = val.get(a).get(j);
                            if(vis[p]==0)
                            {
                                
                                vis[p] = 1;
                                arr.add(p);
                                varr.add(qq*b);
                                if(p == y)
                                {
                                    ans[i] = qq*b;
                                    break;
                                }
                            }
                        }
                       // System.out.println(arr);
                    }
                }
            }
        }
        return ans;
    }
}