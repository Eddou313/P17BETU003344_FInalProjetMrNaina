package servlets;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

import DAO.*;


public class PrevisionServlet extends HttpServlet {
@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    HttpSession session = request.getSession();
    int userId = (int) session.getAttribute("userId");
    String libelle = request.getParameter("libelle");
    double montant = Double.parseDouble(request.getParameter("montant"));

    PrevisionDao pd = new PrevisionDao();

    try {
            pd.insertLigneCredit(userId,libelle,montant);
            request.setAttribute("succes", "prevision inserer avec succes");
            RequestDispatcher dispatcher = request.getRequestDispatcher("prevision.jsp");
            dispatcher.forward(request, response);
        
    } catch (Exception e) {
        request.setAttribute("erreur", "Erreur de base de données : " + e.getMessage());
        RequestDispatcher dispatcher = request.getRequestDispatcher("prevision.jsp");
        dispatcher.forward(request, response);
    }
}

}