
/**
 * @author colasr
 * determine l'equipement total sur le perso
 */
public class EquipementPerso extends PieceEquipement
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
}
