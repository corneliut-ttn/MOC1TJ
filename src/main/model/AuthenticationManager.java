package main.model;

import main.servlets.WordFinderServlet;

import java.io.*;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Cornelius on 31.10.2016.
 */
public class AuthenticationManager {

    static public String USERS_PATH = "E:\\MOC1\\JT\\Projects\\WordFinder\\src\\resources\\users.txt";
    static public int ERR_WRONG_PASS = -1;
    static public int ERR_NO_USER = -2;
    static public int ERR_USER_EXISTS = -3;

    static public int LOGIN_SUCCESS = 1;
    static public int REGISTER_SUCCESS = 2;
    private HashMap<String, String> mUserData;

    public AuthenticationManager() {
        init();
    }

    private void init() {
        mUserData = new HashMap<>();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(USERS_PATH));
            try {
                String line = br.readLine();

                while (line != null) {
                    String[] info = line.split("(,|;| )");
                    if (info.length == 2)
                        this.mUserData.put(info[0], info[1]);
                    line = br.readLine();
                }

            } catch (IOException ex) {
                Logger.getLogger(AuthenticationManager.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    br.close();
                } catch (IOException ex) {
                    Logger.getLogger(AuthenticationManager.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(WordFinderServlet.class.getName()).log(Level.WARNING, "User data files not found:" + USERS_PATH, ex);
        }
    }

    public int login(String sUserName, String sUserPassword) {
        if (mUserData.containsKey(sUserName)) {
            if (mUserData.get(sUserName).equals(sUserPassword)) {
                return LOGIN_SUCCESS;
            }
            return ERR_WRONG_PASS;
        }
        return ERR_NO_USER;
    }

    public int register(String sUserName, String sUserPassword) {
        if (!mUserData.containsKey(sUserName)) {
            try {
                PrintWriter usersWriter = new PrintWriter(new BufferedWriter(new FileWriter(USERS_PATH, true)));

                usersWriter.write("\n" + sUserName + "," + sUserPassword + "\n");
                usersWriter.flush();
                usersWriter.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            init();
            return REGISTER_SUCCESS;
        }
        return ERR_USER_EXISTS;
    }
}
