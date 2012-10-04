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
		byte profession = 1; //1 pour avoir la profession Gladiateur
		
		
		NouvPersonnageMenu perso = new NouvPersonnageMenu(nom, profession);

		System.out.println(perso.getNomPersonnage());
		System.out.println(perso.getNomProfession());
		
		/* 0 pour un emplacement libre , 1 pour un obstacle, 2 pour  l'emplcement 
		 du joueur, 3+ pour le(s) monstre(s)*/
		byte[][] map={
				 {1,1,1,1,1,1},
				 {1,2,0,0,0,1},
				 {1,0,0,0,0,1},
				 {1,0,1,1,0,1},
				 {1,0,0,0,0,1},
				 {1,0,0,0,0,1},
				 {1,1,1,1,1,1}
		 }; 
		
		


	}
}
