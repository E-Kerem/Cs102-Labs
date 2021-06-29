import cs1.SimpleURLReader;

public class MySimpleURLReader extends SimpleURLReader {
    private String urlName;

    public MySimpleURLReader(String s) {
        super(s);
        this.urlName = s;
    }

    public String getURL() {
        return urlName;
    }

    public String getName() {
        String tmp = "";
        for (int i = urlName.length() - 1; i > 0; i--) {
            if (urlName.charAt(i) == '/') {
                break;
            }
            tmp += urlName.charAt(i);
        }
        String x = new StringBuffer(tmp).reverse().toString();
        String result = x;
        return result;
    }

    public int getNumberOfCSSLinks() {
        String search = "<link";
        String search2 = ".css";
        int index = getPageContents().indexOf(search);
        int index2 = getPageContents().indexOf(search2);
        int count = 0;
        while (index >= 0) {
            if(index2 > 0) {
                count++;
                index2 = getPageContents().indexOf(search2, index2 + 1);
            }
            index = getPageContents().indexOf(search, index + 1);
        }
        return count;
    }

}
