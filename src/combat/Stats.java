// FIXME renommer le paquetage (fr.iutvalence.java.projets.(nom))
package combat;


// FIXME réfléchir à utiliser l'héritage pour différencier les personnages et se passer de Stats

// FIXME écrire un commentaire
public class Stats
{
    //Stats pour le gladiateur
	
	// FIXME écrire un commentaire
	// FIXME si c'est une constante, la définir comme telle
    private final static int puissanceGladiateur=8;

	// FIXME écrire un commentaire
	// FIXME si c'est une constante, la définir comme telle
    private final static int defenseGladiateur=5;

	// FIXME écrire un commentaire
	// FIXME si c'est une constante, la définir comme telle
    private final static int pointDeVieGladiateur=45;
    
	// FIXME écrire un commentaire
	// FIXME si c'est une constante, la définir comme telle
    private final static int pointDeMouvementGladiateur=4;
    
    // Stats pour le templier
	// FIXME écrire un commentaire
	// FIXME si c'est une constante, la définir comme telle
    private final static int puissanceTemplier=7;
    
	// FIXME écrire un commentaire
	// FIXME si c'est une constante, la définir comme telle
    private final static int defenseTemplier=6;
    
	// FIXME écrire un commentaire
	// FIXME si c'est une constante, la définir comme telle
    private final static int pointDeVieTemplier=50;
    
	// FIXME écrire un commentaire
	// FIXME si c'est une constante, la définir comme telle
    private final static int pointDeMouvementTemplier=4;
    
    //Stats pour le rodeur
	// FIXME écrire un commentaire
	// FIXME si c'est une constante, la définir comme telle
    private final static int puissanceRodeur=8;
    
	// FIXME écrire un commentaire
	// FIXME si c'est une constante, la définir comme telle
    private final static int defenseRodeur=4;
    
	// FIXME écrire un commentaire
	// FIXME si c'est une constante, la définir comme telle
    private final static int pointDeVieRodeur=40;
    
	// FIXME écrire un commentaire
	// FIXME si c'est une constante, la définir comme telle
    private final static int pointDeMouvementRodeur=3;
    
    //Stats pour le sorcier
	// FIXME écrire un commentaire
	// FIXME si c'est une constante, la définir comme telle
    private final static int puissanceSorcier=8;
    
	// FIXME écrire un commentaire
	// FIXME si c'est une constante, la définir comme telle
    private final static int defenseSorcier=4;
    
	// FIXME écrire un commentaire
	// FIXME si c'est une constante, la définir comme telle
    private final static int pointDeVieSorcier=40;
    
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
	
    // FIXME écrire un commentaire
	public Stats (int puissance, int defense, int pointDeVie, int pointDeMouvement)
	{
	    this.puissance = puissance;
	    this.defense = defense;
	    this.pointDeVie = pointDeVie;
	    this.pointDeMouvement = pointDeMouvement;  
	}
	
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
	
    // FIXME écrire un commentaire
	public int getPuissance()
	{
	    return puissance;
	}

    // FIXME écrire un commentaire
	public int getDefense()
	{
	    return defense;
	}

    // FIXME écrire un commentaire
	// FIXME renommer la méthode
	public int getPointDeVie()
	{
	    return pointDeVie;
	}

    // FIXME écrire un commentaire
	// FIXME renommer la méthode
	public int getPointDeMouvement()
	{
	    return pointDeMouvement;
	}
	
	// FIXME redéfinir toString
}
