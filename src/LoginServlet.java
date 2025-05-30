import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.servlet.*;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String u = req.getParameter("username");
        String p = req.getParameter("password");

        resp.setContentType("text/html");

        String stored = UserStore.users.get(u);
        if (stored != null && stored.equals(p)) {
            resp.getWriter().println("Welcome, " + u + "!");
        } else {
            resp.getWriter().println("Invalid login. <a href='/login.html'>Try again</a>");
        }
    }
}
