package model;

public class Map_P 
{	
	private String requete;
	
	public Map_P()
	{
		
	}
	public String requeteVerifierUtilisateur(String utilisateur,String mdp)
	{
		requete = "SELECT COUNT(*) FROM utilisateurs WHERE `Identifiant`=\"" + utilisateur + "\" and `Mdp`=\"" + mdp + "\"";
		return requete;
	}
}
