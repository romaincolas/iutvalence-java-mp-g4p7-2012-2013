package fr.iutvalence.java.projets.lancement;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChoixMenu implements ActionListener
{
	/**
	 * choix du menu (1:Affiche menu de base , 2:affiche choix map, 3:affiche choix profession)
	 */
	private int choixMenu;
	
	/**
	 * map valide par le joueur  (default aucune)
	 */
	private int choixMap;
	
	
	/**
	 * profession valide par le joueur (default aucune)
	 */
	private int choixProfession;
	
	
	/**  
	 * choix de l'apercu de la map un tel (default 1)
	 */
	private int choixMapAAfficher;
	
	/**
	 * cree l'objet choix du menu
	 */
	public ChoixMenu()
	{
		this.choixMenu = 1;
		this.choixMap = 0;
		this.choixProfession = 0;
		this.choixMapAAfficher = 1;
	}
	
	
	public int getChoixMenu()
	{
		return this.choixMenu;
	}
	
	public int getChoixMap()
	{
		return this.choixMap;
	}



	public int getChoixProfession()
	{
		return this.choixProfession;
	}



	public int getChoixMapAAfficher()
	{
		return this.choixMapAAfficher;
	}


	@Override
	public void actionPerformed(ActionEvent e)
	{
		  if (e.getActionCommand().equals("Retour")) {
			  this.choixMenu = 1;
		    }
		  
		  else if (e.getActionCommand().equals("Quitter")) {
			  System.exit(0);
		    }
		  
		  else if (e.getActionCommand().equals("Map 1")) {
			  this.choixMap = 1;
		    }
		  
		  else if (e.getActionCommand().equals("Map 2")) {
			  this.choixMap = 2;
		    }
		  
		  else if (e.getActionCommand().equals("Gladiateur")) {
			  this.choixProfession = 1;
		    }
		  
		  else if (e.getActionCommand().equals("Templier")) {
			  this.choixProfession = 2;
		    }
		  
		  else if (e.getActionCommand().equals("Rodeur")) {
			  this.choixProfession = 3;
		    }
		  
		  else if (e.getActionCommand().equals("Sorcier")) {
			  this.choixProfession = 4;
		    }
		  
		  else if (e.getActionCommand().equals("Voir Map 1")) {
			  this.choixMapAAfficher = 1;
		    }
		  
		  else if (e.getActionCommand().equals("Voir Map 2")) {
			  this.choixMapAAfficher = 2;
		    }
		  
		  else if (e.getActionCommand().equals("Choix de la Map")) {
			  this.choixMenu = 2;
		    }
		  
		  else if (e.getActionCommand().equals("Choix de la profession")) {
			  this.choixMenu = 3;
		    }
		  
		  
	}

}
