import java.util.ArrayList;

public class cActor {

    public ArrayList<cActor> listaActores;

    public String genero;
    public String nombre;
    public String apellido;
    public String fechaNacimiento;
    public String nacionalidad;

    public cActor(){

        listaActores = new ArrayList<>();
    }

    public void altaActor(cActor a){

        this.listaActores.add(a);
    }

    //Muestra las propiedades de los actores
    public String toString(cActor a){

        return  "* Actores y actrices. *\n" +
                "nombre -> " + genero + "\n" +
                "Genero -> " + genero + "\n" +
                "Fecha de nacimeinto -> " + fechaNacimiento + "\n" +
                "Nacionalidad -> " + nacionalidad + "\n";
    }
}