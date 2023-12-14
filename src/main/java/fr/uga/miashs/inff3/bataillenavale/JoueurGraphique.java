package fr.uga.miashs.inff3.bataillenavale;

public class JoueurGraphique extends JoueurAvecGrille {

  //Attribut
  private GrilleGraphique grilleTirs;

  //Constructeurs
  public JoueurGraphique(GrilleNavaleGraphique grilleDefense,
  GrilleGraphique grilleTirs, String nom) {...}
  public JoueurGraphique(GrilleNavaleGraphique grilleDefense,
  GrilleGraphique grilleTirs) {...}

  //Méthodes
  public Coordonnee choixAttaque() {...}
  protected void retourDefense(Coordonnee c, int etat) {...}
  protected void retourAttaque(Coordonnee c, int etat) {
    Color couleur = etat == A_L_EAU ? Color.BLUE : Color.RED;
    grilleTirs.colorie(c, couleur);
    switch (etat) {
    case TOUCHE:
      JOptionPane.showMessageDialog(grilleTirs, "Vous avez touché un navire en " + c);
    break;
    case COULE:
      JOptionPane.showMessageDialog(grilleTirs, "Vous avez coulé un navire en " + c);
    break;
    case GAMEOVER:
      JOptionPane.showMessageDialog(grilleTirs, "Vous avez gagné!!!");
    }
  }
}
