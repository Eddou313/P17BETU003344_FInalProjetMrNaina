package servlets;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import models.*;

import java.util.*;

import DAO.*;

public class dashboardServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            HttpSession session = request.getSession();
            int userId = (int) session.getAttribute("userId");
            PrevisionDao pd = new PrevisionDao();
            DepenseDao dd = new DepenseDao();
            List<Dashboard> listD = new ArrayList<>();
            
            List<Prevision> listPrevision = pd.getAllPrevision();

            for(Prevision p : listPrevision){
                double depense = dd.getSumDepense(userId,p.getId());
                double reste = pd.getReste(userId,p.getId());
                Dashboard db = new Dashboard(p.getLibelle(),depense,reste);
                listD.add(db);
            }

        try{
            request.setAttribute("listDash",listD);
            request.getRequestDispatcher("dashboard.jsp").forward(request, response);
        }catch (Exception e) {
        request.setAttribute("erreur", "Erreur : " + e.getMessage());
        RequestDispatcher dispatcher = request.getRequestDispatcher("dashboard.jsp");
        dispatcher.forward(request, response);
    }
    }
}