public class Codec {

    HashMap<Integer,String> h = new HashMap<Integer,String>();
    int count = 0;
    String p = "http://tinyurl.com/";
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        count++;
        h.put(count,longUrl);
        return p+String.valueOf(count);
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        String x = shortUrl.substring(19);
        int y = Integer.valueOf(x);
        return h.get(y);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));