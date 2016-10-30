package main;

import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Cornelius on 30.10.2016.
 */
public class WordFinderBean {

    static public String LOG_PATH = "E:\\MOC1\\JT\\Projects\\WordFinder\\src\\log";
    static public String DB_PATH = "E:\\MOC1\\JT\\Projects\\WordFinder\\src\\database";

    private String sInitialLetters;
    private int nMinSize;
    private Set<String> lFoundWords;
    private String sDbPath;
    private HashMap<String, Boolean> mAllWords;

    public WordFinderBean() {

    }

    public WordFinderBean(String sFileName) {
        this.sDbPath = DB_PATH + "\\" + sFileName;
        lFoundWords = new HashSet<>();
        mAllWords = new HashMap<>();
        init();
    }

    public static String getLogPath() {
        return LOG_PATH;
    }

    public static void setLogPath(String logPath) {
        LOG_PATH = logPath;
    }

    public static String getDbPath() {
        return DB_PATH;
    }

    public static void setDbPath(String dbPath) {
        DB_PATH = dbPath;
    }

    private void init() {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(sDbPath));
            try {
                String line = br.readLine();

                while (line != null) {
                    String word = line.split("( |\t)")[0];
                    mAllWords.put(word.toLowerCase(), Boolean.TRUE);
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
            Logger.getLogger(WordFinderServlet.class.getName()).log(Level.WARNING, "Dictionary file not found:" + sDbPath, ex);
        }
    }

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

    void findWords(String sInput, int nSize) {
        this.sInitialLetters = sInput;
        this.nMinSize = nSize;
        permutation("", sInput, nSize);
    }

    private void permutation(String prefix, String sInput, int nSize) {
        int n = sInput.length();
        if (n != 0) {
            for (int i = 0; i < n; i++) {
                String pre = prefix + sInput.charAt(i);
                if ((pre != null) && (!pre.isEmpty()) && (mAllWords.containsKey(pre.toLowerCase())) && (pre.length() >= nSize)) {
                    lFoundWords.add(pre);
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
