package fr.uga.miashs.inff3.bataillenavale;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GrilleNavaleTest {

	


    @Test
    void testRecoitTir() {
        int tailleGrille = 10;
        int[] taillesNavires = {5, 4, 3, 3, 2};

        GrilleNavale grille = new GrilleNavale(tailleGrille, taillesNavires);

        assertTrue(grille.recoitTir(new Coordonnee("A1"))); // Tirer sur la case A1
        assertFalse(grille.recoitTir(new Coordonnee("A1"))); // Retirer sur la case A1 une deuxième fois
    }

    @Test
    void testEstTouche() {
        int tailleGrille = 10;
        int[] taillesNavires = {5, 4, 3, 3, 2};

        GrilleNavale grille = new GrilleNavale(tailleGrille, taillesNavires);

        assertTrue(grille.recoitTir(new Coordonnee("A1"))); // Tirer sur la case A1
        assertTrue(grille.estTouche(new Coordonnee("A1"))); // Vérifier si la case A1 est touchée
        assertFalse(grille.estTouche(new Coordonnee("B2"))); // Vérifier si la case B2 est touchée (ne devrait pas l'être)
    }

    @Test
    void testEstALEau() {
        int tailleGrille = 10;
        int[] taillesNavires = {5, 4, 3, 3, 2};

        GrilleNavale grille = new GrilleNavale(tailleGrille, taillesNavires);

        assertTrue(grille.recoitTir(new Coordonnee("A1"))); // Tirer sur la case A1
        assertFalse(grille.estALEau(new Coordonnee("A1"))); // Vérifier si la case A1 est à l'eau (ne devrait pas l'être)
        assertTrue(grille.estALEau(new Coordonnee("B2"))); // Vérifier si la case B2 est à l'eau (devrait l'être)
    }

    @Test
    void testEstCoule() {
        int tailleGrille = 10;
        int[] taillesNavires = {5, 4, 3, 3, 2};

        GrilleNavale grille = new GrilleNavale(tailleGrille, taillesNavires);

        grille.recoitTir(new Coordonnee("A1"));
        grille.recoitTir(new Coordonnee("A2"));
        grille.recoitTir(new Coordonnee("A3"));
        grille.recoitTir(new Coordonnee("A4"));
        grille.recoitTir(new Coordonnee("A5"));
        assertTrue(grille.estCoule(new Coordonnee("A1"))); // Vérifier si le navire à partir de A1 est coulé
        assertFalse(grille.estCoule(new Coordonnee("B2"))); // Vérifier si le navire à partir de B2 n'est pas coulé
    }

    @Test
    void testPerdu() {
        int tailleGrille = 10;
        int[] taillesNavires = {5, 4, 3, 3, 2};

        GrilleNavale grille = new GrilleNavale(tailleGrille, taillesNavires);

        grille.recoitTir(new Coordonnee("A1"));
        grille.recoitTir(new Coordonnee("A2"));
        grille.recoitTir(new Coordonnee("A3"));
        grille.recoitTir(new Coordonnee("A4"));
        grille.recoitTir(new Coordonnee("A5"));

        grille.recoitTir(new Coordonnee("B1"));
        grille.recoitTir(new Coordonnee("B2"));
        grille.recoitTir(new Coordonnee("B3"));
        grille.recoitTir(new Coordonnee("B4"));

        grille.recoitTir(new Coordonnee("C1"));
        grille.recoitTir(new Coordonnee("C2"));
        grille.recoitTir(new Coordonnee("C3"));

        grille.recoitTir(new Coordonnee("D1"));
        grille.recoitTir(new Coordonnee("D2"));
        grille.recoitTir(new Coordonnee("D3"));

        grille.recoitTir(new Coordonnee("E1"));
        grille.recoitTir(new Coordonnee("E2"));

        assertTrue(grille.perdu()); // Vérifier si la grille est perdue après avoir touché tous les navires
    }

    @Test
    void testToString() {
        int tailleGrille = 10;
        int[] taillesNavires = {5, 4, 3, 3, 2};

        GrilleNavale grille1 = new GrilleNavale(tailleGrille, taillesNavires);

        String expected = "  A B C D E F G H I J \n" +
                "1 # # # # # . . . . . \n" +
                "2 . . . . . . . . . . \n" +
                "3 . . . . . . . . . . \n" +
                "4 . . . . . . . . . . \n" +
                "5 . . . . . . . . . . \n" +
                "6 . . . . . . . . . . \n" +
                "7 . . . . . . . . . . \n" +
                "8 . . . . . . . . . . \n" +
                "9 . . . . . . . . . . \n" +
                "10 . . . . . . . . . . \n";

        assertEquals(expected, grille1.toString());
    }
}

