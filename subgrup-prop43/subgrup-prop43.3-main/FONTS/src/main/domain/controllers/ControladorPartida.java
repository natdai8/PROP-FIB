package FONTS.src.main.domain.controllers;

import FONTS.src.main.domain.classes.*;
import FONTS.src.main.domain.classes.Record;
import FONTS.src.main.domain.classes.enums.Colour;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Vector;

public class ControladorPartida {
    private Vector<Partida> Partidas;
    private Partida partidaActual;
    private CodeMaker CMActual;
    private CodeBreaker CBActual;
    private Turno turnoActual;
    private Maquina Machine;
    private final Ranking ranking = new Ranking();
    private boolean cargado = false;

    /**
     * Constructora de partida
     */
    public ControladorPartida(){
        Partidas = new Vector<>();
        partidaActual = null;
        CMActual = null;
        CBActual = null;
        turnoActual = null;
        Machine = null;
    }

    /**
     * Devuelve el username de quien ha creado la partida en posicion (id)
     * @param id
     * @return username del creador
     */
    public String getUsername(int id){
        return Partidas.elementAt(id).getUsername();
    }

    /**
     * @return Devuelve el nombre de la partida activa en el controlador
     */
    public String getNombre(){
        return partidaActual.getNombre();
    }

    /**
     * @param id
     * @return Devuelve el nombre de la partida que esta guardada en la posicion (id)
     */
    public String getNombre(int id){
        return Partidas.get(id).getNombre();
    }

    /**
     * @return Devuelve si estan permitidas las repeticiones de colores en las combinaciones de la partida activa
     */
    public boolean getRepeticiones(){
        return partidaActual.getRepeticiones();
    }

    /**
     * @return Devuelve si estan permitidas los eespacios en blanco en las combinaciones de la partida activa
     */
    public boolean getBlanks(){
        return partidaActual.getBlanks();
    }

    /**
     * @return Devuelve el numero de turnos de la partida activa
     */
    public int getTurnos(){
        return partidaActual.getTurnos();
    }

    /**
     * @param id
     * @return Devuelve el numero de turnos de la partida guardada en posicion (id)
     */
    public int getTurnos(int id){
        return Partidas.get(id).getTurnos();
    }

    /**
     * @param id
     * @return Devuelve en que turno esta la partida guardada en poscicion (id)
     */
    public int getTurno_act(int id){
        return Partidas.elementAt(id).getTurno_act();
    }

    /**
     * @return Devuelve el numero de intentos por turno de la partida activa
     */
    public int getIntentos(){
        return partidaActual.getIntentos();
    }

    /**
     * @return Devuelve el numero de colores de la partida activa
     */
    public int getN_color(){
        return partidaActual.getN_color();
    }

    /**
     * @return Devuelve el ranking
     */
    public ArrayList<Record> getRanking(){
        return ranking.getRanking();}

    /**
     * @return Devuelve la puntuacion del humano en la partida activa
     */
    public int getPuntuacion(){
        return partidaActual.getPuntuacionHM();
    }

    /**
     * @param id
     * @return Devuelve la puntuacion del humano en la partida guardada en la posicion (id)
     */
    public int getPuntuacion(int id){
        return Partidas.elementAt(id).getPuntuacionHM();
    }

    /**
     * @return Devuelve la lista de colores de la partida activa
     */
    public List<Colour> getColores(){
        return partidaActual.getColores();
    }

    /**
     * @return Devuelve la lista de colores extra de la partida activa
     */
    public List<Colour> getColoresExtra() {
        return partidaActual.getColoresExtra();
    }

    /**
     * @return Devuelce la IA de la partida actual 0-Fiveguess y 1-Generic
     */
    public int getIA(){ return partidaActual.getIA();}

    /**
     * @return Comprueba si el CodeMaker es el jugador humano
     */
    public boolean isCMhuman(){
        return CMActual.isHuman();
    }

    /**
     * @return Devuelve el codigo secreto
     */
    public List<Colour> getCodigoSecreto(){
        return CMActual.getCombi();
    }


    /**
     * @return Devuelve el intento actual del turno activo
     */
    public int getTurno_actualStep() {
        return turnoActual.getActualSteps();
    }


    /**
     * @return Devuelve si esta cargada la persistencia
     */
    public boolean getCargado() {return cargado;}


    /**
     * @param username
     * @return Devuelve una lista con los records personales del propietario
     */
    public ArrayList<Record> getPersonalRecord(String username){
        return ranking.getRecords(username);
    }

    /**
     * Configura si las repeticiones en las combinaciones son validas en la partida activa
     */
    public void setRepTrue(){
        partidaActual.setRepTrue();
    }

    /**
     * Configura si las repeticiones en las combinaciones no son validas en la partida activa
     */
    public void setRepFalse(){
        partidaActual.setRepFalse();
    }

    /**
     * Configura si los espacios en blanco en las combinaciones son validas en la partida activa
     */
    public void setBlkTrue(){
        partidaActual.setBlkTrue();
    }

    /**
     * Configura si los espacios en blanco en las combinaciones no son validas en la partida activa
     */
    public void setBlkFalse(){
        partidaActual.setBlkFalse();
    }

    /**
     * Configura el rol del jugador humano. True:CM False:CB
     * @param CMhuman
     */
    public void setHuman(boolean CMhuman) {
        partidaActual.setPlayers(CMhuman);
    }

    /**
     * Cofigura el numero de turnos en la partida activa
     * @param turnos
     */
    public void setTurnos(int turnos){
        partidaActual.setTurnos(turnos);
    }

    /**
     * Configura el numero de intentos en la partida activa
     * @param intentos
     */
    public void setIntentos(int intentos){
        partidaActual.setIntentos(intentos);
    }

    /**
     * Configura los colores extra de la partida activa
     * @param extra
     */
    public void setColoresExtra(List<Colour> extra) {
        partidaActual.setColoresExtra(extra);
    }

    /**
     * Configura la IA de la partida actual
     * @param ia
     */
    public void setIA(int ia) {partidaActual.setIA(ia);}

    /**
     * Actualiza la puntuacion de la partida activa
     */
    public void addPuntuacio() {
        int punt = 0;
        switch (partidaActual.getColores().size()) {
            case 6:
                punt += 30;
                break;
            case 7:
                punt += 20;
                break;
            case 8:
                punt += 10;
                break;
        }
        boolean repe = partidaActual.getRepeticiones();
        boolean blk = partidaActual.getBlanks();
        if (repe && blk) punt += 10;
        else if ((repe && !blk) || (!repe && blk)) punt += 20;
        else if (!repe && !blk) punt += 30;
        if (partidaActual.getIsCMHuman()){
            partidaActual.addPuntuacio(punt/(partidaActual.getIntentos()));
        } else {
            punt = punt - turnoActual.getActualSteps() * (punt/(partidaActual.getIntentos()));
            partidaActual.addPuntuacio(punt);
        }
    }

    /**
     * @return Retorna la puntuacion que se puede obtener
     */
    public int getPossiblePuntuationCB(){
        int punt = 0;
        switch (partidaActual.getColores().size()) {
            case 6:
                punt += 30;
                break;
            case 7:
                punt += 20;
                break;
            case 8:
                punt += 10;
                break;
        }
        boolean repe = partidaActual.getRepeticiones();
        boolean blk = partidaActual.getBlanks();
        if (repe && blk) punt += 10;
        else if ((repe && !blk) || (!repe && blk)) punt += 20;
        else if (!repe && !blk) punt += 30;
        punt = punt - turnoActual.getActualSteps() * (punt/(partidaActual.getIntentos()));
        return punt;
    }


    /**
     * @return Comprueba si la partida activa a terminado
     */
    public boolean partida_ended(){
        if (Objects.equals(partidaActual, null)) return true;
        return partidaActual.ended();}

    /**
     * Inicia el CodeMaker como maquina
     */
    public void iniciar_CMMachine(){
        CMActual.machineCM(partidaActual.getColores(), partidaActual.getN_combi(), partidaActual.getBlanks(), partidaActual.getRepeticiones());
    }

    /**
     * Inicia el CodeMaker como humano
     * @param input
     */
    public void iniciar_CMHuman(List<Colour> input){ CMActual.humanCM(input);}

    /**
     * @param intento
     * @return Devuelve los keypegs de un intento
     */
    public List<Integer> askForAnswer(List<Colour> intento) {
        return CMActual.askForAnswer(intento);
    }

    /**
     * @return Devuelve una pista (intento generado por el algoritmo)
     */
    public List<Colour> getPista(){
        return CBActual.getPista();
    }


    /**
     * Actualiza la informacion del turno añadiendole del ultimo intento y respuesta
     * @param intento
     * @param respuesta
     */
    public void updateTurno(List<Colour> intento, List<Integer> respuesta) {

        turnoActual.newTry(intento, respuesta);
        CBActual.newTurn();
    }

    /**
     * @param i
     * @return Devuelve todos los intentos del jugador como Codebreaker en el turno
     */
    public List<Colour> getIntentoCB(int i)
    {
        return turnoActual.getCodigosCB().get(i);
    }

    /**
     * @param i
     * @return Devuelve todas las respuestas del jugador como Codemaker en el turno
     */
    public List<Integer> getIntentoCM(int i)
    {
        return turnoActual.getRespuestasCM().get(i);
    }


    /**
     * Carga las partidas de memoria a local
     * @param partidas
     */
    public void cargarPartidas(Vector<Partida> partidas) {
        Partidas = partidas;
        cargado = true;
    }


    /**
     * Carga en el controlador una partida nueva vacia
     * @param username
     * @param name
     * @return retorna la partida cargada
     */
    public Partida new_game(String username, String name){
        partidaActual = new Partida(name, username);
        CMActual = null;
        CBActual = null;
        turnoActual = null;
        return partidaActual;
    }

    /**
     * Carga en el controlador una partida anteriormente guardada
     * @param id
     */
    public void load_game(int id){
        partidaActual = Partidas.get(id);
        CMActual = new CodeMaker(partidaActual.getIsCMHuman());
        CBActual = new CodeBreaker(!(partidaActual.getIsCMHuman()));
        if (partidaActual.getVturnos().size() > 0) {
            turnoActual = partidaActual.getVturnos().get(partidaActual.getTurno_act());
            CMActual.humanCM(turnoActual.getCodigoSolucion());
        }
        else turnoActual = null;
        if (getIA() == 0) iniciar_FiveG();
        else if(getIA() == 1) iniciar_Genetic();
    }

    public void delete_game(String name){
        if (partidaActual != null && partidaActual.getNombre().equals(name)) {
            partidaActual = null;
            CMActual = null;
            CBActual = null;
            turnoActual = null;
            Machine = null;
        }
        Partidas.remove(checkPartidas(name));
    }

    /**
     * @return Inidica si el ranking se ha cargado de persistencia
     */
    public boolean IsRankingCharged(){
        return ranking.IsRankingCharged();
    }

    /**
     * @return Guarda la partida activa en el vector de partidas
     */
    public Partida save_game() {
        if (!Objects.equals(turnoActual, null)) partidaActual.addTurno(turnoActual);
        int id = checkPartidas(partidaActual.getNombre());
        if (id >= 0) Partidas.set(id, partidaActual);
        else Partidas.add(partidaActual);
        return partidaActual;
    }

    /**
     * Comprueba si la partida activa ya esta guardada
     * @param name
     * @return -1 si no etsa guardada, id de la partida si esta guardada
     */
    public int checkPartidas(String name){

        for (int i = 0; i < Partidas.size(); ++i){
            if (Partidas.get(i).getNombre().equals(name)) return i;
        }
        return -1;
    }

    /**
     * @return Comprueba si el turno ha empezado
     */
    public boolean turno_empezado() {
        return !(Objects.equals(turnoActual, null));
    }


    /**
     * Inicia la partida
     */
    public void iniciar_Partida() {

        //elegir codigo
        if (partidaActual.getIsCMHuman()) {
            CMActual = new CodeMaker(true);
            CBActual = new CodeBreaker(false);
        } else {
            CMActual = new CodeMaker(false);
            CBActual = new CodeBreaker(true);
        }
        if (partidaActual.getTurno_act() == -1) partidaActual.nextTurn();
    }

    /**
     * Finaliza la partida, actualiza record y la borra de las partidas guardadas
     */
    public void finPartida(){
        AddRecord(partidaActual.getUsername(), partidaActual.getPuntuacionHM());
        int index = checkPartidas(partidaActual.getNombre());
        if (index >= 0) Partidas.remove(index);
        partidaActual = null;
    }

    /**
     * Añade un usuario con su puntuacion a la lista de records
     * @param username
     * @param puntuacio
     */
    public void AddRecord(String username, int puntuacio){
        ranking.AddRecord(username, puntuacio);
    }

    /**
     *  Incia el turno
     */
    public void iniciar_Turno(){
        turnoActual = new Turno(CMActual.getCombi(), partidaActual.getIsCMHuman(), partidaActual.getIntentos());
    }

    /**
     * Finaliza el turno, y actualiza la informacion en la partida activa
     */
    public void finTurno() {
        switchrols();
        partidaActual.addTurno(turnoActual);
        turnoActual = null;
        partidaActual.nextTurn();
    }

    /**
     * Inicia el algoritmo de FIVEGUESS
     */
    public void iniciar_FiveG(){
        Machine = new FiveGuess(partidaActual.getIntentos(), partidaActual.getRepeticiones(), partidaActual.getBlanks(), partidaActual.getColoresExtra().size());
    }

    /**
     *  Inicia el algoritmo genetic
     */
    public void iniciar_Genetic(){
        Machine = new Genetic(partidaActual.getIntentos(), partidaActual.getRepeticiones(), partidaActual.getBlanks(), partidaActual.getColoresExtra().size());
    }

    /**
     * Inicia y calcula la solucion
     * @throws Exception
     */
    public void iniciar_solve() throws Exception {
        int i = partidaActual.getIA();
        if (i == 0) iniciar_FiveG();
        else iniciar_Genetic();
        List<List<Integer>> aux = Machine.solve(color2int(CMActual.getCombi()));
        List<List<Colour>> auxC = new Vector<>();
        for (List<Integer> integers : aux) {
            auxC.add(int2color(integers));
        }
        CBActual.setAlgorithmSol(auxC);
    }

    /**
     * Comprueba que el intento sea correcto segun las normas de la partida activa
     * @param intento
     * @return
     */
    public boolean checkIntento(List<Colour> intento){
        Vector<Colour> used_col = new Vector<>();
        for (Colour colour : intento) {
            if (used_col.size() > 0 && !partidaActual.getRepeticiones() && used_col.contains(colour)) return false;
            if (0 < used_col.size() && !partidaActual.getBlanks() && colour.equals(Colour.VACIO)) return false;
            used_col.add(colour);
        }
        return true;
    }

    /**
     * Devuelve el tamaño del vector de las partidas guardadas
     * @return integer del tamaño del vector partidas
     */
    public int getPartidas_size(){
        return Partidas.size();
    }

    /**
     * Traduce un color a un caracter (su inicial en ingles)
     * @param aux_color
     * @return el caracter correspondiente al color
     */
    public String color2char (Colour aux_color){
        switch (aux_color) {
            case LILA:
                return "P";
            case AZUL:
                return "B";
            case NARANJA:
                return "O";
            case VERDE:
                return "G";
            case VACIO:
                return "_";
            case AMARILLO:
                return "Y";
            case ROJO:
                return "R";

            //extras
            case CYAN:
                return "C";
            case MAGENTA:
                return "M";
            case TURQUESA:
                return "T";
            default:
                return "_";
        }
    }

    /**
     * Devuelve en String que rol es el jugador humano en la partida activa
     * @return
     */
    public String getHumanRol(){
        if (partidaActual.getIsCMHuman()) return "CM";
        return "CB";
    }

    /**
     * Devuelve en String que rol es el jugador humano en la partida guardada en posicion(id)
     * @param id
     * @return
     */
    public String getHumanRol(int id){
        if (Partidas.get(id).getIsCMHuman()) return "CM";
        return "CB";
    }

    /**
     * Pasa de List<Colour> a List<Integer> una lista de colores
     * @param list
     * @return
     */
    public List<Integer> color2int(List<Colour> list) {

        List<Integer> ret = new ArrayList<>(list.size());
        List<Colour> Extra = getColoresExtra();
        int intCyan = -1, intMagenta = -1, intTurquesa = -1;
        for (int i = 0; i < Extra.size(); ++i){
            switch(Extra.get(i)){
                case CYAN:
                    intCyan = 6+i;
                    break;
                case MAGENTA:
                    intMagenta = 6+i;
                    break;
                case TURQUESA:
                    intTurquesa = 6+i;
                    break;
            }
        }

        for (Colour colour : list) {
            switch (colour) {
                case AZUL:
                    ret.add(1);
                    break;
                case LILA:
                    ret.add(4);
                    break;
                case ROJO:
                    ret.add(2);
                    break;
                case VACIO:
                    ret.add(getN_color());
                    break;
                case VERDE:
                    ret.add(0);
                    break;
                case NARANJA:
                    ret.add(5);
                    break;
                case AMARILLO:
                    ret.add(3);
                    break;

                //extras
                case TURQUESA:
                    ret.add(intTurquesa);
                    break;
                case MAGENTA:
                    ret.add(intMagenta);
                    break;
                case CYAN:
                    ret.add(intCyan);
                    break;
            }
        }
        return ret;
    }

    /**
     * Pasa de List<Integer> a List<Colour> una lista de colores
     * @param lista
     * @return
     */
    public List<Colour> int2color(List<Integer> lista) {
        List<Colour> ret = new Vector<>();
        List<Colour> Extra = getColoresExtra();
        int intCyan = -1, intMagenta = -1, intTurquesa = -1;
        for (int i = 0; i < Extra.size(); ++i){
            switch(Extra.get(i)){
                case CYAN:
                    intCyan = 6+i;
                    break;
                case MAGENTA:
                    intMagenta = 6+i;
                    break;
                case TURQUESA:
                    intTurquesa = 6+i;
                    break;
            }
        }
        for (Integer integer : lista) {
            switch (integer) {
                case 1:
                    ret.add(Colour.AZUL);
                    break;
                case 4:
                    ret.add(Colour.LILA);
                    break;
                case 2:
                    ret.add(Colour.ROJO);
                    break;
                case 0:
                    ret.add(Colour.VERDE);
                    break;
                case 5:
                    ret.add(Colour.NARANJA);
                    break;
                case 3:
                    ret.add(Colour.AMARILLO);
                    break;
                default:
                    if(integer.equals(getN_color())) ret.add(Colour.VACIO);
                    else if (integer.equals(intCyan)) ret.add(Colour.CYAN);
                    else if (integer.equals(intMagenta)) ret.add(Colour.MAGENTA);
                    else if (integer.equals(intTurquesa)) ret.add(Colour.TURQUESA);
            }
        }
        return ret;
    }

    /**
     * Cambia los roles de los jugadores
     */
    private void switchrols(){
        CBActual = new CodeBreaker(!CBActual.CBPersona());
        CMActual = new CodeMaker(!CMActual.isHuman());
        partidaActual.setPlayers(!(partidaActual.getIsCMHuman()));
    }



}
