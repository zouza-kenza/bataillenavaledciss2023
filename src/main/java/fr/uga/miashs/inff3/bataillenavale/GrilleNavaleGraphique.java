package fr.uga.miashs.inff3.bataillenavale;
import java.awt.*; //pour colorier

public class GrilleNavaleGraphique extends GrilleNavale {
	private GrilleGraphique grille;
	
	//Constructeur : permet d'obtenir une grille de taille
	public GrilleNavaleGraphique(int taille) {
		super(taille, 5); // le prof m'a dit qu'on peut mettre n'importe quel nombre sur la deuxième variable
		// parce que c'est la capacité du nombre de navires qu'on a dans la grille
		grille = new GrilleGraphique(taille);
	}
	
	//méthodes :
	public GrilleGraphique getGrilleGraphique() {
		return this.grille; //accesseur en lecture pour grille
	}
	
	public boolean ajouteNavire(Navire n) {
		 if (super.ajouteNavire(n)) {
			 //colore la partie de la grille occupée par le navire n en vert.
			 this.grille.colorie(n.getDebut(), n.getFin(), Color.GREEN);
			 return true;
		 }
			return false;
		}


		public boolean recoitTir(Coordonnee c) {
			if (super.recoitTir(c)) { //vérifie si le tir a touché un navire
				this.grille.colorie(c, Color.RED); // colore la case de la grille touchée par le tir en rouge.
				return true;
			}
			else {
				this.grille.colorie(c, Color.BLUE);  //colore la case de la grille non touchée par le tir en bleu.
				return false; 
			}}
}
