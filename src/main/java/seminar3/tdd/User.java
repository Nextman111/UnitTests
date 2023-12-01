package seminar3.tdd;

public class User {

    String name;
    String password;

    boolean isAuthenticate = false;
    private boolean isAdmin = false;

    public User(String name, String password, boolean isAdmin) {
        this.name = name;
        this.password = password;
        this.isAdmin = isAdmin;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public boolean authenticate(String name, String password) {
        return false;
    }

}