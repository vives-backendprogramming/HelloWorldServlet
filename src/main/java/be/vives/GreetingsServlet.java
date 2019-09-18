package be.vives;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class GreetingsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // stap 1: return string in response
        // resp.getWriter().println("Hi there from GreetingsServlet!");


        // stap 2: return html in response
        //resp.setContentType("text/html");
        //String message = "<h3>Hi there from GreetingsServlet!</h3><img src='images/hithere.gif'/>";
        //resp.getWriter().write(message);

        // stap 3: query param name
        resp.setContentType("text/html");
        String name = req.getParameter("name");
        String message;
        if(name == null){
            message = "<h3>Hi there from GreetingsServlet!</h3><img src='images/hithere.gif'/>";
        }
        else {
            message = "<h3>Hi there, "+name+"</h3><img src='images/hithere.gif'/>";
        }
        PrintWriter p = resp.getWriter();
        p.write(message);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
}
