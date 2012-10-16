package combat;


/**
 * On retrouve toutes les stats d'un acteur (utilisation: calcul des degats, PM, PV )
 * @author colasr
 *
 */
public class Stats
{
	
    /**
     * Puissance de base du Gladiateur 
     */	
    private final static int puissanceGladiateur=8;
    /**
     * Defence de base  du Gladiateur 
     */
    private final static int defenseGladiateur=5;
    /**
     * Point de vie de base du Gladiateur
     */
    private final static int pointDeVieGladiateur=45;
    /**
     * Point de mouvement de base du Gladiateur
     */
    private final static int pointDeMouvementGladiateur=4;
    
    /**
     * Puissance du de base du templier
     */	
    private final static int puissanceTemplier=7;
    /**
     * Defence de base du templier
     */
    private final static int defenseTemplier=6;
    /**
     * Point de vie de base du templier
     */
    private final static int pointDeVieTemplier=50;
    /**
     * Point de mouvement de base du templier
     */
    private final static int pointDeMouvementTemplier=4;
    
    /**
     * Puissance du de base du rodeur
     */	
    private final static int puissanceRodeur=8;
    /**
     * Defence de base du rodeur
     */
    private final static int defenseRodeur=4;
    /**
     * Point de vie de base du rodeur
     */
    private final static int pointDeVieRodeur=40;
    /**
     * Point de mouvement de base du rodeur
     */
    private final static int pointDeMouvementRodeur=3;
    
    /**
     * Puissance du de base  du sorcier
     */	
    private final static int puissanceSorcier=8;
    /**
     * Defence de base du sorcier
     */
    private final static int defenseSorcier=4;
    /**
     * Point de vie de base du sorcier
     */
    private final static int pointDeVieSorcier=40;
    /**
     * Point de mouvement de base du sorcier
     */
    private final static int pointDeMouvementSorcier=4;
    
    
	/**
	 * puissance
	 */
	private final int puissance;

	/**
	 * defense
	 */
	private final int defense;
	
	/**
	 * points de vie
	 */
	private final int pointDeVie;
	
	/**
	 * points de mouvement
	 */
	private final int pointDeMouvement;
	
	/**
	 * Cree une liste de stat entre en param
	 * @param puissance
	 * @param defense
	 * @param pointDeVie
	 * @param pointDeMouvement
	 */
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
	public int getPuissance()
	{
	    return this.puissance;
	}

	/**
	 * @return defense
	 */
	public int getDefense()
	{
	    return this.defense;
	}

	/**
	 * @return nombre de point de vie
	 */
	public int getPointDeVie()
	{
	    return this.pointDeVie;
	}

	/**
	 * @return nombre de point de mouvement
	 */
	public int getPointDeMouvement()
	{
	    return this.pointDeMouvement;
	}
}
