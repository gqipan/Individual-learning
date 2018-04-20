/**
 * Author: Qipan.G
 * Date: 2018/4/19
 * Time: 18:49
 * Descriptions:
 */
public class GemString {


    public static void main(String[] args) {
        numJewelsInStones("aA", "aAAbbbb");
    }

    public static int numJewelsInStones(String J, String S) {
        // z: ASCII = 122
        // A: ASCII = 65
        // 从0 开始, 数组大小为：122-65+1 = 58
        byte[] location =new  byte[58];

        for (char c : J.toCharArray()) {
            // A - Z 中只要存在，在对应位置标明1
            location[c - 'A'] = 1;
        }
        int result = 0;
        for (char c : S.toCharArray()) {
            if (location[c - 'A'] == 1){
                result++;
            }
        }
        return result;
    }


}
