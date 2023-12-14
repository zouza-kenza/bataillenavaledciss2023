package fr.uga.miashs.inff3.bataillenavale;

//import java.util.Random;

public class JoueurAuto extends JoueurAvecGrille {
	//private Random random = new Random();

		public JoueurAuto(GrilleNavale g, String nom){
			super(g, nom);
		}
		public JoueurAuto (GrilleNavale g){
			super(g);
		}
		/*
		protected void retourAttaque(Coordonnee c, int etat) {
    			this.retourAttaque(c, etat);
		}


		protected void retourDefense(Coordonnee c, int etat) {
    			this.retourDefense(c, etat);
		}
		*/

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
		/*
		int ligne = random.nextInt(getTailleGrille()); // getTailleGrille définie dans le 1.2 étape 2 normalement sinon à refaire avec les lignes et les colonnes pour chaque 
		int colonne = random.nextInt(getTailleGrille());
		return new Coordonnee(ligne, colonne); // pas sur d'avoir besoin
		*/
		return new Coordonnee((int)(Math.random()*this.getTailleGrille()), (int)(Math.random()*this.getTailleGrille()));
		}
	


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}



