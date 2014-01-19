package civilization_unites;

import civilization.Case;
import civilization_batiments.Batiment;
import civilization_joueurs.Joueur;
import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UMA_Helicoptere extends UniteMilitaireAerien
{    
    public UMA_Helicoptere(Joueur _joueur, Case caseParent, Batiment batimentParent)
    {
        super(_joueur, "Hélicoptère de combat", 5, 0, 6, 0, 8, 8, 7, 7, 2, 10, caseParent, batimentParent, 18);
    }
    
    public static final Map<String, Method> actions = new LinkedHashMap<>();
    static {
        try {
            actions.put("Réparer", Unite.class.getDeclaredMethod("reparer"));
            actions.put("Détruire", Unite.class.getDeclaredMethod("detruire"));
        } catch (NoSuchMethodException | SecurityException ex) {
            Logger.getLogger(UMA_Helicoptere.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public Map<String, Method> getActions() 
    {
        return actions;
    }
}