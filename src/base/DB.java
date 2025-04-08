package base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {
    private static final String URL = "jdbc:mysql://localhost:3306/Exam";
    private static final String USER = "root";
    // private static final String USER = "root";
    private static final String PASSWORD = "";
    // private static final String PASSWORD = "5U8b8LK3";

    public static Connection getConnection() throws SQLException {
        try {
            // Charger explicitement le pilote MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connexion réussie !");
            return connection;
        } catch (ClassNotFoundException e) {
            System.err.println("Pilote MySQL non trouvé : " + e.getMessage());
            throw new SQLException("Pilote non chargé", e);
        } catch (SQLException e) {
            System.err.println("Erreur de connexion : " + e.getMessage());
            throw e;
        }
    }
}

// package base;

// import java.sql.Connection;
// import java.sql.DriverManager;
// import java.sql.SQLException;

// public class DB {
//     private static final String URL = "jdbc:mysql://localhost:3306/db_s2_ETU003344";
//     private static final String USER = "ETU003344";
//     private static final String PASSWORD = "xj8Ocz78";

//     public static Connection getConnection() throws SQLException {
//         try {
//             Class.forName("com.mysql.cj.jdbc.Driver");
//             Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
//             System.out.println("Connexion réussie !");
//             return connection;
//         } catch (ClassNotFoundException e) {
//             System.err.println("Pilote MySQL non trouvé : " + e.getMessage());
//             throw new SQLException("Pilote non chargé", e);
//         } catch (SQLException e) {
//             System.err.println("Erreur de connexion : " + e.getMessage());
//             throw e;
//         }
//     }
// }