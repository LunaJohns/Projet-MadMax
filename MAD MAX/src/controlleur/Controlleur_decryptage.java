package controlleur;

import model.CAD;
import model.Decryptage;
import model.MapDictionnaire;


public class Controlleur_decryptage 
{

	public void lancementDecryptage()
	{
		//Initialisation des composants
		CAD cad = new CAD();
		
		MapDictionnaire Map_dic = new MapDictionnaire();
		Decryptage decryptage = new Decryptage();
		
		//Connexion
		boolean etatConnexion = cad.Connexion();
		
		if (etatConnexion == true)
		{
			decryptage.genererListeCle(0,"", Map_dic, cad);
	
			cad.Fermeture();
		}
		
		
	}

}
