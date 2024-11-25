package FONTS.src.main.domain.controllers;
import FONTS.src.main.domain.classes.Record;
import FONTS.src.main.domain.classes.enums.Colour;
import FONTS.src.main.persistence.controllers.PersistenceController;

import java.util.ArrayList;
import java.util.List;


public class DomainController {
    ProfileController ctrlPerfil;
    ControladorPartida ctrlPartida;
    PersistenceController ctrlPersistencia;

    /**
     * Funcion creadora del controlador de dominio
     */
    public DomainController() {
        ctrlPerfil = new ProfileController();
        ctrlPersistencia = new PersistenceController();
        ctrlPartida = new ControladorPartida();
    }

    /**
     * @param newName
     * @param newPassword
     * @return Indica si el usuario se ha podido registrar
     */
    public boolean signIn(String newName, String newPassword) {
        boolean signedIn = false;
        if (ctrlPersistencia.signin(newName, newPassword)) {
            signedIn = ctrlPerfil.signIn(newName, newPassword);
            return signedIn;
        }
        return signedIn;
    }

    /**
     *
     * @param username
     * @param password
     * @return Retorna si el usuario se ha podido registrar
     */
    public boolean logIn(String username, String password) {
        if (ctrlPersistencia.login(username, password)) {
            ctrlPerfil.logIn(username, password);
            return true;
        }
        return false;
    }

    /**
     * Cierra la cession del usuario activo
     */
    public void logOut() {
        ctrlPerfil.logOut();
    }

    /**
     * Añade el record a la lista de ranking con todos los records guardados
     * @param username
     * @param puntuacio
     */
    public void AddRecord(String username, int puntuacio){
        ctrlPartida.AddRecord(username,puntuacio);
    }

    /**
     *  Lee el ranking global
     */
    public void readRanking()
    {
        ArrayList<String> ranking = ctrlPersistencia.getRankingPersistencia();
        for (int i = 0; i < ranking.size(); i += 2) {
            {
                String username = ranking.get(i);
                int points = Integer.parseInt(ranking.get(i + 1));
                AddRecord(username, points);
            }
        }
    }

    /**
     * @param username
     * @return Consulta el record personal de un usuario determinado 'username'
     */
    public ArrayList<Record> consultPR(String username) {
        return ctrlPartida.getPersonalRecord(username);
    }

    /**
     * @return Retorna el nombre de una partida
     */
    public String getNombre() {
        return ctrlPartida.getNombre();
    }

    /**
     * @param id
     * @return Retorna el nombre de una partida según su id
     */
    public String getNombre(int id) {
        return ctrlPartida.getNombre(id);
    }

    /**
     * Funcion que establece la inteligencia que va a usar el programa
     * @param ia
     */
    public void setIA(boolean ia) {
        if (ia) ctrlPartida.setIA(0);
        else ctrlPartida.setIA(1);
    }

    /**
     * Funcion para añadir los colores extras
     * @param extra
     */
    public void setColoresExtra(List<Colour> extra) {
        ctrlPartida.setColoresExtra(extra);
    }

    /**
     * Funcion para definir el numero de turnos de una partida
     * @param turnos
     */
    public void setTurnos(int turnos) {
        ctrlPartida.setTurnos(turnos);
    }

    /**
     * Funcion para definir el numero de intentos de una partida
     * @param intentos
     */
    public void setIntentos(int intentos) {
        ctrlPartida.setIntentos(intentos);
    }

    /**
     * Funcion para aceptar repeticiones
     */
    public void setRepTrue() {
        ctrlPartida.setRepTrue();
    }

    /**
     * Funcion para prohibir repeticiones
     */
    public void setRepFalse() {
        ctrlPartida.setRepFalse();
    }

    /**
     * Funcion para aceptar espacios en blanco
     */
    public void setBlkTrue() {
        ctrlPartida.setBlkTrue();
    }

    /**
     * Funcion para aceptar espacios en blanco
     */
    public void setBlkFalse() {
        ctrlPartida.setBlkFalse();
    }

    /**
     * Indica que el code maker es el jugador
     * @param CMhuman
     */
    public void setHuman(boolean CMhuman) {
        ctrlPartida.setHuman(CMhuman);
    }

    /**
     * @return Indica el numero de intentos realizados
     */
    public int getIntentos() {
        return ctrlPartida.getIntentos();
    }

    /**
     * @return Devuelve el numero de colores
     */
    public int getN_color() {
        return ctrlPartida.getN_color();
    }


    /**
     * @return Devuelve el numero de turnos de la partida activa
     */
    public int getTurnos() {
        return ctrlPartida.getTurnos();
    }

    /**
     * @param id
     * @return Devuelve el numero de turnos de la partida guardada en posicion (id)
     */
    public int getTurnos(int id) {
        return ctrlPartida.getTurnos(id);
    }

    /**
     * @return Devuelve la lista de colores de la partida activa
     */
    public List<Colour> getColores() {
        return ctrlPartida.getColores();
    }

    /**
     * @return  Devuelve si estan permitidas las repeticiones de colores en las combinaciones de la partida activa
     */
    public boolean getRepeticiones() {
        return ctrlPartida.getRepeticiones();
    }

    /**
     * @return Devuelve si estan permitidas los espacios en blanco en las combinaciones de la partida activa
     */
    public boolean getBlanks() {
        return ctrlPartida.getBlanks();
    }

    /**
     * @param id
     * @return Devuelve la puntuacion del humano en la partida guardada en la posicion (id)
     */
    public int getPuntuacion(int id) {
        return ctrlPartida.getPuntuacion(id);
    }

    /**
     * @return Devuelve la puntuacion del humano en la partida activa
     */
    public int getPuntuacion() {
        return ctrlPartida.getPuntuacion();
    }

    /**
     * @return Devuelve el username del perfil activo
     */
    public String getUsername() {
        return ctrlPerfil.getUsername();
    }

    /**
     * @return Inidica si el ranking se ha cargado de persistencia
     */
    public boolean IsRankingCharged(){
        return ctrlPartida.IsRankingCharged();
    }
    /**
     * @param id
     * @return Devuelve el username de quien ha creado la partida en posicion (id)
     */
    public String getUsername(int id) {
        return ctrlPartida.getUsername(id);
    }

    /**
     * @param id
     * @return Devuelve en que turno esta la partida guardada en poscicion (id)
     */
    public int getTurno_act(int id) {
        return ctrlPartida.getTurno_act(id);
    }


    /**
     * @return Indica si el CodeMaker es el jugador
     */
    public boolean isCMhuman() {
        return ctrlPartida.isCMhuman();
    }


    /**
     * @return Devuelve el intento actual del turno activo
     */
    public int getTurno_actualStep() {
        return ctrlPartida.getTurno_actualStep();
    }

    /**
     * @return Devuelve una pista generada por el algoritmo
     */
    public List<Colour> getPista() {
        return ctrlPartida.getPista();
    }

    /**
     * @return Devuelve el tamaño del vector de las partidas guardadas
     */
    public int getPartidas_size() {
        return ctrlPartida.getPartidas_size();
    }

    /**
     * @return Devuelve en String que rol es el jugador humano en la partida activa
     */
    public String getHumanRol() {
        return ctrlPartida.getHumanRol();
    }

    /**
     * @param id
     * @return Devuelve en String que rol es el jugador humano en la partida guardada en posicion(id)
     */
    public String getHumanRol(int id) {
        return ctrlPartida.getHumanRol(id);
    }

    /**
     * @param intento
     * @return Devuelve los keypegs de un intento
     */
    public List<Integer> askForAnswer(List<Colour> intento) {
        return ctrlPartida.askForAnswer(intento);
    }


    /**
     * Carga las partidas guardadas en persitencia local de 'username'
     * @param username
     */
    public void load_disc_games(String username) {
        ctrlPartida.cargarPartidas(ctrlPersistencia.listearPartidas(username));
    }


    /**
     * Carga en el controlador una partida nueva vacia
     * @param username
     * @param name
     */
    public void new_game(String username, String name) {
        if (!ctrlPartida.getCargado()) {
            load_disc_games(ctrlPerfil.getUsername());
        }
        ctrlPersistencia.guardarPartida(ctrlPartida.new_game(username, name));
    }

    /**
     * Carga en el controlador una partida anteriormente guardada
     * @param id
     */
    public void load_game(int id) {
        if (!ctrlPartida.getCargado()) {
            load_disc_games(ctrlPerfil.getUsername());
        }
        ctrlPartida.load_game(id);
    }

    /**
     * Elimina la partida con nombre 'name'
     * @param name
     */
    public void delete_game(String name) {
        if (!ctrlPartida.getCargado()) {
            load_disc_games(ctrlPerfil.getUsername());
        }
        ctrlPersistencia.borrarPartida(getUsername(checkPartidas(name)), name);
        ctrlPartida.delete_game(name);
    }

    /**
     * Guarda la partida activa en el vector de partidas
     */
    public void save_game() {
        if (!ctrlPartida.getCargado()) {
            load_disc_games(ctrlPerfil.getUsername());
        }
        ctrlPersistencia.guardarPartida(ctrlPartida.save_game());
    }


    /**
     * @return Retorna si la partida ha finalizado
     */
    public boolean partida_ended() {
        return ctrlPartida.partida_ended();
    }


    /**
     * Añade la puntuacion al jugador
     */
    public void addPuntuacio() {
        ctrlPartida.addPuntuacio();
    }

    /**
     * @return Indica si el turno ha iniciado
     */
    public boolean turno_empezado() {
        return ctrlPartida.turno_empezado();
    }

    /**
     * Inicia la partida
     */
    public void iniciar_Partida() {

        ctrlPartida.iniciar_Partida();
    }

    /**
     * Finaliza la partida, actualiza record y la borra de las partidas guardadas
     */
    public void finPartida() {
        ctrlPersistencia.savePoints(ctrlPerfil.getUsername(), ctrlPartida.getPuntuacion());
        ctrlPersistencia.borrarPartida(ctrlPerfil.getUsername(), ctrlPartida.getNombre());
        ctrlPartida.finPartida();
    }

    /**
     * @return Devuelve el ranking global
     */
    public ArrayList<Record> getRanking() {
        return ctrlPartida.getRanking();
    }

    /**
     * Inicia el turno
     */
    public void iniciar_Turno() {
        ctrlPartida.iniciar_Turno();
    }

    /**
     * Actualiza la informacion del turno añadiendole del ultimo intento y respuesta
     * @param intento
     * @param respuesta
     */
    public void updateTurno(List<Colour> intento, List<Integer> respuesta) {
        ctrlPartida.updateTurno(intento, respuesta);
    }

    /**
     * Finaliza el turno, y actualiza la informacion en la partida activa
     */
    public void finTurno() {
        ctrlPartida.finTurno();
    }

    /**
     * Inicia el calculo de la solucion con el algortimo Fiveguess
     */
    public void iniciar_FiveG() {
        ctrlPartida.iniciar_FiveG();
    }

    /**
     * Inicia el calculo de la solucion con el algortimo genetico
     */
    public void iniciar_Genetic() {
        ctrlPartida.iniciar_Genetic();
    }

    /**
     *  Inicia y calcula la solucion
     */
    public void iniciar_solve() throws Exception {
        if (ctrlPartida.getIA() == 0) ctrlPartida.iniciar_FiveG();
        if (ctrlPartida.getIA() == 1) ctrlPartida.iniciar_Genetic();
        ctrlPartida.iniciar_solve();
    }

    /**
     * @return Devuelce la IA de la partida actual 0-Fiveguess y 1-Generic
     */
    public int getIA()
    {
        return ctrlPartida.getIA();
    }

    /**
     * @return Devuelve la puntuacion asociada
     */
    public int getPossiblePuntuationCB(){ return ctrlPartida.getPossiblePuntuationCB();}

    /**
     * @return Devuelve la lista de colores extra de la partida activa
     */
    public List<Colour> getColoresExtra()
    {
        return ctrlPartida.getColoresExtra();
    }

    /**
     * @param name
     * @return Comprueba si la partida activa ya esta guardada
     */
    public int checkPartidas(String name) {
        return ctrlPartida.checkPartidas(name);
    }

    /**
     * @return Retorns el codigo generado por el CM
     */
    public List<Colour> getCodigoSecreto() {
        return ctrlPartida.getCodigoSecreto();
    }

    /**
     * @param intento
     * @return Retorna si un intento es valido segun las normas de la partida
     */
    public boolean checkIntento(List<Colour> intento) {
        return ctrlPartida.checkIntento(intento);
    }

    /**
     * Inicia el CodeMaker como humano
     * @param input
     */
    public void iniciar_CMHuman(List<Colour> input) {
        ctrlPartida.iniciar_CMHuman(input);
    }

    /**
     * Inicia el CodeMaker como maquina
     */
    public void iniciar_CMMachine() {
        ctrlPartida.iniciar_CMMachine();
    }

    /**
     * @param i
     * @return Devuelve el intento del Code Breaker
     */
    public List<Colour> getIntentoCB(int i)
    {
        return ctrlPartida.getIntentoCB(i);
    }

    /**
     * @param i
     * @return Devuelve el intento del Code Maker
     */
    public List<Integer> getIntentoCM(int i) {
        return ctrlPartida.getIntentoCM(i);
    }

}