import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.servlet.*;
import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String u = req.getParameter("username");
        String p = req.getParameter("password");

        resp.setContentType("text/html");

        if (UserStore.users.containsKey(u)) {
            resp.getWriter().println("Username taken. <a href='/register.html'>Try again</a>");
        } else {
            UserStore.users.put(u, p);
            resp.getWriter().println("Registered! <a href='/login.html'>Login now</a>");
        }
    }
}
