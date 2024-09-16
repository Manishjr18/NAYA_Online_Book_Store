
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


@WebServlet("/CustomerRegisterServlet")
public class CustomerRegisterServlet extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        

      resp.setContentType("text/html");
      
      String mailid,password,firstname,lastname,address,phone;
    mailid=req.getParameter("mailid");
    password=req.getParameter("password");
    firstname=req.getParameter("firstname");
    lastname=req.getParameter("lastname");
    address=req.getParameter("address");
    phone=req.getParameter("phone");
    PrintWriter ps=resp.getWriter();

    try{    
        Class.forName("com.mysql.jdbc.Driver");
        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/Book","root","");
        Statement s=con.createStatement();
        String q="insert into user values('"+mailid+"','"+password+"','"+firstname+"','"+lastname+"','"+address+"','"+phone+"')";
        if(s.executeUpdate(q)==1){
            //ps.print("Registered Succussfully");
            //ps.println("<a href='/webdemo/login'>GO to Login</a>");
        }
    }catch(Exception e){
        ps.println(e.toString());
    }   
// Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    
    

      ps.println("<html>"
              + "<head>"
              + "<title>Preview</title>"
              +"<style>"
               +" body {background-image: url('Photo.jpg');}"
              +"pre {\n" +
"                font-family: Arial;\n" +
"                color: #690b0b;\n" +
               
"            }"
              +"</style>"
              + "</head>"
             
              + "<body backgound="+"/Photo.jpg"+">"
             
              +"<H2>Registered Successfully</h2>"
              + "<pre align-item : center>Welcome "+firstname+" "+lastname + " you are registered as a user</pre>"
                      + "<pre align-item : center><a href="+"CustomerLogin.html"+">Click Here </a> To goto to Login page</pre>"
                                      + "</body>"
                                      + "</html>");
        
// Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
}








