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
	


	
//GESTION MOUVEMENT DES ACTEURS
	/**
	 * Deplace l'acteur vers le haut
	 * @param idActeur (numero de l'acteur)
	 */
	public void DeplacementHaut(int idActeur)
	{
		this.acteurs[idActeur-2].getPosition().changePosY(1);
	}
	/**
	 * Deplace l'acteur vers le bas
	 * @param idActeur (numero de l'acteur)
	 */
	public void DeplacementBas(int idActeur)
	{
		this.acteurs[idActeur-2].getPosition().changePosY(-1);
	}
	
	/**
	 * Deplace l'acteur vers la droit
	 * @param idActeur (numero de l'acteur)
	 */
	public void DeplacementDroit(int idActeur)
	{
		this.acteurs[idActeur-2].getPosition().changePosX(1);
	}
	
	/**
	 * Deplace l'acteur vers la gauche
	 * @param idActeur (numero de l'acteur)
	 */
	public void DeplacementGauche(int idActeur)
	{
		this.acteurs[idActeur-2].getPosition().changePosX(-1);
	}
	
	
	//GESTION DE LA CARTE
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
	
	
	//GESTION DES ATTAQUES
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
	 * cree une liste de touts les acteurs qui peuvent etre touche par la competence
	 * @param numActeur (le numero de l'acteur qui utilise la competences)
	 * @param competences (la competence utilise)
	 * @return liste d'acteur (les acteurs a portee)
	 */
	public Acteur[] ZoneDePortee(int numActeur, Competences competences)
	{
		Acteur[] lesActeurs = new Acteur[0];
		Coordonnees positionActeur = this.carte.CherchePositionActeur(numActeur);
		Coordonnees positionCible;
		int element;
		int x;
		int y;
		int j = 0;
		
		int nombreDActeurs = 0;
		
		for (y=-competences.getPortee();y<competences.getPortee()+1;y++)
		{
			for(x=-j;x<j+1;x++)
			{
				positionCible = new Coordonnees(x,y);
				element = this.carte.getElement(new Coordonnees(positionCible,positionActeur));
				if (element > 1 && element != numActeur)
				{	
					lesActeurs = new Acteur[nombreDActeurs+1];
					lesActeurs[nombreDActeurs] = (this.acteurs[element-2]);
					nombreDActeurs++;
				}
			}
			if (y>=0)
				j = j - 1;
			else
				j = j + 1;
		}
		return lesActeurs;
	}
	
	
}
