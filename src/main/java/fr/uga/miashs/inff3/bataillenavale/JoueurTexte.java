package fr.uga.miashs.inff3.bataillenavale;

import java.util.Scanner;

public class JoueurTexte extends JoueurAvecGrille { 
	 

    private Scanner sc;

    public JoueurTexte(GrilleNavale g, String nom) {
        super(g, nom);
        this.sc = new Scanner(System.in);
	if (nom.isEmpty() || nom == null) {
			throw new IllegalArgumentException("Le nom est vide ou contient un ou des espace(s)");
		}
    }

    public JoueurTexte(GrilleNavale g) {
        super(g);
        this.sc = new Scanner(System.in);
    }

    protected void retourAttaque(Coordonnee c, int etat) {
		switch (etat) {
			case TOUCHE :
				System.out.println("Vous avez touché en " + c + "le navire est " + etat);
			break;
			case COULE :
				System.out.println("Vous avez coulé en " + c + "le navire a "  + etat);
			break; 
			case A_L_EAU :
				System.out.println("A l'eau en " + c + "le navire est " + etat);
			break; 
			case GAMEOVER :
				System.out.println("Partie terminée" + etat);
			break;  // il faut changer ou bien initialiser pour faire en sorte que 1, 2 , 3 ,4 correspondent bien au Coulé, à l'eau, touché,
		}
    }

    protected void retourDefense(Coordonnee c, int etat) {
		switch (etat) {
			case TOUCHE :
				System.out.println("Vous avez été touché en " + c + "le navire est " + etat);
			break;
			case COULE :
				System.out.println("Vous avez été coulé " + c + "le navire est "  + etat);
			break; 
			case A_L_EAU :
				System.out.println("Vous êtes à l'eau en " + c + "le navire est " + etat);
			break; 
			case GAMEOVER :
				System.out.println("Partie terminée" + etat);
			break;  
		}
    }
       
	public Coordonnee choixAttaque() {
    System.out.println("Saisissez la ligne pour l'attaque : ");
    	String ligne = sc.nextLine();
    System.out.println("Saisissez la colonne pour l'attaque : ");
    	String colonne = sc.nextLine();

		String coordonneeStr = ligne + colonne; 

    return new Coordonnee(coordonneeStr) ;
	}
}
   


/*private boolean estValide(String CoordonneeValide) {
    if (CoordonneeValide.length() < 2 || CoordonneeValide.length() > 3) 
	return false;
    char ligne = CoordonneeValide.charAt(0);
    if (ligne < 'A' || ligne > 'J') return false;  
    try {
        int colonne = Integer.parseInt(coord.substring(1));
        return colonne >= 1 && colonne <= 10; // 10 nombre de colonnes
    } catch (NumberFormatException e) {
        return false;
     } 
} 
 // c'est pour voir si les coordonnées sont bons ou pas, on peut rajouter la méthode qui permet de savoir si les coordonnées sont valides ou pas dans coordonne
*/
