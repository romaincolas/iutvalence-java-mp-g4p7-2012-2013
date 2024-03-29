package fr.iutvalence.java.projets.combat;

import java.awt.*;
import java.awt.event.*;

/**
 * @author colasr
 * Objet de gestion d'un combat
 */
public class GestionCombat
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
	 * Calcule et reduit le nombre de point de vie d'un joueur en fonction de l'action d'un monstre (0 mini)
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
	 * Calcule et reduit le nombre de point de vie d'un joueur en fonction de l'action d'un monstre (0 mini)
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
	 * cree une liste de touts les monstres qui peuvent etre touche par la competence
	 * si les points du vie du monstre est > a 0
	 * @param competences (la competence utilise)
	 * @return liste d'acteur (les acteurs a portee)
	 */
	private Monstre[] ZoneDePorteeJoueur(Competences competences)
	{
		Monstre[] lesMonstres = new Monstre[60];
		Monstre[] lesMonstresARetourne;
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
				positionCible = new Coordonnees(AdditionneCoordonnees(positionCible,positionJoueur).getX(),AdditionneCoordonnees(positionCible,positionJoueur).getY());
				element = this.carte.getElement(positionCible);
				if (element > 2 && this.monstres[nombreDeMonstre].getPointDeVieActuels() > 0)
				{	
					lesMonstres[nombreDeMonstre] = (this.monstres[nombreDeMonstre]);
					nombreDeMonstre++;
				}
			}
			if (y>=0)
				j = j - 1;
			else
				j = j + 1;
		}
		lesMonstresARetourne = new Monstre[nombreDeMonstre];
		for (x=0;x<nombreDeMonstre;x++)
		{
			lesMonstresARetourne[x] = lesMonstres[x];
		}
			
		return lesMonstresARetourne;
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
	 * Joue tous les monstres
	 */
	private void tourMonstres(InterfaceCombat fenetre)
	{
		int numMonstre = 0;
		//Coordonnees[] cheminOptimal;
		while(numMonstre < this.monstres.length)
		{
			
			Coordonnees[] cheminOptimal = this.carte.ChercheCheminOptimal(numMonstre+3);//Calcule cheminOptimal vers le joueur
			while (this.monstres[numMonstre].getPointDeMouvementActuels() != 0 && !(ZoneDePorteeMonstre(numMonstre)))
			{
				this.monstres[numMonstre].setPosition(cheminOptimal[0]);
				this.monstres[numMonstre].setPointDeMouvementActuels(this.monstres[numMonstre].getPointDeMouvementActuels()-1);	
			}
			
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
	private void tourJoueur(ChoixCombat choixCombat, InterfaceCombat fenetre)
	{
		int menuAffiche, monstreAffiche;
		menuAffiche = 1;
		monstreAffiche = -1;
		//******DEBUT DU TOUR DU JOUEUR******//
		while(!choixCombat.isFinDuTour())
		{
			
			//*****AFFICHE LE MENU****//
			if(choixCombat.getChoixMenu() != menuAffiche)
			{
				switch(choixCombat.getChoixMenu())
				{
					case 1:
						fenetre.afficheActionBase();
						fenetre.actualiseFenetre();
						break;
						
					case 2:
						fenetre.afficheActionCompetence(this.joueur.getCompetences());
						fenetre.actualiseFenetre();
						break;
						
					case 3:
						fenetre.afficheActionChoixMonstre(ZoneDePorteeJoueur(this.joueur.getCompetences(choixCombat.getChoixCompetence())));
						fenetre.actualiseFenetre();
						break;
						
					case 4:
						fenetre.afficheActionMouvement();
						fenetre.actualiseFenetre();
						break;
						
					default:
						fenetre.afficheActionBase();
						fenetre.actualiseFenetre();
				}
				
				menuAffiche = choixCombat.getChoixMenu();
			}
			
			if(choixCombat.getChoixMonstreAAfficher() != monstreAffiche)
			{
				fenetre.afficheInfoMonstre(this.monstres[choixCombat.getChoixMonstreAAfficher()]);
				fenetre.actualiseFenetre();
				monstreAffiche = choixCombat.getChoixMonstreAAfficher();
			}
			
			if(choixCombat.getChoixMouvement() != 0)
			{
				switch(choixCombat.getChoixMouvement())
				{
					case 1:
						this.DeplacementJoueurHaut();
				        this.carte.ActualiseCarte(this.monstres, this.joueur);
				        fenetre.afficheInfoJoueur(this.joueur);
				        fenetre.actualiseArene(this.carte,this.monstres);
				        fenetre.actualiseFenetre();	
				        break;
					case 2:
					    this.DeplacementJoueurGauche();
					    this.carte.ActualiseCarte(this.monstres, this.joueur);
					    fenetre.afficheInfoJoueur(this.joueur);
					    fenetre.actualiseArene(this.carte,this.monstres);
					    fenetre.actualiseFenetre();
						break;						
					case 3:
					    this.DeplacementJoueurBas();
					    this.carte.ActualiseCarte(this.monstres, this.joueur);
					    fenetre.afficheInfoJoueur(this.joueur);
					    fenetre.actualiseArene(this.carte,this.monstres);
					    fenetre.actualiseFenetre();
						break;
					case 4:
					    this.DeplacementJoueurDroit();
					    this.carte.ActualiseCarte(this.monstres, this.joueur);
					    fenetre.afficheInfoJoueur(this.joueur);
					    fenetre.actualiseArene(this.carte,this.monstres);
					    fenetre.actualiseFenetre();
					    break;
					default:					    
						this.DeplacementJoueurHaut();
				        this.carte.ActualiseCarte(this.monstres, this.joueur);
				        fenetre.afficheInfoJoueur(this.joueur);
				        fenetre.actualiseArene(this.carte,this.monstres);
				        fenetre.actualiseFenetre();						
				}
				
				choixCombat.setChoixMouvement(0);
			}
			
			//*****DETECTION D'UNE ATTAQUE SUR UN MONSTRE*****//
			if(choixCombat.getChoixMonstre() >= 0 && choixCombat.getChoixCompetence()>=0)
			{
				//test si le nombre de pa est suffisant
				this.joueur.setPointDActionActuels(this.joueur.getPointDActionActuels()- this.joueur.getCompetences(choixCombat.getChoixCompetence()).getConsommation());
				if(this.joueur.getPointDActionActuels() >= 0)
				{
					//faire l'attque
					this.AttaqueJoueur(choixCombat.getChoixMonstre(), this.joueur.getCompetences(choixCombat.getChoixCompetence()));
					
					if(this.monstres[choixCombat.getChoixMonstre()].getPointDeVieActuels() == 0)
					{
						fenetre.actualiseArene(this.carte, this.monstres);
					}
				}
				
				else
					//annuler l'attaque
					this.joueur.setPointDActionActuels(this.joueur.getPointDActionActuels()+ this.joueur.getCompetences(choixCombat.getChoixCompetence()).getConsommation());
				
				
				//retoure a la fenetre de base
				fenetre.afficheActionBase();
				fenetre.afficheInfoMonstre(this.monstres[choixCombat.getChoixMonstre()]);
				fenetre.actualiseFenetre();
				
				//on desactive les variables de detection
				choixCombat.setChoixCompetence(-1);
				choixCombat.setChoixMonstre(-1);
			}
		}
		
		//****FIN DU TOUR DU JOUEUR*****//
		this.joueur.setPointDeMouvementActuels(this.joueur.getStats().getPointsDeMouvement());
		this.joueur.setPointDActionActuels(5);
	}
	
	
	//LANCEMENT D UN COMBAT
	/**
	 * Lancement d'un combat en arene
	 */
	public void lancement()
	{
		ChoixCombat choixCombat = new ChoixCombat(this.monstres, this.joueur.getCompetences());
		InterfaceCombat fenetre = new InterfaceCombat(this.carte, choixCombat, this.joueur);
		
		
		while(ResteMonstres() && this.joueur.getPointDeVieActuels() > 0)
		{
			tourJoueur(choixCombat, fenetre);
			tourMonstres(fenetre);
			choixCombat.setFinDuTour(false);
			fenetre.afficheActionBase();
			fenetre.afficheInfoJoueur(this.joueur);
			fenetre.actualiseFenetre();
			
		}
		
		 System.exit(0);
	}
	
	
	/*
	public void actionPerformed(ActionEvent e)
	{
		  if (e.getActionCommand().equals("Attaque")) {
			  if (this.joueur.getPointDActionActuels() > 0)
			  {
				  this.fenetre.afficheActionCompetence();
				  this.fenetre.actualiseFenetre();
			  }
		    }	
		  
		  else if (e.getActionCommand().equals("Deplacement")) {
		      this.fenetre.afficheActionMouvement();
		      this.fenetre.afficheInfoJoueur(this.joueur);
		      this.fenetre.actualiseFenetre();
		    }
		  
		  else if (e.getActionCommand().equals("Retour")) {
		      this.fenetre.afficheActionBase();
		      this.fenetre.actualiseFenetre();
		    }
		  
		  else if (e.getActionCommand().equals("Haut")) {
		      this.DeplacementJoueurHaut();
		      this.carte.ActualiseCarte(this.monstres, this.joueur);
		      this.fenetre.afficheInfoJoueur(this.joueur);
		      this.fenetre.actualiseArene();
		      this.fenetre.actualiseFenetre();
		    }
		  
		  else if (e.getActionCommand().equals("Gauche")) {
		      this.DeplacementJoueurGauche();
		      this.carte.ActualiseCarte(this.monstres, this.joueur);
		      this.fenetre.afficheInfoJoueur(this.joueur);
		      this.fenetre.actualiseArene();
		      this.fenetre.actualiseFenetre();
		    }
		  
		  else if (e.getActionCommand().equals("Bas")) {
		      this.DeplacementJoueurBas();
		      this.carte.ActualiseCarte(this.monstres, this.joueur);
		      this.fenetre.afficheInfoJoueur(this.joueur);
		      this.fenetre.actualiseArene();
		      this.fenetre.actualiseFenetre();
		    }
		  
		  else if (e.getActionCommand().equals("Droite")) {
		      this.DeplacementJoueurDroit();
		      this.carte.ActualiseCarte(this.monstres, this.joueur);
		      this.fenetre.afficheInfoJoueur(this.joueur);
		      this.fenetre.actualiseArene();
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
					  Monstre[] monstreAPortee = this.ZoneDePorteeJoueur(this.joueur.getCompetences(numComp));
					  this.numCombetenceUtilise = numComp;
					  
					  this.fenetre.afficheActionChoixMonstre(monstreAPortee);
					  this.fenetre.afficheInfoCompetence(this.joueur.getCompetences(numComp));
					  this.fenetre.actualiseFenetre();
				  }
			  }
			  
			  for(numMonstre = 0;numMonstre<this.monstres.length;numMonstre++)
			  {
				  if(e.getActionCommand().equals(this.monstres[numMonstre].getNom()))
				  {
					  this.numMonstreAPortee = numMonstre;
				  }
			  }
		  }
	}*/
	
}
