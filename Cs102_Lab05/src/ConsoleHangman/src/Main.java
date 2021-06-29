public class Main extends BasicSetup {
    private static String[] words = {"Kalem", "Efe" , "Silgi" , "Bardak" };

    @Override
    public String chooseSecretWord()
    {
        int random = (int) (Math.random() * words.length );
        return words[random];
    }
}
