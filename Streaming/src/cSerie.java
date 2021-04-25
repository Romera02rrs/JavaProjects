import java.util.ArrayList;
import java.util.Iterator;

public class cSerie {

    /*Se introducen las arrayList de actores y directores dentro
    de la clase pelicula por que cada pelicula contiene sus propios
    actores y directoes, ademas tambien contienen sus propias
    temporadas y dentro de la calse temporada contiene su arrayList
    de capitulos*/

    public ArrayList<cActor> listaActores;
    public ArrayList<cDirector> listaDirectores;
    public ArrayList<cTemporada> listaTemporadas;

    public String titulo;
    public String fecha;
    public String paisDeProduccion;
    public String genero;
    public String resumen;

    public String numeroTemporadas;

    public int nota = -1;
    public String comentario;

    public cSerie(){

        listaActores = new ArrayList<>();
        listaDirectores = new ArrayList<>();
        listaTemporadas = new ArrayList<>();
    }

    public String toString(cSerie s){

        if (nota == -1 || comentario.equals(null)){
            return  "** Titulo -> " + titulo + " **\n" +
                    "Genero -> " + genero + "\n" +
                    "Fecha -> " + fecha + "\n" +
                    "Pais de produccion -> " + paisDeProduccion + "\n" +
                    "Resumen -> " + resumen + "\n" +
                    "Nota -> No hay datos introducidos \n" +
                    "comentario sobre la nota ->  No hay datos introducidos \n";
        }
        return "\n** Titulo -> " + titulo + " **\n" +
                "Genero -> " + genero + "\n" +
                "Fecha -> " + fecha + "\n" +
                "Pais de produccion -> " + paisDeProduccion + "\n" +
                "Resumen -> " + resumen + "\n" +
                "Nota -> " + nota + "\n" +
                "comentario sobre la nota -> " + comentario + "\n";
    }

    public void mostrarActores(){ //Esto deberia estar en la web

        Iterator<cActor> iter = getListaActores().listIterator();
        while (iter.hasNext()){
            cActor a = iter.next();
            System.out.println(a.toString(a));
        }
    }

    public void mostrarDirectores(){ //Esto deberia estar en la web?

        Iterator<cDirector> iter = getListaDirectores().listIterator();
        while (iter.hasNext()){
            cDirector d = iter.next();
            System.out.println(d.toString(d));
        }
    }

    //Metodo que muestra las temporadas que tiene la serie
    public void mostrarTemporadas(){ //Esto deberia estar en la web?

        Iterator<cTemporada> iter = getListaTemporadas().listIterator();
        while (iter.hasNext()){
            cTemporada t = iter.next();
            System.out.println(t.toString(t));
            t.mostrarCapitulos();
        }
    }

    public void altaActor(cActor a){

        this.listaActores.add(a);
    }

    public void altaDirector(cDirector d){

        this.listaDirectores.add(d);
    }

    public void altaTemporada(cTemporada t){

        this.listaTemporadas.add(t);
    }

    public ArrayList<cActor> getListaActores(){

        return this.listaActores;
    }

    public ArrayList<cDirector> getListaDirectores(){

        return this.listaDirectores;
    }

    public ArrayList<cTemporada> getListaTemporadas(){

        return this.listaTemporadas;
    }
}