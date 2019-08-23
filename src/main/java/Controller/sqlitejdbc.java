package Controller;

import java.sql.*;

public class sqlitejdbc {

  //  create crud functions
    public static void main( String args[] ) {
        Connection c = null;

        try {
         //   Class.forName("");
            //Class.forName("com.mysql.jdbc.Driver").newInstance();
            Class.forName("xerial.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:swingyDB.db");
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Opened database successfully");
    }
//
//    public static void testconn() {
//        Connection c = null;
//
//        try {
//            //   Class.forName("");
//
//            c = DriverManager.getConnection("jdbc:sqlite:swingyDB.db");
//        } catch ( Exception e ) {
//            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
//            System.exit(0);
//        }
//        System.out.println("Opened database successfully");
//    }
}
