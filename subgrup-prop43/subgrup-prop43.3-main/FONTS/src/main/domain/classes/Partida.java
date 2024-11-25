package FONTS.src.main.domain.classes;

import FONTS.src.main.domain.classes.enums.Colour;

import java.util.List;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;

public class Partida {
    private String username;
    private String nombre;
    private boolean repeticiones;
    private boolean blanks;
    private boolean isCMHuman;
    private int turnos;
    private int turno_act;
    private int intentos;
    private int n_color;
    private int n_combi;
    private int puntuacionHM;
    private List<Colour> Colores = new Vector<>();
    private List<Colour> ColoresExtra = new Vector<>();
    private Vector<Turno> vturnos = new Vector<>();
    private int IA = 0; //0=Five Guesses, 1= genetic

    /**
     * Constructora
     * @param nombre
     * @param username
     */
    public Partida(String nombre, String username) {
        this.nombre = nombre;
        this.username = username;
        this.repeticiones = false;
        this.blanks = false;
        this.intentos = 12;
        this.turnos = 2;
        this.turno_act = -1;
        this.n_color = 6;
        this.n_combi = 4;
        this.puntuacionHM = 0;
        this.isCMHuman = true;
        Colores.add(0, Colour.VERDE);
        Colores.add(1, Colour.AZUL);
        Colores.add(2, Colour.ROJO);
        Colores.add(3, Colour.AMARILLO);
        Colores.add(4, Colour.LILA);
        Colores.add(5, Colour.NARANJA);
    }

    /**
     * Setters
     * "@param" que necesite el setter en cuestion
     */
    public void setRepTrue(){
        this.repeticiones = true;
    }

    public void setRepFalse(){
        this.repeticiones = false;
    }

    public void setBlkTrue(){
        this.blanks = true;
    }

    public void setBlkFalse(){
        this.blanks = false;
    }

    public void setPlayers(boolean CMhuman) {
        isCMHuman=CMhuman;
    }

    public void setTurnos(int turnos){
        this.turnos = turnos;
    }

    public void setIntentos(int intentos){
        this.intentos = intentos;
    }

    public void setColoresExtra(List<Colour> extra){
        n_color += extra.size() - this.ColoresExtra.size();
        this.ColoresExtra = extra;
    }

    public void setIA(int ia) {
        switch (ia){
            case 0:
                IA = 0;
                break;
            case 1:
                IA = 1;
                break;
        }
    }

    /**
     * Getters
     * @return Depende el getter en cuestion
     */
    public String getUsername(){
        return this.username;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean getRepeticiones(){
        return this.repeticiones;
    }

    public boolean getBlanks(){
        return this.blanks;
    }

    public boolean getIsCMHuman() {return isCMHuman; }

    public int getTurnos(){
        return this.turnos;
    }

    public int getTurno_act(){
        return this.turno_act;
    }

    public int getIntentos(){
        return this.intentos;
    }

    public int getN_color(){
        return this.n_color;
    }

    public int getN_combi(){
        return this.n_combi;
    }

    public int getPuntuacionHM(){
        return this.puntuacionHM;
    }

    public List<Colour> getColores(){
        return Colores;
    }

    public List<Colour> getColoresExtra(){
        return ColoresExtra;
    }

    public Vector<Turno> getVturnos() {
        return vturnos;
    }

    public int getIA() {return IA;}


    /**
     * Añade un turno en la partida
     * @param turno Estado actual del turno a añadir
     */
    public void addTurno(Turno turno) {
        vturnos.add(turno);
    }

    /**
     * Actualiza la puntuación de la partida
     * @param puntuacion Numero a sumar  a la puntuación
     */
    public void addPuntuacio(int puntuacion){

        puntuacionHM += puntuacion;
    }

    /**
     * Pasa al siguiente turno
     */
    public void nextTurn() {
        ++turno_act;
    }

    /**
     * Comprueba si a finalizado la partida
     * @return Boolean
     */
    public boolean ended() {
        return turnos <= turno_act;
    }

}
