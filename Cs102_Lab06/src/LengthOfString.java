public class LengthOfString {
    public static void main(String[] args) {
        System.out.println(calculate("Kerem efe"));
    }
    public static int calculate(String str) {
        if(str.length() == 0)
            return 0;
        else
            return 1 + calculate(str.substring(1));
    }
}
