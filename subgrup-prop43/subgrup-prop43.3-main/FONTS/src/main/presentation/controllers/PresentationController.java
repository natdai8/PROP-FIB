package FONTS.src.main.presentation.controllers;
import FONTS.src.main.domain.classes.Record;
import FONTS.src.main.domain.classes.enums.Colour;
import FONTS.src.main.domain.controllers.DomainController;
import FONTS.src.main.presentation.views.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class PresentationController {

    static DomainController ctrl = new DomainController();
    static normas normas = null;

    /**
     * @param username Nombre de la partida
     * @return Comprueba si la partida activa ya esta guardada
     */
    public int checkPartidas(String username) {return ctrl.checkPartidas(username);}
    /**
     * @param newName nuevo nombre de usuario
     * @param newPassword nuevo password
     * @return Indica si el usuario se ha podido registrar
     */
    public boolean signIn (String newName, String newPassword)
    {
        return ctrl.signIn(newName, newPassword);
    }


    /**
     * @param username
     * @param password
     * @return Retorna si el usuario se ha podido registrar
     */
    public boolean logIn (String username, String password)
    {
        return ctrl.logIn(username, password);
    }

    /**
     * Cierra la cession del usuario activo
     */
    public void logOut ()
    {
        ctrl.logOut();
    }

    /**
     * @param username
     * @return Consulta el record personal de un usuario determinado 'username'
     */
    public ArrayList<Record> consultPR (String username)
    {
        return ctrl.consultPR(username);
    }

    /**
     * Carga en el controlador una partida nueva vacia
     * @param username
     * @param name
     */
    public void new_game(String username, String name){
        ctrl.new_game(username, name);
    }

    /**
     * Carga en el controlador una partida anteriormente guardada
     * @param id
     */
    public void load_game(int id){
        ctrl.load_game(id);
    }

    public String getUsername (){
        return ctrl.getUsername();
    }

    public String getNombre(){
        return ctrl.getNombre();
    }

    /**
     * @param id
     * @return Retorna el nombre de una partida según su id
     */
    public String getNombre(int id){
        return ctrl.getNombre(id);
    }

    /**
     * @return Inidica si el ranking se ha cargado de persistencia
     */
    public boolean IsRankingCharged(){
        return ctrl.IsRankingCharged();
    }

    /**
     * Guarda la partida activa en el vector de partidas
     */
    public void save_game() {
        ctrl.save_game();
    }

    /**
     * Funcion que establece la inteligencia que va a usar el programa
     * @param ia
     */
    public void setIA(boolean ia) {
        ctrl.setIA(ia);
    }

    /**
     * Funcion para añadir los colores extras
     * @param extra
     */
    public void setColoresExtra(List<Colour> extra) {
        ctrl.setColoresExtra(extra);
    }

    /**
     * Funcion para definir el numero de turnos de una partida
     * @param turnos
     */
    public void setTurnos(int turnos){
        ctrl.setTurnos(turnos);
    }

    /**
     * Funcion para definir el numero de intentos de una partida
     * @param intentos
     */
    public void setIntentos(int intentos){
        ctrl.setIntentos(intentos);
    }

    /**
     * Funcion para aceptar repeticiones
     */
    public void setRepTrue(){
        ctrl.setRepTrue();
    }

    /**
     * Funcion para prohibir repeticiones
     */
    public void setRepFalse(){
        ctrl.setRepFalse();
    }

    /**
     * Funcion para aceptar espacios en blanco
     */
    public void setBlkTrue(){
        ctrl.setBlkTrue();
    }

    /**
     * Funcion para prohibir espacios en blanco
     */
    public void setBlkFalse(){
        ctrl.setBlkFalse();
    }

    /**
     * Indica que el code maker es el jugador
     * @param CMhuman
     */
    public void setHuman(boolean CMhuman) {
        ctrl.setHuman(CMhuman);
    }

    /**
     * @return Indica el numero de intentos realizados
     */
    public int getIntentos(){
        return ctrl.getIntentos();
    }

    /**
     * @return Devuelve el numero de turnos de la partida activa
     */
    public int getTurnos(){
        return ctrl.getTurnos();
    }

    /**
     * @param id
     * @return Devuelve el numero de turnos de la partida guardada en posicion (id)
     */
    public int getTurnos(int id){
        return ctrl.getTurnos(id);
    }

    /**
     * @return Devuelve la lista de colores de la partida activa
     */
    public List<Colour> getColores(){
        return ctrl.getColores();
    }

    /**
     * @return Devuelve si estan permitidas las repeticiones de colores en las combinaciones de la partida activa
     */
    public boolean getRepeticiones(){
        return ctrl.getRepeticiones();
    }

    /**
     * @return Devuelve si estan permitidas los eespacios en blanco en las combinaciones de la partida activa
     */
    public boolean getBlanks(){
        return ctrl.getBlanks();
    }

    /**
     *
     * @param id
     * @return Devuelve la puntuacion del humano en la partida guardada en la posicion (id)
     */
    public int getPuntuacion(int id){
        return ctrl.getPuntuacion(id);
    }

    /**
     * @return Devuelve la puntuacion del humano en la partida activa
     */
    public int getPuntuacion(){
        return ctrl.getPuntuacion();
    }

    /**
     *
     * @param id
     * @return Devuelve el username de quien ha creado la partida en posicion (id)
     */
    public String getUsername(int id){
        return ctrl.getUsername(id);
    }

    /**
     * @param id
     * @return Devuelve en que turno esta la partida guardada en poscicion (id)
     */
    public int getTurno_act(int id){
        return ctrl.getTurno_act(id);
    }

    public boolean partida_ended(){ return ctrl.partida_ended();}

    public boolean isCMhuman(){
        return ctrl.isCMhuman();
    }

    public int getTurno_actualStep() {
        return ctrl.getTurno_actualStep();
    }
    public void addPuntuacio() {
        ctrl.addPuntuacio();
    }

    public void finPartida(){
        ctrl.finPartida();
    }
    public ArrayList<Record> getRanking(){
        return ctrl.getRanking();
    }

    public void updateTurno(List<Colour> intento, List<Integer> respuesta) {
        ctrl.updateTurno(intento, respuesta);
        int i = 0;
    }
    public void finTurno() {
        ctrl.finTurno();
    }

    public void iniciar_FiveG(){
        ctrl.iniciar_FiveG();
    }
    public void iniciar_Genetic(){
        ctrl.iniciar_Genetic();
    }

    public boolean checkIntento(List<Colour> intento){
        return ctrl.checkIntento(intento);
    }

    public List<Colour> getCodigoSecreto(){
        return ctrl.getCodigoSecreto();
    }

    public List<Colour> getPista(){
        return ctrl.getPista();
    }

    public void iniciar_CMHuman(List<Colour> input){ ctrl.iniciar_CMHuman(input);}



    public int getPartidas_size(){
        return ctrl.getPartidas_size();
    }

    public String getHumanRol(){
        return ctrl.getHumanRol();
    }

    public String getHumanRol(int id){
        return ctrl.getHumanRol(id);
    }

    public List<Integer> askForAnswer(List<Colour> intento) {
        return ctrl.askForAnswer(intento);
    }


    public void delete_game(String name) {
        ctrl.delete_game(name);
    }

    public void cargarRanking(){
        ctrl.readRanking();
    }

    public void changeWindowToLogin ()
    {
        inicioSesion inicio = new inicioSesion();
        inicio.setVisible(true);
        inicio.setSize(600, 600);

    }

    public void changeWindowToSignin ()
    {
        registro reg = new registro();
        reg.setVisible(true);
        reg.setSize(600, 600);
    }

    public void changeWindowToStartMenu ()
    {
        menuInicio menuI = new menuInicio();
        menuI.setVisible(true);
        menuI.setSize(600, 600);
    }

    public void changeWindowToRanking ()
    {
        ConsultarRanking ranking = new ConsultarRanking();
        ranking.setVisible(true);
        ranking.setSize(600, 600);
    }
    public void changeWindowToPersonalGames (String user)
    {
        GestionarPartidas gestionarPartidas = new GestionarPartidas(user);
        ctrl.getPartidas_size();
        gestionarPartidas.setVisible(true);
        gestionarPartidas.setSize(600, 600);
    }
    public void changeWindowToPersonalRecords (String user)
    {
        ConsultarRecords records = new ConsultarRecords(user);
        records.setVisible(true);
        records.setSize(600, 600);
    }

    public void changeWindowToStartPlay(int i)
    {
        if (!ctrl.partida_ended()) {
            if (!ctrl.turno_empezado())
            {
                ctrl.iniciar_Partida();
                int ia = ctrl.getIA();
                if(ia == 0) ctrl.iniciar_FiveG();
                else ctrl.iniciar_Genetic();
            }
            EmpezarTurno empezarTurno = new EmpezarTurno(i);
            empezarTurno.setVisible(true);
            empezarTurno.setSize(600, 600);
        }
        else {
            changeWindowToFinPartida();
        }
    }

    public void changeWindowToPlay() throws Exception {
        if (ctrl.isCMhuman()) {
            if (ctrl.turno_empezado()) {
                //ctrl.iniciar_Turno();
                ctrl.iniciar_solve();
                CM_tablero cmTablero = new CM_tablero(ctrl.getN_color());
                cmTablero.setVisible(true);
                cmTablero.setSize(600,600);
            }
            else {
                ctrl.iniciar_Turno();
                CM_CodeCreator codeCreator = new CM_CodeCreator(ctrl.getN_color());
                codeCreator.setVisible(true);
                codeCreator.setSize(600, 600);
            }
        }
        else {
            if (ctrl.turno_empezado()) {
                ctrl.iniciar_CMMachine();
                ctrl.iniciar_solve();
                CB_tablero cbTablero = new CB_tablero(ctrl.getN_color());
                cbTablero.setVisible(true);
                cbTablero.setSize(600,600);
            }
            else {
                ctrl.iniciar_Turno();
                ctrl.iniciar_CMMachine();
                ctrl.iniciar_solve();
                CB_tablero cbTablero = new CB_tablero(ctrl.getN_color());
                cbTablero.setVisible(true);
                cbTablero.setSize(600, 600);
            }
        }
    }

    public int getPossiblePuntuationCB(){ return ctrl.getPossiblePuntuationCB();}

    public void changeWindowToPlayCM() throws Exception {
        ctrl.iniciar_Turno();
        ctrl.iniciar_solve();
        CM_tablero cmTablero = new CM_tablero(ctrl.getN_color());
        cmTablero.setVisible(true);
        cmTablero.setSize(600,600);
    }

    public void changeWindowToCrearPartida ()
    {
        CrearPartida crearPartida = new CrearPartida();
        crearPartida.setVisible(true);
        crearPartida.setSize(600,600);
    }

    public void changeWindowToPrincipalMenu (String user)
    {
        ctrl.load_disc_games(user);
        menuPrincipal menuP = new menuPrincipal();
        menuP.setVisible(true);
        menuP.setSize(600, 600);

    }

    public void changeWindowToFinPartida ()
    {
        FinPartida finPartida = new FinPartida();
        finPartida.setVisible(true);
        finPartida.setSize(600, 600);
    }

    public void openWindowNormas() {
        if (normas != null) return;
        normas = new normas();
        normas.cargar_valores();
        normas.setVisible(true);
        normas.setSize(600, 600);
    }

    public void closeWindowNormas() {
        normas.setVisible(false);
        normas = null;
    }

    public List<Colour> getColoresExtra()
    {
        return ctrl.getColoresExtra();
    }
    
    public List<Colour> getIntentoCB(int i)
    {
        return ctrl.getIntentoCB(i);
    }

    public List<Integer> getIntentoCM(int i) {
        return ctrl.getIntentoCM(i);
    }

    public Color EnumtoColor(Colour c) {
        Color newColor;
        switch (c) {
            case VACIO:
                newColor = new Color(255, 255, 255);
                return newColor;
            case VERDE:
                newColor = new Color(0, 255, 0);
                return newColor;
            case AZUL:
                newColor = new Color(0, 0, 255);
                return newColor;
            case ROJO:
                newColor = new Color(255, 0, 0);
                return newColor;
            case AMARILLO:
                newColor = new Color(255, 255, 0);
                return newColor;
            case LILA:
                newColor = new Color(108, 70, 117);
                return newColor;
            case NARANJA:
                newColor = new Color(255, 128, 0);
                return newColor;
            case CYAN:
                newColor = new Color(0, 255, 255);
                return newColor;
            case TURQUESA:
                newColor = new Color(28, 193, 143);
                return newColor;
            case MAGENTA:
                newColor = new Color(255, 0, 255);
                return newColor;
        }
        return null;
    }


}
