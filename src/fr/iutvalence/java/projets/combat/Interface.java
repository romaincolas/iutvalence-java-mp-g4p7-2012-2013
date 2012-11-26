package fr.iutvalence.java.projets.combat;

import javax.swing.*;
import java.awt.*;

public class Interface
{
	private JFrame fenetre;
	private JLabel affichage;
	private JButton boutonPlus; 
    private JButton boutonQuitter; 


	public Interface()
	{
		super();
		this.fenetre = new JFrame("Combat");
		this.fenetre.setVisible(true);
		this.affichage = new JLabel();
		
	    this.boutonPlus = new JButton("+");
	    this.boutonQuitter = new JButton("Quitter");
	    
	    Container conteneur = this.fenetre.getContentPane();
	    GridLayout disposition = new GridLayout(2, 2);

	    conteneur.setLayout(disposition);
	    conteneur.add(this.affichage);
	    conteneur.add(this.boutonPlus);
	    conteneur.add(this.boutonQuitter);
	}
}
