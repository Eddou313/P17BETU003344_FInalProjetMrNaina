package servlets;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

import DAO.*;
import models.*;


public class LoginServlet extends HttpServlet {
@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    String username = request.getParameter("username");
    String password = request.getParameter("password");

    UserDao auth = new UserDao();

    try {
        User user = auth.authentification(username, password);
        if (user != null) {
            HttpSession session = request.getSession();
            session.setAttribute("userId", user.getId());
            response.sendRedirect("dashboard");
        } else {
            request.setAttribute("erreur", "Nom d'utilisateur ou mot de passe incorrect.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
            dispatcher.forward(request, response);
        }
    } catch (Exception e) {
        request.setAttribute("erreur", "Erreur de base de données : " + e.getMessage());
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }
}

}