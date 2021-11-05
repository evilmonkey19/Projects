package meu;

/**
 *
 * @author upcnet
 */
import java.sql.*;

public class FirstExample {

    static final String DB_URL = "jdbc:mysql://localhost:3306/primerabbdd?serverTimezone=UTC";
    static final String USER = "ecomm";
    static final String PASS = "ecomm";

    public static void main(String[] args) {

        try {

            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();

            String insert1 = "INSERT INTO usuari (nom, cognom) VALUES (?, ?)";
            PreparedStatement pst = conn.prepareStatement(insert1);
            pst.setString(1, "john");
            pst.setString(2, "smith");
            pst.executeUpdate();

            ResultSet rs = stmt.executeQuery("SELECT * FROM usuari");

            while (rs.next()) {
                System.out.println("nom: " + rs.getString("nom")+" , cognom: " + rs.getString("cognom"));
            }

            java.util.Date utilDate = new java.util.Date();
            java.sql.Timestamp sqlTS = new java.sql.Timestamp(utilDate.getTime());
            String insert2 = "INSERT INTO missatge (contingut, data, emissor, receptor) VALUES (?,?,?,?)";

            PreparedStatement pst2 = conn.prepareStatement(insert2);
            pst2.setString(1, "hola");
            pst2.setString(2, sqlTS.toString());
            pst2.setString(3, "2");
            pst2.setString(4, "3");
            pst2.executeUpdate();

            rs = stmt.executeQuery("SELECT contingut FROM missatge WHERE emissor='2'");

            while (rs.next()) {
                System.out.println("contingut: " + rs.getString("contingut"));
            }

            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
