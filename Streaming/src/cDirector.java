import java.util.ArrayList;

public class cDirector {

    public ArrayList<cDirector> listaDirectores;

    public String genero;
    public String nombre;
    public String apellido;
    public String fechaNacimiento;
    public String nacionalidad;

    public cDirector(){

        listaDirectores = new ArrayList<>();
    }

    public void altaDirector(cDirector d){

        this.listaDirectores.add(d);
    }

    //MUestra las propiedades de los directores
    public String toString(cDirector d){

        return  "* Directores de pelicula *\n" +
                "nombre -> " + genero + "\n" +
                "Genero -> " + genero + "\n" +
                "Fecha de nacimeinto -> " + fechaNacimiento + "\n" +
                "Nacionalidad -> " + nacionalidad + "\n";
    }
}