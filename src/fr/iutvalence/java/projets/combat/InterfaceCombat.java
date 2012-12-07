package fr.iutvalence.java.projets.combat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Florian
 * objet qui permet d'afficher une fenetre de combat
 */
public class InterfaceCombat
{
	/**
	 * Taille en largeur de la fenetre
	 */
	private final static int FENETRE_LARGEUR = 700;
	
	/**
	 * Taille en Hauteur de la fenetre
	 */
	private final static int FENETRE_HAUTEUR = 700;
	
	/**
	 * La fenetre d un combat avec l arene et les informations
	 */
	private JFrame fenetre;
	
	//*********FENETRE DE L'ARENE ************//
	/**
	 * Grille de la carte 
	 */
	private JPanel arene;
	/**
	 * Liste de toute les cases de l'arene
	 */
	private JButton[] cases;
	
	
	//***********FENETRE D'INFORMATION **********//
	/**
	 * Informations sur le joueur, les monstres
	 */
	private Container info;
	
	/**
	 * affichage de la carte (en haut de la fenetre)
	 */
	private Container action;
	
	//***********BOUTON****************//
	
	/**
	 * bouton de retour au menu de base
	 */
	private JButton boutonRetour;
	
	/**
	 * Gestion des actions bouton
	 */
	private ChoixCombat choixCombat;


	
	/**
	 * Affiche le lancement d'une fenetre de combat
	 * @param carte 
	 * @param combat
	 */
	public InterfaceCombat(Carte carte, ChoixCombat choixCombat,PersonnageEnCombat joueur)
	{
		super();
		//******INIT VARIABLE*****//
		int x, y, largeurCarte, hauteurCarte, nbCase;
		nbCase = 0;
		largeurCarte = carte.GetDimension().getX();
		hauteurCarte = carte.GetDimension().getY();
		this.choixCombat = choixCombat;
		
		//*********DEFINIR FENETRE*****//
		this.cases = new JButton[largeurCarte*hauteurCarte];
		this.fenetre = new JFrame();
		this.fenetre.setTitle("Combat");
		this.fenetre.setSize(FENETRE_LARGEUR, FENETRE_HAUTEUR);
		this.fenetre.setLocationRelativeTo(null);
		this.fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//*********************DEFINIR LES BOUTONS*********************//
		JButton boutonRetour = new JButton("Retour");
		boutonRetour.addActionListener(this.choixCombat);
		
		this.boutonRetour = boutonRetour;
		
		//**********************CREE LA CARTE*********************///
		this.arene = new JPanel(new GridLayout(largeurCarte,hauteurCarte));
		
		JPanel infoEtAction = new JPanel(new GridLayout(0,2));
		
		for (y = 0; y < largeurCarte; y++)
		{
			for (x = hauteurCarte-1; x >= 0; x--)
			{ 
				switch (carte.getCarte()[x][y])
				{
					case 0:
						this.cases[nbCase] = new JButton(new ImageIcon("img/herbe.gif"));
						this.arene.add(this.cases[nbCase]);// Vide;
						break;
						
					case 1:
						
						this.cases[nbCase] = new JButton(new ImageIcon("img/trou.gif"));
						this.arene.add(this.cases[nbCase]);// Trou
						break;
						
					case 2:
						this.cases[nbCase] = new JButton(new ImageIcon("img/aventurier.gif"));
						this.arene.add(this.cases[nbCase]); //Le Joueur
						break;
					case -1:
						this.cases[nbCase] = new JButton(); 
						this.arene.add(this.cases[nbCase]); //Affiche "F" pour une erreur
						
					default:
						this.cases[nbCase] = new JButton(new ImageIcon("img/monstre.gif"));
						this.arene.add(this.cases[nbCase]); // Ennemie
				}
				nbCase+=1;
			}
		}		

		
		//***********CREE LES INFORMATIONS ET LES ACTIONS EN BAS DE FENETRE************//
		afficheActionBase();
		afficheInfoJoueur(joueur);
		infoEtAction.add(this.info);
		infoEtAction.add(this.action);
		
		//*******AJOUTE LES 2 JPANEL A LA FENETRE***********//
	    Container conteneurFrame = this.fenetre.getContentPane();
	    GridLayout disposition = new GridLayout(0, 1);
	    conteneurFrame.setLayout(disposition);
	    conteneurFrame.add(this.arene);
	    conteneurFrame.add(infoEtAction);

	    this.fenetre.setVisible(true);
	}

	/**
	 * actualise l'interface de combat
	 */
	public void actualiseFenetre()
	{
		
		JPanel infoEtAction= new JPanel(new GridLayout(0, 2));
		
		infoEtAction.add(this.info);
		infoEtAction.add(this.action);
		
		
	    Container conteneurFrame = new Container();
	    GridLayout disposition = new GridLayout(0, 1);
	    conteneurFrame.setLayout(disposition);
	    conteneurFrame.add(this.arene);
	    conteneurFrame.add(infoEtAction);

	    this.fenetre.setContentPane(conteneurFrame);
	    //this.fenetre.repaint();
	    this.fenetre.setVisible(true);
	}
	
	/**
	 * Affiche les actions de base d'un joueur (CHANGE this.action)
	 */
	public void afficheActionBase()
	{
		GridLayout dispositionAction = new GridLayout(0, 1);
		Container conteneurAction = new Container(); 
		conteneurAction.setLayout(dispositionAction);
		
		JButton boutonAttaque = new JButton("Attaque");
		boutonAttaque.addActionListener(this.choixCombat);
		
		JButton boutonMouvement = new JButton("Deplacement");
		boutonMouvement.addActionListener(this.choixCombat);
		
		JButton boutonFinTour = new JButton("Fin du tour");
		boutonFinTour.addActionListener(this.choixCombat);
		
		JButton boutonQuitter = new JButton("Quitter");
		boutonQuitter.addActionListener(this.choixCombat);
		
		conteneurAction.add(boutonAttaque);
		conteneurAction.add(boutonMouvement);
		conteneurAction.add(boutonFinTour);
		conteneurAction.add(boutonQuitter);

		this.action = conteneurAction;
		
	}
	/**
	 * Supprime la possibilite de faire des actions
	 */
	public void supprimeAction()
	{
		this.action = new Container();
		this.info = new Container();
	}
	
	/**
	 * Affiche les competences disponibles d'un joueur
	 */
	public void afficheActionCompetence(Competences[] competences)
	{
		JButton bouton;
		int nbComp = 0;
		GridLayout dispositionAction = new GridLayout(0, 3);
		Container conteneurAction = new Container(); 
		conteneurAction.setLayout(dispositionAction);
		
		for(nbComp=0;nbComp<competences.length;nbComp++)
		{
			bouton = new JButton(competences[nbComp].getNom());
			bouton.addActionListener(this.choixCombat);
			conteneurAction.add(bouton);
		}
		
		conteneurAction.add(this.boutonRetour);
		
		this.action = conteneurAction;
	}
	
	/**
	 * affiche les monstres a portee d'une competence
	 * @param monstreAPortee (les monstres a portee d'une competence)
	 */
	public void afficheActionChoixMonstre(Monstre[] monstreAPortee)
	{
		int numMonstre;
		JButton bouton;
		GridLayout dispositionAction = new GridLayout(0, 3);
		Container conteneurAction = new Container(); 
		conteneurAction.setLayout(dispositionAction);
		
		if (monstreAPortee.length >= 1)
		{
			for(numMonstre=0;numMonstre<monstreAPortee.length;numMonstre++)
			{
				bouton = new JButton(monstreAPortee[numMonstre].getNom());
				bouton.addActionListener(this.choixCombat);
				conteneurAction.add(bouton);
			}
		
			conteneurAction.add(this.boutonRetour);
		
			this.action = conteneurAction;
		}
	}
	
	/**
	 * Affiche les boutons de mouvement
	 */
	public void afficheActionMouvement()
	{
		GridLayout dispositionAction = new GridLayout(0, 3);
		Container conteneurAction = new Container(); 
		conteneurAction.setLayout(dispositionAction);
		
		JButton boutonHaut = new JButton("Haut");
		boutonHaut.addActionListener(this.choixCombat);
		
		JButton boutonDroite = new JButton("Droite");
		boutonDroite.addActionListener(this.choixCombat);
		
		JButton boutonBas = new JButton("Bas");
		boutonBas.addActionListener(this.choixCombat);
		
		JButton boutonGauche = new JButton("Gauche");
		boutonGauche.addActionListener(this.choixCombat);
		
		conteneurAction.add(new JLabel());
		conteneurAction.add(boutonHaut);
		conteneurAction.add(new JLabel());
		conteneurAction.add(boutonGauche);
		conteneurAction.add(boutonBas);
		conteneurAction.add(boutonDroite);
		conteneurAction.add(new JLabel());
		conteneurAction.add(new JLabel());
		conteneurAction.add(new JLabel());
		conteneurAction.add(this.boutonRetour);
		
		this.action = conteneurAction;
		
	}
	
	/**
	 * Affiche les informations sur le joueur
	 * @param joueur Information du joueur a afficher
	 */
	public void afficheInfoJoueur(PersonnageEnCombat joueur)
	{
		GridLayout dispositionPanelInfo = new GridLayout(0, 1);
		Container conteneurPanelInfo = new Container(); 
		conteneurPanelInfo.setLayout(dispositionPanelInfo);
		
		conteneurPanelInfo.add(new JLabel("Nom : " + joueur.getNom()));
		conteneurPanelInfo.add(new JLabel("Point d'action : " + joueur.getPointDActionActuels() + "/5"));
		conteneurPanelInfo.add(new JLabel("Point de vie : " + joueur.getPointDeVieActuels() + "/" + joueur.getStats().getPointsDeVie()));
		conteneurPanelInfo.add(new JLabel("Point de Mouvement : " + joueur.getPointDeMouvementActuels() + "/" + joueur.getStats().getPointsDeMouvement()));
		
		this.info = conteneurPanelInfo;
		this.info.repaint();
	}
	
	/**
	 * Affiche les informations sur un monstre
	 * @param monstre Information du monstre
	 */
	public void afficheInfoMonstre(Monstre monstre)
	{
		GridLayout dispositionPanelInfo = new GridLayout(0, 1);
		Container conteneurPanelInfo = new Container(); 
		conteneurPanelInfo.setLayout(dispositionPanelInfo);
		
		conteneurPanelInfo.add(new JLabel("Nom : " + monstre.getNom()));
		conteneurPanelInfo.add(new JLabel("Point de vie : " + monstre.getPointDeVieActuels() + "/" + monstre.getStats().getPointsDeVie()));
		
		this.info = conteneurPanelInfo;
		this.info.repaint();
	}
	
	/**
	 * Affiche les informations sur une competence
	 * @param competence Information sur une competence
	 */
	public void afficheInfoCompetence(Competences competence)
	{
		GridLayout dispositionPanelInfo = new GridLayout(0, 1);
		Container conteneurPanelInfo = new Container(); 
		conteneurPanelInfo.setLayout(dispositionPanelInfo);
		
		conteneurPanelInfo.add(new JLabel("Nom : " + competence.getNom()));
		conteneurPanelInfo.add(new JLabel("Bonus de puissance : " + competence.getBonusPuissance()));
		conteneurPanelInfo.add(new JLabel("Portee : " + competence.getPortee()));
		conteneurPanelInfo.add(new JLabel("Consommation : " + competence.getConsommation()));
		
		this.info = conteneurPanelInfo;
		this.info.repaint();
	}
	
	/**
	 * actualise l'affichage de la carte
	 */
	public void actualiseArene(Carte carte, Monstre[] monstres)
	{
		int x, y, largeurCarte, hauteurCarte, nbCase;
		largeurCarte = carte.GetDimension().getX();
		hauteurCarte = carte.GetDimension().getY();
		nbCase = 0;
		
		JPanel areneTemp = new JPanel(new GridLayout(largeurCarte,hauteurCarte));
		
		for (y = 0; y < largeurCarte; y++)
		{
			for (x = hauteurCarte-1; x >= 0; x--)
			{ 
				switch (carte.getCarte()[x][y])
				{
					case 0:
						this.cases[nbCase] = new JButton(new ImageIcon("img/herbe.gif"));
						areneTemp.add(this.cases[nbCase]);// Vide;
						break;
						
					case 1:
						this.cases[nbCase] = new JButton(new ImageIcon("img/trou.gif"));
						areneTemp.add(this.cases[nbCase]);// Trou
						break;
						
					case 2:
						this.cases[nbCase] = new JButton(new ImageIcon("img/aventurier.gif")); 
						areneTemp.add(this.cases[nbCase]); //Le Joueur
						break;
					case -1:
						this.cases[nbCase] = new JButton(); 
						areneTemp.add(this.cases[nbCase]); //Affiche "F" pour une erreur
						
					default:
						if(monstres[(carte.getCarte()[x][y])-3].getPointDeVieActuels() == 0)
						{
							this.cases[nbCase] = new JButton(new ImageIcon("img/mort.png"));
							areneTemp.add(this.cases[nbCase]); // Ennemie Mort		
						}
						else
						{
							this.cases[nbCase] = new JButton(new ImageIcon("img/monstre.gif"));
							areneTemp.add(this.cases[nbCase]); // Ennemie
						}
				}
				nbCase+=1;
			}
		}
		this.arene = areneTemp;
		this.arene.repaint();
	}
	

	
}
