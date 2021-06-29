public class HTMLFilteredReader extends MySimpleURLReader {

    public HTMLFilteredReader(String s) {
        super(s);
    }

    public String getPageContents() {
        boolean flag = true;

        String result = "";

        for(int i = 0; i < super.getPageContents().length(); i++) {
            if( super.getPageContents().charAt(i) == '<' ) {
                flag = false;
            }
            else if ( flag ) {
                result += super.getPageContents().charAt(i);
            }
            else if ( super.getPageContents().charAt(i) == '>' ) {
                flag = true;
            }
        }
        return result;
    }

    public String  getUnfilteredPageContents() {
        return super.getPageContents();
    }


}
