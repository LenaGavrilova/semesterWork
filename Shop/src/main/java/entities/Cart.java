package entities;

public class Cart {
    private String userLogin;
    private int pid;
    private int amount;

    public Cart() {
    }

    public Cart(String userLogin, int pid, int amount) {
        this.userLogin = userLogin;
        this.pid = pid;
        this.amount = amount;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "userLogin='" + userLogin + '\'' +
                ", pid=" + pid +
                ", amount=" + amount +
                '}';
    }
}

