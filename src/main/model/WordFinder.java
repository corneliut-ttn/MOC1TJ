package main.model;

import main.beans.WordFinderResultBean;
import main.servlets.WordFinderServlet;

import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Cornelius on 30.10.2016.
 */
public class WordFinder {

    static public String LOG_PATH = "E:\\MOC1\\JT\\Projects\\WordFinder\\src\\log";
    static public String DB_PATH = "E:\\MOC1\\JT\\Projects\\WordFinder\\src\\database";

    private WordFinderResultBean wordFinderResultBean;

    public WordFinder(String sFileName) {
        wordFinderResultBean = new WordFinderResultBean();
        wordFinderResultBean.setsDbPath(DB_PATH + "\\" + sFileName);
        wordFinderResultBean.setlFoundWords(new HashSet<>());
        wordFinderResultBean.setmAllWords(new HashMap<>());
        init();
    }

    public WordFinderResultBean getWordFinderResultBean() {
        return wordFinderResultBean;
    }

    private void init() {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(wordFinderResultBean.getsDbPath()));
            try {
                String line = br.readLine();

                while (line != null) {
                    String word = line.split("( |\t)")[0];
                    wordFinderResultBean.getmAllWords().put(word.toLowerCase(), Boolean.TRUE);
                    line = br.readLine();
                }

            } catch (IOException ex) {
                Logger.getLogger(WordFinderServlet.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    br.close();
                } catch (IOException ex) {
                    Logger.getLogger(WordFinderServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(WordFinderServlet.class.getName()).log(Level.WARNING, "Dictionary file not found:" + wordFinderResultBean.getsDbPath(), ex);
        }
    }

    public void findWords(String sInput, int nSize) {
        wordFinderResultBean.setsInitialLetters(sInput);
        wordFinderResultBean.setnMinSize(nSize);
        permutation("", sInput, nSize);
    }

    private void permutation(String prefix, String sInput, int nSize) {
        int n = sInput.length();
        if (n != 0) {
            for (int i = 0; i < n; i++) {
                String pre = prefix + sInput.charAt(i);
                if ((pre != null) && (!pre.isEmpty()) && (wordFinderResultBean.getmAllWords().containsKey(pre.toLowerCase())) && (pre.length() >= nSize)) {
                    wordFinderResultBean.getlFoundWords().add(pre);
                }
                permutation(prefix + sInput.charAt(i), sInput.substring(0, i) + sInput.substring(i + 1, n), nSize);
            }
        }
    }

    public void toLogFile() {
        BufferedWriter bw = null;
        String sLogFile = LOG_PATH + "\\log.txt";
        try {
            bw = new BufferedWriter(new FileWriter(sLogFile, true));
            bw.write(this.toString());
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
