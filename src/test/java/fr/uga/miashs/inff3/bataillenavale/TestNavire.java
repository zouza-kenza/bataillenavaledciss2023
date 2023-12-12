import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class TestNavire {
	
	@Test
	void testContient(){
		  // Création de coordonnées pour simuler un navire vertical de (3, 3) à (5, 3)
		Coordonnee debut = new Coordonnee(3, 3);
		Navire navireVertical= new Navire(debut,3,true);
		
		// Vérification des coordonnées incluses dans le navire
		assertTrue(navireVertical.contient(new Coordonnee(3, 3) ));
		assertTrue(navireVertical.contient(new Coordonnee(4, 3) ));
		assertTrue(navireVertical.contient(new Coordonnee(5, 3) ));
		// Vérification des coordonnées en dehors du navire
		assertFalse(navireVertical.contient(new Coordonnee(2, 3) ));
		assertFalse(navireVertical.contient(new Coordonnee(6, 3) ));
		
		
	}
	@Test
	void testRecoitTir() {
		Coordonnee debut = new Coordonnee(3, 3);
		Navire navireHorizental= new Navire(debut,4,false);
		// Vérification des tirs sur le navire
		assertTrue(navireHorizental.recoitTir(new Coordonnee(3, 3) ));
		assertTrue(navireHorizental.recoitTir(new Coordonnee(3, 4) ));
		assertTrue(navireHorizental.recoitTir(new Coordonnee(3, 5) ));
		// Vérification des tirs en  dehors du navire
		assertFalse(navireHorizental.recoitTir(new Coordonnee(3, 2) ));
		assertFalse(navireHorizental.recoitTir(new Coordonnee(3, 7) ));
		
	}
	@Test
		    void testEstTouche() {
		        Coordonnee debut = new Coordonnee(3, 3);
		        Navire navireVertical = new Navire(debut, 3, true);
		        
		        assertTrue(navireVertical.recoitTir(new Coordonnee(3, 3) ));
		        assertTrue(navireVertical.recoitTir(new Coordonnee(4, 3) ));
		        
		        // Vérifier si les parties touchées sont correctes
		        assertTrue(navireVertical.estTouche(new Coordonnee(3, 3)));
		        assertTrue(navireVertical.estTouche(new Coordonnee(4, 3)));
		        assertFalse(navireVertical.estTouche(new Coordonnee(5, 3)));
		        
	}
	 @Test
	    void testEstCoule() {
	        Coordonnee debut = new Coordonnee(3, 3);
	        Navire navireHorizontal = new Navire(debut, 4, false);

	        // Tirs pour couler le navire
	        navireHorizontal.recoitTir(new Coordonnee(3, 3));
	        navireHorizontal.recoitTir(new Coordonnee(3, 4));
	        navireHorizontal.recoitTir(new Coordonnee(3, 5));
	        navireHorizontal.recoitTir(new Coordonnee(3, 6));

	        // Vérifier si le navire est coulé
	        assertTrue(navireHorizontal.estCoule());
	    }
	 @Test
	 void testChevauche() {
	     Coordonnee debut = new Coordonnee(3, 3);
	     Navire navireHorizontal = new Navire(debut, 4, false);
	     Navire navireVertical = new Navire(new Coordonnee(3, 3), 3, true);

	     // Vérifier si les navires se chevauchent
	     assertTrue(navireHorizontal.chevauche(navireVertical));
	     assertTrue(navireVertical.chevauche(navireHorizontal));

	     // Autres scénarios où les navires ne se chevauchent pas
	     Navire navireNonChevauchant = new Navire(new Coordonnee(7, 7), 2, false);
	     assertFalse(navireHorizontal.chevauche(navireNonChevauchant));
	     assertFalse(navireVertical.chevauche(navireNonChevauchant));
	 }


		       
		  
		
	}
	


