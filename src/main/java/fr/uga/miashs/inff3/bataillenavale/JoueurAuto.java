package fr.uga.miashs.inff3.bataillenavale;

public class JoueurAuto extends JoueurAvecGrille {
	public JoueurAuto(GrilleNavale g, String nom) {
		super(g, nom);
	}
	
	public JoueurAuto(GrilleNavale g) {
		super(g);
	}
	
	protected void retourAttaque(Coordonnee c, int etat) {
		String res = "";
		if (etat == Joueur.A_L_EAU)
			res = "C'est à l'eau !";
		else if (etat == Joueur.COULE)
			res = "Vous avez coulé un navire !";
		else if (etat == Joueur.GAMEOVER)
			res = "Vous avez perdu !";
		else if (etat == Joueur.TOUCHE)
			res = "Vous avez touché un navire !";
		System.out.println("Attaque en " + c + ": " + res);
	}
	
	protected void retourDefense(Coordonnee c, int etat) {
		String res = "";
		if (etat == Joueur.A_L_EAU)
			res = "C'est à l'eau !";
		else if (etat == Joueur.COULE)
			res = "Le navire est coulé !";
		else if (etat == Joueur.GAMEOVER)
			res = "Vous avez gagné !";
		else if (etat == Joueur.TOUCHE)
			res = "Le navire est touché !";
		System.out.println("Attaque en " + c + ": " + res);
	}
	
	public Coordonnee choixAttaque() {
		
		return null;
	}
}
