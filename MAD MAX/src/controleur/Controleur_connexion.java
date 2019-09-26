package controleur;

import vue.Vue_Decryptage;

public class Controleur_connexion 
{
	public Controleur_decryptage controleurDecryptage;
	
	public Controleur_connexion(Controleur_decryptage controleurDecryptage)
	{
		this.controleurDecryptage = controleurDecryptage;
	}
	
	public void lancementConnexion(Controleur_decryptage controleurDecryptage)
	{			
		
		Vue_Decryptage fenetreDecryptage = new Vue_Decryptage(controleurDecryptage);
		
	}
}
