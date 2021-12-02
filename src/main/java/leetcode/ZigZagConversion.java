package leetcode;

public class ZigZagConversion {
    static boolean isAnyError = false;

    public static void main(String[] args) {
        exec("PAYPALISHIRING", 3, "PAHNAPLSIIGYIR");
        exec("PAYPALISHIRING", 4, "PINALSIGYAHRPI");
        exec("AB", 1, "AB");
        if (isAnyError) {
            System.out.println("\n######## NOT PASSED :( ########");
        } else {
            System.out.println("\nEVERYTHING IS OK :)");
        }
    }

    public static void exec(String input, int numRows, String expected) {
        String actual = buffers(input, numRows);
        if (actual.equals(expected)) {
            System.out.println("OK: " + expected + " == " + actual);
        } else {
            isAnyError = true;
            System.out.println("ERROR: " + expected + " != " + actual);
        }
    }

    private static String buffers(String s, int numRows) {
        char[] chars = s.toCharArray();
        int length = chars.length;
        StringBuffer[] buffers = new StringBuffer[numRows];
        for (int i = 0; i < buffers.length; i++) {
            buffers[i] = new StringBuffer();
        }

        int index = 0;
        while (index < length) {
            for (int j = 0; j < numRows && index < length; j++) {
                buffers[j].append(chars[index++]);
            }
            for (int j = numRows - 2; j > 0 && index < length; j--) {
                buffers[j].append(chars[index++]);
            }
        }

        StringBuilder result = new StringBuilder();
        for (StringBuffer buffer : buffers) {
            result.append(buffer);
        }

        return result.toString();
    }
}
