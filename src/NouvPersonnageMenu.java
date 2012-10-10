// FIXME déplacer dans un paquetage

// FIXME détailler le commentaire
// FIXME me justifier l'extension de la class statsProfession
/**
 * Classe de création du personnage Hors-combat (menu)
 * @author colasr
 */
public class NouvPersonnageMenu
{
    String gladiateur = "Gladiateur";
    String templier = "Templier";
    String rodeur = "Rôdeur"; 
    String sorcier="Sorcier";
	/**
	 * nom du personnage
	 */
	private final String nom;


	/**
	 * id de la profession ( 1=Gladiateur/2=Templier/3=Rodeur/4=Sorcier )
	 */
	private final byte profession;
	
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
	 * crée un nouveau personnage de niveau 1 + lui assigne des statistiques de base en fonction de 
	 * sa profession.
	 * @param nom (le nom du personnage)
	 * @param Profession (la profession 1=Gladiateur/2=Templier/3=Rodeur/4=Sorcier)
	 */
	public NouvPersonnageMenu(String nom, byte profession)
	{
		this.nom = nom;
		this.profession = profession;
		this.experience = 0;
		this.niveau = 1;
		this.argent = 50;
		this.nbVictoire = 0;
		this.nbDefaite = 0;
	}

	public String getNomPersonnage() {
	    return nom;
	}
	
	public String getNomProfession() {
	    if (getProfession() == 1){
		return gladiateur;
	    }
	    
	    else if (getProfession() == 2){
		return templier;
	    }
	    
	    else if (getProfession() == 3){
		return rodeur;
	    }
	    
	    else {
		return sorcier;
	    }
	}

	public byte getProfession() {
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
