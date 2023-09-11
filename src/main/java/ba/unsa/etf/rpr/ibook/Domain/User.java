package ba.unsa.etf.rpr.ibook.Domain;

import ba.unsa.etf.rpr.ibook.Dao.Idable;

public class User implements Idable {
    private int id;
    private String username;
    private String password;

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User() {
    }
}
