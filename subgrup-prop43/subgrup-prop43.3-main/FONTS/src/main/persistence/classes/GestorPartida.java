package FONTS.src.main.persistence.classes;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import FONTS.src.main.domain.classes.Partida;
import FONTS.src.main.domain.classes.Turno;
import FONTS.src.main.domain.classes.enums.Colour;


public class GestorPartida {

    File saveFile;
    private FileReader fr;
    private FileWriter fw;
    private BufferedReader br;
    private PrintWriter pw;


    /**
     * Constructora
     */
    public GestorPartida() {
        try{
            saveFile = new File("FONTS/src/main/persistence/classes/data/savePartida.txt");
            fr = new FileReader(saveFile);
            fw = new FileWriter(saveFile, true);
            br = new BufferedReader(fr);
            br.mark(8192);
            pw = new PrintWriter(fw);

        } catch (IOException e) {
            System.err.println("RUNTIME UNHANDLED EXCEPTION -> IOException when trying to read savePartidas file! E: " + e.toString());
            System.err.println(Thread.currentThread().getStackTrace().toString());
            System.exit(-2);
        }
    }

    /**
     * Guarda en disco la partida pasada por parametro
     * @param partida partida a guardar
     */
    public void guardarPartida(Partida partida)  {
        String data = ':' + partida.getUsername() + ',' + partida.getNombre() + ',' + partida.getPuntuacionHM() + ',' + partida.getTurno_act() + ',' + partida.getTurnos() + ',';
        if (partida.getIsCMHuman()) data += "CM";
        else data += "CB";
        data += ',';
        if (partida.getRepeticiones()) data += "true";
        else data += "false";
        data += ',';
        if (partida.getBlanks()) data += "true";
        else data += "false";
        data += ',' + Integer.toString(partida.getIntentos()) + ",[";
        for (int i = 0; i < partida.getColoresExtra().size(); ++i){
            if (i > 0) data += ',';
            data += partida.getColoresExtra().get(i).toString();
        }
        data += "],[";

        for (int i = 0; i < partida.getVturnos().size(); ++i){
            data += '[' + partida.getVturnos().get(i).getCodigoSolucion().toString() + ',' + partida.getVturnos().get(i).getActualSteps() + ',' + partida.getVturnos().get(i).getCodigosCB().toString() + ',' + partida.getVturnos().get(i).getRespuestasCM() + ']';
        }
        data += "]," + partida.getIA();
        data += ";";
        if (existePartida(partida.getUsername(), partida.getNombre())) borrarPartida(partida.getUsername(), partida.getNombre());
        pw.println(data);
        pw.flush();
        return;
    }

    /**
     * Devuelve un vector de partidas guardadas en disco que su creador es el usuario
     * @param username usuario propietario
     * @return Vector de Partidas
     */
    public Vector<Partida> listearPartidas(String username)  {
        //array [username,nombre,rol,turnos,turno_act,puntuacion]
        Vector<Partida> listPartidas = new Vector<>();
        try {
            br.reset();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Partida partida;
        int i;
        while ((i = next()) != -1) {
            if (i == ':') {
                String user = "";
                while ((i =  next()) != -1 && i != ',' && i != ':') user += (char) i;
                if (user.equals(username)) {
                    String nombre = "";
                    while ((i =  next()) != -1 && i != ',') nombre += (char) i;
                    partida = new Partida(nombre, username);
                    for (int j = 0; j < 10; ++j){
                        String aux = "";
                        int inV = 0;
                        while ((i =  next()) != -1 && (i != ',' || inV > 0) && i != ';') {
                            if (i == '[') ++inV;
                            if (i == ']') --inV;
                            aux += (char) i;
                        }
                        switch (j){
                            case 4:
                                if (aux.equalsIgnoreCase("TRUE")) partida.setRepTrue();
                                break;
                            case 5:
                                if (aux.equalsIgnoreCase("TRUE")) partida.setBlkTrue();
                                break;
                            case 6:
                                partida.setIntentos(Integer.parseInt(aux));
                                break;
                            case 0:
                                partida.addPuntuacio(Integer.parseInt(aux));
                                break;
                            case 1:
                                int tact = Integer.parseInt(aux);
                                for (int a = 0; tact >= a; ++a) partida.nextTurn();
                                break;
                            case 2:
                                partida.setTurnos(Integer.parseInt(aux));
                                break;
                            case 3:
                                partida.setPlayers(aux.equals("CM"));
                                break;
                            case 7:
                                if (aux.equals("[]")) break;
                                Vector<Colour> colours = new Vector<>();
                                String col = "";
                                for (int a = 0; a < aux.length(); ++a) {
                                    char c = aux.charAt(a);
                                    if (c != '[' ) {
                                        if (c != ',' && c != ']'){
                                            col += c;
                                        }
                                        else {
                                            colours.add(str2col(col));
                                            col = "";
                                        }
                                    }
                                }
                                partida.setColoresExtra(colours);
                                break;
                            case 8:
                                if (aux.equals("[]")) break;
                                List<Colour> lista = new Vector<>();
                                col = "";
                                int checkpoint = 0;
                                boolean end = false;
                                for (int a = checkpoint; a < aux.length() && !end; ++a) {
                                    char c = aux.charAt(a);
                                    if (c != '[' ) {
                                        if (c != ',' && c != ']'){
                                            if (c != ' ') col += c;
                                        }
                                        else {
                                            if (c == ']') {
                                                end = true;
                                            }
                                            lista.add(str2col(col));
                                            col = "";
                                        }
                                    }
                                    checkpoint = a;
                                }

                                ++checkpoint;
                                if (aux.charAt(checkpoint) != ',' ) return null;
                                ++checkpoint;
                                Turno turno = new Turno(lista, partida.getIsCMHuman(), partida.getIntentos());
                                String act = "";
                                end = false;
                                for (int a = checkpoint; a < aux.length() && !end; ++a) {
                                    if (aux.charAt(a) != ',') act += aux.charAt(a);
                                    else end = true;
                                    checkpoint++;
                                }
                                ++checkpoint;List<List<Colour>> listaCol = new ArrayList<>();

                                for (int b = 0; b < Integer.parseInt(act); ++b) {
                                    end = false;
                                    col = "";
                                    lista = new Vector<>();
                                    while (checkpoint < aux.length() && !end){
                                        char c = aux.charAt(checkpoint);
                                        if (c != '[' ) {
                                            if (c != ',' && c != ']'){
                                                if (c != ' ')col += c;
                                            }
                                            else {
                                                if (c == ']') {
                                                    end = true;
                                                }
                                                if (!col.equals(""))lista.add(str2col(col));
                                                col = "";
                                            }
                                        }
                                        checkpoint++;
                                    }
                                    listaCol.add(lista);
                                }
                                while(checkpoint < aux.length() && aux.charAt(checkpoint) != ',') ++checkpoint;
                                ++checkpoint;

                                for (int b = 0; b < Integer.parseInt(act); ++b) {
                                    end = false;
                                    String num = "";
                                    List<Integer> list = new Vector<>();
                                    while (checkpoint < aux.length() && !end){
                                        char c = aux.charAt(checkpoint);
                                        if (c != '[' ) {
                                            if (c != ',' && c != ']'){
                                                if (c != ' ') num += c;
                                            }
                                            else {
                                                if (c == ']') {
                                                    end = true;
                                                }
                                                if (!num.equals("")) list.add(Integer.parseInt(num));
                                                num = "";
                                            }
                                        }
                                        checkpoint++;
                                    }
                                    turno.newTry(listaCol.get(b), list);
                                }
                                partida.addTurno(turno);

                                break;
                            case 9:
                                switch (aux) {
                                    case "0":
                                        partida.setIA(0);
                                        break;
                                    case "1":
                                        partida.setIA(1);
                                        break;
                                }
                                break;
                            default:
                        }
                    }
                    listPartidas.add(listPartidas.size(), partida);
                }
            }

        }
        return listPartidas;
    }

    /**
     * Comprueba si una partida existe en disco
     * @param username usuario propietario
     * @param name nombre de la partida
     * @return boolean
     */
    private boolean existePartida(String username, String name)  {
        try {
            br.reset();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        int i;
        while ((i = next()) != -1) {
            if (i == ':') {
                String user = "";
                while ((i = next()) != -1 && i != ',' && i != ':') user += (char) i;
                if (user.equals(username)) {
                    String nombre = "";
                    while ((i = next()) != -1 && i != ',') nombre += (char) i;
                    if (name.equals(nombre)) return true;
                }
            }
        }
        return false;
    }

    /**
     * Borra una partida en disco
     * @param username usuario propietario de la partida
     * @param name nombre de la partida
     */
    public void borrarPartida(String username, String name)  {
        if (!existePartida(username, name)) return;
        try {

            //Construct the new file that will later be renamed to the original filename.
            File tempFile = new File(saveFile.getPath() + ".tmp");
            PrintWriter pw = new PrintWriter(new FileWriter(tempFile));

            br.reset();
            int i;
            boolean found = false;
            while ((i = next()) != -1) {
                if (i == ':') {
                    br.mark(8192);
                    String line = ':' + br.readLine();
                    br.reset();
                    if (!found) {
                        String user = "";
                        while ((i = next()) != -1 && i != ',' && i != ':') user += (char) i;
                        if (user.equals(username)) {
                            String nombre = "";
                            while ((i = next()) != -1 && i != ',') nombre += (char) i;
                            if (name.equals(nombre)) found = true;
                            if (!found) {
                                pw.println(line);
                                pw.flush();
                            }
                        }
                        else {
                            pw.println(line);
                            pw.flush();
                        }
                    }
                    else {
                        pw.println(line);
                        pw.flush();
                    }
                }
            }
            pw.close();
            br.close();
            fr.close();
            fw.close();
            this.pw.close();


            //Delete the original file
            if (!saveFile.delete()) {
                System.out.println("Could not delete file");
                return;
            }

            //Rename the new file to the filename the original file had.
            if (!tempFile.renameTo(saveFile))
                System.out.println("Could not rename file");

            saveFile = new File("FONTS/src/main/persistence/classes/data/savePartida.txt");
            fr = new FileReader(saveFile);
            fw = new FileWriter(saveFile, true);
            br = new BufferedReader(fr);
            br.mark(8192);
            this.pw = new PrintWriter(fw);
        }
        catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * lee el siguiente caracter del bufferReader
     * @return caracter en ASCII
     */
    private int next()  {
        try{
            return br.read();
        } catch (IOException e) {
            System.err.println("RUNTIME UNHANDLED EXCEPTION -> IOException when trying to read savePartidas file! E: " + e.toString());
            System.err.println(Thread.currentThread().getStackTrace().toString());
            System.exit(-2);
            return 0;
        }
    }

    /**
     * Pasa de una String a enum Colour
     * @param input Color en string
     * @return enum Colour
     */
    private Colour str2col (String input) {
        switch (input){
            case "ROJO":
                return Colour.ROJO;
            case "VERDE":
                return Colour.VERDE;
            case "AZUL":
                return Colour.AZUL;
            case "AMARILLO":
                return Colour.AMARILLO;
            case "LILA":
                return Colour.LILA;
            case "NARANJA":
                return Colour.NARANJA;
            case "VACIO":
                return Colour.VACIO;
            case "CYAN":
                return Colour.CYAN;
            case "MAGENTA":
                return Colour.MAGENTA;
            case "TURQUESA":
                return Colour.TURQUESA;
            default:
                return null;
        }
    }
}
