package frontiere;

import controleur.ControlAcheterProduit;

public class BoundaryAcheterProduit {
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {
		String choixProduit = Clavier.entrerChaine("Quel produit voulez vous acheter ?\n");
		String[] tabVendeur = controlAcheterProduit.trouverVendeursProduit(choixProduit) ;
		if (tabVendeur== null) {
			System.out.println("Désolé, personne ne vend ce produit au marché.");
		} else {
			System.out.println("Chez quel commerçant voulez-vous acheter des" + choixProduit +".");
			for (int i = 0; i < tabVendeur.length; i++) {
				System.out.println(i+1 + " - " + tabVendeur[i]);
			}
			int choixVendeur;
			do {
				choixVendeur = Clavier.entrerEntier("");
			} while (choixVendeur < 1 || choixVendeur > tabVendeur.length);
			System.out.println(nomAcheteur + " se déplace jusqu'à l'étal du vendeur " + tabVendeur[choixVendeur-1]);
			System.out.println("Bonjour " + nomAcheteur);
			
			int qte = Clavier.entrerEntier("Combien de " + choixProduit + " voulez-vous acheter ?");
			int qteAchetee = controlAcheterProduit.acheterProduit(tabVendeur[choixVendeur-1], qte);
			
		}  
	}
}
