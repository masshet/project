import by.masliakov.race.connect.ConnectorDB;
import by.masliakov.race.exception.TechnicalException;

import java.sql.*;
//import oracle.jdbc.driver.*;

/**
 * Created by mrstark on 21.9.15.
 */
public class Main {
    public static void main(String[] args) throws TechnicalException, SQLException {
        Connection connection = null;
        try {
            connection = new ConnectorDB().getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(connection.isClosed());
    }
}
