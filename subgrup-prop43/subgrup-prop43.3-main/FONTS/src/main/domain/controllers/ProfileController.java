package FONTS.src.main.domain.controllers;

import java.util.*;
import FONTS.src.main.domain.classes.Perfil;


public class ProfileController
{
    private Vector<Perfil> profiles;
    private Perfil activeProfile;

    /**
     * Constructora
     */
    public ProfileController()
    {
        profiles = new Vector<Perfil>();
        activeProfile = null;
    }

    /**
     * Setter útil
     * @param activeProfile Establece este perfil como el activo en este momento
     */
    public void setActiveProfile(Perfil activeProfile)
    {
        this.activeProfile = activeProfile;
    }

    /**
     * Para saber el nombre de usuario del "activeProfile"
     * @return Devuelve el username del perfil activo
     */
    public String getUsername ()
    {
        return activeProfile.getUsername();
    }

    /**
     * Creación de una nueva cuenta con los parámetros de entrada
     * @param newName Nombre de usuario para registrarse
     * @param newPassword Contraseña asociado al nombre
     * @return Devuelve si se ha podido crear correctamente
     */
    public boolean signIn (String newName, String newPassword)
    {
        return profiles.add(new Perfil(newName, newPassword));
    }

    /**
     * Se realiza un inicio de sesión con los parámetros de entrada
     * @param username Nombre de usuario para iniciar sesión
     * @param password Contraseña asociada al nombre de usuario
     */
    public void logIn (String username, String password)
    {
        for (Perfil p : profiles)
        {
            if(Objects.equals(p.getUsername(), username) && Objects.equals(p.getPassword(), password))
            {
                setActiveProfile(p); //La cuenta existe de verdad y se pone como el perfil activo
                return;
            }
        }
        Perfil p = new Perfil(username, password);
        setActiveProfile(p);
    }

    /**
     * Cierre de sesión
     */
    public void logOut ()
    {
        if (activeProfile != null) activeProfile = null;
    }

}