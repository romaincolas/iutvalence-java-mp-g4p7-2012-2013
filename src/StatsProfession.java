// FIXME déplacer dans un paquetage

/**
 * Stats de base de chaque Profession
 * @author colasr
 */
public class StatsProfession
{
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
	 * idProfession de la profession
	 */
	private final byte idProfession;
	
	/**
	 * puissance de base
	 */
	private Stats stats;

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
		    this.stats = new Stats(puissanceGladiateur, defenseGladiateur, pointDeVieGladiateur, pointDeMouvementGladiateur);
		}
		else if (idProfession == 2)
		{
		    this.stats = new Stats(puissanceTemplier, defenseTemplier, pointDeVieTemplier, pointDeMouvementTemplier);
		}
		else if (idProfession == 3)
		{
		    this.stats = new Stats(puissanceRodeur, defenseRodeur, pointDeVieRodeur, pointDeMouvementRodeur);
		}
		else
		{
		    this.stats = new Stats(puissanceSorcier, defenseSorcier, pointDeVieSorcier, pointDeMouvementSorcier);
		}
		
		
	}

	//Obtenir une valeur
	public byte getIdProfession() {
	    return idProfession;
	}

	public int getPuissance() {
	    return stats.getPuissance();
	}

	public int getDefense() {
	    return stats.getDefense();
	}

	public int getPointDeVie() {
	    return stats.getPointsDeVie();
	}

	public int getPointDeMouvement() {
	    return stats.getPointsDeMouvement();
	}
	
	
}
