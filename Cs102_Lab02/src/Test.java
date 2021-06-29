import cs1.*;

public class Test {
    public static void main(String[] args) {
        String url1 = "http://www.cs.bilkent.edu.tr/~ozturk/cs102/housman.txt";
        String url2 = "http://www.cs.bilkent.edu.tr/~ozturk/cs102/scrapethissite.html";

        SimpleURLReader a1 = new SimpleURLReader(url1);
        MySimpleURLReader b1 = new MySimpleURLReader(url2);
        HTMLFilteredReader c1 = new HTMLFilteredReader(url2);
        WordSearch d1;

        System.out.println("----------------------------------------------------------");
        System.out.println("This is the content of this URL: \n" + a1.getPageContents());
        System.out.println("This URL has " + a1.getLineCount() + " lines \n");

        System.out.println("----------------------------------------------------------");
        System.out.println(" URL is : " + b1.getURL());
        System.out.println(" Name of the url is " + b1.getName() + "\n");

        System.out.println("----------------------------------------------------------");
        System.out.println(" This url2 has " + b1.getNumberOfCSSLinks() + " .css links \n");
        b1 = new MySimpleURLReader(url1);
        System.out.println(" This url1 has " + b1.getNumberOfCSSLinks() + " .css links ");

        System.out.println("----------------------------------------------------------");
        System.out.println("This is the content of this URL: " + c1.getPageContents() + "\n");

        System.out.println("----------------------------------------------------------");
        System.out.println(new WordSearch(url2, "Turkey"));
        System.out.println(new WordSearch(url2, "Ankara"));
    }
}
