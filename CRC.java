public class CRC {
    public static void main(String[] args) {
        String data = "11010110";
        String key = "1001";
        String result = calculateCRC(data, key);
        System.out.println("CRC 校验位为：" + result);
    }

    public static String calculateCRC(String data, String key) {
        int l_key = key.length();
        String appended_data = data + repeat('0', l_key - 1);
        String remainder = mod2div(appended_data, key);
        return remainder;
    }

    public static String mod2div(String divident, String divisor) {
        int pick = divisor.length();
        String tmp = divident.substring(0, pick);
        while (pick < divident.length()) {
            if (tmp.charAt(0) == '1') {
                tmp = xor(divisor, tmp) + divident.charAt(pick);
            } else {
                tmp = xor(repeat('0', pick), tmp) + divident.charAt(pick);
            }
            pick += 1;
        }
        if (tmp.charAt(0) == '1') {
            tmp = xor(divisor, tmp);
        } else {
            tmp = xor(repeat('0', pick), tmp);
        }
        return tmp;
    }

    public static String xor(String a, String b) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < b.length(); i++) {
            if (a.charAt(i) == b.charAt(i)) {
                result.append('0');
            } else {
                result.append('1');
            }
        }
        return result.toString();
    }

    public static String repeat(char c, int length) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < length; i++) {
            result.append(c);
        }
        return result.toString();
    }
}