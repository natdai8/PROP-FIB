package FONTS.src.main.domain.classes;
import FONTS.src.main.domain.classes.enums.Colour;
import java.util.*;

public class CodeBreaker {

    private List<List<Colour>> AlgorithmSol;

    private final boolean esPersona;

    private int numerojugada;

    private boolean alreadyGivenPista;

    /* Creadora */

    /**
     * Creadora
     * @param persona indica si el juagdor es persona o la maquina
     */
    public CodeBreaker(boolean persona) {

        this.esPersona = persona;
        numerojugada = 0;
        alreadyGivenPista = false;
    }

    /**
     * Establece la solucion del algoritmo
     * @param sol solucion algoritmo
     */
    public void setAlgorithmSol(List<List<Colour>> sol){
        AlgorithmSol = sol;
    }

    /**
     * Le pasas el numero de intento por el va el jugador y devuelve la respuesta que daria el algortimo en ese intento
     * @return respuesta algortimo
     */
    public List<Colour> getPista(){
        if (!alreadyGivenPista)
        {
            int tmp = numerojugada;
            ++numerojugada;
            alreadyGivenPista = true;
            return AlgorithmSol.get(tmp);
        }
        return null;
    }

    /**
     * Indica si el CB es persona o maquina en ese turno
     * @return booleano que indica si es persona
     */
    public boolean CBPersona(){
        return esPersona;
    }

    /**
     * Indica si ya se ha dado una pista en ese turno
     */
    public void newTurn()
    {
        alreadyGivenPista = false;
    }


}
