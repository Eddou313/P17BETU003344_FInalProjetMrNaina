package DAO;

import base.DB;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import models.*;

public class PrevisionDao{

    public PrevisionDao(){

    }

    public void insertLigneCredit(int id_user,String libelle,double montant){
        String query = "insert into economie_prevision (id_user,libelle,montant) VALUES (?,?,?)";
        try (Connection conn = DB.getConnection();
            PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1,id_user);
            stmt.setString(2,libelle);
            stmt.setDouble(3,montant);
            stmt.executeUpdate();
        }
         catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Prevision> getAllPrevision(){
        List<Prevision> list = new ArrayList<>();
        String query = "select * from economie_prevision";
        try(Connection conn = DB.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query)) {
                while (rs.next()) {
                    Prevision d = new Prevision(rs.getInt("id_prevision"),rs.getInt("id_user"),rs.getString("libelle"),rs.getDouble("montant"));
                    list.add(d);
                }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public Prevision getById(int id_prevision){
        String query = "select * from economie_prevision where id_prevision = ?";
        try (Connection conn = DB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id_prevision);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Prevision d = new Prevision(rs.getInt("id_prevision"),rs.getInt("id_user"),rs.getString("libelle"),rs.getDouble("montant"));
                    return d;
                }
            }
        
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }

    public double getReste(int id_user,int id_prevision){
        Prevision p = getById(id_prevision);
        DepenseDao dd = new DepenseDao();
        double reste = 0;
        double montantPrevision = p.getMontant();
        double depenseTotalPrevision = dd.getSumDepense(id_user,id_prevision);
        reste = montantPrevision - depenseTotalPrevision;
        return reste;
    }


}