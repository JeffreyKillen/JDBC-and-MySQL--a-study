/*
 * FileName: JdbcConnectionTest.java
 * Author: Jeffrey Killen
 * Date Created: 7/25/19
 * Last Modified:
 * Purpose: To test the DriverManager object for establishing connections
    to a MySQL database with JDBC.
 */
package jdbcstudy;

import java.sql.*;
import java.util.Properties;

public class JdbcConnectionTest {
    
    //Variables
    private String userName;
    private String password;
    private String db;
    
    //Constructors
    public JdbcConnectionTest() {
        
        /*
         * Default Constructor
        */
        
    } // end of JdbcConnectionTest()
    
    public JdbcConnectionTest(String user, String pass, String db) {
        
        /*
         * This constructor set the username, password and database
         * address Strings
        */
        
        this.userName = user;
        this.password = pass;
        this.db = db;
        
    } // end of public JdbcConnectionTest(String user, String pass, String db) {
    
    
    public Connection getConnection() throws SQLException {
        
        Connection con = null;
        Properties connectionProps = new Properties();
        connectionProps.put("user", this.userName);
        connectionProps.put("password", this.password);
        
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + db + "?create=true", connectionProps);
        
        System.out.println("Connected to database.");
        
        return con;
        
    } // end of public Connection getConnection() throws SQLException {
    
} // end of class
