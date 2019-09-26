package controleur;

import java.io.IOException;

import model.Model;




public class Controleur_decryptage
{
	public Model model;
	
	public Controleur_decryptage(Model model)
	{
		this.model = model;
	}

	public void lancementDecryptage() throws IOException
	{
		String test = model.manipulationfichier.lectureFichier();
		
		//Connexion
		boolean etatConnexion = model.cad.Connexion();
		
		if (etatConnexion == true)
		{
			model.decryptage.processusDecryptage(8,test, model.mapdictionnaire, model.cad);
			model.cad.Fermeture();
		}

		String messageDecrypte = model.decryptage.decrypterCaractere(model.decryptage.getCle() , test);
		model.manipulationfichier.ecritureFichier(messageDecrypte);
		
	}

}
