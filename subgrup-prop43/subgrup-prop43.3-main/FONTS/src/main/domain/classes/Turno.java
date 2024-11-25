package FONTS.src.main.domain.classes;

import FONTS.src.main.domain.classes.enums.Colour;

import java.util.*;

/**
 * Clase Turno sirve para guardar y devolver información del jugador en un turno concreto o el actual.
 */
public class Turno {

    boolean codeMakerHuman;
    int maxSteps, actualSteps;

    List<List<Colour>> codigosCB = new Vector<>();
    List<List<Integer>> respuestasCM = new Vector<>();
    List<Colour> codigoSolucion;
    int pistasPedidas;


    /**
     * Constructora de la clase turno
     * @param solution Codigo secreto del Codemaker
     * @param codeMakerHuman Booleano que indica si el Codemaker es humano o no
     * @param MaxSteps Número de intentos del Codebreaker
     */
    public Turno(List<Colour> solution, boolean codeMakerHuman, int MaxSteps)
    {
        codigoSolucion = solution;
        this.codeMakerHuman = codeMakerHuman;
        this.actualSteps = 0;
        this.maxSteps = MaxSteps;
        this.pistasPedidas = 0;
    }

    /**
     * @return Devuelve el número de intentos del jugador en el turno
     */
    public int getActualSteps() {
        return actualSteps;
    }

    /**
     * @return Devuelve todos los intentos del jugador como Codebreaker en el turno
     */
    public List<List<Colour>> getCodigosCB() {
        return codigosCB;
    }

    /**
     * Devuelve todas las respuestas del jugador como Codemaker en el turno
     * @return respuestas del jugador
     */
    public List<List<Integer>> getRespuestasCM() {
        return respuestasCM;
    }

    /**
     * Devuelve la solucion del Codemaker en el turno
     * @return solucion Codemaker
     */
    public List<Colour> getCodigoSolucion() {
        return codigoSolucion;
    }

    /**
     * Funcion que actualiza turno guardando el intento que hizo el Codebreaker y la respuesta a este del Codemaker
     * @param codigosCB Intento del Codebreaker
     * @param respuestasCM Respuesta al intento del Codemaker
     */
    public void newTry(List<Colour> codigosCB, List<Integer> respuestasCM)
    {
        if (this.maxSteps != actualSteps) {
            this.codigosCB.add(this.actualSteps, codigosCB);
            this.respuestasCM.add(this.actualSteps, respuestasCM);
            ++actualSteps;
        }
    }


}
