package fr.iutvalence.java.projets.combat;

/**
 * Zone de combat avec la position de tout les acteurs et les obstacles
 */
public class Carte
{

	/**
	 * La carte (double tableau d'entier)
	 */
	private int[][] carte;


	/**
	 * Crée une carte (double tableau d'entier)
	 * @param carte (double tableau avec 0 pour zone vide,1 pour obstacle, 
	 * 2 pour le personnage, 3+ pour les monstres)
	 */
	public Carte(int[][] carte)
	{
		super();
		this.carte = carte;
	}

	/**
	 * Obtenir le tableau d'entier 
	 * @return le tableau d'entier
	 */
	public int[][] getCarte()
	{
		return this.carte;
	}
	/**
	 * Obtenir l element dans un coordonnees donne
	 * @param coordonnees ou l'on cherche l element
	 * @return int numero de l element ou -1 si il est a l'exterieur de la carte
	 */
	public int getElement(Coordonnees coordonnees)
	{
		if (coordonnees.getX() <= this.carte.length && 0 < coordonnees.getX() && coordonnees.getY() <= this.carte[coordonnees.getX()].length && 0 < coordonnees.getY())
			return this.carte[coordonnees.getX()][coordonnees.getY()];
		else
			return -1;
	}
	
	/**
	 * Donne les coordonnees max en largeur et en hauteur de la carte
	 * @return les coordonnees max en largeur et en hauteur
	 */
	public Coordonnees GetDimension()
	{
		return new Coordonnees(this.carte[0].length,this.carte.length);
	}
	
	/**
	 * Cherche la position d'un acteur en fonction de son numero (numActeur != 0 et 1)
	 * @param numActeur le numero de l'acteur
	 * @return les coordonees de l'acteur sur la carte de base
	 */
	public Coordonnees CherchePositionActeur(int numActeur)
	{
	
		int x, y;
		for (x = 0; x < this.carte.length; x++)
		{
			for (y = 0; y < this.carte[x].length; y++)
			{
				if (this.carte[x][y] == numActeur)
				{
					return new Coordonnees(x, y);
				}
			}
		}
		return null;
	}

	/**
	 * actualise la carte et change la position des acteurs.
	 * @param monstres une liste des monstres qui participent au combat
	 * @param joueur le joueur present sur la carte
	 */
	public void ActualiseCarte(Monstre[] monstres,PersonnageEnCombat joueur)
	{
		int x;
		Coordonnees coordonnees;
		for	(x=0;x<monstres.length;x++)
		{	
			coordonnees=CherchePositionActeur(monstres[x].getNumActeur());
			this.carte[coordonnees.getX()][coordonnees.getY()]=0;
			this.carte[monstres[x].getPosition().getX()][monstres[x].getPosition().getY()] = monstres[x].getNumActeur();			
		}
		
		coordonnees=CherchePositionActeur(2);
		this.carte[coordonnees.getX()][coordonnees.getY()]=0;
		this.carte[joueur.getPosition().getX()][joueur.getPosition().getY()] = joueur.getNumActeur();			
		
	}
	
	/**
	 * Teste la presence d'un obstacle au coordonnees mit en parametre
	 * @param coordonnees (coordonnees ou l on cherche s il y a un obstacle) 
	 * @return Si y a un obstacle on retourne vrai sinon faux
	 */
	public boolean PresenceObstacle(Coordonnees coordonnees)
	{
		if (getElement(coordonnees) == 0)
		{
			return false;
		}
		else
			return true;
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString()
	{
		int x, y;
		String carteAscii = "";
	
		for (y = 0; y < this.carte[0].length; y++)
		{
		    for(x = (this.carte.length)-1; x >= 0; x--)
		    {
		    	if (this.carte[x][y] == 0)
		    	{
					carteAscii = carteAscii + "░";
		    	}
		    	else if (this.carte[x][y] == 1)
		    	{
		    		carteAscii = carteAscii + "█";
		    	}
		    	else if (this.carte[x][y] == 2)
		    	{
		    		carteAscii = carteAscii + "☺";
		    	}
		    	else
		    	{
		    		carteAscii = carteAscii + "☻";
		    	}
			}
			carteAscii = carteAscii + "\n";
		}

		return carteAscii;
	}
	
	
	/**
	 * Donne la position relative de deux coordonees
	 * @param debut (premiere case)
	 * @param fin (deuxieme case)
	 * @return La position relative de deux coordonees (1 pour le nord, 2 pour nord-est, 3
	 * pour l'est, 4 sud-est, 5 sud, 6 sud-ouest, 7 ouest, 8 nord-ouest), 0 pour la meme case;
	 */
	private int positionRelative(Coordonnees debut, Coordonnees fin)
	{
		Coordonnees coorTemp = debut.SoustractionCoordonnees(fin);
		
		if (coorTemp.getX() == 0 && coorTemp.getY() > 0)
			return 1;
		if (coorTemp.getX() > 0 && coorTemp.getY() > 0)
			return 2;
		if (coorTemp.getX() > 0 && coorTemp.getY() == 0)
			return 3;
		if (coorTemp.getX() > 0 && coorTemp.getY() < 0)
			return 4;
		if (coorTemp.getX() == 0 && coorTemp.getY() < 0)
			return 5;
		if (coorTemp.getX() < 0 && coorTemp.getY() < 0)
			return 6;
		if (coorTemp.getX() < 0 && coorTemp.getY() == 0)
			return 7;
		if (coorTemp.getX() < 0 && coorTemp.getY() > 0)
			return 8;
		return 0;
		
	}
	
	
	/**
	 * determine le chemin devant etre emprunté par le monstre pour atteindre le personnage
	 * @param numMonstre (Le numero du monstre a bouger)
	 * @return le chemin que le monstre doit parcourir pour atteindre le personnage
	 */
	
	public Coordonnees[] ChercheCheminOptimal(int numMonstre)
	{
		int posRelative, nbElementMemoire, nbElementInvalides, nbElementUtilise, random, parcours;
		boolean coorValide, coorDansTableauInvalide;
		Coordonnees coorMonstre;
		Coordonnees coorPerso;
		Coordonnees coorTemp;
		Coordonnees coorTest;
		Coordonnees[] cheminUtilise = new Coordonnees[50];
		Coordonnees[] cheminMemoire = new Coordonnees[50];
		Coordonnees[] coordonneesInvalides = new Coordonnees[100];
		
		coorMonstre = CherchePositionActeur(numMonstre);
		coorPerso = CherchePositionActeur(2);
		coorTemp = coorMonstre;
		nbElementMemoire = 0;
		nbElementInvalides = 0;
		nbElementUtilise = 1;
		
		cheminUtilise[0] = coorMonstre;
		
		
		while (coorTemp != coorPerso)
		{
			posRelative = positionRelative(coorTemp, coorPerso);
			
			switch (posRelative)
			{
				case 1:
					
					coorTest = coorTemp;
					coorTest.changePosY(1);
					parcours = 0;
					coorDansTableauInvalide = false;
					
					while(parcours <= coordonneesInvalides.length && !coorDansTableauInvalide)
					{
						coorDansTableauInvalide = coorTest.equals(coordonneesInvalides[parcours]);
						parcours ++;
					}
					
					coorValide = this.carte[coorTest.getX()][coorTest.getY()] == 0 && !coorDansTableauInvalide;
					if (coorValide)
					{
						coorTemp = coorTest;
						cheminMemoire[nbElementMemoire] = coorTemp;
						nbElementMemoire++;
					}
					else
					{
						random = (int)Math.random()*100;
						if (random < 50)
						{
							coorTest = coorTemp;
							coorTest.changePosX(1);
							parcours = 0;
							coorDansTableauInvalide = false;
							
							while(parcours <= coordonneesInvalides.length && !coorDansTableauInvalide)
							{
								coorDansTableauInvalide = coorTest.equals(coordonneesInvalides[parcours]);
								parcours ++;
							}
							
							coorValide = this.carte[coorTest.getX()][coorTest.getY()] == 0 && !coorDansTableauInvalide;
							if (coorValide)
							{
								coorTemp = coorTest;
								cheminMemoire[nbElementMemoire] = coorTemp;
								nbElementMemoire ++;
							}
							else
							{
								coorTest = coorTemp;
								coorTest.changePosX(-1);
								parcours = 0;
								coorDansTableauInvalide = false;
								
								while(parcours <= coordonneesInvalides.length && !coorDansTableauInvalide)
								{
									coorDansTableauInvalide = coorTest.equals(coordonneesInvalides[parcours]);
									parcours ++;
								}
								
								coorValide = this.carte[coorTest.getX()][coorTest.getY()] == 0 && !coorDansTableauInvalide;
								if (coorValide)
								{
									coorTemp = coorTest;
									cheminMemoire[nbElementMemoire] = coorTemp;
									nbElementMemoire ++;
								}
								else
								{
									coordonneesInvalides[nbElementInvalides] = coorTemp;
									nbElementInvalides ++;
									coorTemp = cheminMemoire[nbElementMemoire-1];
									nbElementMemoire --;
								}
							}
						}
						else
						{
							coorTest = coorTemp;
							coorTest.changePosX(-1);
							parcours = 0;
							coorDansTableauInvalide = false;
							
							while(parcours <= coordonneesInvalides.length && !coorDansTableauInvalide)
							{
								coorDansTableauInvalide = coorTest.equals(coordonneesInvalides[parcours]);
								parcours ++;
							}
							
							coorValide = this.carte[coorTest.getX()][coorTest.getY()] == 0 && !coorDansTableauInvalide;
							if (coorValide)
							{
								coorTemp = coorTest;
								cheminMemoire[nbElementMemoire] = coorTemp;
								nbElementMemoire ++;
							}
							else
							{
								coorTest = coorTemp;
								coorTest.changePosX(1);
								parcours = 0;
								coorDansTableauInvalide = false;
								
								while(parcours <= coordonneesInvalides.length && !coorDansTableauInvalide)
								{
									coorDansTableauInvalide = coorTest.equals(coordonneesInvalides[parcours]);
									parcours ++;
								}
								
								coorValide = this.carte[coorTest.getX()][coorTest.getY()] == 0 && !coorDansTableauInvalide;
								if (coorValide)
								{
									coorTemp = coorTest;
									cheminMemoire[nbElementMemoire] = coorTemp;
									nbElementMemoire ++;
								}
								else
								{
									coordonneesInvalides[nbElementInvalides] = coorTemp;
									nbElementInvalides ++;
									coorTemp = cheminMemoire[nbElementMemoire-1];
									nbElementMemoire --;
									if (coorTemp.equals(cheminUtilise[nbElementUtilise-1]))
									{
										coorTemp.changePosY(-1);
										cheminUtilise[nbElementUtilise] = coorTemp;
										nbElementUtilise ++;
									}
								}
							}
						}
					}
					break;
				case 2:
					random = (int)Math.random()*100;
					if (random < 50)
					{
						coorTest = coorTemp;
						coorTest.changePosX(1);
						parcours = 0;
						coorDansTableauInvalide = false;
						
						while(parcours <= coordonneesInvalides.length && !coorDansTableauInvalide)
						{
							coorDansTableauInvalide = coorTest.equals(coordonneesInvalides[parcours]);
							parcours ++;
						}
						
						coorValide = this.carte[coorTest.getX()][coorTest.getY()] == 0 && !coorDansTableauInvalide;
						if (coorValide)
						{
							coorTemp = coorTest;
							cheminMemoire[nbElementMemoire] = coorTemp;
							nbElementMemoire ++;
						}
						else
						{
							coorTest = coorTemp;
							coorTest.changePosY(1);
							parcours = 0;
							coorDansTableauInvalide = false;
							
							while(parcours <= coordonneesInvalides.length && !coorDansTableauInvalide)
							{
								coorDansTableauInvalide = coorTest.equals(coordonneesInvalides[parcours]);
								parcours ++;
							}
							
							coorValide = this.carte[coorTest.getX()][coorTest.getY()] == 0 && !coorDansTableauInvalide;
							if (coorValide)
							{
								coorTemp = coorTest;
								cheminMemoire[nbElementMemoire] = coorTemp;
								nbElementMemoire ++;
							}
							else
							{
								coordonneesInvalides[nbElementInvalides] = coorTemp;
								nbElementInvalides ++;
								coorTemp = cheminMemoire[nbElementMemoire-1];
								nbElementMemoire --;
							}
						}
					}
					else
					{
						coorTest = coorTemp;
						coorTest.changePosY(1);
						parcours = 0;
						coorDansTableauInvalide = false;
						
						while(parcours <= coordonneesInvalides.length && !coorDansTableauInvalide)
						{
							coorDansTableauInvalide = coorTest.equals(coordonneesInvalides[parcours]);
							parcours ++;
						}
						
						coorValide = this.carte[coorTest.getX()][coorTest.getY()] == 0 && !coorDansTableauInvalide;
						if (coorValide)
						{
							coorTemp = coorTest;
							cheminMemoire[nbElementMemoire] = coorTemp;
							nbElementMemoire ++;
						}
						else
						{
							coorTest = coorTemp;
							coorTest.changePosX(1);
							parcours = 0;
							coorDansTableauInvalide = false;
							
							while(parcours <= coordonneesInvalides.length && !coorDansTableauInvalide)
							{
								coorDansTableauInvalide = coorTest.equals(coordonneesInvalides[parcours]);
								parcours ++;
							}
							
							coorValide = this.carte[coorTest.getX()][coorTest.getY()] == 0 && !coorDansTableauInvalide;
							if (coorValide)
							{
								coorTemp = coorTest;
								cheminMemoire[nbElementMemoire] = coorTemp;
								nbElementMemoire ++;
							}
							else
							{
								coordonneesInvalides[nbElementInvalides] = coorTemp;
								nbElementInvalides ++;
								coorTemp = cheminMemoire[nbElementMemoire-1];
								nbElementMemoire --;
								if (coorTemp.equals(cheminUtilise[nbElementUtilise-1]))
								{
									coorTemp.changePosY(-1);
									cheminUtilise[nbElementUtilise] = coorTemp;
									nbElementUtilise ++;
								}
							}
						}
					}
					break;
				case 3:

					coorTest = coorTemp;
					coorTest.changePosX(1);
					parcours = 0;
					coorDansTableauInvalide = false;
					
					while(parcours <= coordonneesInvalides.length && !coorDansTableauInvalide)
					{
						coorDansTableauInvalide = coorTest.equals(coordonneesInvalides[parcours]);
						parcours ++;
					}
					
					coorValide = this.carte[coorTest.getX()][coorTest.getY()] == 0 && !coorDansTableauInvalide;
					if (coorValide)
					{
						coorTemp = coorTest;
						cheminMemoire[nbElementMemoire] = coorTemp;
						nbElementMemoire++;
					}
					else
					{
						random = (int)Math.random()*100;
						if (random < 50)
						{
							coorTest = coorTemp;
							coorTest.changePosY(1);
							parcours = 0;
							coorDansTableauInvalide = false;
							
							while(parcours <= coordonneesInvalides.length && !coorDansTableauInvalide)
							{
								coorDansTableauInvalide = coorTest.equals(coordonneesInvalides[parcours]);
								parcours ++;
							}
							
							coorValide = this.carte[coorTest.getX()][coorTest.getY()] == 0 && !coorDansTableauInvalide;
							if (coorValide)
							{
								coorTemp = coorTest;
								cheminMemoire[nbElementMemoire] = coorTemp;
								nbElementMemoire ++;
							}
							else
							{
								coorTest = coorTemp;
								coorTest.changePosY(-1);
								parcours = 0;
								coorDansTableauInvalide = false;
								
								while(parcours <= coordonneesInvalides.length && !coorDansTableauInvalide)
								{
									coorDansTableauInvalide = coorTest.equals(coordonneesInvalides[parcours]);
									parcours ++;
								}
								
								coorValide = this.carte[coorTest.getX()][coorTest.getY()] == 0 && !coorDansTableauInvalide;
								if (coorValide)
								{
									coorTemp = coorTest;
									cheminMemoire[nbElementMemoire] = coorTemp;
									nbElementMemoire ++;
								}
								else
								{
									coordonneesInvalides[nbElementInvalides] = coorTemp;
									nbElementInvalides ++;
									coorTemp = cheminMemoire[nbElementMemoire-1];
									nbElementMemoire --;
								}
							}
						}
						else
						{
							coorTest = coorTemp;
							coorTest.changePosY(-1);
							parcours = 0;
							coorDansTableauInvalide = false;
							
							while(parcours <= coordonneesInvalides.length && !coorDansTableauInvalide)
							{
								coorDansTableauInvalide = coorTest.equals(coordonneesInvalides[parcours]);
								parcours ++;
							}
							
							coorValide = this.carte[coorTest.getX()][coorTest.getY()] == 0 && !coorDansTableauInvalide;
							if (coorValide)
							{
								coorTemp = coorTest;
								cheminMemoire[nbElementMemoire] = coorTemp;
								nbElementMemoire ++;
							}
							else
							{
								coorTest = coorTemp;
								coorTest.changePosY(1);
								parcours = 0;
								coorDansTableauInvalide = false;
								
								while(parcours <= coordonneesInvalides.length && !coorDansTableauInvalide)
								{
									coorDansTableauInvalide = coorTest.equals(coordonneesInvalides[parcours]);
									parcours ++;
								}
								
								coorValide = this.carte[coorTest.getX()][coorTest.getY()] == 0 && !coorDansTableauInvalide;
								if (coorValide)
								{
									coorTemp = coorTest;
									cheminMemoire[nbElementMemoire] = coorTemp;
									nbElementMemoire ++;
								}
								else
								{
									coordonneesInvalides[nbElementInvalides] = coorTemp;
									nbElementInvalides ++;
									coorTemp = cheminMemoire[nbElementMemoire-1];
									nbElementMemoire --;
									if (coorTemp.equals(cheminUtilise[nbElementUtilise-1]))
									{
										coorTemp.changePosX(-1);
										cheminUtilise[nbElementUtilise] = coorTemp;
										nbElementUtilise ++;
									}
								}
							}
						}
					}
					break;
				case 4:
					random = (int)Math.random()*100;
					if (random < 50)
					{
						coorTest = coorTemp;
						coorTest.changePosX(1);
						parcours = 0;
						coorDansTableauInvalide = false;
						
						while(parcours <= coordonneesInvalides.length && !coorDansTableauInvalide)
						{
							coorDansTableauInvalide = coorTest.equals(coordonneesInvalides[parcours]);
							parcours ++;
						}
						
						coorValide = this.carte[coorTest.getX()][coorTest.getY()] == 0 && !coorDansTableauInvalide;
						if (coorValide)
						{
							coorTemp = coorTest;
							cheminMemoire[nbElementMemoire] = coorTemp;
							nbElementMemoire ++;
						}
						else
						{
							coorTest = coorTemp;
							coorTest.changePosY(-1);
							parcours = 0;
							coorDansTableauInvalide = false;
							
							while(parcours <= coordonneesInvalides.length && !coorDansTableauInvalide)
							{
								coorDansTableauInvalide = coorTest.equals(coordonneesInvalides[parcours]);
								parcours ++;
							}
							
							coorValide = this.carte[coorTest.getX()][coorTest.getY()] == 0 && !coorDansTableauInvalide;
							if (coorValide)
							{
								coorTemp = coorTest;
								cheminMemoire[nbElementMemoire] = coorTemp;
								nbElementMemoire ++;
							}
							else
							{
								coordonneesInvalides[nbElementInvalides] = coorTemp;
								nbElementInvalides ++;
								coorTemp = cheminMemoire[nbElementMemoire-1];
								nbElementMemoire --;
							}
						}
					}
					else
					{
						coorTest = coorTemp;
						coorTest.changePosY(-1);
						parcours = 0;
						coorDansTableauInvalide = false;
						
						while(parcours <= coordonneesInvalides.length && !coorDansTableauInvalide)
						{
							coorDansTableauInvalide = coorTest.equals(coordonneesInvalides[parcours]);
							parcours ++;
						}
						
						coorValide = this.carte[coorTest.getX()][coorTest.getY()] == 0 && !coorDansTableauInvalide;
						if (coorValide)
						{
							coorTemp = coorTest;
							cheminMemoire[nbElementMemoire] = coorTemp;
							nbElementMemoire ++;
						}
						else
						{
							coorTest = coorTemp;
							coorTest.changePosX(1);
							parcours = 0;
							coorDansTableauInvalide = false;
							
							while(parcours <= coordonneesInvalides.length && !coorDansTableauInvalide)
							{
								coorDansTableauInvalide = coorTest.equals(coordonneesInvalides[parcours]);
								parcours ++;
							}
							
							coorValide = this.carte[coorTest.getX()][coorTest.getY()] == 0 && !coorDansTableauInvalide;
							if (coorValide)
							{
								coorTemp = coorTest;
								cheminMemoire[nbElementMemoire] = coorTemp;
								nbElementMemoire ++;
							}
							else
							{
								coordonneesInvalides[nbElementInvalides] = coorTemp;
								nbElementInvalides ++;
								coorTemp = cheminMemoire[nbElementMemoire-1];
								nbElementMemoire --;
								if (coorTemp.equals(cheminUtilise[nbElementUtilise-1]))
								{
									coorTemp.changePosY(-1);
									cheminUtilise[nbElementUtilise] = coorTemp;
									nbElementUtilise ++;
								}
							}
						}
					}
					break;
				case 5:

					coorTest = coorTemp;
					coorTest.changePosY(-1);
					parcours = 0;
					coorDansTableauInvalide = false;
					
					while(parcours <= coordonneesInvalides.length && !coorDansTableauInvalide)
					{
						coorDansTableauInvalide = coorTest.equals(coordonneesInvalides[parcours]);
						parcours ++;
					}
					
					coorValide = this.carte[coorTest.getX()][coorTest.getY()] == 0 && !coorDansTableauInvalide;
					if (coorValide)
					{
						coorTemp = coorTest;
						cheminMemoire[nbElementMemoire] = coorTemp;
						nbElementMemoire++;
					}
					else
					{
						random = (int)Math.random()*100;
						if (random < 50)
						{
							coorTest = coorTemp;
							coorTest.changePosX(-1);
							parcours = 0;
							coorDansTableauInvalide = false;
							
							while(parcours <= coordonneesInvalides.length && !coorDansTableauInvalide)
							{
								coorDansTableauInvalide = coorTest.equals(coordonneesInvalides[parcours]);
								parcours ++;
							}
							
							coorValide = this.carte[coorTest.getX()][coorTest.getY()] == 0 && !coorDansTableauInvalide;
							if (coorValide)
							{
								coorTemp = coorTest;
								cheminMemoire[nbElementMemoire] = coorTemp;
								nbElementMemoire ++;
							}
							else
							{
								coorTest = coorTemp;
								coorTest.changePosX(1);
								parcours = 0;
								coorDansTableauInvalide = false;
								
								while(parcours <= coordonneesInvalides.length && !coorDansTableauInvalide)
								{
									coorDansTableauInvalide = coorTest.equals(coordonneesInvalides[parcours]);
									parcours ++;
								}
								
								coorValide = this.carte[coorTest.getX()][coorTest.getY()] == 0 && !coorDansTableauInvalide;
								if (coorValide)
								{
									coorTemp = coorTest;
									cheminMemoire[nbElementMemoire] = coorTemp;
									nbElementMemoire ++;
								}
								else
								{
									coordonneesInvalides[nbElementInvalides] = coorTemp;
									nbElementInvalides ++;
									coorTemp = cheminMemoire[nbElementMemoire-1];
									nbElementMemoire --;
								}
							}
						}
						else
						{
							coorTest = coorTemp;
							coorTest.changePosX(1);
							parcours = 0;
							coorDansTableauInvalide = false;
							
							while(parcours <= coordonneesInvalides.length && !coorDansTableauInvalide)
							{
								coorDansTableauInvalide = coorTest.equals(coordonneesInvalides[parcours]);
								parcours ++;
							}
							
							coorValide = this.carte[coorTest.getX()][coorTest.getY()] == 0 && !coorDansTableauInvalide;
							if (coorValide)
							{
								coorTemp = coorTest;
								cheminMemoire[nbElementMemoire] = coorTemp;
								nbElementMemoire ++;
							}
							else
							{
								coorTest = coorTemp;
								coorTest.changePosX(-1);
								parcours = 0;
								coorDansTableauInvalide = false;
								
								while(parcours <= coordonneesInvalides.length && !coorDansTableauInvalide)
								{
									coorDansTableauInvalide = coorTest.equals(coordonneesInvalides[parcours]);
									parcours ++;
								}
								
								coorValide = this.carte[coorTest.getX()][coorTest.getY()] == 0 && !coorDansTableauInvalide;
								if (coorValide)
								{
									coorTemp = coorTest;
									cheminMemoire[nbElementMemoire] = coorTemp;
									nbElementMemoire ++;
								}
								else
								{
									coordonneesInvalides[nbElementInvalides] = coorTemp;
									nbElementInvalides ++;
									coorTemp = cheminMemoire[nbElementMemoire-1];
									nbElementMemoire --;
									if (coorTemp.equals(cheminUtilise[nbElementUtilise-1]))
									{
										coorTemp.changePosY(1);
										cheminUtilise[nbElementUtilise] = coorTemp;
										nbElementUtilise ++;
									}
								}
							}
						}
					}
					break;
				case 6:
					random = (int)Math.random()*100;
					if (random < 50)
					{
						coorTest = coorTemp;
						coorTest.changePosX(-1);
						parcours = 0;
						coorDansTableauInvalide = false;
						
						while(parcours <= coordonneesInvalides.length && !coorDansTableauInvalide)
						{
							coorDansTableauInvalide = coorTest.equals(coordonneesInvalides[parcours]);
							parcours ++;
						}
						
						coorValide = this.carte[coorTest.getX()][coorTest.getY()] == 0 && !coorDansTableauInvalide;
						if (coorValide)
						{
							coorTemp = coorTest;
							cheminMemoire[nbElementMemoire] = coorTemp;
							nbElementMemoire ++;
						}
						else
						{
							coorTest = coorTemp;
							coorTest.changePosY(-1);
							parcours = 0;
							coorDansTableauInvalide = false;
							
							while(parcours <= coordonneesInvalides.length && !coorDansTableauInvalide)
							{
								coorDansTableauInvalide = coorTest.equals(coordonneesInvalides[parcours]);
								parcours ++;
							}
							
							coorValide = this.carte[coorTest.getX()][coorTest.getY()] == 0 && !coorDansTableauInvalide;
							if (coorValide)
							{
								coorTemp = coorTest;
								cheminMemoire[nbElementMemoire] = coorTemp;
								nbElementMemoire ++;
							}
							else
							{
								coordonneesInvalides[nbElementInvalides] = coorTemp;
								nbElementInvalides ++;
								coorTemp = cheminMemoire[nbElementMemoire-1];
								nbElementMemoire --;
							}
						}
					}
					else
					{
						coorTest = coorTemp;
						coorTest.changePosY(-1);
						parcours = 0;
						coorDansTableauInvalide = false;
						
						while(parcours <= coordonneesInvalides.length && !coorDansTableauInvalide)
						{
							coorDansTableauInvalide = coorTest.equals(coordonneesInvalides[parcours]);
							parcours ++;
						}
						
						coorValide = this.carte[coorTest.getX()][coorTest.getY()] == 0 && !coorDansTableauInvalide;
						if (coorValide)
						{
							coorTemp = coorTest;
							cheminMemoire[nbElementMemoire] = coorTemp;
							nbElementMemoire ++;
						}
						else
						{
							coorTest = coorTemp;
							coorTest.changePosX(-1);
							parcours = 0;
							coorDansTableauInvalide = false;
							
							while(parcours <= coordonneesInvalides.length && !coorDansTableauInvalide)
							{
								coorDansTableauInvalide = coorTest.equals(coordonneesInvalides[parcours]);
								parcours ++;
							}
							
							coorValide = this.carte[coorTest.getX()][coorTest.getY()] == 0 && !coorDansTableauInvalide;
							if (coorValide)
							{
								coorTemp = coorTest;
								cheminMemoire[nbElementMemoire] = coorTemp;
								nbElementMemoire ++;
							}
							else
							{
								coordonneesInvalides[nbElementInvalides] = coorTemp;
								nbElementInvalides ++;
								coorTemp = cheminMemoire[nbElementMemoire-1];
								nbElementMemoire --;
								if (coorTemp.equals(cheminUtilise[nbElementUtilise-1]))
								{
									coorTemp.changePosY(-1);
									cheminUtilise[nbElementUtilise] = coorTemp;
									nbElementUtilise ++;
								}
							}
						}
					}
					break;
				case 7:

					coorTest = coorTemp;
					coorTest.changePosX(-1);
					parcours = 0;
					coorDansTableauInvalide = false;
					
					while(parcours <= coordonneesInvalides.length && !coorDansTableauInvalide)
					{
						coorDansTableauInvalide = coorTest.equals(coordonneesInvalides[parcours]);
						parcours ++;
					}
					
					coorValide = this.carte[coorTest.getX()][coorTest.getY()] == 0 && !coorDansTableauInvalide;
					if (coorValide)
					{
						coorTemp = coorTest;
						cheminMemoire[nbElementMemoire] = coorTemp;
						nbElementMemoire++;
					}
					else
					{
						random = (int)Math.random()*100;
						if (random < 50)
						{
							coorTest = coorTemp;
							coorTest.changePosY(1);
							parcours = 0;
							coorDansTableauInvalide = false;
							
							while(parcours <= coordonneesInvalides.length && !coorDansTableauInvalide)
							{
								coorDansTableauInvalide = coorTest.equals(coordonneesInvalides[parcours]);
								parcours ++;
							}
							
							coorValide = this.carte[coorTest.getX()][coorTest.getY()] == 0 && !coorDansTableauInvalide;
							if (coorValide)
							{
								coorTemp = coorTest;
								cheminMemoire[nbElementMemoire] = coorTemp;
								nbElementMemoire ++;
							}
							else
							{
								coorTest = coorTemp;
								coorTest.changePosY(-1);
								parcours = 0;
								coorDansTableauInvalide = false;
								
								while(parcours <= coordonneesInvalides.length && !coorDansTableauInvalide)
								{
									coorDansTableauInvalide = coorTest.equals(coordonneesInvalides[parcours]);
									parcours ++;
								}
								
								coorValide = this.carte[coorTest.getX()][coorTest.getY()] == 0 && !coorDansTableauInvalide;
								if (coorValide)
								{
									coorTemp = coorTest;
									cheminMemoire[nbElementMemoire] = coorTemp;
									nbElementMemoire ++;
								}
								else
								{
									coordonneesInvalides[nbElementInvalides] = coorTemp;
									nbElementInvalides ++;
									coorTemp = cheminMemoire[nbElementMemoire-1];
									nbElementMemoire --;
								}
							}
						}
						else
						{
							coorTest = coorTemp;
							coorTest.changePosY(-1);
							parcours = 0;
							coorDansTableauInvalide = false;
							
							while(parcours <= coordonneesInvalides.length && !coorDansTableauInvalide)
							{
								coorDansTableauInvalide = coorTest.equals(coordonneesInvalides[parcours]);
								parcours ++;
							}
							
							coorValide = this.carte[coorTest.getX()][coorTest.getY()] == 0 && !coorDansTableauInvalide;
							if (coorValide)
							{
								coorTemp = coorTest;
								cheminMemoire[nbElementMemoire] = coorTemp;
								nbElementMemoire ++;
							}
							else
							{
								coorTest = coorTemp;
								coorTest.changePosY(1);
								parcours = 0;
								coorDansTableauInvalide = false;
								
								while(parcours <= coordonneesInvalides.length && !coorDansTableauInvalide)
								{
									coorDansTableauInvalide = coorTest.equals(coordonneesInvalides[parcours]);
									parcours ++;
								}
								
								coorValide = this.carte[coorTest.getX()][coorTest.getY()] == 0 && !coorDansTableauInvalide;
								if (coorValide)
								{
									coorTemp = coorTest;
									cheminMemoire[nbElementMemoire] = coorTemp;
									nbElementMemoire ++;
								}
								else
								{
									coordonneesInvalides[nbElementInvalides] = coorTemp;
									nbElementInvalides ++;
									coorTemp = cheminMemoire[nbElementMemoire-1];
									nbElementMemoire --;
									if (coorTemp.equals(cheminUtilise[nbElementUtilise-1]))
									{
										coorTemp.changePosX(1);
										cheminUtilise[nbElementUtilise] = coorTemp;
										nbElementUtilise ++;
									}
								}
							}
						}
					}
					break;
				case 8:
					random = (int)Math.random()*100;
					if (random < 50)
					{
						coorTest = coorTemp;
						coorTest.changePosX(-1);
						parcours = 0;
						coorDansTableauInvalide = false;
						
						while(parcours <= coordonneesInvalides.length && !coorDansTableauInvalide)
						{
							coorDansTableauInvalide = coorTest.equals(coordonneesInvalides[parcours]);
							parcours ++;
						}
						
						coorValide = this.carte[coorTest.getX()][coorTest.getY()] == 0 && !coorDansTableauInvalide;
						if (coorValide)
						{
							coorTemp = coorTest;
							cheminMemoire[nbElementMemoire] = coorTemp;
							nbElementMemoire ++;
						}
						else
						{
							coorTest = coorTemp;
							coorTest.changePosY(1);
							parcours = 0;
							coorDansTableauInvalide = false;
							
							while(parcours <= coordonneesInvalides.length && !coorDansTableauInvalide)
							{
								coorDansTableauInvalide = coorTest.equals(coordonneesInvalides[parcours]);
								parcours ++;
							}
							
							coorValide = this.carte[coorTest.getX()][coorTest.getY()] == 0 && !coorDansTableauInvalide;
							if (coorValide)
							{
								coorTemp = coorTest;
								cheminMemoire[nbElementMemoire] = coorTemp;
								nbElementMemoire ++;
							}
							else
							{
								coordonneesInvalides[nbElementInvalides] = coorTemp;
								nbElementInvalides ++;
								coorTemp = cheminMemoire[nbElementMemoire-1];
								nbElementMemoire --;
							}
						}
					}
					else
					{
						coorTest = coorTemp;
						coorTest.changePosY(1);
						parcours = 0;
						coorDansTableauInvalide = false;
						
						while(parcours <= coordonneesInvalides.length && !coorDansTableauInvalide)
						{
							coorDansTableauInvalide = coorTest.equals(coordonneesInvalides[parcours]);
							parcours ++;
						}
						
						coorValide = this.carte[coorTest.getX()][coorTest.getY()] == 0 && !coorDansTableauInvalide;
						if (coorValide)
						{
							coorTemp = coorTest;
							cheminMemoire[nbElementMemoire] = coorTemp;
							nbElementMemoire ++;
						}
						else
						{
							coorTest = coorTemp;
							coorTest.changePosX(-1);
							parcours = 0;
							coorDansTableauInvalide = false;
							
							while(parcours <= coordonneesInvalides.length && !coorDansTableauInvalide)
							{
								coorDansTableauInvalide = coorTest.equals(coordonneesInvalides[parcours]);
								parcours ++;
							}
							
							coorValide = this.carte[coorTest.getX()][coorTest.getY()] == 0 && !coorDansTableauInvalide;
							if (coorValide)
							{
								coorTemp = coorTest;
								cheminMemoire[nbElementMemoire] = coorTemp;
								nbElementMemoire ++;
							}
							else
							{
								coordonneesInvalides[nbElementInvalides] = coorTemp;
								nbElementInvalides ++;
								coorTemp = cheminMemoire[nbElementMemoire-1];
								nbElementMemoire --;
								if (coorTemp.equals(cheminUtilise[nbElementUtilise-1]))
								{
									coorTemp.changePosY(-1);
									cheminUtilise[nbElementUtilise] = coorTemp;
									nbElementUtilise ++;
								}
							}
						}
					}
					break;
			}
		}
		return cheminUtilise;
	}
		
}
	
