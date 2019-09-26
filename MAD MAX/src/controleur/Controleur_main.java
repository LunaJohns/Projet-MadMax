package controleur;

import java.io.IOException;

import controleur.Controleur_connexion;
import controleur.Controleur_decryptage;
import model.Model;

public class Controleur_main 
{
	public Model model;
	public Controleur_connexion controleurConnexion;
	public Controleur_decryptage controleurDecryptage;
	
	
	public Controleur_main(Model model) throws IOException
	{
		this.model = model;
		
		controleurDecryptage = new Controleur_decryptage(model);
		controleurConnexion = new Controleur_connexion(controleurDecryptage);
	}
	
	
	
}
