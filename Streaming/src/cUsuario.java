public class cUsuario {

    public String correo;
    public String contra;
    public String nombre;
    public String apellido;

    public cUsuario(){

    }

    //Metodo que muestra las propiedades de los usuarios
    public String toString(cUsuario u){

        return "** Nombre -> " + nombre + "** \n" +
                "Apellido -> " + apellido + "\n" +
                "Correo -> " + correo + "\n" +
                "Clave -> " + contra + "\n\n";
    }
}