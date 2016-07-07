/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.suputilov.texthandlersystem.utils;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;
import ua.suputilov.texthandlersystem.model.Line;
import ua.suputilov.texthandlersystem.model.Text;
import ua.suputilov.texthandlersystem.model.TextFile;

/**
 *
 * @author sergey_putilov
 */
@Component
public class TextHandler {

    public TextFile processText(Text text) {
        TextFile textFile = new TextFile();
        textFile.setLines(splitTextOnLines(text.getText()));
        textFile.setLongestWord(findLongestWord(getAllWords(text.getText())));
        textFile.setSmallestWord(findSmallestWord(getAllWords(text.getText())));
        textFile.setLength(calculateLength(text.getText()));
        textFile.setAvgWordLength(calculateAverageWordLength(getAllWords(text.getText())));

        return textFile;
    }

    /**
     * The method gets list of words from string. The word is a set of
     * characters between two spaces.
     *
     * @param text
     * @return
     */
    private String[] getAllWords(String text) {
        String[] words = text.split("\\s+");

        return words;
    }

    /**
     * The method splits text on lines and creates line objectes.
     *
     * @param text
     * @return List<Line>
     */
    private List<Line> splitTextOnLines(String text) {
        List<Line> lines = new ArrayList<Line>();
        String[] stringLines = text.split("\n");

        for (int i = 0; i < stringLines.length; i++) {
            int lineNumber = i + 1;
            String lineText = stringLines[i];
            Line line = new Line();
            line.setText(lineText);
            line.setLineNumber(lineNumber);
            line.setLongestWord(findLongestWord(getAllWords(lineText)));
            line.setSmallestWord(findSmallestWord(getAllWords(lineText)));
            line.setLength(calculateLength(lineText));
            line.setAvgWordLength(calculateAverageWordLength(getAllWords(lineText)));
            // add to list the Line object
            lines.add(line);
        }

        return lines;
    }

    /**
     * The method finds longest word in the text.
     *
     * @param words
     * @return String
     */
    private String findLongestWord(String[] words) {
        int maxLength = 0;
        String longestWord = "";

        if (words != null) {
            for (String word : words) {
                if (word.length() > maxLength) {
                    maxLength = word.length();
                    longestWord = word;
                }
            }
        }

        return longestWord;
    }

    /**
     * The method finds smallest word in the text.
     *
     * @param words
     * @return String
     */
    private String findSmallestWord(String[] words) {
        int minLength = Integer.MAX_VALUE;
        String smallestWord = "";
        if (words != null) {
            for (String word : words) {
                if (word.length() < minLength) {
                    minLength = word.length();
                    smallestWord = word;
                }
            }
        }

        return smallestWord;
    }

    /**
     * The method calculates text length.
     *
     * @param text
     * @return int
     */
    private int calculateLength(String text) {

        return text.length();
    }

    /**
     * The method calculates average word length in the text.
     *
     * @param words
     * @return int
     */
    private int calculateAverageWordLength(String[] words) {
        int countWords = words.length;
        int countCharacters = 0;

        if (countWords != 0) {
            for (String word : words) {
                countCharacters = countCharacters + word.length();
            }

            return countCharacters / countWords;
        }

        return 0;
    }
}
