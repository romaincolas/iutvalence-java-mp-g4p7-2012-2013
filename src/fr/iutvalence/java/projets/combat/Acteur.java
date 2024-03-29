
package fr.iutvalence.java.projets.combat;

/**
 * classe permettant de gerer le personnage en combat (actualisation des stats avec l'equipement ( dans le menu, les
 * statistiques sont celles de base, en combat, on rajoute les bonus de defense et de puissance), coordonées du
 * personnage (permettra de gerer sa position et la distance d'action de ses competences), ses competences (permet de
 * poutrer le monstre)
 * 
 * @author colasr
 */
public class Acteur
{

	/**
	 * points d'action par defaut de tout les acteurs
	 */
	// (FIXED)FIXME (toujours pas !) respecter les conventions d'écriture
	private final static int POINT_ACTION_DEFAUT = 5;

	/**
	 * nom du personnage
	 */
	private final String nom;

	/**
	 * Toutes les stats du personnage
	 */
	private final Stats stats;

	/**
	 * position de l'acteur sur la carte
	 */
	private Coordonnees position;

	
	/**
	 * Nombre de point de vie actuels de l'acteur
	 */
	private int pointDeVieActuels;
	
	/**
	 * nombre de points d'action actuels (lors du tour, réinitialisé a 5 lors de la fin du tour)
	 */
	private int pointDActionActuels;

	/**
	 * nombre de points de mouvement actuels (lors du tour, réinitialisé aux points de mouvement de base de l'acteur
	 * lors de la fin du tour)
	 */
	private int pointDeMouvementActuels;

	/**
	 * numero de l'acteur (correspondant aux localisation de base sur une carte (2 pour un personnage, 3 et plus pour
	 * les differents monstres)
	 */
	private final int numActeur;

	/**
	 * Crée un acteur avec toutes les info utile pour un combat (ses coordonées sur la carte, ses statistiques, son
	 * numero d'acteur lui permettant d'etre identifié)
	 * 
	 * @param nom
	 *            (le nom de l'acteur)
	 * @param stats
	 *            (les statistiques de l'acteur)
	 * @param position
	 *            (la position de l'acteur sur la carte)
	 * @param numActeur
	 *            (le numero de l'acteur lui permettant d'etre identifié)
	 */
	public Acteur(String nom, Stats stats, Coordonnees position, int numActeur)
	{
		this.nom = nom;
		this.stats = stats;
		this.position = position;
		this.pointDeVieActuels = stats.getPointsDeVie(); 
		this.pointDActionActuels = POINT_ACTION_DEFAUT;
		this.pointDeMouvementActuels = stats.getPointsDeMouvement();
		this.numActeur = numActeur;
	}

	
	/**
	 * donne le nom de l'acteur
	 * 
	 * @return le nom de l'acteur
	 */
	public String getNom()
	{
		return this.nom;
	}

	/**
	 * retourne les statistiques de l'acteur (puissance / defense / ...)
	 * 
	 * @return l'objet stats avec toutes les stats de l'acteur
	 */
	public Stats getStats()
	{
		return this.stats;
	}

	/**
	 * donne la position actuelle de l'acteur sur la carte
	 * 
	 * @return la position actuelle de l'acteur
	 */
	public Coordonnees getPosition()
	{
		return this.position;
	}
	
	
	
	/**
	 * Pour obtenir le nombre de point de vie de l'acteur
	 * @return pointDeVieActuels
	 */
	public int getPointDeVieActuels()
	{
		return this.pointDeVieActuels;
	}

	/**
	 * pour obtenir le nombre  de point d'action du tour
	 * @return pointDActionActuels
	 */
	public int getPointDActionActuels()
	{
		return this.pointDActionActuels;
	}

	/**
	 * nombre de point de mouvement restant pour le tour
	 * @return pointDeMouvementActuels
	 */
	public int getPointDeMouvementActuels()
	{
		return this.pointDeMouvementActuels;
	}


	/**
	 * donne le numero de l'acteur 2=personnage,3+=les monstres
	 * @return le numero de l'acteur
	 */
	public int getNumActeur()
	{
		return this.numActeur;
	}
	
	
	
	/**
	 * Change la position
	 * @param position position a mettre pour l acteur
	 */
	public void setPosition(Coordonnees position)
	{
		this.position = position;
	}

	// (FIXED)FIXME completer
	/**
	 * Change le nombre de point de vie de l'acteur
	 * @param pointDeVieActuels the pointDeVieActuels to set
	 */
	public void setPointDeVieActuels(int pointDeVieActuels)
	{
		this.pointDeVieActuels = pointDeVieActuels;
	}

	// (FIXED) FIXME completer
	/**
	 * Change le nombre de point d action actuels de l acteur
	 * @param pointDActionActuels the pointDActionActuels to set
	 */
	public void setPointDActionActuels(int pointDActionActuels)
	{
		this.pointDActionActuels = pointDActionActuels;
	}

	// (FIXED) FIXME completer
	/**
	 * Change le nombre de point de mouvement actuels de l acteur
	 * @param pointDeMouvementActuels the pointDeMouvementActuels to set
	 */
	public void setPointDeMouvementActuels(int pointDeMouvementActuels)
	{
		this.pointDeMouvementActuels = pointDeMouvementActuels;
	}
}
