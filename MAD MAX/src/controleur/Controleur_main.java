package controleur;

import controleur.Controleur_connexion;
import controleur.Controleur_decryptage;
import model.Model;

public class Controleur_main 
{
	public Model model;
	public Controleur_connexion controleurConnexion;
	public Controleur_decryptage controleurDecryptage;
	
	
	public Controleur_main(Model model)
	{
		this.model = model;
		controleurConnexion = new Controleur_connexion();
		controleurDecryptage = new Controleur_decryptage();
	}
	
	
	
}
