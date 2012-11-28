package fr.iutvalence.java.projets.combat;

/**
 * On retrouve toutes les stats d'un acteur (utilisation: calcul des degats, PM, PV )
 * 
 * @author colasr
 * 
 */
// FIXME réfléchir à utiliser l'héritage pour différencier les personnages et se passer de Stats

public class Stats 
{

	// Stats pour le gladiateur
	/**
	 * Puissance de base du Gladiateur
	 */
	// (FIXED)FIXME (toujours pas !) respecter les conventions d'écriture
	private final static int PUISSANCE_GLADIATEUR = 8;

	/**
	 * Defence de base du Gladiateur
	 */
	// (FIXED) FIXME (toujours pas !) respecter les conventions d'écriture	
	private final static int DEFENSE_GLADIATEUR = 5;

	/**
	 * Point de vie de base du Gladiateur
	 */
	// (FIXED) FIXME (toujours pas !) respecter les conventions d'écriture
	private final static int POINT_DE_VIE_GLADIATEUR = 45;

	/**
	 * Point de mouvement de base du Gladiateur
	 */
	// (FIXED) FIXME (toujours pas !) respecter les conventions d'écriture
	private final static int POINT_DE_MOUVEMENT_GLADIATEUR = 4;

	// Stats pour le templier
	/**
	 * Puissance du de base du templier
	 */
	// (FIXED) FIXME (toujours pas !) respecter les conventions d'écriture
	private final static int PUISSANCE_TEMPLIER = 7;

	/**
	 * Defence de base du templier
	 */
	// (FIXED) FIXME (toujours pas !) respecter les conventions d'écriture
	private final static int DEFENSE_TEMPLIER = 6;

	/**
	 * Point de vie de base du templier
	 */
	// (FIXED) FIXME (toujours pas !) respecter les conventions d'écriture
	private final static int POINT_DE_VIE_TEMPLIER = 50;

	/**
	 * Point de mouvement de base du templier
	 */
	// (FIXED) FIXME (toujours pas !) respecter les conventions d'écriture
	private final static int POINT_DE_MOUVEMENT_TEMPLIER = 4;

	// Stats pour le rodeur
	/**
	 * Puissance du de base du rodeur
	 */
	// (FIXED) FIXME (toujours pas !) respecter les conventions d'écriture
	private final static int PUISSANCE_RODEUR = 8;

	/**
	 * Defence de base du rodeur
	 */
	// (FIXED) FIXME (toujours pas !) respecter les conventions d'écriture
	private final static int DEFENSE_RODEUR = 4;

	/**
	 * Point de vie de base du rodeur
	 */
	// (FIXED) FIXME (toujours pas !) respecter les conventions d'écriture
	private final static int POINT_DE_VIE_RODEUR = 40;

	/**
	 * Point de mouvement de base du rodeur
	 */
	// FIXME (toujours pas !) respecter les conventions d'écriture
	private final static int POINT_DE_MOUVEMENT_RODEUR = 3;

	// Stats pour le sorcier
	/**
	 * Puissance du de base du sorcier
	 */
	// (FIXED) FIXME (toujours pas !) respecter les conventions d'écriture
	private final static int PUISSANCE_SORCIER = 8;

	/**
	 * Defence de base du sorcier
	 */
	// (FIXED) FIXME (toujours pas !) respecter les conventions d'écriture
	private final static int DEFENSE_SORCIER = 4;

	/**
	 * Point de vie de base du sorcier
	 */
	// (FIXED) FIXME (toujours pas !) respecter les conventions d'écriture
	private final static int POINT_DE_VIE_SORCIER = 40;

	/**
	 * Point de mouvement de base du sorcier
	 */
	//(FIXED)  FIXME (toujours pas !) respecter les conventions d'écriture
	private final static int POINT_DE_MOUVEMENT_SORCIER = 4;

	/**
	 * puissance de base de l'acteur, determine le nombre de degats infligé au monstre
	 */
	private final int puissance;

	/**
	 * defense de base de l'acteur, determine le nombre de degats retiré lors de l'attaque du monstre
	 */
	private final int defense;

	/**
	 * points de vie maximums de l'acteur
	 */
	private final int pointsDeVie;

	/**
	 * points de mouvement maximums de l'acteur
	 */
	private final int pointsDeMouvement;

	
	/**
	 * Cree une liste de stats pour un monstre
	 * 
	 * @param puissance puissance des attaques
	 * @param defense defense face  au attaque
	 * @param pointDeVie nombre de point de vie
	 * @param pointDeMouvement nombre de point de mouvement
	 */
	public Stats(int puissance, int defense, int pointDeVie, int pointDeMouvement)
	{
		this.puissance = puissance;
		this.defense = defense;
		this.pointsDeVie = pointDeVie;
		this.pointsDeMouvement = pointDeMouvement;
	}

	/**
	 * Cree les stats en fonction de la profession (seulement pour un personnage joueur)
	 * 
	 * @param idProfession numero  de profession
	 */
	public Stats(int idProfession)
	{
		// (FIXED)FIXME utiliser switch/case
		switch (idProfession)
		{

			case (2):
				this.puissance = PUISSANCE_TEMPLIER;
				this.defense = DEFENSE_TEMPLIER;
				this.pointsDeVie = POINT_DE_VIE_TEMPLIER;
				this.pointsDeMouvement = POINT_DE_MOUVEMENT_TEMPLIER;
				break;

			case (3):
				this.puissance = PUISSANCE_RODEUR;
				this.defense = DEFENSE_RODEUR;
				this.pointsDeVie = POINT_DE_VIE_RODEUR;
				this.pointsDeMouvement = POINT_DE_MOUVEMENT_RODEUR;
				break;
			
			case (5):
				this.puissance = PUISSANCE_SORCIER;
				this.defense = DEFENSE_SORCIER;
				this.pointsDeVie = POINT_DE_VIE_SORCIER;
				this.pointsDeMouvement = POINT_DE_MOUVEMENT_SORCIER;
				break;
			
			default:
				this.puissance = PUISSANCE_GLADIATEUR;
				this.defense = DEFENSE_GLADIATEUR;
				this.pointsDeVie = POINT_DE_VIE_GLADIATEUR;
				this.pointsDeMouvement = POINT_DE_MOUVEMENT_GLADIATEUR;	
		}
	}

	/**
	 * donne la puissance dans les stats de l'acteur
	 * 
	 * @return puissance
	 */
	public int getPuissance()
	{
		return this.puissance;
	}

	/**
	 * donne la defense dans les stats de l'acteur
	 * 
	 * @return defense
	 */
	public int getDefense()
	{
		return this.defense;
	}

	/**
	 * donne le nombre de points de vie dans les stats de l'acteur
	 * 
	 * @return nombre de point de vie
	 */
	public int getPointsDeVie()
	{
		return this.pointsDeVie;
	}

	/**
	 * donne le nombre de points de mouvement dans les stats de l'acteur
	 * 
	 * @return nombre de point de mouvement
	 */
	public int getPointsDeMouvement()
	{
		return this.pointsDeMouvement;
	}

	/**
	 * transforme les stats de l'acteur pour l'affichage
	 */
	public String toString()
	{
		return "Puissance = " + this.puissance + "\nDefense = " + this.defense + "\nPoints de vie = " + this.pointsDeVie
				+ "\nPoints de mouvement=" + this.pointsDeMouvement;
	}
	
}
