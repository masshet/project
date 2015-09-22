import by.masliakov.race.connect.ConnectorDB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

/**
 * Created by mrstark on 21.9.15.
 */
@WebServlet("/connect")
public class MainServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write("Hello, Alex");
        Connection connection = null;
        try {
            connection = new ConnectorDB().getConnection();
            resp.getWriter().write(String.valueOf(connection.isClosed()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
