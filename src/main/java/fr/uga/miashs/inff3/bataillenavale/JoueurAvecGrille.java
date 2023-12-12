package fr.uga.miashs.inff3.bataillenavale;
//!! lever des exceptions !!
public class JoueurAvecGrille extends Joueur {
	//attribut
	private GrilleNavale grille;
	
	//constructeurs
	public JoueurAvecGrille(GrilleNavale g, String nom) {
		// nom=super.nom; //ça marche pas pourquoi ? => Syntax error je pense
		super(g.getTaille(), nom); // <= ça marche :) thank me later
		// pourquoi ? on va avoir un nouvel objet Joueur avec la taille de la grille de navires = g.getTaille() et le nom = nom.
		this.grille = g;
	}
	public JoueurAvecGrille(GrilleNavale g) {
		super(g.getTaille());
		this.grille = g;
	}
	
	//méthode
	public int defendre(Coordonnee c) {
		if (c.estTouche()) {	//ne marche pas là car méthode estTouche non défini chez moi
			return super.TOUCHE;
		}
		else if (c.estCoule()) {
			return super.COULE;
		}
		else if (c.perdu()) {
			return super.GAMEOVER;
		}
		return super.A_L_EAU;
		// je pense que ça va pas cette méthode
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
