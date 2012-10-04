// FIXME déplacer dans un paquetage

// FIXME détailler le commentaire
// FIXME me justifier l'extension de la class statsProfession
/**
 * Classe de création du personnage Hors-combat (menu)
 * @author colasr
 */
public class NouvPersonnageMenu extends StatsProfession
{
	/**
	 * nom du personnage
	 */
	private final String nom;


	/**
	 * profession du personnage (StatsProfession contient toutes les stats de base de la 
	 * profession)
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
	
	/**
	 * nombre de victoires
	 */
	private int nbVictoire;
	
	/**
	 * nombre de defaites
	 */
	private int nbDefaite;
	
	/**
	 * points d'action du personnage
	 */
	private final int pa;
	
	/**
	 * crée un nouveau personnage de niveau 1 + lui assigne des statistiques de base en fonction de 
	 * sa profession.
	 * @param nom (le nom du personnage)
	 * @param Profession (la profession 1=Gladiateur/2=Templier/3=Rodeur/4=Sorcier)
	 */
	public NouvPersonnageMenu(String nom, byte Profession)
	{
		// FIXME définir les valeurs par défaut sous forme de constantes
		super(Profession);
		this.nom = nom;
		this.profession = new StatsProfession(Profession);
		this.experience = 0;
		this.niveau = 1;
		this.argent = 50;
		this.nbVictoire = 0;
		this.nbDefaite = 0;
		this.pa = 5;
	}

	public String getNomPersonnage() {
	    return nom;
	}
	
	public String getNomProfession() {
	    if (profession.getIdProfession() == 1){
		return gladiateur;
	    }
	    
	    else if (profession.getIdProfession() == 2){
		return templier;
	    }
	    
	    else if (profession.getIdProfession() == 3){
		return rodeur;
	    }
	    
	    else {
		return sorcier;
	    }
	}

	public StatsProfession getProfession() {
	    return profession;
	}

	public int getExperience() {
	    return experience;
	}

	public int getNiveau() {
	    return niveau;
	}

	public int getArgent() {
	    return argent;
	}

	public int getNbVictoire() {
	    return nbVictoire;
	}

	public int getNbDefaite() {
	    return nbDefaite;
	}

	public int getPa() {
	    return pa;
	}

	public void setExperience(int experience) {
	    this.experience = experience;
	}

	public void setNiveau(int niveau) {
	    this.niveau = niveau;
	}

	public void setArgent(int argent) {
	    this.argent = argent;
	}

	public void setNbVictoire(int nbVictoire) {
	    this.nbVictoire = nbVictoire;
	}

	public void setNbDefaite(int nbDefaite) {
	    this.nbDefaite = nbDefaite;
	}

	
	
}
