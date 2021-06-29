public class WordSearch extends HTMLFilteredReader {

    public WordSearch(String text, String word) {
        super(text);
        String x = super.getPageContents();
        int wordLength = word.length();
        for (int i = 0; i < x.length() - wordLength; i++) {
            if (x.substring(i, i + wordLength).equals(word)) {
                System.out.println(" Word: " + word + " place in the text is " + i);
            }
        }
    }

    @Override
    public String toString() {
        return "";
    }
}

