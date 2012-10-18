// FIXME déplacer dans un paquetage

// FIXME détailler le commentaire
/**
 * Classe de création du personnage Hors-combat (menu)
 * @author colasr
 */
// FIXME justifier ou renommer cette classe
public class NouvPersonnageMenu
{
	
	// FIXME écrire un commentaire
	// FIXME s'il s'agit d'une constante, la définir comme telle
    String gladiateur = "Gladiateur";

	// FIXME écrire un commentaire
	// FIXME s'il s'agit d'une constante, la définir comme telle
    String templier = "Templier";
    
	// FIXME écrire un commentaire
	// FIXME s'il s'agit d'une constante, la définir comme telle
    String rodeur = "Rôdeur"; 
    
	// FIXME écrire un commentaire
	// FIXME s'il s'agit d'une constante, la définir comme telle
    String sorcier="Sorcier";
    
	/**
	 * nom du personnage
	 */
	private final String nom;


	// FIXME utiliser le type int et définir des constantes dans une classe "Profession"
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
	// FIXME renommer l'attribut
	private int nbVictoire;
	
	/**
	 * nombre de defaites
	 */
	// FIXME renommer l'attribut
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

	// FIXME écrire un commentaire
	public String getNomPersonnage() {
	    return nom;
	}

	// FIXME écrire un commentaire
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

	// FIXME écrire un commentaire
	public byte getProfession() {
	    return profession;
	}

	// FIXME écrire un commentaire
	public int getExperience() {
	    return experience;
	}

	// FIXME écrire un commentaire
	public int getNiveau() {
	    return niveau;
	}

	// FIXME écrire un commentaire
	public int getArgent() {
	    return argent;
	}

	// FIXME écrire un commentaire
	// FIXME renommer la méthode
	public int getNbVictoire() {
	    return nbVictoire;
	}

	// FIXME écrire un commentaire
	// FIXME renommer la méthode
	public int getNbDefaite() {
	    return nbDefaite;
	}

	// FIXME écrire un commentaire
	public void setExperience(int experience) {
	    this.experience = experience;
	}

	// FIXME écrire un commentaire
	public void setNiveau(int niveau) {
	    this.niveau = niveau;
	}

	// FIXME écrire un commentaire
	public void setArgent(int argent) {
	    this.argent = argent;
	}

	// FIXME écrire un commentaire
	// FIXME renommer la méthode
	public void setNbVictoire(int nbVictoire) {
	    this.nbVictoire = nbVictoire;
	}

	// FIXME écrire un commentaire
	// FIXME renommer la méthode
	public void setNbDefaite(int nbDefaite) {
	    this.nbDefaite = nbDefaite;
	}

	
	
}
