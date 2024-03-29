package civilization_batiments;

import civilization.Case;
import civilization_joueurs.Joueur;
import civilization_unites.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HotelDeVille extends Batiment 
{    
    public static ArrayList<Class<? extends UniteCivileTerrestre>> unitesDisponiblesPourConstruction = new ArrayList<>(
            Arrays.asList(UCT_Ouvrier.class, UCT_Paysan.class)
    );
    
    public HotelDeVille(Joueur j,Case c) 
    {
        super(j, c, 0, 50, 0, 0, 0, 0, 1, 1, 1, 1, 1); 
        this.statut = "Normal";
    }

    public static final Map<String, Constructor> constructions = new LinkedHashMap<>();
    static {
        try {
            constructions.put("Ouvrier", UCT_Ouvrier.class.getConstructor(Joueur.class, Case.class, Batiment.class));
        } catch (NoSuchMethodException | SecurityException ex) {
            Logger.getLogger(HotelDeVille.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static final Map<String, Method> actions = new LinkedHashMap<>();
    static {
        try {
            actions.put("Réparer", Batiment.class.getDeclaredMethod("reparer"));
        } catch (NoSuchMethodException | SecurityException ex) {
            Logger.getLogger(HotelDeVille.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public Map<String, Constructor> getConstructions() {
        return constructions;
    }

    @Override
    public Map<String, Method> getActions() {
        return actions;
    }

    @Override
    public boolean hebergerUnite(Unite unite) 
    {
        this.unitesHebergees.add(unite);
        unite.setBatimentParent(this);
        unite.changerStatut("hebergee");
        return true;
    }
    
    @Override
    public boolean peutHebergerUnite(Unite unite) 
    {
        return true;
    }
}