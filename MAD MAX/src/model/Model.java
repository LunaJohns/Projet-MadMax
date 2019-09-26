package model;

public class Model 
{
	public CAD cad;
	public Decryptage decryptage;
	public ManipulationFichier manipulationfichier;
	public MapDictionnaire mapdictionnaire;
	public MapPersonne mappersonne;
	
	public Model()
	{
		this.cad = new CAD();
		this.decryptage = new Decryptage();
		this.manipulationfichier = new ManipulationFichier();
		this.mapdictionnaire = new MapDictionnaire();
		this.mappersonne = new MapPersonne();
	}

}
