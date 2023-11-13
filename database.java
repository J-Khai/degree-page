import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class database {
    public static void main(String[] args) {
        String url = "jdbc:mysql://your_database_host:your_port/"; // Replace with your database URL
        String username = "user";
        String password = "password";

        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to the database!");

            Statement statement = conn.createStatement();

            // Create the database only if it doesn't already exist
            String createDatabaseQuery = "CREATE DATABASE IF NOT EXISTS your_database_name";
            statement.executeUpdate(createDatabaseQuery);
            System.out.println("Database created or already exists!");

            // Use the created database
            String useDatabaseQuery = "USE your_database_name";
            statement.executeUpdate(useDatabaseQuery);

            // SQL statements to create tables within the database
            String[] sqlStatements = {
                "CREATE TABLE IF NOT EXISTS Administrator (AdministratorID INT PRIMARY KEY, admin_name VARCHAR(50), degree_prgram VARCHAR(50));",
                "CREATE TABLE IF NOT EXISTS Student (StudentID INT PRIMARY KEY, name VARCHAR(50), degree_program VARCHAR(50));",
                // Add more SQL statements for other tables as needed...
                "CREATE TABLE IF NOT EXISTS AdminLogin (admin_id INT PRIMARY KEY, admin_name VARCHAR(50), login_name VARCHAR(50), login_passowrd VARCHAR(50);",
                "CREATE TABLE IF NOT EXISTS StudentLogin (student_login_id INT PRIMARY KEY, login_name VARCHAR(50), login_password VARCHAR(50);)",
                "CREATE TABLE IF NOT EXISTS Course (course_id INT PRIMARY KEY, course_name VARCHAR(50), course_term VARCHAR(50);)",
                "CREATE TABLE IF NOT EXIST Grade ()"

            };

            // Execute SQL statements to create tables
            for (String sql : sqlStatements) {
                statement.executeUpdate(sql);
            }

            conn.close();
            System.out.println("Tables created successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
