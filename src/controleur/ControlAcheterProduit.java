package controleur;

import personnages.Gaulois;
import villagegaulois.Etal;
import villagegaulois.Village;

public class ControlAcheterProduit {
	private Village village;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlVerifierIdentite controlVerifierIdentite;

	public ControlAcheterProduit(ControlVerifierIdentite controlVerifierIdentite,
			ControlTrouverEtalVendeur controlTrouverEtalVendeur,
			Village village) {
		this.village = village;
		this.controlVerifierIdentite = controlVerifierIdentite;
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}

	public String[] trouverVendeursProduit(String produit) {
		Gaulois[] tabVendeur = village.rechercherVendeursProduit(produit);
		String[] tabNomVendeurs = new String[tabVendeur.length];
		for(int i = 0; i < tabVendeur.length; i++) tabNomVendeurs[i] = tabVendeur[i].getNom();
		return tabNomVendeurs;
	}
	
	public int acheterProduit(String nomVendeur, int qte) {
		 Etal etal = controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur);
		 return etal.acheterProduit(qte);
	}
	
	public boolean isInVillage(String nomVendeur) {
		return controlVerifierIdentite.verifierIdentite(nomVendeur);
	}
}
