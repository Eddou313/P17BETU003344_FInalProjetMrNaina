package DAO;

import base.DB;
import java.sql.*;
import models.*;

public class UserDao{

    public UserDao(){

    }

    public User authentification(String username, String mdp) throws SQLException {
        String query = "select * from economie_user where username = ? and mdp = ?";
        try (Connection conn = DB.getConnection();
            PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, username);
            stmt.setString(2, mdp);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new User(rs.getInt("id_user"), rs.getString("username"), rs.getString("mdp"));
                }
            }
        }
        return null;
    }


}