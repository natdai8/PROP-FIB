 package FONTS.src.main.domain.classes;

 public class Perfil
 {
    private final String username;
    private final String password;

     /**
      * Constructora
      * @param newName Nombre de usuario
      * @param newPassword Contraseña asociada al nombre de usuario
      */
    public Perfil (String newName, String newPassword)
    {
        username = newName;
        password = newPassword;
    }

     /**
      * Getters útiles
      * @return El que corresponda en cada caso
      */
    public String getUsername()
    {
        return username;
    }

    public String getPassword()
     {
         return password;
     }
 }