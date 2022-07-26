package ru.javarush.cryptoanalyzer.gamora.actions.basicactions.textVerification;

public class PunctuationTextVerification implements TextVerification {
    @Override
    public boolean verify(String text) {
        System.out.println("punctuation: ");
        System.out.println("isSpacesAfterCommas: " + isSpacesAfterCommas(text));
        System.out.println("isWhitespacesAfterSentenceEndingMarks: " + isWhitespacesAfterSentenceEndingMarks(text));
        //TODO Code style. Use Russian comments? Bad English is much better than the best Russian comments.
        //оказалось проблемным, выпилено.
        return true;//isSpacesAfterCommas(text) /*&& isWhitespacesAfterSentenceEndingMarks(text)*/;
    }

    /*
     * We know that there's always a space after comma
     * @param text - text to test
     * @return boolean - there's no commas that aren't guided by space
     */
    private boolean isSpacesAfterCommas(String text) {
        String commaRegEx = "[,][^ \n]";
        return noMatch(text, commaRegEx);
    }

    /*
     * We know that there's always a whitespace char (end of line, space, \n) after sentence ending marks (.,...?!)
     * @param text - text to test
     * @return boolean - there's no sentence ending marks that aren't guided by whitespace
     */
    private boolean isWhitespacesAfterSentenceEndingMarks(String text) {
        String sentenceEndingMarksRegEx = "[.\\u2026?!][^\\n $]";
        return noMatch(text, sentenceEndingMarksRegEx);
    }
}
