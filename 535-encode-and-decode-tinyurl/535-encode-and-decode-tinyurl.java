public class Codec {

    HashMap<String, String> map;
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        char c = ((char)(Math.floor(Math.random()*100)));
        sb.append(c);
        while(map.containsKey(sb.toString())) {
            c = ((char)(Math.floor(Math.random()*100)));
            sb.append(c);
        }
        map.put(sb.toString(), longUrl);
        return sb.toString();
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return map.get(shortUrl);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));