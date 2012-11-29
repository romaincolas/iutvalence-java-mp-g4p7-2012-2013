package fr.iutvalence.java.projets.combat;

import java.awt.*;
import java.awt.event.*;

/**
 * @author colasr
 * Objet de gestion d'un combat
 */
public class GestionCombat implements KeyListener
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

	/**
	 * Cree la partie
	 * @param carte (la carte sur lequel la partie se deroule)
     * @param joueur (le joueur present sur la carte)
	 * @param monstres (liste des monstres present sur la carte)
	 */
	public GestionCombat(Carte carte,PersonnageEnCombat joueur, Monstre[] monstres)
	{
		super();
		this.carte = carte;
		this.joueur = joueur;
		this.monstres = monstres;
	}
	
	// ********** GESTION DES KEYSEVENTS ************** //
	@Override
	public void keyPressed(KeyEvent arg0)
	{
		int entree = arg0.getKeyCode();
		System.out.println(entree);
	}

	@Override
	public void keyReleased(KeyEvent arg0)
	{	}

	@Override
	public void keyTyped(KeyEvent arg0)
	{	}

// ********** GESTION DES MOUVEMENTS *************** //	
//JOUEUR
	/**
	 * Deplace l'acteur vers le haut
	 */
	private void DeplacementJoueurHaut()
	{
		this.joueur.getPosition().changePosY(1);
	}
	/**
	 * Deplace l'acteur vers le bas
	 */
	private void DeplacementJoueurBas()
	{
		this.joueur.getPosition().changePosY(-1);
	}
	
	/**
	 * Deplace l'acteur vers la droit
	 */
	private void DeplacementJoueurDroit()
	{
		this.joueur.getPosition().changePosX(1);
	}
	
	/**
	 * Deplace l'acteur vers la gauche
	 */
	private void DeplacementJoueurGauche()
	{
		this.joueur.getPosition().changePosX(-1);
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
	
	private void tourJoueur()
	{
		while(true);
	}
	
	
	//LANCEMENT D UN COMBAT
	public void lancement()
	{
		final Interface fenetre;
		fenetre = new Interface(this.carte);
		
		while(ResteMonstres() && this.joueur.getPointDeVieActuels() > 0)
		{
			
			tourJoueur();
			tourMonstres();
			System.out.println(this.joueur.getPointDeVieActuels());
		}
	}
}
