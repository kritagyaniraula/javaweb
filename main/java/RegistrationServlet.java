import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.registrationcontroller.PasswordEncoder;

@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String uname = request.getParameter("name");
        String uemail = request.getParameter("email");
        String upwd = request.getParameter("pass");
        String oupwd = PasswordEncoder.encodePassword(upwd);
        String urepwd = request.getParameter("re_pass");
        String orepwd = PasswordEncoder.encodePassword(urepwd);
        String umobile = request.getParameter("contact");
        RequestDispatcher dispatcher = null;
        Connection con = null;

      
        if (uname == null || uname.trim().isEmpty()) {
            request.setAttribute("status", "InvalidName");
        } else if (uemail == null || !uemail.matches("\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,}\\b")) {
            request.setAttribute("status", "InvalidEmail");
        } else if (oupwd == null || oupwd.trim().isEmpty()) {
            request.setAttribute("status", "InvalidPassword");
        } else if (!oupwd.equals(orepwd)) {
            request.setAttribute("status", "InvalidPasswordMatch");
        } else if (umobile == null || !umobile.matches("\\d{10}")) {
            request.setAttribute("status", "InvalidMobile");
        } else {
           
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/company?useSSL=false", "root", "Asdf54321@");
                PreparedStatement pst = con.prepareStatement("INSERT INTO users(uname, upwd, uemail, umobile) VALUES (?, ?, ?, ?)");
                pst.setString(1, uname);
                pst.setString(2, oupwd);
                pst.setString(3, uemail);
                pst.setString(4, umobile);

                int rowCount = pst.executeUpdate();

                if (rowCount > 0) {
                    request.setAttribute("status", "sucess");
                } else {
                    request.setAttribute("status", "failed");
                }

            } catch (Exception e) {
                e.printStackTrace();
                request.setAttribute("status", "failed");
            } finally {
                try {
                    if (con != null) {
                        con.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        dispatcher = request.getRequestDispatcher("registration.jsp");
        dispatcher.forward(request, response);
    }
}
