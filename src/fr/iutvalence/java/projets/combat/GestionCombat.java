package fr.iutvalence.java.projets.combat;

import java.awt.*;
import java.awt.event.*;

/**
 * @author colasr
 * Objet de gestion d'un combat
 */
public class GestionCombat implements ActionListener
{
	/**
	 * la carte sur lequel la partie se deroule
	 */
	Carte carte;
	
	/**
	 * Le joueur present sur la carte
	 */
	PersonnageEnCombat joueur;
	
	/**
	 * Liste des monstre present sur la carte
	 */
	Monstre[] monstres;

	Interface fenetre;
	
	boolean finDuTour;
	
	int numCombetenceUtilise;
	int numMonstreVise; 
	
	/**
	 * Cree la partie
	 * @param carte (la carte sur lequel la partie se deroule)
     * @param joueur (le joueur present sur la carte)
	 * @param monstres (liste des monstres present sur la carte)
	 */
	public GestionCombat()
	{
		
	}
	
	public GestionCombat(Carte carte,PersonnageEnCombat joueur, Monstre[] monstres)
	{
		super();
		this.carte = carte;
		this.joueur = joueur;
		this.monstres = monstres;
		this.numCombetenceUtilise = 0;
		this.numMonstreVise = 0;
		this.fenetre = new Interface(carte, this);
	}

// ********** GESTION DES MOUVEMENTS *************** //	
//JOUEUR
	/**
	 * Deplace l'acteur vers le haut seulement si il lui reste des points de mouvement ou si il n'y a pas d'obstacle
	 */
	private void DeplacementJoueurHaut()
	{
		if (this.joueur.getPointDeMouvementActuels()>0)
		{
			this.joueur.getPosition().changePosY(1);
			if (this.carte.getElement(this.joueur.getPosition()) != 0)
			{
			this.joueur.getPosition().changePosY(-1);
			}
		
			else
				this.joueur.setPointDeMouvementActuels(this.joueur.getPointDeMouvementActuels()-1);
		}
	}
	/**
	 * Deplace l'acteur vers le bas seulement si il lui reste des points de mouvement ou si il n'y a pas d'obstacle
	 */
	private void DeplacementJoueurBas()
	{
		if (this.joueur.getPointDeMouvementActuels()>0)
		{
			this.joueur.getPosition().changePosY(-1);
			if (this.carte.getElement(this.joueur.getPosition()) != 0)
			{
				this.joueur.getPosition().changePosY(1);
			}
		
			else
				this.joueur.setPointDeMouvementActuels(this.joueur.getPointDeMouvementActuels()-1);
		}
	}
	
	/**
	 * Deplace l'acteur vers la droit seulement si il lui reste des points de mouvement ou si il n'y a pas d'obstacle
	 */
	private void DeplacementJoueurDroit()
	{
		if (this.joueur.getPointDeMouvementActuels()>0)
		{
			this.joueur.getPosition().changePosX(1);
			if (this.carte.getElement(this.joueur.getPosition()) != 0)
			{
				this.joueur.getPosition().changePosX(-1);
			}
		
			else
				this.joueur.setPointDeMouvementActuels(this.joueur.getPointDeMouvementActuels()-1);
		}
	}
	
	/**
	 * Deplace l'acteur vers la gauche seulement si il lui reste des points de mouvement ou si il n'y a pas d'obstacle
	 */
	private void DeplacementJoueurGauche()
	{
		if (this.joueur.getPointDeMouvementActuels()>0)
		{
			this.joueur.getPosition().changePosX(-1);
			if (this.carte.getElement(this.joueur.getPosition()) != 0)
			{
				this.joueur.getPosition().changePosX(1);
			}
		
			else
				this.joueur.setPointDeMouvementActuels(this.joueur.getPointDeMouvementActuels()-1);
		}
				
	}
	
	
	//MONSTRE
	/**
	 * Deplace l'acteur vers le haut
	 * @param idMonstre (numero de l'acteur)
	 */
	private void DeplacementMonstreHaut(int idMonstre)
	{
		this.monstres[idMonstre].getPosition().changePosY(1);
	}
	/**
	 * Deplace l'acteur vers le bas
	 * @param idMonstre (numero de l'acteur)
	 */
	private void DeplacementMonstreBas(int idMonstre)
	{
		this.monstres[idMonstre].getPosition().changePosY(-1);
	}
	
	/**
	 * Deplace l'acteur vers la droit
	 * @param idMonstre (numero de l'acteur)
	 */
	private void DeplacementMonstreDroit(int idMonstre)
	{
		this.monstres[idMonstre].getPosition().changePosX(1);
	}
	
	/**
	 * Deplace l'acteur vers la gauche
	 * @param idMonstre (numero de l'acteur)
	 */
	private void DeplacementMonstreGauche(int idMonstre)
	{
		this.monstres[idMonstre].getPosition().changePosX(-1);
	}
	

	//GESTION DE LA CARTE
	/**
	 * Affiche la carte en ascii sur le terminal
	 */
	private void AfficheCarte()
	{
		String carteAscii;

		this.carte.ActualiseCarte(this.monstres, this.joueur);
		carteAscii = this.carte.toString();
		System.out.println(carteAscii);
	}
	
	/**
	 * Teste la presence des monstres sur la carte
	 * @return vrai si il reste des monstres, 
	 * faux sinon
	 */
	private boolean ResteMonstres()
	{
		int i;
		
		for(i=0;i<this.monstres.length;i++)
		{
			if (this.monstres[i].getPointDeVieActuels() > 0)
			{
				return true;
			}
		}
		
		return false;
	}
	
	
	//GESTION DES ATTAQUES
	/**
	 * Calcule et reduit le nombre de point de vie d'un joueur en fonction de l'action d'un monstre
	 * @param idAttaquant (identifiant de l'attaquant)
	 */
	private void AttaqueMonstre(int idAttaquant)
	{
		int puissanceTotale;
		int vieDefenseur;
		int vieDeduite;
		Monstre monstre = this.monstres[idAttaquant];
		puissanceTotale = monstre.getCompetences().getBonusPuissance() + this.monstres[idAttaquant].getStats().getPuissance();
		vieDeduite = puissanceTotale-this.joueur.getStats().getDefense();
		
		if (vieDeduite < 0)
		{
			vieDeduite = 0;
		}
		
		vieDefenseur = this.joueur.getPointDeVieActuels() - vieDeduite;
		
		if (vieDefenseur < 0)
		{
			vieDefenseur = 0;
		}
		
		this.joueur.setPointDeVieActuels(vieDefenseur);
	}
	
	/**
	 * Calcule et reduit le nombre de point de vie d'un joueur en fonction de l'action d'un monstre
	 * @param idDefenseur (identifiant de l'attaquant)
	 * @param competence la competence utilisé par le joueur
	 */
	private void AttaqueJoueur(int idDefenseur, Competences competence)
	{
		int puissanceTotale;
		int vieDefenseur;
		int vieDeduite;
		Monstre monstre = this.monstres[idDefenseur];
		puissanceTotale = competence.getBonusPuissance() + this.joueur.getStats().getPuissance();
		vieDeduite = puissanceTotale-monstre.getStats().getDefense();
		
		if (vieDeduite < 0)
		{
			vieDeduite = 0;
		}
		
		vieDefenseur = monstre.getPointDeVieActuels() - vieDeduite;
		
		if (vieDefenseur < 0)
		{
			vieDefenseur = 0;
		}
		
		monstre.setPointDeVieActuels(vieDefenseur);
	}
	
	/**
	 * cree une liste de touts les acteurs qui peuvent etre touche par la competence
	 * @param competences (la competence utilise)
	 * @return liste d'acteur (les acteurs a portee)
	 */
	private Monstre[] ZoneDePorteeJoueur(Competences competences)
	{
		Monstre[] lesMonstres = new Monstre[1];
		Coordonnees positionJoueur = this.carte.CherchePositionActeur(2);
		Coordonnees positionCible;
		int element;
		int x;
		int y;
		int j = 0;
		
		int nombreDeMonstre = 0;
		
		for (y=-competences.getPortee();y<competences.getPortee()+1;y++)
		{
			for(x=-j;x<j+1;x++)
			{
				positionCible = new Coordonnees(x,y);
				element = this.carte.getElement(AdditionneCoordonnees(positionCible,positionJoueur));
				if (element > 2)
				{	
					nombreDeMonstre++;
					lesMonstres = new Monstre[lesMonstres.length+1];
					lesMonstres[nombreDeMonstre] = (this.monstres[element-3]);
					
				}
			}
			if (y>=0)
				j = j - 1;
			else
				j = j + 1;
		}
		return lesMonstres;
	}
	
	/**
	 * Cherche si le joueur est a portee d'une attaque d'un monstre 
	 * @param numMonstre monstre qui attaque
	 * @return Vrai si le joueur est a portee du monstre
	 */
	private boolean ZoneDePorteeMonstre(int numMonstre)
	{
		Monstre monstre = this.monstres[numMonstre];
		Coordonnees positionMonstre = this.carte.CherchePositionActeur(numMonstre+3);
		Coordonnees positionCible;
		int element;
		int x;
		int y;
		int j = 0;
		
		for (y=-monstre.getCompetences().getPortee();y<monstre.getCompetences().getPortee()+1;y++)
		{
			for(x=-j;x<j+1;x++)
			{
				positionCible = new Coordonnees(x,y);
				element = this.carte.getElement(AdditionneCoordonnees(positionCible,positionMonstre));
				if (element == 2)
				{	
					return true;
				}
			}
			if (y>=0)
				j = j - 1;
			else
				j = j + 1;
		}
		
		return false;
	}
	
	/**
	 * Cree un nouveau objet coordonnees a partie de l'adition de 2 coordonnees
	 * @param coord1 premier coordonnees a aditionner
	 * @param coord2 deuxieme coordonnees a aditionner
	 * @return D'addition des 2 coordonnees
	 */
	private Coordonnees AdditionneCoordonnees(Coordonnees coord1,Coordonnees coord2)
	{
		return new Coordonnees(coord1.getX()+coord2.getX(),coord1.getY()+coord2.getY());
	}
	
	/**
	 * Cree un nouveau objet coordonnees a partie de la soustraction de 2 coordonnees
	 * @param coord1 premier coordonnees
	 * @param coord2 coordonnees a soustraire 
	 * @return soustre 2 coordonnees
	 */
	private Coordonnees SoustractionCoordonnees(Coordonnees coord1,Coordonnees coord2)
	{
		return new Coordonnees(coord1.getX()-coord2.getX(),coord1.getY()-coord2.getY());
	}
	
	
	/**
	 * Joue tous les monstres
	 */
	private void tourMonstres()
	{
		int numMonstre = 0;
		while(numMonstre < this.monstres.length)
		{
			if(ZoneDePorteeMonstre(numMonstre))
			{
				AttaqueMonstre(numMonstre);
			}
			numMonstre ++;
		}
	}
	
	/**
	 * Lanceletour du joueur
	 */
	private void tourJoueur()
	{
		int i = 0;
		this.finDuTour = true;
		
		while(this.finDuTour){
			System.out.println();
		}
		this.joueur.setPointDeMouvementActuels(this.joueur.getStats().getPointsDeMouvement());
	}
	
	
	//LANCEMENT D UN COMBAT
	/**
	 * Lancement d'un combat en arene
	 */
	public void lancement()
	{
		while(ResteMonstres() && this.joueur.getPointDeVieActuels() > 0)
		{
			tourJoueur();
			tourMonstres();
			this.fenetre.afficheActionBase();
			this.fenetre.afficheInfoActeur(this.joueur);
			this.fenetre.actualiseFenetre();
			
		}
		
		 System.exit(0);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		  if (e.getActionCommand().equals("Attaque")) {
		      this.fenetre.afficheActionCompetence(this.joueur);
		      this.fenetre.actualiseFenetre();
		    }	
		  
		  else if (e.getActionCommand().equals("Deplacement")) {
		      this.fenetre.afficheActionMouvement();
		      this.fenetre.actualiseFenetre();
		    }
		  
		  else if (e.getActionCommand().equals("Retoure")) {
		      this.fenetre.afficheActionBase();
		      this.fenetre.actualiseFenetre();
		    }
		  
		  else if (e.getActionCommand().equals("Haut")) {
		      this.DeplacementJoueurHaut();
		      this.carte.ActualiseCarte(this.monstres, this.joueur);
		      this.fenetre.afficheInfoActeur(this.joueur);
		      this.fenetre.actualiseArene(this.carte);
		      this.fenetre.actualiseFenetre();
		    }
		  
		  else if (e.getActionCommand().equals("Gauche")) {
		      this.DeplacementJoueurGauche();
		      this.carte.ActualiseCarte(this.monstres, this.joueur);
		      this.fenetre.afficheInfoActeur(this.joueur);
		      this.fenetre.actualiseArene(this.carte);
		      this.fenetre.actualiseFenetre();
		    }
		  
		  else if (e.getActionCommand().equals("Bas")) {
		      this.DeplacementJoueurBas();
		      this.carte.ActualiseCarte(this.monstres, this.joueur);
		      this.fenetre.afficheInfoActeur(this.joueur);
		      this.fenetre.actualiseArene(this.carte);
		      this.fenetre.actualiseFenetre();
		    }
		  
		  else if (e.getActionCommand().equals("Droite")) {
		      this.DeplacementJoueurDroit();
		      this.carte.ActualiseCarte(this.monstres, this.joueur);
		      this.fenetre.afficheInfoActeur(this.joueur);
		      this.fenetre.actualiseArene(this.carte);
		      this.fenetre.actualiseFenetre();
		    }
		  
		  else if (e.getActionCommand().equals("Fin du tour")) {
			  
		      this.fenetre.supprimeAction();
		      this.fenetre.actualiseFenetre();
		      this.finDuTour = false;
		    }
		  
		  else if (e.getActionCommand().equals("Quitter")){
			  System.exit(0);
		    }
		  
		  else {
			  int numComp;
			  int numMonstre;
			  for(numComp = 0;numComp<this.joueur.GetNombreCompetences();numComp++)
			  {
				  if(e.getActionCommand().equals(this.joueur.getCompetences(numComp).getNom()))
				  {
					  this.numCombetenceUtilise = numComp;
				  }
			  }
			  
			  for(numMonstre = 0;numMonstre<this.joueur.GetNombreCompetences();numMonstre++)
			  {
				  if(e.getActionCommand().equals(this.monstres[numMonstre+3].getNom()))
				  {
					  this.numMonstreVise = numMonstre;
				  }
			  }
		  }
	}
	
}
