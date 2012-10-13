package combat;
/**
 * classe permettant de gerer le personnage en combat (actualisation des stats avec l'equipement (
 * dans le menu, les statistiques sont celles de base, en combat, on rajoute les bonus de defense et 
 * de puissance), coordonées du personnage (permettra de gerer sa position et la distance d'action de ses 
 * competences), ses competences (permet de poutrer le monstre)
 * @author colasr
 */
public class Acteur
{
	int pointDActionDefaut = 5;
	/**
	 * nom du personnage
	 */
	protected final String nom;
	
	/**
	 * Toutes les stats du personnage
	 */
	protected final Stats stats;
	
	protected Coordonees coordonees;
	
	protected int pointDAction;
	
	protected int pointDeMouvement;
	
	
	/**
	 * Crée un acteur avec toutes les info utile pour un combat 
	 * @param nom
	 * @param stats
	 * @param coordonees
	 */	
	public Acteur (String nom, Stats stats, Coordonees coordonees) {
	    this.nom = nom;
	    this.stats = stats;
	    this.coordonees = coordonees;
	    this.pointDAction= pointDActionDefaut;
	    this.pointDeMouvement= this.stats.getPointDeMouvement();

	}

	/**
	 * donne le nom de l'acteur
	 */	
	public String getNom() {
	    return nom;
	}

	/**
	 * donne l'objet stats avec toutes les stats de l'acteur
	 */
	public Stats getStats() {
	    return stats;
	}

	/**
	 * donne  les coordonees actuel de l'acteur dans un objet Coordonees
	 */
	public Coordonees getCoordonees() {
	    return coordonees;
	}

	/**
	 * ajout x à la position actuel del'acteur 
	 */
	public void changePosX(int x) {
		this.coordonees.changePosX(x);
	}

	/**
	 * ajout x à la position actuel de l'acteur 
	 */
	public void changePosY(int y) {
		this.coordonees.changePosY(y);
	}
	
	/**
	 * positionne l'acteur à de nouvelles coordonees
	 */
	public void setCoordonees(Coordonees coordonees) {
	    this.coordonees = coordonees;
	}



}
