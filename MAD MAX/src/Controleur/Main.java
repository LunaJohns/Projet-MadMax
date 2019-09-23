package Controleur;

import Model.CAD;;

public class Main 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		System.out.println("Hello");
		CAD test = new CAD();
		test.Connexion("SELECT id, nom, prenom FROM utilisateur;");

	}

}
