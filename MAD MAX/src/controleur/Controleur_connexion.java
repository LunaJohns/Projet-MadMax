package controleur;

import model.CAD;
import model.MapPersonne;
import vue.Vue_Connexion;

public class Controleur_connexion 
{
	public void lancementConnexion()
	{			
		Vue_Connexion fenetreConnexion = new Vue_Connexion();
		
		//Vérification utilisateur
		CAD cad = new CAD();
		MapPersonne Map_p = new MapPersonne();
			
		boolean etatConnexion = cad.Connexion();
		String requete = Map_p.requeteVerifierUtilisateur("utilisateur 1", "1");
			
		if (etatConnexion == true)
		{
			cad.executerRequete(requete);
			cad.Fermeture();
		}
		
	}
}
