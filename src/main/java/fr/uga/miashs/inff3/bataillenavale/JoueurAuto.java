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

		public Coordonnee choixAttaqueMoyen(boolean estTouche, boolean estCoule) {
			//il faut que ce soit plus embriqué (si estTouché alors on continue verticalement etc,  si avec nouvel essai estcoulé alors on retourne coordonnée random)
			//récursivité ??  
			    if (!estTouche) {
			     // Si non touché, retourne une coordonnée au hasard
			    return new Coordonnee((int)(Math.random() * this.getTailleGrille()), (int)(Math.random() * this.getTailleGrille()));
			    }
			    if (estCoule) {//peut-être changer l'emplacement car peut pas avoir un bateau de 1 case je crois
			        // Si touché et le bateau est coulé, coordonnée au hasard
			        return new Coordonnee((int)(Math.random() * this.getTailleGrille()), (int)(Math.random() * this.getTailleGrille()));
			    }
			    // Si touché mais le bateau n'est pas coulé, nouvel essaie 
			    if (this.getLigne() + 1 < this.getTailleGrille()) {
			        // Continue l'essai sur la même ligne (ligne + 1) donc verticalement vers le bas
			        return new Coordonnee(this.getLigne() + 1, this.getColonne());
			    } else if (this.getLigne() - 1 >= 0) {
			        // Sinon, essaie avec ligne - 1 donc verticalement vers le haut
			        return new Coordonnee(this.getLigne() - 1, this.getColonne());
			    } else if (this.getColonne() + 1 < this.getTailleGrille()) {
			        // Si ça ne touche rien verticalement, test horizontalement vers la droite avec colonne + 1
			        return new Coordonnee(this.getLigne(), this.getColonne() + 1);
			    } else if (this.getColonne() - 1 >= 0) {
			        // Si colonne + 1 ne fonctionne pas, test horizontalement vers la gauche avec colonne - 1
			        return new Coordonnee(this.getLigne(), this.getColonne() - 1);
			    } 
			}
	


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}



