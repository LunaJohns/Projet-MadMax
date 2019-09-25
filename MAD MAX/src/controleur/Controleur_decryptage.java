package controleur;

import model.CAD;
import model.Decryptage;;

public class Controleur 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		//CAD test = new CAD();
		//test.Connexion("SELECT id, Identifiant, Mdp FROM utilisateurs;");
		
		Decryptage test2 = new Decryptage();
		test2.genererListeCle(0);
		
		//Binaire
		int[] t1 = {122,122,122,122};
		//String resultat1 = test2.decrypterBinaire(t1, "00010101000001000001001000010101"); 
		//Caractère
		String resultat2 = test2.decrypterCaractere(t1, "test");
		System.out.println(resultat2);
	}

}
