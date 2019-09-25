package model;

public class Decryptage 
{
	
	private int[] Cle;
	private Boolean cleTrouve = false;
	
	public Decryptage()
	{
		Cle = new int[4];
		
		for (int i = 0; i < Cle.length; i++) 
		{

			Cle[i] = 97;
		}
		
	}
	
	public void genererListeCle(int index, String chaineCryptee, MapDictionnaire Map_dic, CAD cad)
	{
		if (index < Cle.length && cleTrouve != true)
		{
			for (int x = 97; x <= 122;x++)
			{
				
				Cle[index] = x;
				
				String chaineDecrypter = decrypterCaractere(Cle,chaineCryptee);
				
				//Verification
				String requete = Map_dic.requeteVerifierMot(chaineDecrypter);
				boolean occurranceTrouve = cad.executerRequete(requete);
				
				if (occurranceTrouve == true)
				{
					System.out.print("Clé trouvé : ");
					toString(Cle);
					cleTrouve = true;
				}
				genererListeCle(index + 1,chaineCryptee, Map_dic, cad);
				
			}
		}

	}
	
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
		
		//Conversion - binaire -> décimal
		for (i = 0; i < chaineCrypterBinaire.length; i++) 
		{
			chaineCrypterDecimal[i] = Integer.parseInt(chaineCrypterBinaire[i], 2);
		}

		//Decryptage
		//Tableau de int permettant de stocker le message Decrypter (en décimal)
		int[] chaineDecrypterDecimal = new int[chaineCrypter.length()];
		
		for (i = 0; i < chaineCrypterDecimal.length; i++) 
		{
			//On test si on doit reprendre la clé au début (dans le cas ou le message est plus long que la clé)
			if (j == CleDecimal.length)
			{
				j = 0;
			}
			//Opération XOR
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
		
		//Afficher la Clé en décimal
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
		
		//Afficher la chaine - décimal
		System.out.print("\nMessage en décimal : ");
		for (i = 0; i < chaineCrypterDecimal.length; i++) 
		{
			System.out.print(" " + chaineCrypterDecimal[i]);
		}
		
		//Afficher la chaine Decrypter
		System.out.print("\nChaine Decryptée en décimal :");
		for (i = 0; i < tailleChaineCrypter; i++) 
		{
			System.out.print(" " + chaineDecrypterDecimal[i]);
		}
		
		//Afficher la chaine Decrypter 
		System.out.print("\nChaine Decryptée : ");
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
	
}
