// FIXME déplacer dans un paquetage

// FIXME détailler le commentaire
// FIXME me justifier l'extension de la class statsProfession
/**
 * @author colasr
 * Classe de création du personnage Hors-combat (menu)
 */
public class NouvPersonnageMenu extends StatsProfession
{
	/**
	 * nom du personnage
	 */
	private final String nom;
	
	
	/**
	 * @return the nom
	 */
	public String getNom()
	{
		return nom;
	}


	/**
	 * @return the profession
	 */
	public StatsProfession getProfession()
	{
		return profession;
	}


	/**
	 * classe du personnage
	 */
	private final StatsProfession profession;
	
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
	
	// FIXME respecter les conventions d'écriture
	/**
	 * nombre de victoires
	 */
	private int nbVictoire;
	
	// FIXME respecter les conventions d'écriture
	/**
	 * nombre de defaites
	 */
	private int nbDefaite;
	
	// FIXME initialisation de l'attribut dans le constructeur
	/**
	 * points d'action du personnage
	 */
	private final int pa = 5;
	
	// FIXME corriger le commentaire
	/**
	 * crée un nouveau personnage de niveau 1 + crée l'objet statsProfession correspondant
	 * @param nom
	 * @param nomProfession
	 */

	public NouvPersonnageMenu(String nom, String nomProfession)
	{
		// FIXME définir les valeurs par défaut sous forme de constantes
		super(nomProfession);
		this.nom = nom;
		this.profession = new StatsProfession(nomProfession);
		this.experience = 0;
		this.niveau = 1;
		this.argent = 50;
		this.nbVictoire = 0;
		this.nbDefaite = 0;
	}
}
