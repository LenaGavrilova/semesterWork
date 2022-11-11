package entities;

public class Order {
    private int id;
    private String login;
    private int pid;

    public Order() {
    }

    public Order(int id, String login, int pid) {
        this.id = id;
        this.login = login;
        this.pid = pid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", pid=" + pid +
                '}';
    }
}
