/*
 * FileName: CreateTables.java
 * Author: Jeffrey Killen
 * Date Created: 07/30/19
 * Last Modified:
 * Purpose: This class uses the JDBC Java Tutorial information to set up
        MySQL databases for use in later lessons.
 */
package jdbcstudy;

import java.sql.*;

public class CreateTables {
    
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    public static String createTableSuppliers() {
        
        String createString = "create table " + "ebookshop" + 
                ".SUPPLIERS " +
                "(SUP_ID integer NOT NULL, " +
                "SUP_NAME varchar(40) NOT NULL, " +
                "STREET varchar(40) NOT NULL, " +
                "CITY varchar(20) NOT NULL, " +
                "STATE char(2) NOT NULL, " +
                "ZIP char(5), " +
                "PRIMARY KEY (SUP_ID))";
        
        return createString;      
        
    } // end of public String createTableSuppliers() throws SQLException {
    
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    public static String createTableCoffees() {
        
        String createString = "create table " + "ebookshop" +
                ".COFFEES " +
                "(COF_NAME varchar(32) NOT NULL, " +
                "SUP_ID integer NOT NULL, " +
                "PRICE float NOT NULL, " +
                "SALES integer NOT NULL, " +
                "TOTAL integer NOT NULL, " +
                "PRIMARY KEY (COF_NAME), " +
                "FOREIGN KEY (SUP_ID) REFERENCES ebookshop.SUPPLIERS (SUP_ID))";
        
        return createString;
        
    } // end of public String createTableCoffees() throws SQLException {
    
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    public static String createTableInventory() {
        
        String createString = "create table ebookshop.COF_INVENTORY " +
                "(WAREHOUSE_ID char(4) NOT NULL, " +
                "COF_NAME varchar(32) NOT NULL, " +
                "SUP_ID integer NOT NULL, " +
                "QUAN integer NOT NULL, " +
                "DATE_VAL DATE NOT NULL, " +
                "PRIMARY KEY (WAREHOUSE_ID), " +
                "FOREIGN KEY (SUP_ID) REFERENCES ebookshop.SUPPLIERS (SUP_ID), " +
                "FOREIGN KEY (COF_NAME) REFERENCES ebookshop.COFFEES (COF_NAME))";
        
        return createString;        
        
    } // end of public String createTableInventory() throws SQLException {
    
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    public static String createTableMerch() {
        
        String createString = "create table ebookshop.MERCH_INVENTORY " +
                "(ITEM_ID integer NOT NULL, " +
                "ITEM_NAME varchar(40) NOT NULL, " +
                "SUP_ID integer NOT NULL, " +
                "QUAN integer NOT NULL, " +
                "DATE date NOT NULL, " +
                "PRIMARY KEY (ITEM_ID), " +
                "FOREIGN KEY (SUP_ID) REFERENCES ebookshop.SUPPLIERS (SUP_ID))";
        
        return createString;
        
    } // end of public static String createTableMerch() throws SQLException {
    
    public static String createTableHouses() {
        
        String createString = "create table ebookshop.COFFEE_HOUSES " +
                "(STORE_ID integer NOT NULL, " +
                "CITY varchar(40) NOT NULL, " +
                "COFFEE integer NOT NULL, " +
                "MERCH integer NOT NULL, " +
                "TOTAL integer NOT NULL, " +
                "PRIMARY KEY (STORE_ID))";
        
        return createString;               
        
    } // end of public static String createTableHouses() throws SQLException {

    public static void populateTableSuppliers(Statement stmt) throws SQLException {
                
        /*stmt.executeUpdate("insert into ebookshop.SUPPLIERS " +
                "values(?, '?', " +
                "'?', " +
                "'?', '?', '?')");*/
        
        stmt.executeUpdate("insert into ebookshop.SUPPLIERS " +
                "values(49, 'Superior Coffee', " +
                "'1 Party Place', " +
                "'Mendocino', 'CA', '95460')");
        
        stmt.executeUpdate("insert into ebookshop.SUPPLIERS " +
                "values(101, 'Acme, Inc.', " +
                "'99 Market Street', " +
                "'Groundsville', 'CA', '95199')");
        
        stmt.executeUpdate("insert into ebookshop.SUPPLIERS " +
                "values(150, 'The High Ground', " +
                "'100 Coffee Lane', " +
                "'Meadows', 'CA', '93966')");
        
        
    } // end of public void String populateTableSuppliers() {
    
} // end of class
