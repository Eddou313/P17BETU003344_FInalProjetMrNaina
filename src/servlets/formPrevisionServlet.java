package servlets;

import java.io.*;

import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class formPrevisionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            request.getRequestDispatcher("prevision.jsp").forward(request, response);
        }catch (Exception e) {
        request.setAttribute("erreur", "Erreur : " + e.getMessage());
        RequestDispatcher dispatcher = request.getRequestDispatcher("prevision.jsp");
        dispatcher.forward(request, response);
    }
    }
}