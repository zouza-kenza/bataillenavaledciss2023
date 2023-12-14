package fr.uga.miashs.inff3.bataillenavale;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.border.TitledBorder;

public class FenetreJoueur extends JFrame {

	private JPanel contentPane;
	
	private GrilleGraphique grilleTirs;
	private GrilleNavaleGraphique grilleDefense;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FenetreJoueur frame = new FenetreJoueur();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	public FenetreJoueur(String nom, int taille) {
		this.setTitle(nom); //définir le nom de l'interface
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 559, 341);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 0, 0, 0)); //important
		
		JPanel panelAttaque = new GrilleGraphique(taille);
		panelAttaque.setBorder(new TitledBorder(null, "Grille de tir", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(panelAttaque);
//		panelAttaque.setLayout(new GridLayout(1, 0, 0, 0)); // thing make this fucking weird
		
		JPanel panelDefense = new GrilleGraphique(taille);
		panelDefense.setBorder(new TitledBorder(null, "Grille de d\u00E9fense", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(panelDefense);
//		panelDefense.setLayout(new GridLayout(1, 0, 0, 0)); // this one too
		
	}
	
	public GrilleGraphique getGrilleTirs() {
		return grilleTirs;
	}
	
	public GrilleNavaleGraphique getGrilleDefense() {
		return grilleDefense;
	}
	
	public FenetreJoueur() {
		this("Jack Sparrow", 12);
	}

}
