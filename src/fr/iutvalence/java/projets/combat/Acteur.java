
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
	// FIXME (NOT FIXED) respecter les conventions d'écriture
	private final static int POINTACTIONDEFAUT = 5;

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
		this.pointDActionActuels = POINTACTIONDEFAUT;
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

}
