import java.util.ArrayList;
import java.util.Iterator;

public class cPelicula {

    /*Se introducen las arrayList de actores y directores dentro
    de la clase pelicula por que cada pelicula contiene sus propios
    actores y directoes*/

    public ArrayList<cActor> listaActores;
    public ArrayList<cDirector> listaDirectores;

    public String titulo;
    public String fecha;
    public String paisDeProduccion;
    public String genero;
    public String resumen;

    public int nota = -1;
    public String comentario;

    public cPelicula(){

        listaActores = new ArrayList<>();
        listaDirectores = new ArrayList<>();
    }

    //Muestra las caracteristicas de las peliculas
    public String toString(cPelicula p){

        //Si no tiene nota insetada muestra que no hay datos introducidos en la pelicula
        if (nota == -1 || comentario.equals(null)){
            return  "** Titulo -> " + titulo + " **\n" +
                    "Genero -> " + genero + "\n" +
                    "Fecha -> " + fecha + "\n" +
                    "Pais de produccion -> " + paisDeProduccion + "\n" +
                    "Resumen -> " + resumen + "\n" +
                    "Nota -> No hay datos introducidos \n" +
                    "comentario sobre la nota ->  No hay datos introducidos \n";
        }
        return "** Titulo -> " + titulo + " **\n" +
                "Genero -> " + genero + "\n" +
                "Fecha -> " + fecha + "\n" +
                "Pais de produccion -> " + paisDeProduccion + "\n" +
                "Resumen -> " + resumen + "\n" +
                "Nota -> " + nota + "\n" +
                "comentario sobre la nota -> " + comentario + "\n";
    }

    //Metodo que muestra los actores que contiene la pelicula
    public void mostrarActores(){ //Esto deberia estar en la web?

        Iterator<cActor> iter = getListaActores().listIterator();
        while (iter.hasNext()){
            cActor a = iter.next();
            System.out.println(a.toString(a));
        }
    }

    //Metodo que muestra los directores que contiene la pelicula
    public void mostrarDirectores(){ //Esto deberia estar en la web?

        Iterator<cDirector> iter = getListaDirectores().listIterator();
        while (iter.hasNext()){
            cDirector d = iter.next();
            System.out.println(d.toString(d));
        }
    }


    public void altaActor(cActor a){

        this.listaActores.add(a);
    }

    public void altaDirector(cDirector d){

        this.listaDirectores.add(d);
    }

    public ArrayList<cActor> getListaActores(){

        return this.listaActores;
    }

    public ArrayList<cDirector> getListaDirectores(){

        return this.listaDirectores;
    }
}