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

		public Coordonnee choixAttaqueAuto() { // on va stocker les coordonnées dans lesquelles le bot a attaqué et on va vérifier les tirs précédents grace au set
			Coordonnee coord; // création de nouvelle coordonnées coord
			do {
				int ligne = random.nextInt(getTailleGrille());  
				int colonne = random.nextInt(getTailleGrille());
				coord = new Coordonnee (ligne,colonne); // coord récupère le random de la ligne et colonne 
			} while (tirsEffectues.contains(coord)); // tant que tirsEffectues qu'on a crée plus haut pour stocker et faire comme un historique
			
			tirsEffectues.add(coord);
			return coord;
			}
		
	


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}



