package FONTS.src.main.persistence.classes;

import java.io.*;

public class GestorPerfil
{
    File credentials = new File("FONTS\\src\\main\\persistence\\classes\\data\\credentials.txt");
    private BufferedReader reader;
    private BufferedWriter writer;
    String username, password, currentLine;

    /**
     * Constructora
     */
    public GestorPerfil() {

    }

    /**
     * Control se sesiones para el inicio de sesión por parte de persistencia
     * @param usernameLogin Nombre con el que se intenta iniciar la sesión
     * @param passwordLogin Contraseña con la que se intenta iniciar la sesión
     * @return Devuelve si en el credentials.txt existe "usernameLogin" y "passwordLogin"
     */
    public boolean login (String usernameLogin, String passwordLogin)
    {
        try {
            reader = new BufferedReader(new FileReader(credentials));
            while((currentLine = reader.readLine()) != null)
            {
                String[] user = currentLine.split(", "); //Todo antes de la coma es nombre, todo después es contraseña
                username = user[0];
                password = user[1];
                if (username.equals(usernameLogin) && password.equals(passwordLogin)) return true;
            }
        }
        catch (IOException e)
        {
            System.out.println("Algo ha ido mal...");
            e.printStackTrace();
        }
        return false; //No se ha encontrado ningún usuario-contraseña con usernameLogin-passwordLogin
    }

    /**
     * Control se sesiones para el registro por parte de persistencia
     * @param newUsername Nombre con el que se intenta registrar
     * @param newPassword Contraseña con el que se intenta registrar
     * @return Devuelve si existe ya un nombre de usuario "newUsername" para no repetir nombres de usuario
     */
    public boolean signin (String newUsername, String newPassword)
    {
        try {
            reader = new BufferedReader(new FileReader(credentials));
            while((currentLine = reader.readLine()) != null)
            {
                String[] user = currentLine.split(", "); //Todo antes de la coma es nombre, todo después es contraseña
                username = user[0];
                if (username.equals(newUsername)) return false; //Ya existe usuario con newUsername
            }
            try
            {
                writer = new BufferedWriter(new FileWriter(credentials, true));
                writer.write(newUsername + ", " + newPassword + "\n");
                writer.close();
                return true;
            }
            catch (IOException eWriter)
            {
                System.out.println("Algo ha ido mal...");
                eWriter.printStackTrace();
            }
        }
        catch (IOException eReader)
        {
            System.out.println("Algo ha ido mal...");
            eReader.printStackTrace();
        }
        return false;
    }
}