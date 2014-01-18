package civilization.game_engine;

import civilization.Plateau;
import civilization_joueurs.Joueur;
import java.util.ArrayList;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class Game extends StateBasedGame
{
    public static final String gameName = "Civilisation";
    //public static Joueur j1 = new Joueur();
    //public static Joueur j2 = new Joueur();
    public static ArrayList<Joueur> joueurs = new ArrayList<Joueur>() {{
        add(new Joueur());
        add(new Joueur());
    }};
    public static final int menu = 0;
    public static final int prePlay = 1;
    public static final int play = 2;
    public static final int wSizeX=1020;
    public static final int wSizeY=720;
    public static Plateau plateau;
    
    public Game(String name) 
    {
        super(gameName);
        plateau = new Plateau();
        this.addState(new Menu(menu));
        this.addState(new PrePlay(prePlay));
        this.addState(new Play(play));
        
    }
   
    /**
     * Initialise les trois etats de JEu
     * @param gc
     * @throws SlickException 
     */
    @Override
    public void initStatesList(GameContainer gc) throws SlickException 
    {
        this.getState(menu).init(gc, this);
        this.getState(play).init(gc, this);
        this.enterState(menu);
    }
    
    public static void main(String[] args)  
    {
        try {
            AppGameContainer appgc;
            appgc = new AppGameContainer(new Game(gameName));
            appgc.setDisplayMode(wSizeX, wSizeY, false);
            appgc.setTargetFrameRate(100);
            appgc.start();
        } catch (SlickException ex) {
            ex.printStackTrace();
        }
    }
}