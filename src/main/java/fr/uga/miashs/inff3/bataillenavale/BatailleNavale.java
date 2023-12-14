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

public class BatailleNavale {

	private JFrame frame;
	private Joueur joueur1, joueur2;
	private int tailleGrille;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

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
		
		textField = new JTextField();
		textField.setColumns(10);
		panel_01.add(textField);
		
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
		
		textField_1 = new JTextField();
		textField_1.setText("Joueur 1");
		textField_1.setColumns(10);
		Nom.add(textField_1);
		
		JRadioButton btn1_1 = new JRadioButton("Joueur graphique");
		btn1_1.setFont(new Font("Tahoma", Font.ITALIC, 11));
		panelJoueur_1.add(btn1_1);
		
		JRadioButton btn2_1 = new JRadioButton("Joueur Texte");
		btn2_1.setFont(new Font("Tahoma", Font.ITALIC, 11));
		btn2_1.setVerticalAlignment(SwingConstants.TOP);
		panelJoueur_1.add(btn2_1);
		
		JRadioButton btn3_1 = new JRadioButton("Joueur Auto");
		btn3_1.setFont(new Font("Tahoma", Font.ITALIC, 11));
		btn3_1.setVerticalAlignment(SwingConstants.TOP);
		panelJoueur_1.add(btn3_1);
		
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
		
		textField_2 = new JTextField();
		textField_2.setText("Joueur 2");
		textField_2.setColumns(10);
		Nom_2.add(textField_2);
		
		JRadioButton btn1_1_1 = new JRadioButton("Joueur graphique");
		btn1_1_1.setFont(new Font("Tahoma", Font.ITALIC, 11));
		panelJoueur_2.add(btn1_1_1);
		
		JRadioButton btn2_1_1 = new JRadioButton("Joueur Texte");
		btn2_1_1.setFont(new Font("Tahoma", Font.ITALIC, 11));
		btn2_1_1.setVerticalAlignment(SwingConstants.TOP);
		panelJoueur_2.add(btn2_1_1);
		
		JRadioButton btn3_1_1 = new JRadioButton("Joueur Auto");
		btn3_1_1.setFont(new Font("Tahoma", Font.ITALIC, 11));
		btn3_1_1.setVerticalAlignment(SwingConstants.TOP);
		panelJoueur_2.add(btn3_1_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(0, 304, 332, 38);
		frame.getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		JButton btnNewButton = new JButton("Lancer la partie");
		btnNewButton.setBackground(new Color(128, 128, 255));
		btnNewButton.setBounds(112, 5, 107, 23);
		panel_3.add(btnNewButton);
	}

}
