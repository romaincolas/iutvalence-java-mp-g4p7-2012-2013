// FIXME renommer le paquetage (fr.iutvalence.java.projets.(nom))
package fr.iutvalence.java.projets.combat;



/**
 * classe permettant de gerer le personnage en combat (actualisation des stats avec l'equipement (
 * dans le menu, les statistiques sont celles de base, en combat, on rajoute les bonus de defense et 
 * de puissance), coordonées du personnage (permettra de gerer sa position et la distance d'action de ses 
 * competences), ses competences (permet de poutrer le monstre)
 * @author colasr
 */
public class Acteur
{
	
	/**
	 * points d'action par defaut de tout les acteurs
	 */
	// FIXME respecter les conventions d'écriture
	private final static int pointDActionDefaut = 5;
	
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
	private Coordonees coordonees;
	
	/**
	 * nombre de points d'action actuels (lors du tour, réinitialisé a 5 lors 
	 * de la fin du tour)
	 */
	// FIXME renommer l'attribut
	private int pointDAction;
	
	/**
	 * nombre de points de mouvement actuels (lors du tour, réinitialisé aux points de
	 * mouvement de base de l'acteur lors de la fin du tour)
	 */
	// FIXME renommer l'attribut
	private int pointDeMouvement;
	
	/**
	 * numero de l'acteur (correspondant aux localisation de base sur une carte (2 pour un 
	 * personnage, 3 et plus pour les differents monstres)
	 */
	private final int numActeur;
	
	// FIXME compléter le commentaire
	/**
	 * Crée un acteur avec toutes les info utile pour un combat 
	 * @param nom
	 * @param stats
	 * @param coordonees
	 * @param numActeur 
	 */	
	public Acteur (String nom, Stats stats, Coordonees coordonees, byte numActeur)
	{
	    this.nom = nom;
	    this.stats = stats;
	    this.coordonees = coordonees;
	    this.pointDAction = pointDActionDefaut;
	    this.pointDeMouvement = this.stats.getPointDeMouvement();
	    this.numActeur = numActeur;

	}

	// FIXME compléter le commentaire
	/**
	 * @return le nom de l'acteur
	 */	
	public String getNom()
	{
	    return this.nom;
	}

	// FIXME compléter le commentaire
	/**
	 * @return l'objet stats avec toutes les stats de l'acteur
	 */
	public Stats getStats()
	{
	    return this.stats;
	}

	// FIXME compléter le commentaire
	/**
	 * @return les coordonees actuel de l'acteur dans un objet Coordonees
	 */
	public Coordonees getCoordonees()
	{
	    return this.coordonees;
	}

	
	// FIXME cette méthode est inutile (cf. setCoordonnees)	
	// FIXME compléter le commentaire
	/**
	 * ajout x à la position actuel del'acteur 
	 * @param x (x a ajouter)
	 */
	public void changePosX(int x)
	{
		this.coordonees.changePosX(x);
	}

	// FIXME cette méthode est inutile (cf. setCoordonnees)
	// FIXME compléter le commentaire
	/**
	 * ajout y à la position actuel de l'acteur 
	 * @param y (y a ajouter)
	 */
	public void changePosY(int y)
	{
		this.coordonees.changePosY(y);
	}
	
	/**
	 * positionne l'acteur à de nouvelles coordonees
	 * @param coordonees
	 */
	// FIXME renommer la méthode
	public void setCoordonees(Coordonees coordonees)
	{
	    this.coordonees = coordonees;
	}
}
