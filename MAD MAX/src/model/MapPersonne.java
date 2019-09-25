package model;

public class MapPersonne 
{	
	private String requete;
	
	public MapPersonne()
	{
		
	}
	public String requeteVerifierUtilisateur(String utilisateur,String mdp)
	{
		requete = "SELECT COUNT(*) FROM utilisateurs WHERE `Identifiant`=\"" + utilisateur + "\" and `Mdp`=\"" + mdp + "\"";
		return requete;
	}
}
