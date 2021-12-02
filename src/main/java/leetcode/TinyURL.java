package leetcode;

import java.util.HashMap;
import java.util.Map;

public class TinyURL {

    static Map<String, String> codeUrlMap = new HashMap<>();
    static Map<String, String> urlCodeMap = new HashMap<>();

    static final int codeLength = 10;
    static char[] chars;

    static {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i <= 9; i++) {
            builder.append(i);
        }
        for (char c = 'A'; c <= 'Z'; c++) {
            builder.append(c);
        }
        for (char c = 'a'; c <= 'z'; c++) {
            builder.append(c);
        }
        chars = builder.toString().toCharArray();
    }

    public static void main(String[] args) {
        Utils.exec(TinyURL::encode, "", "");
    }

    private static String getCode() {
        char[] code = new char[codeLength];
        for (int i = 0; i < codeLength; i++) {
            int randomCharIndex = (int) (Math.random() * chars.length);
            code[i] = chars[randomCharIndex];
        }
        return "http://tinyurl.com/" + String.valueOf(code);
    }

    // Encodes a URL to a shortened URL.
    public static String encode(String longUrl) {
        if (urlCodeMap.containsKey(longUrl)) return urlCodeMap.get(longUrl);

        String code = getCode();
        while (urlCodeMap.containsKey(code)) {
            code = getCode();
        }

        urlCodeMap.put(longUrl, code);
        codeUrlMap.put(code, longUrl);

        return code;
    }

    // Decodes a shortened URL to its original URL.
    public static String decode(String shortUrl) {
        return codeUrlMap.get(shortUrl);
    }
}
