import java.io.IOException;

import java.io.PrintWriter;



import java.lang.ProcessBuilder.Redirect.Type;

import java.sql.*;
import java.util.jar.Attributes.Name;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.swing.JOptionPane;

@WebServlet(urlPatterns = {"/adminlog"})

public class YourOrder extends HttpServlet {

protected void processRequest(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

res.setContentType("text/html;charset=UTF-8"); 
PrintWriter pr = res.getWriter();

String firstname = req.getParameter("username"); String password = req.getParameter("password"); 
try {

Class.forName("com.mysql.cj.jdbc.Driver");

Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Book", "root", "");

String sql = "select * from myorder where firstname=? and password=?";

String sql2="Select * from myorder";
PreparedStatement s = con.prepareStatement(sql);
Statement s2=con.createStatement();
s.setString(1, firstname);
s.setString(2, password);
ResultSet rs = s.executeQuery();
ResultSet r=s2.executeQuery(sql2);
if(firstname.equals("admin") && password.equals("admin")){
    if (rs.next()) {
    pr.print("<table style=\"background-color:#DFB86F \" border=2><caption></caption>"+"<tr><th>MailId</th><th>Password</th><th>FirstName</th><th>LastName</th><th>Address</th></tr>");

while(r.next()){

pr.print("<html><head></head><body><tr>"

+ "<td>" + r.getString("mailid") + "</td><td>" + r.getString("password") + "</td><td>" + r.getString("firstname") + "</td>"

+ "<td>" + r.getString("lastname") + "</td><td>" + r.getString("address")+"</td>"+"</tr></body></html>");

}
pr.print(""
            +"<html>"
            +"<head>"
            +"<meta charset=\"ISO-8859-1\">"
            + "<title>Book Store</title>"
            + "<link rel=\"apple-touch-icon\" sizes=\"180x180\" href=\"./favicons/apple-touch-icon.png\">"
            + "<link rel=\"icon\" type=\"image/png\" sizes=\"32x32\" href=\"./favicons/favicon-32x32.png\">"
            + "<link rel=\"icon\" type=\"image/png\" sizes=\"16x16\" href=\"./favicons/favicon-16x16.png\">"
            + "<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css\" >"
            + "<link rel=\"stylesheet\" href=\"styles.css\">"
            + "<style>"
            + "* {\n" +
            "  box-sizing: border-box;\n" +
            "}\n" +
            "\n" +
            ".column {\n" +
            "  float: left;\n" +
            "  width: 33.33%;\n" +
            "  padding: 5px;\n" +
            "}\n" +
            "\n" +
            "/* Clearfix (clear floats) */\n" +
            ".row::after {\n" +
            "  content: \"\";\n" +
            "  clear: both;\n" 
            + "  display: table;\n" 
            + "}"

            + "div {text-align: center;}"

    
            + "</style>"
            + "</head>"
            + "<body onload=\"funload()\">"
            + "<header>"
            + "<nav class=\"navbar navbar-expand-sm bg-dark\">\n" +
"				<a class=\"navbar-brand\">\n" +
"					<!-- The below line can be an image or a h1, either will work -->\n" +
"					\n" +
"				</a>\n" +
"				\n" +
"				<button style=\"background-color:white;\" class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarNav\" aria-controls=\"navbarNav\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n" +
"				    <span class=\"navbar-toggler-icon\" ></span>\n" +
"				 </button>\n" +
"\n" +
"                <div class=\"collapse navbar-collapse\" id=\"navbarNav\">                \n" +
"				<ul class=\"navbar-nav\" >\n" +
"					<li class=\"nav-item\"><span><a class=\"nav-link active\" href=\"index.html\">Home</a></span></li>\n" +
"					<li class=\"nav-item \"><span><a class=\"nav-link\" href=\"CustomerLogin.html\">Login</a></span></li>\n" +
"					<li class=\"nav-item \"><span><a class=\"nav-link\" href=\"YourOrder.java\">User_Order</a></span></li>\n" +
"				</ul>\n" +
"				</div>\n" +
"			</nav>"
            
            + "</header>"
            + ""
//            + "<br>"
//            + "<div id=\"topmid\"><h1>User Details</h1></div>"
//            + "<br>"
//          
//            +"<h3><a href="+"delete.html"+">Click Here To Delete User</a></h3>"
//            + "<table class=\"tab\">"
            + "<tr>"
            + "<td><a href=\"index.html\" id=\"happy\">Life is Learning<br>!!Welcome to our book store!!</a></td>"
           
            + "</tr>"
            + "</table>"
            + "</body>"
            +"</html>"
        
        
);
}
}
}catch (SQLException | ClassNotFoundException e)
        { 
        pr.print(e.toString());

}
}


@Override

protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

processRequest(request, response);

}

@Override

protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

processRequest(request, response);

}

@Override

public String getServletInfo() {

return "Short description";

}

}

/**
 *
 * @author manis
 */

