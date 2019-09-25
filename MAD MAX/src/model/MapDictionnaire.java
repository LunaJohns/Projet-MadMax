package model;

public class MapDictionnaire 
{
	private String requete;
	
	public MapDictionnaire()
	{
		
	}
	public String requeteVerifierMot(String texte)
	{
		requete = "SELECT COUNT(*) FROM dictionnaire WHERE `mot`=\"" + texte + "\"";
		return requete;
	}
}
