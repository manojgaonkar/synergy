package serv;

/*
 * ConnectionPool.java
 *
 * Created on February 29, 2008, 4:37 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.naming.Context;

/**
 *
 * @author MD
 */
public class ConnectionPool {
    
    private Connection con = null;      
    
    
    private String _Driver = null;
    private String _Host = null;
    private String _Port = null;
    private String _DataBase = null;
   
    
    public static String _user = null ; //  "root";
    public static String _password = null ; // "syncomp";
    
    private Context initCtx = null;
    
    public ConnectionPool(){
    
//    Hashtable<Object,Boolean> ht = null ;
    
    /** Creates a new instance of ConnectionPool */
  
   
//    public ConnectionPool(HttpServletRequest request) {     
//        
//        HttpSession hs = request.getSession();
//        
//        userPassword(hs);   **********************************     
//        
        _Driver = "jdbc:mysql:";
        _Host = "server" ; //"localhost";
        _Port = "3306";
        _DataBase = "kmfmktgNew";
        _user = "root";
        _password = "syncomp";   
//        
        
}        
    
    public Connection getconnection(){
        
//        ht = new Hashtable<Object,Boolean>();    
        
        try {
//            first step to Connect to Database
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        
            con = DriverManager.getConnection(_Driver
                    +"//"
                    +_Host+":"
                    +_Port+"/"
                    +_DataBase+"?user="
                    +_user+"&password="
                    +_password);                
                
        } catch (InstantiationException ex) {
            ex.printStackTrace();
            System.out.print("Can not Connect 1");
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
            System.out.print("Can not Connect 2");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            System.out.print("Can not Connect 3");
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.print("Can not Connect 4");
        }      
        
        return this.con;
    }
    
//    public Connection getconnection(){        
//        
//        try{      
//            
//            Hashtable env = new Hashtable();
//            
//            env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.rmi.registry.RegistryContextFactory");            
//            
//            initCtx = new InitialContext(env);
//            
//            DataSource ds = (DataSource) initCtx.lookup("BEMULDB");
//            
//            con =  ds.getConnection(_user,_password);
//            
//        } catch (Exception ex) {
//            System.out.println("Couldn't create connection." + ex.getMessage());
//            JOptionPane.showMessageDialog(null,new String("Couldn't create connection."+ex.toString()));
//            try {
//                throw new Exception("Couldn't open connection to database: " + ex.getMessage());
//            } catch (Exception ex1) {
//                ex1.printStackTrace();
//            }
//        }                                        
//        return con ;
//    }
        
//  public synchronized Connection Getconnection(){
//
//        try {
////            first step to Connect to Database
//            Class.forName("com.mysql.jdbc.Driver").newInstance();
//        
//            con = DriverManager.getConnection(_Driver
//                    +"//"
//                    +_Host+":"
//                    +_Port+"/"
//                    +_DataBase+"?user="
//                    +_user+"&password="
//                    +_password);                
//                
//        } catch (InstantiationException ex) {
//            ex.printStackTrace();
//            System.out.print("Can not Connect 1");
//        } catch (IllegalAccessException ex) {
//            ex.printStackTrace();
//            System.out.print("Can not Connect 2");
//        } catch (ClassNotFoundException ex) {
//            ex.printStackTrace();
//            System.out.print("Can not Connect 3");
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//            System.out.print("Can not Connect 4");
//        }                
//        return con;
//    }    
    
    
//    public void removeObject(){
//        
//        
//      try {
//            
//            Hashtable env = new Hashtable();
//            
//            env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.rmi.registry.RegistryContextFactory");            
//            
//            initCtx = new InitialContext(env);
//            
//            initCtx.unbind("BEMULDB");
//            
//        } catch (NamingException ex) {
//            ex.printStackTrace();
//        }                      
//    }
    
}
