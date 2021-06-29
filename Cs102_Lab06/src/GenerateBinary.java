public class GenerateBinary {
    public static void main(String[] args) {
        generateBinary(5,"");
    }
    public static void generateBinary(int n, String val){
        if(n == 0) {
            System.out.println(val);
        } else {
            generateBinary(n-1, val + "0");
            if(val.length() != 0 &&
                    val.substring(val.length()-1).equals("0")){
                generateBinary(n-1, val + "1");
            } else if( val.length() == 0) {
                generateBinary(n-1, val + "1");
            }
        }
    }
}
