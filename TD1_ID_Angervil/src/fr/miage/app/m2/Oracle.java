package fr.miage.app.m2;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class Oracle {
    private Connection conn;
    
    public Oracle()
    {
        super();
    }
    
   /* private void connexion() throws SQLException, ClassNotFoundException
    {
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        }
        catch (ClassNotFoundException ex) 
        {
            System.err.println("Erreur de chargement du driver.");
        }
        
        try 
        {
            this.conn = DriverManager.getConnection("jdbc:oracle:thin:@miage03.dmiage.u-paris10.fr:1521:MIAGE", "auangerv", "apprentis2012pw");
//"jdbc:oracle:thin:@172.19.255.3:1521:MIAGE"

        }
        catch (SQLException ex) 
        {
            System.err.println("Erreur de connexion à la base de données.");
        }  
    }*/
    
    private void deconnexion()
    {
        try
        {
            this.conn.close();      
        }
        catch (SQLException ex) 
        {
            System.err.println("Erreur de deconnexion à la base de données.");
        }    
    }
   
    public int R2() throws SQLException{
    	int i=0; 
    try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
       }catch( Exception ex ) {
           System.err.println( "Erreur lors du chargement du driver" );
           System.exit(1);
       }
   try{
         String url= "jdbc:oracle:thin:@miage03.dmiage.u-paris10.fr:1521:MIAGE";
         Connection cx = DriverManager.getConnection (url,"auangerv","apprentis2012pw");
         Statement st = cx.createStatement();
         ResultSet rs =  st.executeQuery("SELECT provenance FROM ETUDIANT WHERE provenance = 'fr'" );
         while(rs.next()){
        	 i++;
         }
    
         cx.close();
         st.close();
         rs.close();
   
   
   		}catch(SQLException e){
   			System.err.println( "Erreur lors de la cx Ã  la base" );
   			System.exit(1);
   		}
   
    	 return i;

    }
}
