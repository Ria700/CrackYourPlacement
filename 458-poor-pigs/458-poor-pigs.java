import static java.lang.Math.ceil;
import static java.lang.Math.log;
class Solution {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        return (int) ceil(log(buckets) / log(minutesToTest / minutesToDie + 1));
    }
}