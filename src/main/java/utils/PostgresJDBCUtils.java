package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgresJDBCUtils {
	public static Connection getConnection() throws ClassNotFoundException {
        String host = "localhost";
        String port = "5432";
        String dbname = "struts1_test";
        String user = "postgres";
        String pass = "root";
        String dburl = "jdbc:postgresql://" + host + ":" + port + "/" + dbname + "?loggerLevel=OFF";
        Connection conn = null;
        try {
        	//Class.forName("org.postgresql.Driver");
           DriverManager.registerDriver(new org.postgresql.Driver());
            conn = DriverManager.getConnection(dburl, user, pass);
        } catch ( SQLException e) {
            throw new RuntimeException(e);
        }
        return conn;
    }
}
