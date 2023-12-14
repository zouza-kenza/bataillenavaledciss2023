package fr.uga.miashs.inff3.bataillenavale;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.border.TitledBorder;

public class FenetreJoueur extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

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
	public FenetreJoueur() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panelAttaque = new GrilleGraphique(10);
		panelAttaque.setBorder(new TitledBorder(null, "Grille de tir", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(panelAttaque);
		
		JPanel panelDefense = new GrilleGraphique(10);
		panelDefense.setBorder(new TitledBorder(null, "Grille de d\u00E9fense", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(panelDefense);
	}

}
