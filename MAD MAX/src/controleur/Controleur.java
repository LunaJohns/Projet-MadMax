package controleur;

import model.CAD;
import model.Decryptage;;

public class Controleur 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		CAD test = new CAD();
		test.Connexion("SELECT id, Identifiant, Mdp FROM utilisateurs;");
		
		Decryptage test2 = new Decryptage();
		test2.genererListeCle(0);

	}

}
