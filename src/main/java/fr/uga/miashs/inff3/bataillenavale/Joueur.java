package fr.uga.miashs.inff3.bataillenavale;
// !! lever des exceptions !!
public abstract class Joueur {
	public final static int TOUCHE = 1;
	public final static int COULE = 2;
	public final static int A_L_EAU = 3;
	public final static int GAMEOVER = 4;
	
	//attributs
	private Joueur adversaire;
	private int tailleGrille;
	private String nom;
	
	//Constructeurs
	public Joueur(int tailleGrille, String nom) {
		this.nom = nom;
		this.tailleGrille = tailleGrille;
	}
	public Joueur(int tailleGrille) {
		this.tailleGrille = tailleGrille;
	}
	
	//Méthodes
	public int getTailleGrille() {
		return tailleGrille;
	}
	public String getNom() {
		return nom;
	}
	
	public void jouerAvec(Joueur j) {
		//vérifier qu'un lien entre les joueurs peut être établi		
		this.adversaire = j;
		j.adversaire = this; // établisse un lien entre j et this
		deroulementJeu(this, j); // lance le déroulement du jeu
		this.adversaire = null; // si la partie est finie on réinitialise les joueurs à null
		j.adversaire = null;
	}
	
	private static void deroulementJeu(Joueur attaquant, Joueur defenseur) {
		int res = 0;
		while (res != GAMEOVER) {
			Coordonnee c = attaquant.choixAttaque();
			res = defenseur.defendre(c);
			attaquant.retourAttaque(c, res);
			defenseur.retourDefense(c, res);
			Joueur x = attaquant;
			attaquant = defenseur;
			defenseur = x;
		}
	}
	
	//méthodes abstraites, on les définira donc dans les sous-classe de joueur
	protected abstract void retourAttaque(Coordonnee c, int etat); 
	
	protected abstract void retourDefense(Coordonnee c, int etat);
	
	public abstract Coordonnee choixAttaque();
	
	public abstract int defendre(Coordonnee c);

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
