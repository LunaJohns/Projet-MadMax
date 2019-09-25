package controleur;

import model.CAD;
import model.Decryptage;
import model.Map_P;;

public class Controleur_decryptage 
{

	public void lancementDecryptage()
	{
		//Base de données
		CAD cad = new CAD();
		Map_P Map_p = new Map_P();
		
		boolean etatConnexion = cad.Connexion();
		String requete = Map_p.requeteVerifierUtilisateur("utilisateur 1", "0");
		
		if (etatConnexion == true)
		{
			cad.executerRequete(requete);
			cad.Fermeture();
		}
		
		/*
		Decryptage test2 = new Decryptage();
		test2.genererListeCle(0);
		
		int[] t1 = {122,122,122,122};
		//Caractère
		String resultat2 = test2.decrypterCaractere(t1, "test");
		System.out.println(resultat2);
		*/
	}

}
