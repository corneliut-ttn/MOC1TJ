package main.beans;

import java.util.HashMap;
import java.util.Set;

/**
 * Created by Cornelius on 31.10.2016.
 */
public class WordFinderResultBean {
    private String sInitialLetters;
    private int nMinSize;
    private Set<String> lFoundWords;
    private String sDbPath;
    private HashMap<String, Boolean> mAllWords;

    public String getsInitialLetters() {
        return sInitialLetters;
    }

    public void setsInitialLetters(String sInitialLetters) {
        this.sInitialLetters = sInitialLetters;
    }

    public int getnMinSize() {
        return nMinSize;
    }

    public void setnMinSize(int nMinSize) {
        this.nMinSize = nMinSize;
    }

    public Set<String> getlFoundWords() {
        return lFoundWords;
    }

    public void setlFoundWords(Set<String> lFoundWords) {
        this.lFoundWords = lFoundWords;
    }

    public String getsDbPath() {
        return sDbPath;
    }

    public void setsDbPath(String sDbPath) {
        this.sDbPath = sDbPath;
    }

    public HashMap<String, Boolean> getmAllWords() {
        return mAllWords;
    }

    public void setmAllWords(HashMap<String, Boolean> mAllWords) {
        this.mAllWords = mAllWords;
    }

    @Override
    public String toString() {
        return "WordFinderBean{" +
                "sInitialLetters='" + sInitialLetters + '\'' +
                ", lFoundWords=" + lFoundWords +
                ", sDbPath='" + sDbPath + '\'' +
                ", mAllWords=" + mAllWords +
                ", Time: " + System.currentTimeMillis() +
                '}';
    }

    public String wordsToString() {
        return "{ lFoundWords=" + lFoundWords + '}';
    }
}
