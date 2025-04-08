package servlets;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

import java.util.List;

import DAO.*;
import models.*;

public class formDepenseServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrevisionDao pd = new PrevisionDao();
        List<Prevision> listPrevision = pd.getAllPrevision();
        try{   
            request.setAttribute("listPrevision",listPrevision);
            request.getRequestDispatcher("depense.jsp").forward(request, response);

        }catch (Exception e) {
            request.setAttribute("erreur", "Erreur : " + e.getMessage());
            RequestDispatcher dispatcher = request.getRequestDispatcher("prevision.jsp");
            dispatcher.forward(request, response);
        }
    }
}