package frontiere;

import controleur.ControlPrendreEtal;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		boolean nomVendeurConnu = controlPrendreEtal.verifierIdentite(nomVendeur);
		boolean etalDisponible;
		if (!nomVendeurConnu) {
			System.out.println("Je suis désolée " + nomVendeur + " mais il faut être un habitant de notre village pour commercer ici.\n");
		} else {
			System.out.println("Bonjour " + nomVendeur + ", je vais regarder si je peux trouver un étal.\n");
			etalDisponible = controlPrendreEtal.resteEtals();
			if (!etalDisponible) {
				
			} else {
				installerVendeur(nomVendeur);
			}
		}
		
	}

	private void installerVendeur(String nomVendeur) {
		String produit;
		int nbProduit;
		int numeroEtal;
		System.out.println("C'est parfait, il me reste un étal pour vous !\nIl me faudrait quelques renseignements:\n");
		produit = Clavier.entrerChaine("Quel produit souhaitez vous vendre ?\n");
		nbProduit = Clavier.entrerEntier("Combien souhaitez vous en vendre ?\n");
		numeroEtal = controlPrendreEtal.prendreEtal(nomVendeur, produit, nbProduit);
		if (numeroEtal != -1) {
			System.out.println("Le vendeur " + nomVendeur + " s'est installé à l'étal n°" + numeroEtal+1);
		}
		
	}
}
