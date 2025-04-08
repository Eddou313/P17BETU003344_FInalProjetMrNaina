package servlets;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

import DAO.*;


public class DepenseServlet extends HttpServlet 
{
@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    HttpSession session = request.getSession();
    int userId = (int) session.getAttribute("userId");
    int id_prevision = Integer.parseInt(request.getParameter("id_prevision"));
    double montant = Double.parseDouble(request.getParameter("montant"));

    DepenseDao dd = new DepenseDao();

    try {
            dd.insertLigneDepense(userId,id_prevision,montant);
            request.setAttribute("succes", "depense inserer avec succes");
            response.sendRedirect("formDepense?succes");
            // RequestDispatcher dispatcher = request.getRequestDispatcher("depense.jsp");
            // dispatcher.forward(request, response);
        
    } catch (Exception e) {
        request.setAttribute("erreur", "Erreur de base de données : " + e.getMessage());
        response.sendRedirect("formDepense?erreur = "+e.getMessage()+"");

    }
}

}