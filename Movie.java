package net.sqlitetutorial;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author sqlitetutorial.net
 */
class Movie{

    /**
     * Create a new table in the test database
     *
     */
    public static void createNewTable() {
        // SQLite connection string
        String url = "jdbc:sqlite:C://sqlite/db/Movies.db";
        
        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS Movies (\n"
                + "	name text PRIMARY KEY,\n"
                + "	actorsname text NOT NULL,\n"
                + "	actressname text NOT NULL,\n"
                + "	releaseyear int\n"
                + " director text NOT NULL,\n"
                + ");";
        
        try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        createNewTable();
    }
}