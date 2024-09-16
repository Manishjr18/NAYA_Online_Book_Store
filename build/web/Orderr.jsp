<%-- 
    Document   : admin.jsp
    Created on : 16-Oct-2023, 5:36:37 pm
    Author     : manis
--%>
<%@ page import="java.sql.*" %>
<%@ page import="javax.sql.*" %>
<%@ page import="javax.naming.*" %>

<%@ page import="java.io.*,java.util.*"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Book Store</title>
<link rel="apple-touch-icon" sizes="180x180"
	href="./favicons/apple-touch-icon.png">
<link rel="icon" type="image/png" sizes="32x32"
	href="./favicons/favicon-32x32.png">
<link rel="icon" type="image/png" sizes="16x16"
	href="./favicons/favicon-16x16.png">
<link rel="manifest" href="./favicons/site.webmanifest">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css">
<link rel="stylesheet" href="styles.css">
<!-- JavaScript Bundle with Popper -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js">
	
</script>

<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js">
	
</script>
<link rel="stylesheet" href="styles.css">
<style>
.row {
	display: -ms-flexbox; /* IE10 */
	display: flex;
	-ms-flex-wrap: wrap; /* IE10 */
	flex-wrap: wrap;
	margin: 0 -16px;
}

.col-25 {
	-ms-flex: 25%; /* IE10 */
	flex: 25%;
}

.col-50 {
	-ms-flex: 50%; /* IE10 */
	flex: 50%;
}

.col-75 {
	-ms-flex: 75%; /* IE10 */
	flex: 75%;
}

.col-25, .col-50, .col-75 {
	padding: 0 16px;
}

.container {
	background-color: #f2f2f2;
	padding: 5px 20px 15px 20px;
	border: 1px solid lightgrey;
	border-radius: 3px;
}

input[type=text] {
	width: 100%;
	margin-bottom: 20px;
	padding: 12px;
	border: 1px solid #ccc;
	border-radius: 3px;
}

label {
	margin-bottom: 10px;
	display: block;
}

.icon-container {
	margin-bottom: 20px;
	padding: 7px 0;
	font-size: 24px;
}

.btn {
	background-color: #04AA6D;
	color: white;
	padding: 12px;
	margin: 10px 0;
	border: none;
	width: 100%;
	border-radius: 3px;
	cursor: pointer;
	font-size: 17px;
}

.btn:hover {
	background-color: #45a049;
}

span.price {
	float: right;
	color: grey;
}

/* Responsive layout - when the screen is less than 800px wide, make the two columns stack on top of each other instead of next to each other (and change the direction - make the "cart" column go on top) */
@media ( max-width : 800px) {
	.row {
		flex-direction: column-reverse;
	}
	.col-25 {
		margin-bottom: 20px;
	}
}
</style>
</head>
    <body onload="funload()">
	<header>
		<nav class="navbar navbar-expand-sm bg-dark">
				<a class="navbar-brand">
					<!-- The below line can be an image or a h1, either will work -->
					
				</a>
				
				<button style="background-color:white;" class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
				    <span class="navbar-toggler-icon" ></span>
				 </button>

                <div class="collapse navbar-collapse" id="navbarNav">                
				<ul class="navbar-nav" >
					<li class="nav-item"><span><a class="nav-link active" href="index.html">Home</a></span></li>
					<li class="nav-item "><span><a class="nav-link" href="CustomerLogin.html">Login</a></span></li>

				</ul>
				</div>
			</nav>
	</header>
        <%
    String book_name = request.getParameter("one");
    out.println("<h2><strong>Your Orders</strong></h2>");
    out.print(book_name);
    

    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;
    try {
        // Load the JDBC driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        // Establish the connection
           conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Book", "root", "");
        

        // Create a statement
        stmt = conn.createStatement();

        // Execute a query to retrieve id, bookname, and price
        String sql = "SELECT * FROM books where ID='one'";
        rs = stmt.executeQuery(sql);
out.println("abc");
        
        if (rs.next()){
            
            out.print(rs.getString(1)+rs.getString(2)+rs.getString(3));
            }

        // Iterate through the result set and display the information
        while (rs.next()) {
        out.print("<br>");
            String id = rs.getString("id");
            String bookname = rs.getString("bookname");
            String price = rs.getString("price");
            out.println("<tr><td>" + id + "</td><td>" + bookname + "</td><td>" + price + "</td></tr>");
        }

        // Print HTML table footer
        out.println("</table>");

    } catch (Exception e) {
        e.printStackTrace();
    } %>
    </body>

</html>
