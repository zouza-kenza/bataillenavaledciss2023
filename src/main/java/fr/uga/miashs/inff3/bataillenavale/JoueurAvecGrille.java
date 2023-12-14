package fr.uga.miashs.inff3.bataillenavale;
//!! lever des exceptions !!
public class JoueurAvecGrille extends Joueur {
	//attribut
	private GrilleNavale grille;
	
	//constructeurs
	public JoueurAvecGrille(GrilleNavale g, String nom) {
		// nom=super.nom; //ça marche pas pourquoi ? => Syntax error je pense
		super(g.getTaille(), nom);
		// on va avoir un nouvel objet Joueur avec la taille de la grille de navires = g.getTaille() et le nom = nom.
		this.grille = g;
	}
	public JoueurAvecGrille(GrilleNavale g) {
		super(g.getTaille());
		this.grille = g;
	}
	
	//méthode
	public int defendre(Coordonnee c) { //c : la position du tir
		// si la grille a reçu un tir et on vérifie ensuite si la case :
		this.grille.recoitTir(c);
			if (this.grille.estALEau(c))
				return super.A_L_EAU; // si ça marche pas remplacer par chiffres
			else if (this.grille.estCoule(c))
				return super.COULE;
			
			else if (this.grille.perdu())
				return super.GAMEOVER;
			else
				return super.TOUCHE;
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	@Override
	protected void retourAttaque(Coordonnee c, int etat) {
		// TODO Auto-generated method stub
		
	}
	@Override
	protected void retourDefense(Coordonnee c, int etat) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Coordonnee choixAttaque() {
		// TODO Auto-generated method stub
		return null;
	}

}
