package fr.iutvalence.java.projets.combat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Interface
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
	//private JPanel infoEtAction;
	
	private Container info;
	
	private Container action;
	
	//***********BOUTON****************//
	
	private JButton boutonAttaque;
	
	private JButton boutonCompetence;
	
	private JButton boutonMouvement;
	
	private JButton boutonHaut;
	
	private JButton boutonGauche;
	
	private JButton boutonDroite;
	
	private JButton boutonBas;
	
	private JButton boutonFinTour;
	
	private JButton boutonQuitter;
	
	private JButton boutonRetoure;
	
	private GestionCombat combat;


	public Interface(Carte carte, GestionCombat combat)
	{
		super();
		//******INIT VARIABLE*****//
		int x, y, largeurCarte, hauteurCarte, nbCase;
		nbCase = 0;
		largeurCarte = carte.GetDimension().getX();
		hauteurCarte = carte.GetDimension().getY();
		this.combat = combat;
		
		//*********DEFINIR FENETRE*****//
		this.cases = new JButton[largeurCarte*hauteurCarte];
		this.fenetre = new JFrame();
		this.fenetre.setTitle("Combat");
		this.fenetre.setSize(FENETRE_LARGEUR, FENETRE_HAUTEUR);
		this.fenetre.setLocationRelativeTo(null);
		this.fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//*********************DEFINIR LES BOUTONS*********************//
		JButton boutonAttaque = new JButton("Attaque");
		boutonAttaque.addActionListener(this.combat);

		JButton boutonCompetence = new JButton();
		boutonAttaque.addActionListener(this.combat);
		
		JButton boutonMouvement = new JButton("Deplacement");
		boutonMouvement.addActionListener(this.combat);
		
		JButton boutonHaut = new JButton("Haut");
		boutonHaut.addActionListener(this.combat);
		
		JButton boutonDroite = new JButton("Droite");
		boutonDroite.addActionListener(this.combat);
		
		JButton boutonBas = new JButton("Bas");
		boutonBas.addActionListener(this.combat);
		
		JButton boutonGauche = new JButton("Gauche");
		boutonGauche.addActionListener(this.combat);
		
		JButton boutonFinTour = new JButton("Fin du tour");
		boutonFinTour.addActionListener(this.combat);
		
		JButton boutonRetoure = new JButton("Retoure");
		boutonRetoure.addActionListener(this.combat);
		
		JButton boutonQuitter = new JButton("Quitter");
		boutonQuitter.addActionListener(this.combat);
		
		this.boutonAttaque = boutonAttaque;
		this.boutonCompetence = boutonCompetence;
		this.boutonMouvement = boutonMouvement;
		this.boutonHaut= boutonHaut;
		this.boutonDroite = boutonDroite;
		this.boutonBas = boutonBas;
		this.boutonGauche = boutonGauche;
		this.boutonFinTour = boutonFinTour;
		this.boutonQuitter = boutonQuitter;
		this.boutonRetoure = boutonRetoure;
		
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
		afficheInfoActeur(combat.joueur);
		
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
	
		conteneurAction.add(this.boutonAttaque);
		conteneurAction.add(this.boutonMouvement);
		conteneurAction.add(this.boutonFinTour);
		conteneurAction.add(this.boutonQuitter);

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
	 * @param joueur (le joueur dont  les competences doivent etre affiché )
	 */
	public void afficheActionCompetence(PersonnageEnCombat joueur)
	{
		int nbComp = 0;
		GridLayout dispositionAction = new GridLayout(0, 3);
		Container conteneurAction = new Container(); 
		conteneurAction.setLayout(dispositionAction);
		
		for(nbComp=0;nbComp<joueur.GetNombreCompetences();nbComp++)
		{
			this.boutonCompetence.setLabel(joueur.getCompetences(nbComp).getNom());
			conteneurAction.add(this.boutonCompetence);
		}
		
		conteneurAction.add(this.boutonRetoure);
		
		this.action = conteneurAction;
		
		this.action.setEnabled(false);
		this.info.setEnabled(false);
	}
	
	public void afficheActionMouvement()
	{
		GridLayout dispositionAction = new GridLayout(0, 3);
		Container conteneurAction = new Container(); 
		conteneurAction.setLayout(dispositionAction);
		
		conteneurAction.add(new JLabel());
		conteneurAction.add(this.boutonHaut);
		conteneurAction.add(new JLabel());
		conteneurAction.add(this.boutonGauche);
		conteneurAction.add(this.boutonBas);
		conteneurAction.add(this.boutonDroite);
		conteneurAction.add(new JLabel());
		conteneurAction.add(new JLabel());
		conteneurAction.add(new JLabel());
		conteneurAction.add(this.boutonRetoure);
		
		this.action = conteneurAction;
		
	}
	
	/**
	 * 
	 * Affiche les informations sur un acteur
	 * @param acteur Information de l'acteur a afficher
	 */
	public void afficheInfoActeur(Acteur acteur)
	{
		GridLayout dispositionPanelInfo = new GridLayout(0, 1);
		Container conteneurPanelInfo = new Container(); 
		conteneurPanelInfo.setLayout(dispositionPanelInfo);
		
		conteneurPanelInfo.add(new JLabel("Nom : " + acteur.getNom()));
		conteneurPanelInfo.add(new JLabel("Point d'action : " + acteur.getPointDActionActuels()));
		conteneurPanelInfo.add(new JLabel("Point de vie : " + acteur.getPointDeVieActuels()));
		conteneurPanelInfo.add(new JLabel("Point de Mouvement : " + acteur.getPointDeMouvementActuels()));
		
		this.info = conteneurPanelInfo;
		this.info.repaint();
	}
	
	public void actualiseArene(Carte carte)
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
						this.cases[nbCase] = new JButton(new ImageIcon("img/monstre.gif"));
						areneTemp.add(this.cases[nbCase]); // Ennemie
				}
				nbCase+=1;
			}
		}
		this.arene = areneTemp;
		this.arene.repaint();
	}
	
	
	
}
