package by.masliakov.race.connect;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * Created by mrstark on 21.9.15.
 */
public class ConnectorDB {

    private static final String DRIVER = "oracle.jdbc.OracleDriver";
    private static final String CONNECTION = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String USER = "Hippodrome";
    private static final String PASSWORD = "qriddickp1";

    public static Connection getConnection() throws Exception
    {

        Class.forName(DRIVER);
        Connection con = DriverManager.getConnection(CONNECTION, USER, PASSWORD);

        return con;
    }
}
