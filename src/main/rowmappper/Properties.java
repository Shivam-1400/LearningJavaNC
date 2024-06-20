package main.rowmappper;

public class Properties {
    private String url;
    private String user;
    private String password;
    public Properties(){
        url= "jdbc:postgresql://127.0.0.1:5432/netcore1";
        user= "postgres";
        password= "mysecretpassword";
    }

    public Properties(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
