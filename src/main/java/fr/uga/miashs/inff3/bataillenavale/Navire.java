package batailleNavale;

public class Navire {
		private Coordonnee debut;
	private Coordonnee fin;
	private Coordonnee[] partiesTouchees;
	private int nbTouchees;
	
	
	//constructeur :
	public Navire(Coordonnee debut, int longueur, boolean estVertical) {
		this.debut = debut;
		if (estVertical) {
			fin = new Coordonnee(debut.getLigne() + longueur - 1, debut.getColonne());
		}
		else {
			fin = new Coordonnee(debut.getLigne(), debut.getColonne() + longueur - 1);
		}
		partiesTouchees = new Coordonnee[longueur];
		nbTouchees = 0;
	}
	
	// méthodes :
	
	// retourne une représentation textuelle du navire
	public String toString() {
		if (this.debut.getLigne() == this.fin.getLigne()) //horizontal
			return ("Navire(" + debut + ", " + (fin.getColonne() - debut.getColonne() + 1) + " horizontal)");
		return ("Navire(" + debut + ", " + (fin.getLigne() - debut.getLigne() + 1) + " vertical"); //vertical
	}

	// retournent respectivement les coordonnées de début et de fin du navire.
	public Coordonnee getDebut() {
		return this.debut;
	}
	public Coordonnee getFin() {
		return this.fin;
	}
	
	// teste si le navire contient la coordonnée spécifiée.
	public boolean contient(Coordonnee c) {
		if (debut.getLigne() == c.getLigne() && debut.getColonne() >= c.getColonne() && fin.getColonne() >= c.getColonne())
			return true;
		else if (debut.getColonne() == c.getColonne() && debut.getLigne() >= c.getLigne() && fin.getLigne() >= c.getColonne())
			return true;
		return false;
	}
	
//	public boolean touche(Navire n) {...}

	public boolean chevauche (Navire n){
		for (int i = debut.getLigne();i <=fin.getLigne();i++) {
			for (int j=debut.getColonne(); j<=fin.getColonne(); j++){
				if (n.contient(part)){
					return true;
				}
			}
		}
		return false ; 
	}

	// enregistre la coordonnée spécifiée comme étant touchée.
	public boolean recoitTir(Coordonnee c) {
		//vérifie si la coordonnée n'existe pas dans partiesTouchees[]
		boolean existe = false;
		for (int i = 0; i < partiesTouchees.length; i++) {
			if (partiesTouchees[i] != null && partiesTouchees[i].equals(c)) {
				existe = true;
				break;
			}
		}
		if (existe == false && this.contient(c) ) {
			partiesTouchees[nbTouchees] = c;
			nbTouchees ++;
			return true;
		}
		return false;
	}
	
//	public boolean estTouche(Coordonnee c) {...}
	
	public boolean estTouche() {
		if (nbTouchees>0) {
		return true ;
		}
		return false;
	}
	public boolean estCoule() {
		return nbTouchees == partiesTouchees.length;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
