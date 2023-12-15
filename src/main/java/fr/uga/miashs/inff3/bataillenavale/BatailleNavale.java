package fr.uga.miashs.inff3.bataillenavale;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.border.TitledBorder;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import java.awt.CardLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Component;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import javax.swing.ButtonGroup;

public class BatailleNavale {

	private JFrame frame;
	private Joueur joueur1, joueur2;
	private int tailleGrille;
	private JTextField tfNomJ1;
	private JTextField tfNomJ2;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	private void demarrerPartie() {
		new Thread() {
			public void run() {
				joueur1.jouerAvec(joueur2);
			}
		}.start();
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BatailleNavale window = new BatailleNavale();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BatailleNavale() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 348, 385);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel_01 = new JPanel();
		panel_01.setBounds(0, 1, 332, 39);
		frame.getContentPane().add(panel_01);
		panel_01.setLayout(new BoxLayout(panel_01, BoxLayout.X_AXIS));
		
		JLabel lblTailleDeGrille = new JLabel("Taille de grille : ");
		lblTailleDeGrille.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel_01.add(lblTailleDeGrille);
		
		JSpinner spTaille = new JSpinner();
		panel_01.add(spTaille);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 40, 332, 259);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panelJoueur_1 = new JPanel();
		panelJoueur_1.setBorder(new TitledBorder(null, "Joueur 1", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.add(panelJoueur_1);
		panelJoueur_1.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel Nom = new JPanel();
		Nom.setAutoscrolls(true);
		panelJoueur_1.add(Nom);
		Nom.setLayout(new BoxLayout(Nom, BoxLayout.X_AXIS));
		
		JLabel Nom_de_Joueur_1_1 = new JLabel("Nom : ");
		Nom_de_Joueur_1_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		Nom.add(Nom_de_Joueur_1_1);
		
		tfNomJ1 = new JTextField();
		tfNomJ1.setText("Joueur 1");
		tfNomJ1.setColumns(10);
		Nom.add(tfNomJ1);
		
		JRadioButton btnJ1Graphique = new JRadioButton("Joueur graphique");
		buttonGroup.add(btnJ1Graphique);
		btnJ1Graphique.setSelected(true);
		btnJ1Graphique.setFont(new Font("Tahoma", Font.ITALIC, 11));
		panelJoueur_1.add(btnJ1Graphique);
		
		JRadioButton btnJ1Texte = new JRadioButton("Joueur Texte");
		buttonGroup.add(btnJ1Texte);
		btnJ1Texte.setFont(new Font("Tahoma", Font.ITALIC, 11));
		btnJ1Texte.setVerticalAlignment(SwingConstants.TOP);
		panelJoueur_1.add(btnJ1Texte);
		
		JRadioButton btnJ1Auto = new JRadioButton("Joueur Auto");
		buttonGroup.add(btnJ1Auto);
		btnJ1Auto.setFont(new Font("Tahoma", Font.ITALIC, 11));
		btnJ1Auto.setVerticalAlignment(SwingConstants.TOP);
		panelJoueur_1.add(btnJ1Auto);
		
		JPanel panelJoueur_2 = new JPanel();
		panelJoueur_2.setBorder(new TitledBorder(null, "Joueur 2", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.add(panelJoueur_2);
		panelJoueur_2.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel Nom_2 = new JPanel();
		panelJoueur_2.add(Nom_2);
		Nom_2.setLayout(new BoxLayout(Nom_2, BoxLayout.X_AXIS));
		
		JLabel Nom_de_Joueur_2 = new JLabel("Nom : ");
		Nom_de_Joueur_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		Nom_de_Joueur_2.setAlignmentX(Component.CENTER_ALIGNMENT);
		Nom_2.add(Nom_de_Joueur_2);
		
		tfNomJ2 = new JTextField();
		tfNomJ2.setText("Joueur 2");
		tfNomJ2.setColumns(10);
		Nom_2.add(tfNomJ2);
		
		JRadioButton btnJ2Graphique = new JRadioButton("Joueur graphique");
		btnJ2Graphique.setFont(new Font("Tahoma", Font.ITALIC, 11));
		panelJoueur_2.add(btnJ2Graphique);
		
		JRadioButton btnJ2Texte = new JRadioButton("Joueur Texte");
		btnJ2Texte.setFont(new Font("Tahoma", Font.ITALIC, 11));
		btnJ2Texte.setVerticalAlignment(SwingConstants.TOP);
		panelJoueur_2.add(btnJ2Texte);
		
		JRadioButton btnJ2Auto = new JRadioButton("Joueur Auto");
		btnJ2Auto.setSelected(true);
		btnJ2Auto.setFont(new Font("Tahoma", Font.ITALIC, 11));
		btnJ2Auto.setVerticalAlignment(SwingConstants.TOP);
		panelJoueur_2.add(btnJ2Auto);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(0, 304, 332, 38);
		frame.getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		JButton btnNewButton = new JButton("Lancer la partie");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int[] tailleNavires = {2,3,4,4,5};
				int taille = Integer.parseInt(spTaille.getValue().toString());
				if (btnJ1Graphique.isSelected()) {
					GrilleNavaleGraphique gn1 = new GrilleNavaleGraphique(taille);
					GrilleGraphique gt1 = new GrilleGraphique(taille);
					FenetreJoueur f1 = new FenetreJoueur(tfNomJ1.getText(),gt1,gn1.getGrilleGraphique());
			
					gn1.placementAuto(tailleNavires);
					joueur1 = new JoueurGraphique(gn1,gt1,tfNomJ1.getText());
					
					f1.setVisible(true);
				}
				if (btnJ1Texte.isSelected()) {
					GrilleNavale gn1 = new GrilleNavale(taille, tailleNavires);
					joueur1 = new JoueurTexte(gn1,tfNomJ1.getText());
					
				
					//f1.setVisible(true);
				}
				if (btnJ1Auto.isSelected()) {
					GrilleNavale gn1 = new GrilleNavale(taille,tailleNavires);
					joueur1 = new JoueurTexte(gn1,tfNomJ1.getText());
					
					
				}
				if (btnJ2Graphique.isSelected()) {
					GrilleNavaleGraphique gn2 = new GrilleNavaleGraphique(taille);
					GrilleGraphique gt2 = new GrilleGraphique(taille);
					FenetreJoueur f2 = new FenetreJoueur(tfNomJ2.getText(),gt2,gn2.getGrilleGraphique());
			
					gn2.placementAuto(new int[] {2});
					joueur2 = new JoueurGraphique(gn2,gt2,tfNomJ2.getText());
					
					f2.setVisible(true);
				}
				if (btnJ2Texte.isSelected()) {
					GrilleNavale gn2 = new GrilleNavale(taille, tailleNavires);
					joueur1 = new JoueurTexte(gn2,tfNomJ2.getText());
					//f2.setVisible(true);
				}
				if (btnJ2Auto.isSelected()) {
					GrilleNavale gn2 = new GrilleNavale(taille,tailleNavires);
					joueur2 = new JoueurAuto(gn2,tfNomJ2.getText());
					
					
				}
				
				
				
				// a la fin
				demarrerPartie();
				
			}
		});
		btnNewButton.setBackground(new Color(128, 128, 255));
		btnNewButton.setBounds(112, 5, 107, 23);
		panel_3.add(btnNewButton);
	}

}
