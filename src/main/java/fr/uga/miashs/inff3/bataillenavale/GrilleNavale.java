package fr.uga.miashs.inff3.bataillenavale;
import java.util.Arrays;
public class GrilleNavale {
    private Navire[] navires;
    private int nbNavires;
    private int taille;
    private Coordonnee[] tirsRecus;
    private int nbTirsRecus;

//    public GrilleNavale(int taille, int[] taillesNavires) {
//        this.taille = taille;
//        this.nbNavires = 0;
//        this.navires = new Navire[taillesNavires.length];
//        placementAuto(taillesNavires);
//        this.tirsRecus = new Coordonnee[taille * taille];
//        this.nbTirsRecus = 0;
//    }
    public GrilleNavale(int taille, int[] taillesNavires) {
        this.taille = taille;
        this.nbNavires = 0;
        int totalTailleNavires = 0;
        
        for (int i = 0; i < taillesNavires.length; i++) {
            totalTailleNavires += taillesNavires[i];
        }
        
        this.navires = new Navire[totalTailleNavires];
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


//    public String toString() {
//        StringBuilder representation = new StringBuilder("   ");
//
//        // Ajout des lettres de A à J pour l'en-tête
//        for (int i = 0; i < taille; i++) {
//            representation.append((char) ('A' + i)).append(" ");
//        }
//        representation.append("\n");
//
//        for (int i = 0; i < taille; i++) {
//            if (i < 9) {
//                representation.append(" ");
//            }
//            representation.append(i + 1).append(" ");
//
//            for (int j = 0; j < taille; j++) {
//                Coordonnee coord = new Coordonnee(i, j);
//                boolean navirePresent = false;
//                boolean tirRecu = false;
//
//                // Vérification de la présence d'un navire ou d'un tir reçu à cette coordonnée
//                for (Navire navire : navires) {
//                    if (navire.contient(coord)) {
//                        navirePresent = true;
//                        break;
//                    }
//                }
//                for (int k = 0; k < nbTirsRecus; k++) {
//                    if (tirsRecus[k].equals(coord)) {
//                        tirRecu = true;
//                        break;
//                    }
//                }
//
//                if (navirePresent) {
//                    representation.append("# "); // Ajout d'un navire
//                } else if (tirRecu) {
//                    representation.append("O "); // Ajout d'un tir dans l'eau
//                } else {
//                    representation.append(". "); // Ajout d'une case vide
//                }
//            }
//            representation.append("\n");
//        }
//        return representation.toString();
//    }

	public String toString() {
//		 1-creer A B C D E ......
		StringBuffer s = new StringBuffer();
		s.append("  ");
		for (int i = 0; i < this.taille; i++) {
			s.append(" ").append((char) ('A' + i));
		}
		s.append("\n"); // retourner à la ligne

		int lgLigne = s.length();
		// 2- creer 1 2 3 4 5...
		for (int i = 0; i < this.taille; i++) {
			if (i < 9) {
				s.append(" ");
			}

			s.append(i + 1);
			for (int j = 0; j < this.taille; j++) {
				s.append(" ").append(".");
			}
			s.append("\n");
		}
//					
		// NAVIRES
		int indDebut, indFin;
		for (int i = 0; i < nbNavires; i++) {
			int linDeb = navires[i].getDebut().getLigne();
			int colDeb = navires[i].getDebut().getColonne();

			int linFin = navires[i].getFin().getLigne();
			int colFin = navires[i].getFin().getColonne();

//					System.out.println("debut " + navires[i].getDebut() + ", lig = " + linDeb + ", col = " + colDeb);
//					System.out.println("fin   " + navires[i].getFin() + ", lig = " + linFin + ", col = " + colFin);

			// NAVIRE Horizontal
			if (linDeb == linFin) {

				indDebut = (linDeb + 1) * lgLigne + 3 + colDeb * 2;
				indFin = (linFin + 1) * lgLigne + 3 + colFin * 2;
				for (int j = indDebut; j <= indFin; j += 2) {
					s.setCharAt(j, '#');
				}
//						s.setCharAt(indDebut, '#');
			}
			// VERTICAL
			else {

				indDebut = (linDeb + 1) * lgLigne + 3 + colDeb * 2;
				indFin = (linFin + 1) * lgLigne + 3 + colFin * 2;
				for (int j = indDebut; j <= indFin; j += lgLigne) {
					s.setCharAt(j, '#');
				}
			}

		}
		// TOUCHER OU A L'EAU
		for (int i = 0; i < nbTirsRecus; i++) {

			int j = (tirsRecus[i].getLigne() + 1) * lgLigne + 3 + tirsRecus[i].getColonne() * 2;
			if (s.charAt(j) == '#')
				s.setCharAt(j, 'X');
			else
				s.setCharAt(j, 'O');

		}

		return s.toString();

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
    public int getTaille() {
        return taille;
    }

    public boolean ajouteNavire(Navire n) {
       for (int i=0 ; i< nbNavires ; i++) {
    	   if (navires[i].touche(n) || navires[i].chevauche(n)) {
    		   return false;
    	   }
       }
       if (nbNavires == navires.length) {
    	   Navire[] tmp = new Navire[nbNavires+5];
    	   for (int i=0 ; i<nbNavires ; i++) {
    		   tmp[i]=navires[i];
    	   }
    	   navires=tmp;
       }
       navires[nbNavires] = n;
       nbNavires++;
       return true;
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
    
//    public boolean estTouche(Coordonnee c) {
//        for (Navire navire : navires) {
//            if (navire.estTouche(c)) {
//                return true; // Un des navires a été touché en c
//            }
//        }
//        return false; // Aucun navire touché en c
//    }
    public boolean estTouche(Coordonnee c) {
		for (int i = 0; i < nbNavires; i++) {
			if (navires[i].estTouche(c)) {
				return true;
			}
		}
		return false;
	}
    public boolean estALEau(Coordonnee c) {
        return !estTouche(c) && estDansTirsRecus(c);
  }
//    public boolean estALEau(Coordonnee c) {
//        for (Navire navire : navires) {
//            if (navire.estTouche(c)) {
//                return false; // La case a touché un navire, donc elle n'est pas à l'eau
//            }
//        }
//        return estDansTirsRecus(c); // Retourne vrai si la case est dans les tirs reçus
//    }

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
    	int [] tab = {2, 2, 5};
    	//int [] tab = {2,};
       GrilleNavale grille = new GrilleNavale(10, tab);
       System.out.println(grille);
    }
}



