// FIXME déplacer dans un paquetage

/**
 * classe permettant de gerer le personnage en combat (actualisation des stats avec l'equipement (
 * dans le menu, les statistiques sont celles de base, en combat, on rajoute les bonus de defense et 
 * de puissance), coordonées du personnage (permettra de gerer sa position et la distance d'action de ses 
 * competences), ses competences (permet de poutrer le monstre)
 * @author colasr
 */
public class PersonnageEnCombat
{
	/**
	 * nom du personnage
	 */
	private final String nom;

	
	/**
	 * id de la profession ( 1=Gladiateur/2=Templier/3=Rodeur/4=Sorcier )
	 */
	private final byte idProfession;
	
	/**
	 * Toutes les stats du personnage
	 */
	private final Stats stats;
	
	private Coordonees coordonees;
	
	private final Competences[] competences;
	
	
	/**
	 * Crée un personnage avec toutes les info utile pour un combat 
	 * @param nom
	 * @param idProfession
	 * @param  stats
	 * @param coordonees
	 */	
	public PersonnageEnCombat (String nom, byte idProfession, Coordonees coordonees, Competences[] competences) {
	    this.nom = nom;
	    this.idProfession  = idProfession;
	    this.stats = new Stats(idProfession);
	    this.coordonees = coordonees;
	    this.competences=competences;
	}

	/**
	 * donne le nom du personnage
	 */	
	public String getNom() {
	    return nom;
	}
	
	/**
	 * donne l'id de la profession ( 1=Gladiateur/2=Templier/3=Rodeur/4=Sorcier )
	 */
	public byte getIdProfession() {
	    return idProfession;
	}

	/**
	 * donne l'objet stats avec toutes les stats du perso
	 */
	public Stats getStats() {
	    return stats;
	}

	/**
	 * donne  les coordonees actuel du personnage dans un objet Coordonees
	 */
	public Coordonees getCoordonees() {
	    return coordonees;
	}
	
	public Competences[] getCompetences() {
		return competences;
	}

	/**
	 * ajout x à la position actuel du personnage 
	 */
	public void changePosX(int x) {
		this.coordonees.changePosX(x);
	}

	/**
	 * ajout x à la position actuel du personnage 
	 */
	public void changePosY(int y) {
		this.coordonees.changePosY(y);
	}
	
	/**
	 * positionne le perso à de nouvelles coordonees
	 */
	public void setCoordonees(Coordonees coordonees) {
	    this.coordonees = coordonees;
	}



}
