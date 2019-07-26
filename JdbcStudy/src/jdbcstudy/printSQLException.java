/*
 * FileName: printSQLException.java
 * Author: Jeffrey Killen, referenced from docs.oracle.com
 * Date Created: 7/26/19
 * Last Modified:
 * Purpose: This class takes an SQL Exception as input and prints
 *  all available information from that error. This class also contains methods
 *  for checking warnings reported with a Connection or ResultSet object.
 */
package jdbcstudy;

import java.sql.*;

public class printSQLException {
    
    //////////////////////////////////////////////////////////////////////////////////
    
    public static void printSQLException(SQLException ex) {
        
        /*
         * This method handles the printing of the stack trace, sql state, 
         * error code, message, and cause of any thrown SQLException passed in.
        */
        
        for(Throwable e : ex) {
            
           if(e instanceof SQLException) {
               
               if(ingnoreSQLException(((SQLException) e).getSQLState()) == false) {
                   
                   e.printStackTrace(System.err);
                   
                   System.err.println("SQLState: " + ((SQLException)e).getSQLState());
                   
                   System.err.println("Error Code: " + ((SQLException)e).getErrorCode());
                   
                   System.err.println("Message: " + e.getMessage());
                   
                   Throwable t = ex.getCause();
                   
                   while(t != null) {
                       
                       System.out.println("Cause: " + t);
                       t = t.getCause();
                       
                   } // end of while
                   
               } // end of if(ingnoreSQLException(((SQLException) e).getSQLState()) == false) {
               
           } // end of if(e instanceof SQLException) {
            
        } // end of for(Throwable e : ex) {
        
    } // end of public static void printSQLException(SQLException ex) {
    
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    public static boolean ingnoreSQLException(String sqlState) {
        
        /*
         * This method defines specific SQL states to ignore when an 
         * SQLException is thrown.
        */
        
        if(sqlState == null) {
            
            System.out.println("The SQL state is not defined.");
            return false;
            
        } // end of if(sqlState == null) {
        
        //Add specific error codes here to ignore them
        //X0Y32: Jar file already exists in schema
        if(sqlState.equalsIgnoreCase("X0Y32")) {
            
            return true;
            
        } // end of if(sqlState.equalsIgnoreCase("X0Y32")) {
        
        //42Y55: Table already exists in schema
        if(sqlState.equalsIgnoreCase("42Y55")) {
            
            return true;
            
        } // end of if(sqlState.equalsIgnoreCase("42Y55")) {
        
        return false;
        
    } // end of public static boolean ingnoreSQLException(String sqlState) {
    
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    public static void getWarningsFromResultSet(ResultSet rs) throws SQLException {
        
        /*
         * This class retrieves warnings from a ResultSet and passes them
         * to the printWarnings() method.
        */
        
        printSQLException.printWarnings(rs.getWarnings());
        
    } // end of public static void getWarninsFromResultSet(ResultSet rs) throws SQLException {
    
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    public static void getWarningsFromConnection(Connection con) throws SQLException {
        
        /*
         * This class retrieves warnings from a Connection and passes them to
         * the printWarningsd() method.
        */
        
        printSQLException.printWarnings(con.getWarnings());
        
    } // end of public static void getWarningsFromConnection(Connection con) throws SQLException {
    
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    public static void printWarnings(SQLWarning warn) throws SQLException {
        
        /*
         * This method accepts an SQLWarning object as input. If it is not null,
         * the message, state, and error code are printed to the output for each
         * warning.
        */
        
        if(warn != null) {
            
            System.out.println("\n---Warning---\n");
            
        } // end of if
        
        while(warn != null) {
            
            System.out.println("Messaage: " + warn.getMessage());
            System.out.println("SQLState: " + warn.getSQLState());
            System.out.println("Error code: " + warn.getErrorCode());
            System.out.println("");
            warn = warn.getNextWarning();
            
        } // end of while
        
    } // end of public static void printWarnings(SQLWarning warn) throws SQLException {  
    
} // end of class
