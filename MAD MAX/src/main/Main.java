package main;

import controleur.Controleur_connexion;
import controleur.Controleur_decryptage;

public class Main 
{
	public static void main(String[] args) 
	{
		
		//Controleur_connexion controleurConnexion = new Controleur_connexion();
		//controleurConnexion.lancementConnexion();
		
		Controleur_decryptage controleurDecryptage = new Controleur_decryptage();
		controleurDecryptage.lancementDecryptage();
		
	}
}
