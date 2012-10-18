// FIXME renommer le paquetage (fr.iutvalence.java.projets.(nom))
package fr.iutvalence.java.projets.combat;


/**
 * On retrouve toutes les stats d'un acteur (utilisation: calcul des degats, PM, PV )
 * @author colasr
 *
 */
// FIXME réfléchir à utiliser l'héritage pour différencier les personnages et se passer de Stats

// FIXME écrire un commentaire
public class Stats
{
	
    /**
     * Puissance de base du Gladiateur 
     */	
    //Stats pour le gladiateur
	// FIXME écrire un commentaire
	// FIXME si c'est une constante, la définir comme telle
    private final static int puissanceGladiateur=8;
    
    /**
     * Defence de base  du Gladiateur 
     */
	// FIXME écrire un commentaire
	// FIXME si c'est une constante, la définir comme telle
    private final static int defenseGladiateur=5;

    /**
     * Point de vie de base du Gladiateur
     */
	// FIXME écrire un commentaire
	// FIXME si c'est une constante, la définir comme telle
    private final static int pointDeVieGladiateur=45;
   
    /**
     * Point de mouvement de base du Gladiateur
     */
	// FIXME écrire un commentaire
	// FIXME si c'est une constante, la définir comme telle
    private final static int pointDeMouvementGladiateur=4;
    
    /**
     * Puissance du de base du templier
     */	
    // Stats pour le templier
	// FIXME écrire un commentaire
	// FIXME si c'est une constante, la définir comme telle
    private final static int puissanceTemplier=7;

    /**
     * Defence de base du templier
     */
	// FIXME écrire un commentaire
	// FIXME si c'est une constante, la définir comme telle
    private final static int defenseTemplier=6;

    /**
     * Point de vie de base du templier
     */
	// FIXME écrire un commentaire
	// FIXME si c'est une constante, la définir comme telle
    private final static int pointDeVieTemplier=50;

    /**
     * Point de mouvement de base du templier
     */
	// FIXME écrire un commentaire
	// FIXME si c'est une constante, la définir comme telle
    private final static int pointDeMouvementTemplier=4;
    
    /**
     * Puissance du de base du rodeur
     */	
    //Stats pour le rodeur
	// FIXME écrire un commentaire
	// FIXME si c'est une constante, la définir comme telle
    private final static int puissanceRodeur=8;

    /**
     * Defence de base du rodeur
     */
	// FIXME écrire un commentaire
	// FIXME si c'est une constante, la définir comme telle
    private final static int defenseRodeur=4;
    /**
     * Point de vie de base du rodeur
     */
    
	// FIXME écrire un commentaire
	// FIXME si c'est une constante, la définir comme telle
    private final static int pointDeVieRodeur=40;

    /**
     * Point de mouvement de base du rodeur
     */
	// FIXME écrire un commentaire
	// FIXME si c'est une constante, la définir comme telle
    private final static int pointDeMouvementRodeur=3;
    
    /**
     * Puissance du de base  du sorcier
     */	
    //Stats pour le sorcier
	// FIXME écrire un commentaire
	// FIXME si c'est une constante, la définir comme telle
    private final static int puissanceSorcier=8;
   
    /**
     * Defence de base du sorcier
     */    
	// FIXME écrire un commentaire
	// FIXME si c'est une constante, la définir comme telle
    private final static int defenseSorcier=4;

    /**
     * Point de vie de base du sorcier
     */    
	// FIXME écrire un commentaire
	// FIXME si c'est une constante, la définir comme telle
    private final static int pointDeVieSorcier=40;

    /**
     * Point de mouvement de base du sorcier
     */
	// FIXME écrire un commentaire
	// FIXME si c'est une constante, la définir comme telle
    private final static int pointDeMouvementSorcier=4;
    
    
    
    // FIXME détailler le commentaire
	/**
	 * puissance
	 */
	private final int puissance;

    // FIXME détailler le commentaire
	/**
	 * defense
	 */
	private final int defense;
	
	/**
	 * points de vie
	 */
	// FIXME renommer l'attribut
	private final int pointDeVie;
	
	/**
	 * points de mouvement
	 */
	// FIXME renommer l'attribut
	private final int pointDeMouvement;
	
	/**
	 * Cree une liste de stat entre en param
	 * @param puissance
	 * @param defense
	 * @param pointDeVie
	 * @param pointDeMouvement
	 */
    // FIXME écrire un commentaire
	public Stats (int puissance, int defense, int pointDeVie, int pointDeMouvement)
	{
	    this.puissance = puissance;
	    this.defense = defense;
	    this.pointDeVie = pointDeVie;
	    this.pointDeMouvement = pointDeMouvement;  
	}
	
	
	/**
	 * Cree les stats en fonction de la profession (seulement pour un personnage joueur)
	 * @param idProfession
	 */
    // FIXME écrire un commentaire
	public Stats (byte  idProfession)
	{
	    
		if (idProfession == 1)
		{
		     this.puissance = puissanceGladiateur;
		     this.defense = defenseGladiateur;
		     this.pointDeVie = pointDeVieGladiateur;
		     this.pointDeMouvement = pointDeMouvementGladiateur;
		}
		else if (idProfession == 2)
		{
		    this.puissance = puissanceTemplier;
		    this.defense = defenseTemplier;
		    this.pointDeVie = pointDeVieTemplier;
		    this.pointDeMouvement = pointDeMouvementTemplier;
		}
		
		else if (idProfession == 3)
		{		     
		    this.puissance = puissanceRodeur;
		    this.defense = defenseRodeur;
		    this.pointDeVie = pointDeVieRodeur;
		    this.pointDeMouvement = pointDeMouvementRodeur;		
		}
		
		else
		{
		    this.puissance = puissanceSorcier;
		    this.defense = defenseSorcier;
		    this.pointDeVie = pointDeVieSorcier;
		    this.pointDeMouvement = pointDeMouvementSorcier;
		}
	}
	
	/**
	 * @return puissance
	 */
    // FIXME écrire un commentaire
	public int getPuissance()
	{
	    return this.puissance;
	}

	/**
	 * @return defense
	 */
    // FIXME écrire un commentaire
	public int getDefense()
	{
	    return this.defense;
	}

	/**
	 * @return nombre de point de vie
	 */
    // FIXME écrire un commentaire
	// FIXME renommer la méthode
	public int getPointDeVie()
	{
	    return this.pointDeVie;
	}

	/**
	 * @return nombre de point de mouvement
	 */
    // FIXME écrire un commentaire
	// FIXME renommer la méthode
	public int getPointDeMouvement()
	{
	    return this.pointDeMouvement;
	}
	
	// FIXME redéfinir toString
}
