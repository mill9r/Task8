<%@ page import="java.sql.*" %>
<% Class.forName("com.mysql.jdbc.Driver"); %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<HTML>
<HEAD>
    <TITLE>Fetching Data From a Database</TITLE>
</HEAD>

<BODY>
<H1>Fetching Data From a Database</H1>

<%
    Connection con = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/student?useSSL=false", "root", "unreal2k3");
    String param = request.getParameter("query");

    String query = "SELECT price,cash from student.cash WHERE cash =" + "'" + param + "'";
    Statement stmt = con.createStatement();
    ResultSet rs = stmt.executeQuery(query);


    if (!rs.next()) {
        out.println("Sorry, could not find that publisher. ");
    } else {
%>

<TABLE BORDER="1">
    <TR>
        <TH><%= param%>
        </TH>
    </TR>
    <TR>
        <TD><%= rs.getDouble("price") %>
        </TD>
    </TR>
</TABLE>
<BR>
<%
    }
%>
</BODY>
</HTML>