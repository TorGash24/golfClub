package ru.javarush.golfclub;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "sumServlet", value = "/sumServlet")
public class MySumServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String aParam = req.getParameter("a");
        String bParam = req.getParameter("b");
        String color = "blue";
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = resp.getWriter();

        HttpSession session = req.getSession();
        long creationTime = session.getCreationTime();
        String id = session.getId();

        int status = resp.getStatus();


        int sum = Integer.parseInt(aParam) + Integer.parseInt(bParam);

        try {
            writer.println("SUM = " + sum);
            writer.println("<br>");
            writer.println("creationTime = " + creationTime);
            writer.println("<br>");
            writer.println("id = " + id);
            writer.println("<br>");
            writer.println("SUM = " + sum);
            writer.println("<br>");
            writer.println("<h1 style=color:" + color + ">PrivetGolf</h1>");
            writer.println("<br>");
            writer.println("Status=" + status);
            writer.println("<br>");
            writer.println("<a href=hello-servlet>Hello Servlet</a>");
        } finally {
            writer.close();
        }



    }
}
