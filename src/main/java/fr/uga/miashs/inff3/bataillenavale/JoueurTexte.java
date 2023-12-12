package batailleNavale;

import java.util.Scanner;

public class JoueurTexte extends JoueurAvecGrille {
    private Scanner sc;

    public JoueurTexte(GrilleNavale g, String nom) {
        super(g, nom);
        this.sc = new Scanner(System.in);
    }

    public JoueurTexte(GrilleNavale g) {
        super(g);
        this.sc = new Scanner(System.in);
    }

    protected void retourAttaque(Coordonnee c, int etat) {
		String message = switch (etat) {
			case TOUCHE :
				System.out.println("Vous avez touché en " + c + "le navire est " +etat);
			break;
			case COULE :
				System.out.println("Vous avez coulé en " + c + "le navire a "  +etat);
			break; 
			case A_L_EAU :
				System.out.println("A l'eau en " + c + "le navire est " +etat);
			break; 
			case GAMEOVER :
				System.out.println("Partie terminée" + etat);
			break;  
		}
    }

    protected void retourDefense(Coordonnee c, int etat) {
		String message = switch (etat) {
			case TOUCHE :
				System.out.println("Vous avez été touché en " + c + "le navire est " +etat);
			break;
			case COULE :
				System.out.println("Vous avez été coulé " + c + "le navire est "  +etat);
			break; 
			case A_L_EAU :
				System.out.println("Vous êtes à l'eau en " + c + "le navire est " +etat);
			break; 
			case GAMEOVER :
				System.out.println("Partie terminée" + etat);
			break;  
		}
    }
       
    }


	public Coordonnee choixAttaque() {
    System.out.println("Saisissez la ligne pour l'attaque : ");
    	String ligne = sc.nextLine();
    System.out.println("Saisissez la colonne pour l'attaque : ");
    	String colonne = sc.nextLine();
		
		String coordonneeStr = ligne + colonne;

	}


    return new Coordonnee(coordonneeStr);
}
   
	public abstract int defendre (Coordonnee c) {
		return super.defendre(c);

 }
