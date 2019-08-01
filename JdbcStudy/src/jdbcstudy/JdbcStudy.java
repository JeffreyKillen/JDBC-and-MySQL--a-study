/*
 * FileName: JdbcStudy.java
 * Author: Jeffrey Killen
 * Date Created: 7/25/19
 * Last Modified:
 * Purpose: A driver class for testing JDBC, Java and MySQL
 */

package jdbcstudy;

import java.sql.*;

public class JdbcStudy {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        JdbcConnectionTest ct = new JdbcConnectionTest("root", "password", "ebookshop");
        Connection con;
        Statement stmt = null;
        
        try {
            
            con = ct.getConnection();
            printSQLException.getWarningsFromConnection(con);
            
            stmt = con.createStatement();
            
            CreateTables.populateTableSuppliers(stmt);
            
            stmt.close();
        
        } catch(SQLException sqlEx) {
            
            printSQLException.printSQLException(sqlEx);
            
        } // end of try/catch
        
    } // end of main()
    
} //end of class
