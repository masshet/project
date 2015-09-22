package by.masliakov.race.connect;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * Created by mrstark on 21.9.15.
 */
public class ConnectorDB {

    static Properties prop;
    static
    {
        prop = new Properties();
        try {
            prop.load(new FileInputStream("WEB-INF/db.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws Exception
    {

        Class.forName(prop.getProperty("driver"));
        Connection con = DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("user"), prop.getProperty("password"));

        return con;
    }
}
