// FIXME (FIXED) renommer le paquetage (fr.iutvalence.java.projets.(nom))
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
	// FIXME (FIXED) respecter les conventions d'écriture
	private final static int PUISSANCEGLADIATEUR = 8;

	/**
	 * Defence de base du Gladiateur
	 */
	// FIXME (FIXED) respecter les conventions d'écriture	
	private final static int DEFENSEGLADIATEUR = 5;

	/**
	 * Point de vie de base du Gladiateur
	 */
	// FIXME (FIXED) respecter les conventions d'écriture
	private final static int POINTDEVIEGLADIATEUR = 45;

	/**
	 * Point de mouvement de base du Gladiateur
	 */
	// FIXME (FIXED) respecter les conventions d'écriture
	private final static int POINTDEMOUVEMENTGLADIATEUR = 4;

	// Stats pour le templier
	/**
	 * Puissance du de base du templier
	 */
	// FIXME (FIXED) respecter les conventions d'écriture
	private final static int PUISSANCETEMPLIER = 7;

	/**
	 * Defence de base du templier
	 */
	// FIXME (FIXED) respecter les conventions d'écriture
	private final static int DEFENSETEMPLIER = 6;

	/**
	 * Point de vie de base du templier
	 */
	// FIXME (FIXED) respecter les conventions d'écriture
	private final static int POINTDEVIETEMPLIER = 50;

	/**
	 * Point de mouvement de base du templier
	 */
	// FIXME (FIXED) respecter les conventions d'écriture
	private final static int POINTDEMOUVEMENTTEMPLIER = 4;

	// Stats pour le rodeur
	/**
	 * Puissance du de base du rodeur
	 */
	// FIXME (FIXED) respecter les conventions d'écriture
	private final static int PUISSANCERODEUR = 8;

	/**
	 * Defence de base du rodeur
	 */
	// FIXME (FIXED) respecter les conventions d'écriture
	private final static int DEFENSERODEUR = 4;

	/**
	 * Point de vie de base du rodeur
	 */
	// FIXME (FIXED) respecter les conventions d'écriture
	private final static int POINTDEVIERODEUR = 40;

	/**
	 * Point de mouvement de base du rodeur
	 */
	// FIXME (FIXED) respecter les conventions d'écriture
	private final static int POINTDEMOUVEMENTRODEUR = 3;

	// Stats pour le sorcier
	/**
	 * Puissance du de base du sorcier
	 */
	// FIXME (FIXED) respecter les conventions d'écriture
	private final static int PUISSANCESORCIER = 8;

	/**
	 * Defence de base du sorcier
	 */
	// FIXME (FIXED) respecter les conventions d'écriture
	private final static int DEFENSESORCIER = 4;

	/**
	 * Point de vie de base du sorcier
	 */
	// FIXME (FIXED) respecter les conventions d'écriture
	private final static int POINTDEVIESORCIER = 40;

	/**
	 * Point de mouvement de base du sorcier
	 */
	// FIXME (FIXED) respecter les conventions d'écriture
	private final static int POINTDEMOUVEMENTSORCIER = 4;

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

	
	// FIXME (FIXED) compléter le commentaire
	/**
	 * Cree une liste de stats pour un monstre
	 * 
	 * @param puissance
	 * @param defense
	 * @param pointDeVie
	 * @param pointDeMouvement
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
	 * @param idProfession
	 */
	// FIXME (FIXED) compléter le commentaire
	public Stats(int idProfession)
	{

		if (idProfession == 1)
		{
			this.puissance = PUISSANCEGLADIATEUR;
			this.defense = DEFENSEGLADIATEUR;
			this.pointsDeVie = POINTDEVIEGLADIATEUR;
			this.pointsDeMouvement = POINTDEMOUVEMENTGLADIATEUR;
		}
		else if (idProfession == 2)
		{
			this.puissance = PUISSANCETEMPLIER;
			this.defense = DEFENSETEMPLIER;
			this.pointsDeVie = POINTDEVIETEMPLIER;
			this.pointsDeMouvement = POINTDEMOUVEMENTTEMPLIER;
		}

		else if (idProfession == 3)
		{
			this.puissance = PUISSANCERODEUR;
			this.defense = DEFENSERODEUR;
			this.pointsDeVie = POINTDEVIERODEUR;
			this.pointsDeMouvement = POINTDEMOUVEMENTRODEUR;
		}

		else
		{
			this.puissance = PUISSANCESORCIER;
			this.defense = DEFENSESORCIER;
			this.pointsDeVie = POINTDEVIESORCIER;
			this.pointsDeMouvement = POINTDEMOUVEMENTSORCIER;
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

	// FIXME (FIXED) redéfinir toString
	
}
