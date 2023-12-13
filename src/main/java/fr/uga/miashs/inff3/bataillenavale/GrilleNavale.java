package fr.uga.miashs.inff3.bataillenavale;

public class GrilleNavale {
    private Navire[] navires;
    private int nbNavires;
    private int taille;
    private Coordonnee[] tirsRecus;
    private int nbTirsRecus;

    public GrilleNavale(int taille, int[] taillesNavires) {
        this.taille = taille;
        this.nbNavires = 0;
        this.navires = new Navire[taillesNavires.length];
        placementAuto(taillesNavires);
        this.tirsRecus = new Coordonnee[taille * taille];
        this.nbTirsRecus = 0;
    }

    public GrilleNavale(int taille, int nbNavires) {
        this.taille = taille;
        this.nbNavires = 0;
        this.navires = new Navire[nbNavires];
        this.tirsRecus = new Coordonnee[taille * taille];
        this.nbTirsRecus = 0;
    }

    public String toString() {
        StringBuilder representation = new StringBuilder("  ");
        for (char c = 'A'; c < 'A' + taille; c++) {
            representation.append(c).append(" ");
        }
        representation.append("\n");

        for (int i = 0; i < taille; i++) {
            representation.append(i + 1).append(" ");
            for (int j = 0; j < taille; j++) {
                Coordonnee coord = new Coordonnee(i, j);
                boolean navirePresent = false;
                boolean tirRecu = false;

                for (Navire navire : navires) {
                    if (navire.contient(coord)) {
                        representation.append("# "); // Marquer la présence d'un navire
                        navirePresent = true;
                        break;
                    }
                }
                if (!navirePresent) {
                    representation.append(". "); // Espace vide sans navire
                }
            }
            representation.append("\n");
        }
        return representation.toString();
    }

    public int getTaille() {
        return taille;
    }

    public boolean ajouteNavire(Navire n) {
        if (nbNavires < navires.length) {
            navires[nbNavires] = n;
            nbNavires++;
            return true;
        }
        return false;
    }

    public void placementAuto(int[] taillesNavires) {
    	if (taillesNavires.length > navires.length)
			throw new IllegalArgumentException("Il y a trop de navires par rapport à la capacité de la grille");
		int colonne = 0;
		int ligne = 0;
		Coordonnee c = null;
		boolean estVertical = false;
		Navire navireRandom = null;

		for (int i = 0; i < taillesNavires.length; i++) {
			System.out.println("Navire " + i);
			do {
				estVertical = Math.random() < 0.5;

				if (estVertical) {
					ligne = (int) (Math.random() * (taille - taillesNavires[i]));
					colonne = (int) (Math.random() * taille); // le navire est dans le sens de la colonne
				} else {
					ligne = (int) (Math.random() * taille); // le navire est dans le sens de la ligne
					colonne = (int) (Math.random() * (taille - taillesNavires[i]));
				}
				c = new Coordonnee(ligne, colonne);
				navireRandom = new Navire(c, taillesNavires[i], estVertical);
//				System.out.println(navireRandom);
			} while (!ajouteNavire(navireRandom));
		}
    }
    private boolean estDansGrille(Coordonnee c) {
        int ligne = c.getLigne();
        int colonne = c.getColonne();

        // Vérifier si la coordonnée est dans la grille (taille entre 1 et taille)
        return ligne >= 1 && ligne <= taille && colonne >= 1 && colonne <= taille;
    }
    private boolean estDansTirsRecus(Coordonnee c) {
        for (int i = 0; i < nbTirsRecus; i++) {
            if (tirsRecus[i].equals(c)) {
                return true; // La coordonnée correspond à un tir reçu
            }
        }
        return false; // La coordonnée ne correspond à aucun tir reçu
    }
    private boolean ajouteDansTirsRecus(Coordonnee c) {
        if (!estDansTirsRecus(c)) { // Vérifier si la coordonnée n'est pas déjà dans les tirs reçus
            if (nbTirsRecus < taille * taille) { // Vérifier si l'ajout est possible sans dépasser la capacité
                tirsRecus[nbTirsRecus] = c;
                nbTirsRecus++;
                return true; // La grille a été modifiée
            }
        }
        return false; // La grille n'a pas été modifiée
    }
    public boolean recoitTir(Coordonnee c) {
    	if (ajouteDansTirsRecus(c)) {
    		for (int i=0; i<nbNavires; i++){
                if (!navires[i].recoitTir(c)) {
                    return true; 
                }
            }
    	}
        return false; 
    }
   
//    	 if (!estDansGrille(c) || estDansTirsRecus(c)) {
//    	        return false; // La coordonnée est en dehors de la grille ou a déjà été tirée
//    	    }
//
//    	    for (Navire navire : navires) {
//    	        if (navire.estTouche(c)) {
//    	            ajouteDansTirsRecus(c); // Ajouter la coordonnée aux tirs reçus
//    	            return true; // La coordonnée a touché un navire
//    	        }
//    	    }
//
//    	    ajouteDansTirsRecus(c); // Ajouter la coordonnée aux tirs reçus
//    	    return false; // La coordonnée est dans l'eau
//	}
    
    public boolean estTouche(Coordonnee c) {
        for (Navire navire : navires) {
            if (navire.estTouche(c)) {
                return true; // Un des navires a été touché en c
            }
        }
        return false; // Aucun navire touché en c
    }
    public boolean estALEau(Coordonnee c) {
        return !estTouche(c) && estDansTirsRecus(c);
    }
    public boolean estCoule(Coordonnee c) {
    	for (int i=0; i<nbNavires; i++){
            if (!navires[i].estCoule()) {
                return true; 
            }
        }
        return false; 
    }

    public boolean perdu() { 
    	for (int i=0; i<nbNavires; i++){
            if (!navires[i].estCoule()) {
                return false; // Il reste au moins un navire non coulé
            }
        }
        return true; // Tous les navires sont coulés
    }
    

    public static void main(String[] args) {
       
    }
}

