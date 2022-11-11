package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBcon {
    private static String dbUrl = "jdbc:postgresql://localhost:5432/SemestrWork";
    private static String dbName = "postgres";
    private static String dbPassword = "BubbleGum2002";
    private static String dbDriver = "org.postgresql.Driver";

    private static Connection connection = null;

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        if (connection == null) {
            Class.forName(dbDriver);
            connection = DriverManager.getConnection(dbUrl,dbName,dbPassword);
            System.out.print("connected");
        }
        return connection;

    }
}

