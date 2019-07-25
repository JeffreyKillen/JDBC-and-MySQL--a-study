package jdbcstudy;

/**
 *
 * @author Jeffrey
 */

import java.sql.*;

public class JdbcStudy {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        JdbcConnectionTest ct = new JdbcConnectionTest("root", "password", "ebookshop");
        
        try {
            
            ct.getConnection();
        
        } catch(SQLException sqlEx) {
            
            System.out.println("Something bad happened.");
            sqlEx.printStackTrace();
            
        } // end of try/catch
        
    } // end of main()
    
} //end of class
