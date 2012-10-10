
public class Stats {
    //Stats pour le gladiateur
    int puissanceGladiateur=8;
    int defenseGladiateur=5;
    int pointDeVieGladiateur=45;
    int pointDeMouvementGladiateur=4;
    
    // Stats pour le templier
    int puissanceTemplier=7;
    int defenseTemplier=6;
    int pointDeVieTemplier=50;
    int pointDeMouvementTemplier=4;
    
    //Stats pour le Rodeur
    int puissanceRodeur=8;
    int defenseRodeur=4;
    int pointDeVieRodeur=40;
    int pointDeMouvementRodeur=3;
    
    //Stats pour Sorcier
    int puissanceSorcier=8;
    int defenseSorcier=4;
    int pointDeVieSorcier=40;
    int pointDeMouvementSorcier=4;
    
	/**
	 * puissance
	 */
	private int puissance;

	/**
	 * defense
	 */
	private int defense;
	
	/**
	 * points de vie
	 */
	private int pointDeVie;
	
	/**
	 * points de mouvement
	 */
	private int pointDeMouvement;
	
	public Stats (int puissance, int defense, int pointDeVie, int pointDeMouvement)
	{
	    this.puissance = puissance;
	    this.defense = defense;
	    this.pointDeVie = pointDeVie;
	    this.pointDeMouvement = pointDeMouvement;  
	}
	
	
	public Stats (byte  idProfession) {
	    
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
	
	public int getPuissance() {
	    return puissance;
	}

	public int getDefense() {
	    return defense;
	}

	public int getPointDeVie() {
	    return pointDeVie;
	}

	public int getPointDeMouvement() {
	    return pointDeMouvement;
	}

	

	public void setPuissance(int puissance) {
	    this.puissance = puissance;
	}

	public void setDefense(int defense) {
	    this.defense = defense;
	}

	public void setPointDeVie(int pointDeVie) {
	    this.pointDeVie = pointDeVie;
	}

	public void setPointDeMouvement(int pointDeMouvement) {
	    this.pointDeMouvement = pointDeMouvement;
	}

	

}
