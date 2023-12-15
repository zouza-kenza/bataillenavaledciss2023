package fr.uga.miashs.inff3.bataillenavale;


import java.util.Set;
import java.util.HashSet;
import java.util.Random;

public class JoueurAuto extends JoueurAvecGrille {
	private Random random = new Random();
	private Set <Coordonnee> tirsEffectues;

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
			switch (etat) {
			case TOUCHE :
				System.out.println("Vous avez touché en " + c + "; le navire est touché");
			break;
			case COULE :
				System.out.println("Vous avez coulé en " + c + "; le navire est coulé");
			break; 
			case A_L_EAU :
				System.out.println("A l'eau en " + c);
			break; 
			case GAMEOVER :
				System.out.println("Partie terminée");
			break;  // il faut changer ou bien initialiser pour faire en sorte que 1, 2 , 3 ,4 correspondent bien au Coulé, à l'eau, touché,
		}
		}


		protected void retourDefense(Coordonnee c, int etat) {
			switch (etat) {
			case TOUCHE :
				System.out.println("Vous avez été touché en " + c + " le navire est touché");
			break;
			case COULE :
				System.out.println("Vous avez été coulé " + c + " le navire est coulé");
			break; 
			case A_L_EAU :
				System.out.println("Vous êtes à l'eau en " + c);
			break; 
			case GAMEOVER :
				System.out.println("Partie terminée");
			break;  
		}
		}

//		public boolean estJoue() {
//		    Coordonnee coord;
//		    boolean coordDejaTiree;
//
//		    do {
//		        int ligne = random.nextInt(getTailleGrille());
//		        int colonne = random.nextInt(getTailleGrille());
//		        coord = new Coordonnee(ligne, colonne);
//
//		        coordDejaTiree = tirsEffectues.contains(coord);
//		    } while (coordDejaTiree);
//
//		    tirsEffectues.add(coord);
//		    return true;
//		}
//
//		public Coordonnee choixAttaque() {
//		    Coordonnee coord;
//		    if (estJoue()) { // La condition doit être entourée de parenthèses pour appeler la méthode
//		        return new Coordonnee((int) (Math.random() * this.getTailleGrille()), (int) (Math.random() * this.getTailleGrille()));
//		    } else {
//		        // Gestion d'une autre condition ou retourner une valeur par défaut si nécessaire
//		        // Par exemple, retourner une coordonnée aléatoire si estJoue() retourne false
//		        coord = new Coordonnee((int) (Math.random() * this.getTailleGrille()), (int) (Math.random() * this.getTailleGrille()));
//		    }
//		    return coord;
//		}

@Override
public Coordonnee choixAttaque() {
	// TODO Auto-generated method stub
	 return new Coordonnee((int) (Math.random() * this.getTailleGrille()), (int) (Math.random() * this.getTailleGrille()));
}	



	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}



