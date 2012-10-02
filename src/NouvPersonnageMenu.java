/**
 * @author colasr
 * Classe de création du personnage Hors-combat (menu)
 */
public class nouvPersonnageMenu extends statsProfession
{

	/**
	 * nom du personnage
	 */
	private final String nom;
	
	
	/**
	 * classe du personnage
	 */
	private final statsProfession profession;
	
	/**
	 * experience du personnage (si egal ou sup à 4*niveau, UP)
	 */
	private int experience;
	
	/**
	 * niveau du personnage (determine l'xp max qui est niveau*4)
	 */
	private int niveau;
	
	/**
	 * argent du personnage
	 */
	private int argent;
	
	/**
	 * nombre de victoires
	 */
	private int nb_victoire;
	
	/**
	 * nombre de defaites
	 */
	private int nb_defaite;
	
	/**
	 * points d'action du personnage
	 */
	private final int pa = 5;
	
	
	/**
	 * crée un nouveau personnage de niveau 1 + crée l'objet statsProfession correspondant
	 * @param nom
	 * @param nom_profession
	 */
	public nouvPersonnageMenu(String nom, String nom_profession)
	{
		super(nom_profession);
		this.nom = nom;
		this.profession_perso = new statsProfession(nom_profession);
		this.experience = 0;
		this.niveau = 1;
		this.argent = 50;
		this.nb_victoire = 0;
		this.nb_defaite = 0;
	}
}
