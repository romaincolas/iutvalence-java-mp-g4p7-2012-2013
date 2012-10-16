// FIXME renommer le paquetage

/**
 * classe permettant la gestion de l'equipement équipé sur le personnage
 * @author colasr
 */
public class EquipementPerso
{
	/**
	 * attribut correspondant au casque équipé
	 */
	private PieceEquipement casque;
	
	/**
	 * attribut correspondant aux gants équipés
	 */
	private PieceEquipement gants;
	
	/**
	 * attribut correspondant au plastron équipé
	 */
	private PieceEquipement plastron;
	
	/**
	 * attribut correspondant aux jambieres équipées
	 */
	private PieceEquipement jambieres;
	
	/**
	 * attribut correspondant aux bottes équipées
	 */
	private PieceEquipement bottes;
	

	/**
	 * crée l'objet equipementPerso avec les 5 pieces d'equipement
	 * @param casque
	 * @param gants
	 * @param plastron
	 * @param jambieres
	 * @param bottes
	 */
	public EquipementPerso(PieceEquipement casque, PieceEquipement gants, PieceEquipement plastron,
			PieceEquipement jambieres, PieceEquipement bottes)
	{
		super();
		this.casque = casque;
		this.gants = gants;
		this.plastron = plastron;
		this.jambieres = jambieres;
		this.bottes = bottes;
	}

	/**
	 * @return les stats du casque equipe sur le personnage
	 */
	public PieceEquipement getCasque()
	{
		return casque;
	}

	/**
	 * @return les stats des gants equipe sur le personnage
	 */
	public PieceEquipement getGants()
	{
		return gants;
	}

	/**
	 * @return les stats du plastron equipe sur le personnage
	 */
	public PieceEquipement getPlastron()
	{
		return plastron;
	}

	/**
	 * @return les stats des jambieres equipees sur le personnage
	 */
	public PieceEquipement getJambieres()
	{
		return jambieres;
	}

	/**
	 * @return les stats des bottes equipe sur le personnage
	 */
	public PieceEquipement getBottes()
	{
		return bottes;
	}

	/**
	 * @param casque (le casque a équiper)
	 */
	public void setCasque(PieceEquipement casque)
	{
		this.casque = casque;
	}

	/**
	 * @param gants (les gants a équiper)
	 */
	public void setGants(PieceEquipement gants)
	{
		this.gants = gants;
	}

	/**
	 * @param plastron (le plastron a équiper)
	 */
	public void setPlastron(PieceEquipement plastron)
	{
		this.plastron = plastron;
	}

	/**
	 * @param jambieres (les jambieres a équiper)
	 */
	public void setJambieres(PieceEquipement jambieres)
	{
		this.jambieres = jambieres;
	}

	/**
	 * @param bottes (les jambieres a équiper)
	 */
	public void setBottes(PieceEquipement bottes)
	{
		this.bottes = bottes;
	}
	
	
}
