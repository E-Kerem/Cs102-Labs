public class NonVowel {
    public static void main(String[] args) {
        System.out.println(count("CS102 is a good course"));
    }
    public static int count(String str) {
        str = str.toLowerCase();
        if(str.length() == 0)
            return 0;
        else if( str.charAt(0) == 'a' || str.charAt(0) == 'e'
                || str.charAt(0) == 'i' || str.charAt(0) == 'o' || str.charAt(0) == 'u')
            return 1 + count(str.substring(1));
        else
            return count(str.substring(1));
    }
}
