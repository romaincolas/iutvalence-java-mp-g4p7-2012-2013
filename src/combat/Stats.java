package combat;


public class Stats
{
    //Stats pour le gladiateur
    private final static int puissanceGladiateur=8;
    private final static int defenseGladiateur=5;
    private final static int pointDeVieGladiateur=45;
    private final static int pointDeMouvementGladiateur=4;
    
    // Stats pour le templier
    private final static int puissanceTemplier=7;
    private final static int defenseTemplier=6;
    private final static int pointDeVieTemplier=50;
    private final static int pointDeMouvementTemplier=4;
    
    //Stats pour le rodeur
    private final static int puissanceRodeur=8;
    private final static int defenseRodeur=4;
    private final static int pointDeVieRodeur=40;
    private final static int pointDeMouvementRodeur=3;
    
    //Stats pour le sorcier
    private final static int puissanceSorcier=8;
    private final static int defenseSorcier=4;
    private final static int pointDeVieSorcier=40;
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
	
	public Stats (int puissance, int defense, int pointDeVie, int pointDeMouvement)
	{
	    this.puissance = puissance;
	    this.defense = defense;
	    this.pointDeVie = pointDeVie;
	    this.pointDeMouvement = pointDeMouvement;  
	}
	
	
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
	
	public int getPuissance()
	{
	    return puissance;
	}

	public int getDefense()
	{
	    return defense;
	}

	public int getPointDeVie()
	{
	    return pointDeVie;
	}

	public int getPointDeMouvement()
	{
	    return pointDeMouvement;
	}
}
