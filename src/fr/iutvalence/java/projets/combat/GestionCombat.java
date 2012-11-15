package fr.iutvalence.java.projets.combat;

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
	 * Liste des acteurs present sur la carte
	 */
	Acteur[] acteurs;
	

	/**
	 * Cree la partie
	 * @param carte (la carte sur lequel la partie se deroule)
	 * @param acteurs (liste des acteurs present sur la carte)
	 */
	public GestionCombat(Carte carte, Acteur[] acteurs)
	{
		super();
		this.carte = carte;
		this.acteurs = acteurs;
	}

	
	/**
	 * Deplace l'acteur vers le haut
	 * @param idActeur (numero de l'acteur)
	 */
	public void DeplacementHaut(int idActeur)
	{
		Coordonnees mouvementTemp = new Coordonnees(this.acteurs[idActeur-2].getPosition());
		mouvementTemp.changePosY(1);
		this.acteurs[idActeur-2].MouvementDeLActeur(this.carte, mouvementTemp);
	}
	/**
	 * Deplace l'acteur vers le bas
	 * @param idActeur (numero de l'acteur)
	 */
	public void DeplacementBas(int idActeur)
	{
		Coordonnees mouvementTemp = new Coordonnees(this.acteurs[idActeur-2].getPosition());
		mouvementTemp.changePosY(-1);
		this.acteurs[idActeur-2].MouvementDeLActeur(this.carte, mouvementTemp);
	}
	
	/**
	 * Deplace l'acteur vers la droit
	 * @param idActeur (numero de l'acteur)
	 */
	public void DeplacementDroit(int idActeur)
	{
		Coordonnees mouvementTemp = new Coordonnees(this.acteurs[idActeur-2].getPosition());
		mouvementTemp.changePosX(1);
		this.acteurs[idActeur-2].MouvementDeLActeur(this.carte, mouvementTemp);
	}
	
	/**
	 * Deplace l'acteur vers la gauche
	 * @param idActeur (numero de l'acteur)
	 */
	public void DeplacementGauche(int idActeur)
	{
		Coordonnees mouvementTemp = new Coordonnees(this.acteurs[idActeur-2].getPosition());
		mouvementTemp.changePosX(-1);
		this.acteurs[idActeur-2].MouvementDeLActeur(this.carte, mouvementTemp);
	}
	
	/**
	 * Affiche la carte en ascii sur le terminal
	 */
	public void AfficheCarte()
	{
		String carteAscii;
		this.carte.ActualiseCarte(this.acteurs);
		carteAscii = this.carte.toString();
		System.out.println(carteAscii);
	}
	
	
	/**
	 * Calcule et reduit le nombre de point de vie d'un acteur en fonction de l'action d'un autre acteur
	 * @param idDefenseur (identifiant du defenseur)
	 * @param idAttaquant (identifiant de l'attaquant)
	 * @param competence (competence utilisée par l'attaquant)
	 */
	public void ReductionPointDeVie(int idDefenseur, int idAttaquant, Competences competence)
	{
		int puissanceTotale;
		int vieDefenseur;
		int vieDeduite;
		puissanceTotale = competence.getBonusPuissance() + this.acteurs[idAttaquant-2].getStats().getPuissance();
		vieDeduite = puissanceTotale-this.acteurs[idDefenseur-2].getStats().getDefense();
		
		if (vieDeduite < 0)
		{
			vieDeduite = 0;
		}
		
		vieDefenseur = this.acteurs[idDefenseur-2].getPointDeVieActuels() - vieDeduite;
		
		if (vieDefenseur < 0)
		{
			vieDefenseur = 0;
		}
		
		this.acteurs[idDefenseur-2].setPointDeVieActuels(vieDefenseur);
	}
	
	/**
	 * @param acteur
	 * @param competences
	 * @return
	 */
	public Acteur[] ZoneDePortee(int idActeur, Competences competences)
	{
		Acteur[] lesActeurs = {};
		int x = 0;
		int y;
		int j;
		
		int nombreDActeurs = 0;
		
		for (y=-competences.getPortee();y<competences.getPortee()+1;y++)
		{
			if (y>0)
				x = x - 1;
			else
				x = x + 1;
			
			for(j=-x;j<x+1;y++)
			{
				if (this.carte.getElement(j,y) > 1)
				{
					
					lesActeurs[nombreDActeurs] = this.acteurs[this.carte.getElement(j, y)];
					nombreDActeurs++;
				}
			}
			
		}
		
		
		return lesActeurs;
	}
	
	
}
