/*
 * FileName: JdbcStudy.java
 * Author: Jeffrey Killen
 * Date Created: 7/25/19
 * Last Modified:
 * Purpose: A driver class for testing JDBC, Java and MySQL
 */

package jdbcstudy;

import java.sql.*;
import java.sql.DatabaseMetaData;

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
            PrintSQLException.getWarningsFromConnection(con);
            
            stmt = con.createStatement();
            
            //////Create Tables/////
            //stmt.executeUpdate(CreateTables.createTableSuppliers());
            //stmt.executeUpdate(CreateTables.createTableCoffees());
            //stmt.executeUpdate(CreateTables.createTableMerch());
            //stmt.executeUpdate(CreateTables.createTableHouses());
            //stmt.executeUpdate(CreateTables.createTableInventory());
            
            /////Populate Tables/////
            CreateTables.populateTableSuppliers(stmt);
            CreateTables.populateTableCoffees(stmt);
            
            /////Query Database/////
            String query = "select COF_NAME, SUP_ID, PRICE, " +
                    "SALES, TOTAL " +
                    "from ebookshop.COFFEES";
            
            ResultSet rs = stmt.executeQuery(query);
            
            while(rs.next()) {
                
                String coffeeName = rs.getString("COF_NAME");
                int supplierID = rs.getInt("SUP_ID");
                float price = rs.getFloat("PRICE");
                int sales = rs.getInt("SALES");
                int total = rs.getInt("TOTAL");
                System.out.println(coffeeName + "\t" + supplierID +
                        "\t" + price + "\t" + sales +
                        "\t" + total);
                
            } // end of while(rs.net()) {
            
            //Test for ResultSet types
            DatabaseMetaData md = con.getMetaData();
            
            System.out.println("");
            if(md.supportsResultSetType(ResultSet.TYPE_FORWARD_ONLY)) {
                System.out.println("This setup supports Type Forward!");
            } else {
                System.out.println("Type Forward not supported!");
            } // end of if/else {
            
            if(md.supportsResultSetType(ResultSet.TYPE_SCROLL_INSENSITIVE)) {
                System.out.println("This setup supports Scroll Insensitive");
            } else {
                System.out.println("Scroll Insensitive not supported!");
            } // end of if/else {
            
            if(md.supportsResultSetType(ResultSet.TYPE_SCROLL_SENSITIVE)) {
                System.out.println("This setup supports Scroll Sensitive");
            } else {
                System.out.println("Scroll Sensitive not supported!");
            } // end of if/else {
            
            /////Delete Table Values/////                        
            stmt.executeUpdate("delete from COFFEES;");
            stmt.executeUpdate("delete from SUPPLIERS;");
            
            /////Clean up/////
            stmt.close();
        
        } catch(SQLException sqlEx) {
            
            PrintSQLException.printSQLException(sqlEx);
            
        } // end of try/catch
        
    } // end of main()
    
} //end of class
