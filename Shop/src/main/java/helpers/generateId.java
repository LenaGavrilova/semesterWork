package helpers;

public class generateId {
    public generateId() {
    }

    public static int id = 13;

    public static int genId() {
        id += 1;
        return id;
    }
}
