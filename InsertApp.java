package net.sqlitetutorial;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author sqlitetutorial.net
 */
public class InsertApp {

    /**
     * Connect to the test.db database
     *
     * @return the Connection object
     */
    private Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:C://sqlite/db/test.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    /**
     * Insert a new row into the warehouses table
     *
     * @param name
     * @param actorname
     * @param actressname
     * @param releaseyear
     * @param director
     */
    public void insert(String name, String actorname,String actressname,int releaseyear,String director) {
        String sql = "INSERT INTO Movies(name,actorname,actressname,releaseyear,director) VALUES(?,?,?,?,?)";

        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setString(2, actorname);
            pstmt.setString(3, actressname);
            pstmt.setInt(4, releaseyear);
            pstmt.setString(5, director);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        InsertApp app = new InsertApp();
        // insert three new rows
        app.insert("October sky","Jake gyllenhaal","Laura dern",1999,"Joe jonston");
        app.insert("Rurouni kenshin the beginning","Takeru satoh","Kasumi arimura",2021,"Keishi ohtomo");
        app.insert("The batman","Robert pattinson","Zoe kravitz",2022,"Matt reeves");
    }

}