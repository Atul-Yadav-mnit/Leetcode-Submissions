class UndergroundSystem {
    HashMap<String,Integer> sum;
    HashMap<String,Integer> nt;
    HashMap<Integer,String> h;
    HashMap<Integer,Integer> ht;
    public UndergroundSystem() {
        h = new HashMap<Integer,String>();
        ht = new HashMap<Integer,Integer>();
        sum = new HashMap<String,Integer>();
        nt = new HashMap<String,Integer>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        h.put(id,stationName);
        ht.put(id,t);
    }
    
    public void checkOut(int id, String stationName, int t) {
        String sst = h.remove(id);
        int st = ht.remove(id);
        String x = sst+"-"+stationName;
        t = t-st;
        if(nt.containsKey(x))
        {
            nt.put(x,nt.get(x)+1);
        }
        else
        {
            nt.put(x,1);
        }
        
        if(sum.containsKey(x))
        {
            sum.put(x,sum.get(x)+t);
        }
        else
        {
            sum.put(x,t);
        }
    }
    
    public double getAverageTime(String startStation, String endStation) {
        String x = startStation+"-"+endStation;
        double s = sum.get(x);
        double c = nt.get(x);
        return s/c;
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */