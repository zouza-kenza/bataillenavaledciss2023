package batailleNavale;

public class BatailleNavale {

  //Attrubuts
  private Joueur joueur1, joueur2;
  private int tailleGrille;

  //Méthode
  private void demarrerPartie() {
    new Thread() {
      public void run() {
        joueur1.jouerAvec(joueur2);
      }
    }.start();
  }
}
