package main;

import controleur.Controleur_main;
import model.Model;
import vue.Vue;

public class Main 
{
	public static void main(String[] args) 
	{
		
		Model model = new Model();
		
		Controleur_main Controleur = new Controleur_main(model);
		
		Vue vue = new Vue(Controleur);
		
		
	}
}
