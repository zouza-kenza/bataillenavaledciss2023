package fr.uga.miashs.inff3.bataillenavale;

//import java.util.Random;

public class JoueurAuto extends JoueurAvecGrille {
	//private Random random = new Random();

		public JoueurAuto(GrilleNavale g, String nom){
			super(g, nom);
			if (nom.isEmpty() || nom == null) {
			throw new IllegalArgumentException("Le nom est vide ou contient un ou des espace(s)");
		}
		}
		public JoueurAuto (GrilleNavale g){
			super(g);
		}
	
		protected void retourAttaque(Coordonnee c, int etat) {
    			this.retourAttaque(c, etat);
		}


		protected void retourDefense(Coordonnee c, int etat) {
    			this.retourDefense(c, etat);
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



