// FIXME déplacer dans un paquetage

/**
 * determine les bonus donnes par la piece d'equipement + nom + id (pour la recherche) + emplacement
 *  occupe par la piece d'equipement (tete, torse, botte, ...)
 * @author colasr
 */
public class PieceEquipement
{
	/**
	 *  nom de la piece d'equipement
	 */
	private final String nom;

	/**
	 * l'emplacement de la piece d'equipement sur le personnage
	 */
	private final byte type;

	/**
	 * bonus que donne la piece en puissance
	 */
	private final int bonusPuissance;

	/**
	 * bonus que donne la piece en defense
	 */
	private final int bonusDefense;

	/**
	 * bonus que donne la piece en PointsMouvement (1 sur certaines bottes, 0 sur le reste)
	 */
	private final int bonusPointsMouvement;

	/**
	 * @param nom (nom de la piece d'equipement)
	 * @param emplacement (l'emplacement de la piece d'equipement sur le personnage)
	 * @param idPiece (ID de la piece (pour la recherche))
	 * @param bonusPuissance (bonus que donne la piece en puissance)
	 * @param bonusDefense (bonus que donne la piece en defense)
	 * @param bonusPointsMouvement (bonus que donne la piece en PointsMouvement)
	 */
	public PieceEquipement(String nom, byte type, int bonusPuissance, int bonusDefense,
			int bonusPointsMouvement)
	{
		super();
		this.nom = nom;
		this.type = type;
		this.bonusPuissance = bonusPuissance;
		this.bonusDefense = bonusDefense;
		this.bonusPointsMouvement = bonusPointsMouvement;
	}

	/**
	 * @return le nom de la piece d'equipement
	 */
	public String getNom()
	{
		return nom;
	}

	/**
	 * @return l'emplacement occupé par la piece d'equipement
	 */
	public byte getType()
	{
		return type;
	}
	

	/**
	 * @return le bonus de puissance de la piece d'equipement
	 */
	public int getBonusPuissance()
	{
		return bonusPuissance;
	}

	/**
	 * @return le bonus de defense de la piece d'equipement
	 */
	public int getBonusDefense()
	{
		return bonusDefense;
	}

	/**
	 * @return le bonus de PointsMouvement de la piece d'equipement
	 */
	public int getBonusPointsMouvement()
	{
		return bonusPointsMouvement;
	}
}


