package fr.iutvalence.java.projets.combat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Florian
 * objet qui regroupe les informations des boutons de l'interface Menu
 */
public class ChoixCombat implements ActionListener
{
	/**
	 * choix du menu (1:Affiche menu de base , 2:affiche choix des competences, 3:affiche choix des monstres, 4:affiche mouvement)
	 */
	private int choixMenu;
	
	/**
	 * Mouvement choisi (1:haut 2:gauche 3:bas 4:droite)
	 */
	private int choixMouvement;
	
	/**
	 * competence valide par le joueur
	 */
	private int choixCompetence;
	
	
	/**
	 * monstre valide par le joueur 
	 */
	private int choixMonstre;
	
	/**
	 * Etat du tour du joueur
	 */
	private boolean finDuTour;
	
	/**  
	 * choix de l'apercu d'un monstre a affiche
	 */
	private int choixMonstreAAfficher;
	
	/**
	 * Competences du joueur
	 */
	private Competences[] competences;
	
	/**
	 * Monstres present sur la carte
	 */
	private Monstre[] monstres;
	
	/**
	 * cree l'objet choix du menu
	 * @param monstres present sur la carte
	 * @param competences du joueur
	 */
	public ChoixCombat(Monstre[] monstres, Competences[] competences)
	{
		this.competences = competences;
		this.monstres = monstres;
		
		this.choixMenu = 1;
		this.choixMonstre = -1; // Desactive la variable
		this.choixMonstreAAfficher = -1;
		this.choixCompetence = -1;
		this.choixMouvement = 0;
	}

	

	public int getChoixMenu()
	{
		return choixMenu;
	}

	public int getChoixMouvement()
	{
		return choixMouvement;
	}

	public int getChoixCompetence()
	{
		return choixCompetence;
	}

	public int getChoixMonstre()
	{
		return choixMonstre;
	}

	public boolean isFinDuTour()
	{
		return finDuTour;
	}

	public int getChoixMonstreAAfficher()
	{
		return choixMonstreAAfficher;
	}


	public void setFinDuTour(boolean finDuTour)
	{
		this.finDuTour = finDuTour;
	}

	public void setChoixCompetence(int choixCompetence)
	{
		this.choixCompetence = choixCompetence;
	}

	public void setChoixMonstre(int choixMonstre)
	{
		this.choixMonstre = choixMonstre;
	}

	public void setChoixMouvement(int choixMouvement)
	{
		this.choixMouvement = choixMouvement;
	}



	@Override
	public void actionPerformed(ActionEvent e)
	{
		/**
		 * choix du menu (1:Affiche menu de base , 2:affiche choix des competences, 3:affiche choix des monstres, 4:affiche mouvement)
		 */
		
		  if (e.getActionCommand().equals("Retour")) {
			  this.choixMenu = 1;
		    }

		  else if (e.getActionCommand().equals("Deplacement")) {
			  this.choixMenu = 4;
		    }
		  
		  else if (e.getActionCommand().equals("Fin du tour")) {
			  this.finDuTour = true; 
		    }
		  
		  else if (e.getActionCommand().equals("Attaque")) {
			  this.choixMenu = 2;
		    }
		  
		  else if (e.getActionCommand().equals("Quitter")) {
			  System.exit(0);
		    }
		  
		  else if (e.getActionCommand().equals("Haut")) {
		      this.choixMouvement = 1;
		    }
		  
		  else if (e.getActionCommand().equals("Gauche")) {
			  this.choixMouvement = 2;
		    }
		  
		  else if (e.getActionCommand().equals("Bas")) {
			  this.choixMouvement = 3;
		    }
		  
		  else if (e.getActionCommand().equals("Droite")) {
			  this.choixMouvement = 4;
		    }
		  
		  else
		  {
			  int numComp;
			  int numMonstre;
			  for(numComp = 0;numComp<this.competences.length;numComp++)
			  {
				  if(e.getActionCommand().equals(this.competences[numComp].getNom()))
				  {
					  this.choixCompetence = numComp;
				  }
			  }
		  
			  for(numMonstre = 0;numMonstre<this.monstres.length;numMonstre++)
			  {
				  if(e.getActionCommand().equals(this.monstres[numMonstre].getNom()))
				  {
					  this.choixMonstre = numMonstre;
				  }
			  }
			  
			  for(numMonstre = 0;numMonstre<this.monstres.length;numMonstre++)
			  {
				  if(e.getActionCommand().equals("Info " + this.monstres[numMonstre].getNom()))
				  {
					  this.choixMonstreAAfficher = numMonstre;
				  }
			  }
		  }
		  
		  
	}

}
