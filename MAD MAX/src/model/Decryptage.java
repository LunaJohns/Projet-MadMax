package model;

public class Decryptage 
{
	
	private int[] Cle = {97,119,113,112,97,97,97,97,97,97,97,97};
	private Boolean cleTrouve = false;
	
	public Decryptage()
	{
		
	}
	
	//On g�nre toutes les cl�s possibles et on test jusqu'a trouver la bonne
	public void processusDecryptage(int index, String chaineCryptee, MapDictionnaire Map_dic, CAD cad)
	{
		if (index < Cle.length && cleTrouve != true)
		{
			for (int x = 97; x <= 122 && cleTrouve != true;x++)
			{
				
				Cle[index] = x;
				//Permet de suivre la progression du decryptage
				toString(Cle);
				
				String chaineDecrypter = decrypterCaractere(Cle,chaineCryptee);
				String chaineDecrypterDecouper[] = chaineDecrypter.split(" ");
				
				String requete = "";
				int occurranceTrouve = 0;
				
				//Verification
				for (int i = 0;i < chaineDecrypterDecouper.length;i++)
				{
					chaineDecrypterDecouper[i] = chaineDecrypterDecouper[i].replaceAll("\"", "\\\\\"");
					requete = Map_dic.requeteVerifierMot(chaineDecrypterDecouper[i]);
					occurranceTrouve += cad.executerRequete(requete);
				}
				
				if (occurranceTrouve == chaineDecrypterDecouper.length)
				{
					System.out.print("Cl� trouv� : ");
					toString(Cle);
					cleTrouve = true;
				}
				processusDecryptage(index + 1,chaineCryptee, Map_dic, cad);
				
			}
		}

	}
	
	//Decryptage-Cryptage Xor avec des bits
	public String decrypterBinaire(int [] CleDecimal, String chaineCrypter)
	{
		int i = 0;
		int j = 0;
		
		int decoupageBits = 0;
		int tailleChaineCrypter = chaineCrypter.length()/8;
		
		//Stockage du message en binaire
		String[] chaineCrypterBinaire = new String[tailleChaineCrypter];
		
		//Stockage du message en Decimal
		int[] chaineCrypterDecimal = new int[tailleChaineCrypter];
		
		//Decoupage du message binaire par paquet de 8 bits
		while (i < tailleChaineCrypter)
		{
			chaineCrypterBinaire[i]  = chaineCrypter.substring(decoupageBits,decoupageBits+8);
			i++;
			decoupageBits += 8;
		}
		
		//Conversion - binaire -> d�cimal
		for (i = 0; i < chaineCrypterBinaire.length; i++) 
		{
			chaineCrypterDecimal[i] = Integer.parseInt(chaineCrypterBinaire[i], 2);
		}

		//Decryptage
		//Tableau de int permettant de stocker le message Decrypter (en d�cimal)
		int[] chaineDecrypterDecimal = new int[chaineCrypter.length()];
		
		for (i = 0; i < chaineCrypterDecimal.length; i++) 
		{
			//On test si on doit reprendre la cl� au d�but (dans le cas ou le message est plus long que la cl�)
			if (j == CleDecimal.length)
			{
				j = 0;
			}
			//Op�ration XOR
			chaineDecrypterDecimal[i] = CleDecimal[j]^chaineCrypterDecimal[i];
			j++;
		}
		
		//Conversion - Decimal -> Text
		char [] chaineDecrypterText = new char[chaineCrypter.length()];
		
		for (i = 0; i < tailleChaineCrypter; i++) 
		{
			chaineDecrypterText[i] = (char) chaineDecrypterDecimal[i];
		}
		
		//Affichage
		
		//Afficher la Cl� en d�cimal
		System.out.print("Cle :");
		for (i = 0; i < CleDecimal.length; i++) 
		{
			System.out.print(" " + CleDecimal[i]);
		}
		
		//Afficher la chaine - binaire
		System.out.print("\nMessage en binaire : ");
		for (i = 0; i < chaineCrypterBinaire.length; i++) 
		{
			System.out.print(" " + chaineCrypterBinaire[i]);
		}
		
		//Afficher la chaine - d�cimal
		System.out.print("\nMessage en d�cimal : ");
		for (i = 0; i < chaineCrypterDecimal.length; i++) 
		{
			System.out.print(" " + chaineCrypterDecimal[i]);
		}
		
		//Afficher la chaine Decrypter
		System.out.print("\nChaine Decrypt�e en d�cimal :");
		for (i = 0; i < tailleChaineCrypter; i++) 
		{
			System.out.print(" " + chaineDecrypterDecimal[i]);
		}
		
		//Afficher la chaine Decrypter 
		System.out.print("\nChaine Decrypt�e : ");
		for (i = 0; i < tailleChaineCrypter; i++) 
		{
			System.out.print(chaineDecrypterText[i]);
		}
		
		//Conversion tableau de char en String
		String chaineDecrypter = "";
		for (i = 0;i < tailleChaineCrypter;i++)
		{
			chaineDecrypter = new StringBuffer().append(chaineDecrypter).append(chaineDecrypterText[i]).toString();
		}
		return chaineDecrypter;
		
	}
	
	//Decryptage-Cryptage Xor avec des caract�res
	public String decrypterCaractere(int [] cleDecimal,String chaineCrypter) {
		String chaineDecrypter = "";
		char tmp;
		for(int i = 0; i < chaineCrypter.length(); i++) {
			//On execute le XOR
			tmp = (char) (cleDecimal[i%cleDecimal.length] ^ chaineCrypter.charAt(i));
			chaineDecrypter = new StringBuffer().append(chaineDecrypter).append(tmp).toString(); 
		}
		return chaineDecrypter;
	}
	
	//Permet d'afficher la cl� (avec des caract�res)
	public void toString(int[] tab) 
	{

		char[] tabChar = new char[tab.length];

		for (int i = 0; i < tab.length; i++) 
		{

			tabChar[i] = (char) tab[i];

		}

		String output = new String(tabChar);
		System.out.println(output);
		
	}

	public int[] getCle() {
		return Cle;
	}

	
}
