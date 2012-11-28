package fr.iutvalence.java.projets.combat;

import javax.swing.*;
import java.awt.*;

public class Interface
{
	private final static int FENETRE_LARGER = 600;
	private final static int FENETRE_HAUTEUR = 400;
	private final static int HAUTEUR_CARTE = 9;
	private final static int LARGEUR_CARTE = 16;
	
	private JFrame fenetre;
	private JLabel affichage;
	
	private JPanel arene;
	private JPanel information;
	
	private JButton boutonPlus; 
    private JButton boutonQuitter; 


	public Interface(Carte carte)
	{
		super();
		int x,y,largeurCarte, hauteurCarte;
		
		largeurCarte = carte.GetDimension().getX();
		hauteurCarte = carte.GetDimension().getY();
		
		this.fenetre = new JFrame();
		this.fenetre.setTitle("Combat");
		this.fenetre.setSize(FENETRE_LARGER, FENETRE_HAUTEUR);
		this.fenetre.setLocationRelativeTo(null);
		this.fenetre.setVisible(true);
		
		this.arene = new JPanel(new GridLayout(largeurCarte,hauteurCarte));
		this.arene.setSize(400, FENETRE_HAUTEUR-50);
		
		this.information = new JPanel();
		this.information.setSize(200, FENETRE_HAUTEUR);
		
		for (y = 0; y < largeurCarte; y++)
		{
			for (x = hauteurCarte-1; x >= 0; x--)
			{
				switch (carte.getCarte()[x][y])
				{
					case 0:
						this.arene.add(new Button("-"));
						break;
						
					case 1:
						this.arene.add(new Button("█"));
						break;
						
					case 2:
						this.arene.add(new Button("A"));
						break;
					case -1:
						this.arene.add(new Button("F"));
						
					default:
						this.arene.add(new Button("E"));
				}
				
			}
		}
	
	    
	    /*Container conteneurFrame = this.fenetre.getContentPane();
	    GridLayout disposition = new GridLayout(0, 2);
	    conteneurFrame.setLayout(disposition);
	    conteneurFrame.add(this.arene);
	    conteneurFrame.add(this.information);*/
	    
	    this.fenetre.add(this.arene);
	    this.fenetre.add(this.information);
	}
}
