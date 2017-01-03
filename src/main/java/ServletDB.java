import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


// write this in browser http://localhost:8080/do?query=euro


public class ServletDB extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("work...");
        String param = request.getParameter("query");
        // USe with servlet
        System.out.println("Param: " + param);
        double price = SQLQuery.dbUpdate(param);
        PrintWriter out = response.getWriter();
        out.println("<HTML>");
        out.println("<BODY");
        out.println("<center>");
        out.println("Result : " + param + " = " + price);

        //use with jsp
//        double price = SQLQuery.dbUpdate(param);
//        System.out.println("price = " + price);
//        request.setAttribute("cash",param);
//        request.setAttribute("result",price);
//        request.getRequestDispatcher("/WEB-INF/views/answer.jsp").forward(request, response);

    }
}
