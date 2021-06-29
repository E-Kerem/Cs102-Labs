import java.io.File;
import java.util.Arrays;

public class NumberOfFiles {
    public static void main(String[] args) {
        File file = new File("/Users/kerem/Documents/School/Cs101:102/Cs102");
        System.out.println(Arrays.toString(file.listFiles()));
        System.out.println(count(file));
    }

    public static long count(File file) {
        long size;
        if (file.isDirectory()) {
            size = 0;
            for (File child : file.listFiles()) {
                size += count(child);
            }
        } else {
            size = file.length();
        }
        return size;
    }
}
