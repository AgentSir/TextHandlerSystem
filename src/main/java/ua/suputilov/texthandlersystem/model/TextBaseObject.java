/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.suputilov.texthandlersystem.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 *
 * @author sergey_putilov
 */
@MappedSuperclass
public abstract class TextBaseObject {

    private String longestWord;
    private String smallestWord;
    private int length;
    private int avgWordLength;

    /**
     * @return the longestWord
     */
    @Column(name = "longest_word")
    public String getLongestWord() {

        return longestWord;
    }

    /**
     * @param longestWord the longestWord to set
     */
    public void setLongestWord(String longestWord) {
        this.longestWord = longestWord;
    }

    /**
     * @return the smallestWord
     */
    @Column(name = "smallest_word")
    public String getSmallestWord() {

        return smallestWord;
    }

    /**
     * @param smallestWord the smallestWord to set
     */
    public void setSmallestWord(String smallestWord) {
        this.smallestWord = smallestWord;
    }

    /**
     * @return the length
     */
    @Column(name = "length")
    public int getLength() {

        return length;
    }

    /**
     * @param length the length to set
     */
    public void setLength(int length) {
        this.length = length;
    }

    /**
     * @return the avgWordLength
     */
    @Column(name = "average_word_length")
    public int getAvgWordLength() {

        return avgWordLength;
    }

    /**
     * @param avgWordLength the avgWordLength to set
     */
    public void setAvgWordLength(int avgWordLength) {
        this.avgWordLength = avgWordLength;
    }
}
