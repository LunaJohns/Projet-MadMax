package controleur;

import model.CAD;
import model.Decryptage;
import model.MapDictionnaire;


public class Controleur_decryptage 
{

	public void lancementDecryptage()
	{
		//Initialisation des composants
		CAD cad = new CAD();
		MapDictionnaire Map_dic = new MapDictionnaire();
		Decryptage decryptage = new Decryptage();
		
		//Test cryptage
		int cleTest[] = {97,119,113,112,97,97,97,97,97,97,97,97};
		String test = decryptage.decrypterCaractere(cleTest , "salim bonjour salim");
		
		//Connexion
		boolean etatConnexion = cad.Connexion();
		
		if (etatConnexion == true)
		{
			decryptage.processusDecryptage(8,test, Map_dic, cad);
			cad.Fermeture();
		}

		//String messageDecrypte = decryptage.decrypterCaractere(decryptage.getCle() , "salim bonjour salim");
		
		
	}

}
