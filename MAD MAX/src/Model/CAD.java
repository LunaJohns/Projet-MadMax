package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CAD 
{
	public CAD()
	{
		
	}
	private static String URL = "jdbc:mysql://localhost/madmax?autoReconnect=true&useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";;
	private static String root = "root";
	private static String PASSWORD = "";
	private String QuerySelect = "";
	Connection connexion = null;
	
	
	public void Connexion(String requete)
	{
		try {
		    connexion = DriverManager.getConnection( URL, root, PASSWORD );
		    
		    Statement statement = connexion.createStatement();
		 
		    //Requete Select
		    QuerySelect = requete;
		    ResultSet resultat = statement.executeQuery( QuerySelect );
		    
		    
		    while (resultat.next())
		    {
		    	int idUtilisateur = resultat.getInt("id");
		    	String Identificant = resultat.getString("Identifiant");
		    	String Mdp = resultat.getString("Mdp");
		    	
		    	System.out.println("id de l'utilisateur : " + idUtilisateur + " Identifiant : " + Identificant + " mdp : " + Mdp);
		    	
		    }
		    
		} catch ( SQLException e ) {
		    /* Gérer les éventuelles erreurs ici */
		} finally {
		    if ( connexion != null )
		        try {
		            /* Fermeture de la connexion */
		            connexion.close();
		        } catch ( SQLException ignore ) {
		            /* Si une erreur survient lors de la fermeture, il suffit de l'ignorer. */
		        }
		}
	}
	
}
