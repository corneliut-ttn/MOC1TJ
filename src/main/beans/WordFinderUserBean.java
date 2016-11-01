package main.beans;

/**
 * Created by Cornelius on 31.10.2016.
 */
public class WordFinderUserBean {
    private String name;
    private String password;
    private boolean loggedIn;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }
}
