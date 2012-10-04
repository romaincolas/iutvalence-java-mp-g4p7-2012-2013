// FIXME déplacer dans un paquetage

/**
 * Stats de base de chaque Profession
 * @author colasr
 */
public class StatsProfession
{
    //Stats pour le gladiateur
    String gladiateur = "Gladiateur";
    int puissanceGladiateur=8;
    int defenseGladiateur=5;
    int pointDeVieGladiateur=45;
    int pointDeMouvementGladiateur=4;
    
    // Stats pour le templier
    String templier = "Templier";
    int puissanceTemplier=7;
    int defenseTemplier=6;
    int pointDeVieTemplier=50;
    int pointDeMouvementTemplier=4;
    
    //Stats pour le Rodeur
    String rodeur = "Rôdeur";
    int puissanceRodeur=8;
    int defenseRodeur=4;
    int pointDeVieRodeur=40;
    int pointDeMouvementRodeur=3;
    
    //Stats pour Sorcier
    String sorcier="Sorcier";
    int puissanceSorcier=8;
    int defenseSorcier=4;
    int pointDeVieSorcier=40;
    int pointDeMouvementSorcier=4;
    
	/**
	 * idProfession de la profession
	 */
	private final byte idProfession;
	
	/**
	 * puissance de base
	 */
	private int puissance;

	/**
	 * defense de base
	 */
	private int defense;
	
	/**
	 * Pv de base
	 */
	private int pv;
	
	/**
	 * Pm de base
	 */
	private int pm;

	/**
	 * Fixe les stats de base du perso pour la profession choisie
	 * @param idProfession
	 */

	public StatsProfession(byte idProfession)
	{
		super();
		this.idProfession = idProfession;
		if (idProfession == 1)
		{
			this.puissance = puissanceGladiateur;
			this.defense = defenseGladiateur;
			this.pv = pointDeVieGladiateur;
			this.pm = pointDeMouvementGladiateur;
		}
		else if (idProfession == 2)
		{
			this.puissance = puissanceTemplier;
			this.defense = defenseTemplier;
			this.pv = pointDeVieTemplier;
			this.pm = pointDeMouvementTemplier;
		}
		else if (idProfession == 3)
		{
			this.puissance = puissanceRodeur;
			this.defense = defenseRodeur;
			this.pv = pointDeVieRodeur;
			this.pm = pointDeMouvementRodeur;
		}
		else
		{
			this.puissance = puissanceSorcier;
			this.defense = defenseSorcier;
			this.pv = pointDeVieSorcier;
			this.pm = pointDeMouvementSorcier;
		}
		
		
		// FIXME méthodes ?
	}

	//Obtenir une valeur
	public byte getIdProfession() {
	    return idProfession;
	}

	public int getPuissance() {
	    return puissance;
	}

	public int getDefense() {
	    return defense;
	}

	public int getPv() {
	    return pv;
	}

	public int getPm() {
	    return pm;
	}

	
	// Changement de valeur
	public void setPuissance(int puissance) {
	    this.puissance = puissance;
	}

	public void setDefense(int defense) {
	    this.defense = defense;
	}

	public void setPv(int pv) {
	    this.pv = pv;
	}

	public void setPm(int pm) {
	    this.pm = pm;
	}
	
	
	
}
