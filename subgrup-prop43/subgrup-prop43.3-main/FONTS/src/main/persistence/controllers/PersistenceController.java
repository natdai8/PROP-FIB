package FONTS.src.main.persistence.controllers;

import FONTS.src.main.persistence.classes.GestorPerfil;
import FONTS.src.main.persistence.classes.GestorRanking;

import FONTS.src.main.domain.classes.Partida;
import FONTS.src.main.persistence.classes.GestorPartida;

import java.util.*;

public class PersistenceController {

    private GestorPartida GestorPartida;
    private GestorPerfil gPerfil;
    private GestorRanking gRanking;

    /**
     * Constructora
     */
    public PersistenceController() {
        GestorPartida = new GestorPartida();
        gPerfil = new GestorPerfil();
        gRanking = new GestorRanking();
    }

    /**
     * Guarda una partida en disco
     * @param partida partida a guardar
     */
    public void guardarPartida(Partida partida)  {
        GestorPartida.guardarPartida(partida);
    }

    /**
     * Devuelve un vector de partidas guardadas en disco que su creador es el usuario
     * @param username usuario propietario
     * @return Vector de Partidas
     */
    public Vector<Partida> listearPartidas(String username)  {
        return GestorPartida.listearPartidas(username);
    }

    /**
     * Borra una partida en disco
     * @param username usuario propietario de la partida
     * @param name nombre de la partida
     */
    public void borrarPartida(String username, String name)  {
        GestorPartida.borrarPartida(username, name);
    }


    /**
     * Control se sesiones para el inicio de sesión por parte de persistencia
     * @param username Nombre con el que se intenta iniciar la sesión
     * @param password Contraseña con la que se intenta iniciar la sesión
     * @return Devuelve si en el credentials.txt existe "usernameLogin" y "passwordLogin"
     */
    public boolean login (String username, String password)
    {
        return gPerfil.login(username, password);
    }

    /**
     * Control se sesiones para el registro por parte de persistencia
     * @param username Nombre con el que se intenta registrar
     * @param password Contraseña con el que se intenta registrar
     * @return Devuelve si existe ya un nombre de usuario "newUsername" para no repetir nombres de usuario
     */
    public boolean signin (String username, String password)
    {
        return gPerfil.signin(username, password);
    }

    /**
     * Para guardar los récords en el fichero ranking.txt
     * @param username Nombre de usuario que quiere guardar los puntos
     * @param points La puntuación en cuestión
     */
    public void savePoints (String username, int points)
    {
        gRanking.savePoints(username, points);
    }

    /**
     * Para guardar los récords de los usuarios en memoria
     * @return Devuelve una estructura de datos que contiene información de los récords de los usuarios del juego
     */
    public ArrayList<String> getRankingPersistencia ()
    {
        return gRanking.getRankingPersistencia();
    }

}