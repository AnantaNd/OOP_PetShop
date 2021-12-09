package Account;

public abstract class Akun {
    private String user, password;

    // Constructor
    public Akun(String user, String password) {
        this.user = user;
        this.password = password;
    }

    // Setter & Getter
    public void setUser(String user) {this.user = user;}
    public void setPassword(String password) {this.password = password;}
    public String getUser() {return this.user;}
    public String getPassword() {return this.password; }
    
    abstract void info();
}
