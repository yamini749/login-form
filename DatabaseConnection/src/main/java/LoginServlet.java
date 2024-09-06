import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import javax.servlet.annotation.*;
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Student", "root", "root");

            String name = request.getParameter("textName");
            String marks = request.getParameter("textMarks");

            PreparedStatement ps = con.prepareStatement("SELECT name FROM records WHERE name=? AND marks=?");
            ps.setString(1, name);
            ps.setString(2, marks);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                RequestDispatcher rd = request.getRequestDispatcher("welcome.jsp");
                rd.forward(request, response);
            } else {
                out.println("<font color='red' size='18'>Login Failed!!<br>");
                out.println("<a href='index.jsp'>Try Again!!</a>");
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            out.close();
        }
    }
}
