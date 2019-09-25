package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CAD 
{
	public CAD()
	{
		this.etatConnexion = false;
	}
	
	private static String URL = "jdbc:mysql://localhost/madmax?autoReconnect=true&useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";;
	private static String root = "root";
	private static String PASSWORD = "";
	private Connection connexion;
	private Statement statement;
	private ResultSet resultat;
	private boolean etatConnexion;
	private boolean occurranceTrouve = false;
	
	
	public boolean Connexion()
	{
		try 
		{
		    connexion = DriverManager.getConnection( URL, root, PASSWORD );
		    System.out.println("Ouverture de la connexion");
		    statement = connexion.createStatement();
		    etatConnexion = true;
		} 
		catch ( SQLException e )
		{
			System.out.println("Impossible d'ouvrir une connexion, message d'erreur : " + e);
		} 
	    return etatConnexion;
	}
	
	public void Fermeture()
	{
        try 
    	{
        	System.out.println("Fermeture de la connexion");
            /* Fermeture de la connexion */
            connexion.close();
        } 
    	catch ( SQLException e ) 
    	{
    		System.out.println("Impossible de fermer la connexion, message d'erreur : " + e);
        }
	}
	
	public boolean executerRequete(String requete)
	{
		try 
		{
		    //Execution de la requete
		    this.resultat = statement.executeQuery( requete );
		    
		    
		    while (resultat.next())
		    {
		    	int nombreOccurance = resultat.getInt("COUNT(*)");
		    	if (nombreOccurance > 0)
		    	{
		    		occurranceTrouve = true;
		    	}
		    	
		    }
		    
		} 
		catch ( SQLException e ) 
		{
			System.out.println("Impossible d'executer le requete, message d'erreur : " + e);
		}
		return occurranceTrouve;
		
	}
	
}
