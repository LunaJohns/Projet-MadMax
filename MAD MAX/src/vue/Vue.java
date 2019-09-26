package vue;

import controleur.Controleur_main;

public class Vue 
{
	public Vue_Connexion Connexion;
	public Vue_Decryptage Decryptage;
	public Controleur_main controleurMain;
	
	public Vue(Controleur_main controleurMain)
	{
		this.Connexion = new Vue_Connexion(controleurMain);
		this.controleurMain = controleurMain;
	}
}
