package fr.iutvalence.java.projets.combat;

import javax.swing.*;
import java.awt.*;

public class Interface
{
	/**
	 * Taille en largeur de la fenetre
	 */
	private final static int FENETRE_LARGEUR = 700;
	
	
	/**
	 * Taille en Hauteur de la fenetre
	 */
	private final static int FENETRE_HAUTEUR = 700;
	
	/**
	 * La fenetre d un combat avec l arene et les informations
	 */
	private JFrame fenetre;
	
	/**
	 * Grille de la carte 
	 */
	private JPanel arene;
	
	/**
	 * Informations sur le joueur, les monstres
	 */
	private JPanel informations;
	
	/**
	 * Liste de toute les cases de l'arene
	 */
	private JButton[] cases; 
	
    /**
     * Bouton qui permet de quitter le jeu
     */
    private JButton boutonQuitter; 


	public Interface(Carte carte)
	{
		super();
		int x, y, largeurCarte, hauteurCarte, nbCase;
		
		nbCase = 0;
		largeurCarte = carte.GetDimension().getX();
		hauteurCarte = carte.GetDimension().getY();
		
		this.cases = new JButton[largeurCarte*hauteurCarte];
		
		this.fenetre = new JFrame();
		this.fenetre.setTitle("Combat");
		this.fenetre.setSize(FENETRE_LARGEUR, FENETRE_HAUTEUR);
		this.fenetre.setLocationRelativeTo(null);
		this.fenetre.setVisible(true);
		
		this.arene = new JPanel(new GridLayout(largeurCarte,hauteurCarte));
		
		this.informations = new JPanel(new GridLayout(0,2));
		
		for (y = 0; y < largeurCarte; y++)
		{
			for (x = hauteurCarte-1; x >= 0; x--)
			{ 
				switch (carte.getCarte()[x][y])
				{
					case 0:
						this.cases[nbCase] = new JButton(new ImageIcon("img/herbe.gif"));
						this.arene.add(this.cases[nbCase]);// Vide;
						break;
						
					case 1:
						
						this.cases[nbCase] = new JButton(new ImageIcon("img/trou.gif"));
						this.arene.add(this.cases[nbCase]);// Trou
						break;
						
					case 2:
						this.cases[nbCase] = new JButton(new ImageIcon("img/aventurier.gif")); 
						this.arene.add(this.cases[nbCase]); //Le Joueur
						break;
					case -1:
						this.cases[nbCase] = new JButton(); 
						this.arene.add(this.cases[nbCase]); //Affiche "F" pour une erreur
						
					default:
						this.cases[nbCase] = new JButton(new ImageIcon("img/monstre.gif"));
						this.arene.add(this.cases[nbCase]); // Ennemie
				}
				nbCase+=1;
			}
		}
		
		
	
	    
	    Container conteneurFrame = this.fenetre.getContentPane();
	    GridLayout disposition = new GridLayout(0, 1);
	    conteneurFrame.setLayout(disposition);
	    conteneurFrame.add(this.arene);
	    conteneurFrame.add(this.informations);
	    
	    this.fenetre.add(this.arene);
	    this.fenetre.add(this.informations);
	}
}
