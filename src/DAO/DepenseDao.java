package DAO;

import base.DB;
import java.sql.*;

public class DepenseDao{

    public DepenseDao(){

    }

    public void insertLigneDepense(int id_user,int id_prevision,double montant){
        PrevisionDao pd = new PrevisionDao();
        double reste = pd.getReste(id_user,id_prevision);
        double sumDepense = getSumDepense(id_user,id_prevision) + montant;

        String query = "insert into economie_depense (id_user,id_prevision,montant) VALUES (?,?,?)";
        if(reste > sumDepense){
            try (Connection conn = DB.getConnection();
                PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setInt(1,id_user);
                stmt.setDouble(2,id_prevision);
                stmt.setDouble(3,montant);
                stmt.executeUpdate();
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        } else if (reste < sumDepense){
            return;
        }
    }

    public double getSumDepense(int id_user,int id_prevision){
        String query = "select sum(montant) as sommeMontant from economie_depense where id_prevision = ? and id_user = ?";
        double d = 0;
        try (Connection conn = DB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id_prevision);
            stmt.setInt(2, id_user);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    d = rs.getDouble("sommeMontant");
                    return d;
                }
            }
        
        } catch (SQLException e) {
            e.printStackTrace();
            return d;
        }
        return d;
    }

}