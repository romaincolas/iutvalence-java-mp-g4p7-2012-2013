/**
 * @author colasr
 * Classe principale, fait tourner le jeu
 */
public class Combat
{

	/**
	 * Fait tourner le jeu
	 * @param args 
	 */
	public static void main(String[] args)
	{
		String nom = "bobo";
		String profession = "Gladiateur";
		
		NouvPersonnageMenu perso;
		
		perso = new NouvPersonnageMenu(nom, profession);

		byte[][] map={
				 {1,1,1,1,1,1},
				 {1,2,0,0,0,1},
				 {1,0,0,0,0,1},
				 {1,0,1,1,0,1},
				 {1,0,0,0,0,1},
				 {1,0,0,0,0,1},
				 {1,1,1,1,1,1}
		 };
		System.out.println(perso.getNom());
		System.out.println(perso.getProfession().getNom());

	}
}
