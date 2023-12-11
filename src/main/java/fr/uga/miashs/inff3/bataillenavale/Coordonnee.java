package fr.uga.miashs.inff3.bataillenavale;

public class Coordonnee {
private int ligne;
	private int colonne;
	
	public Coordonnee(int ligne, int colonne) {
		if (ligne < 0 || ligne > 25 || colonne < 0 || colonne > 25) {
			throw new IllegalArgumentException("Les coordonnées de ligne et de colonne sont éronnées.");
		}
		this.ligne = ligne;
		this.colonne = colonne;
	}
	public Coordonnee(String s) {
		if (s.length() < 2 || s.length() > 3) {
			throw new IllegalArgumentException(
					"La coordonnee depasse les limites elle doit prendre 2 ou 3 caracteres)");
		}
		this.colonne = s.charAt(0) - 'A';
		this.ligne = Integer.parseInt(s.substring(1)) - 1;
		
	}
	public String toString() {
		String coordonnees = new String();
		return coordonnees + (char) (this.colonne + 'A') + (this.ligne + 1);
		
	}
	public int getColonne() {
		return this.colonne;
		
	}
	public int getLigne() {
		return this.ligne;
		
	}

	/*
	 * public boolean equals(Object obj) { return (obj instanceof Coordonnee) &&
	 * (compareTo((Coordonnee) obj) == 0); }
	 */
	public boolean equals(Object obj) {
		if (obj instanceof Coordonnee) {
			Coordonnee c = (Coordonnee) obj;
			return (this.ligne == c.ligne && this.colonne == c.colonne);
		}
		return false;
	}
	public boolean voisine(Coordonnee c) {
		if (this.colonne == c.colonne) {
			if (this.ligne == c.ligne + 1 || this.ligne == c.ligne - 1)
				return true;
		}
		if (this.ligne == c.ligne) {
			if (this.colonne == c.colonne + 1 || this.colonne == c.colonne - 1)
				return true;
		}
		return false;
		
	}
	@Override
	public int compareTo(Coordonnee c) {
			if ((this.ligne == c.ligne && this.colonne < c.colonne) || ((this.ligne < c.ligne) && (this.colonne==c.colonne)))
				return -1;
			else if (this.ligne == c.ligne && this.colonne == c.colonne)
				return 0;
			else
				return 1;
		
	}
	
	

}
