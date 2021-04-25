import java.util.ArrayList;
import java.util.Iterator;

public class cTemporada {

    /*Se crea una arrayList de capitulos por que cada temporada
    contiene sus propios capitulos*/

    public ArrayList<cCapitulos> listaCapitulos;

    public String fecha;
    public int numeroCapitulos;

    public cTemporada(){

        listaCapitulos = new ArrayList<>();
    }

    public void altaCapitulo(cCapitulos c){

        this.listaCapitulos.add(c);
    }

    //Muestra las propiedades de las temporadas
    public String toString(cTemporada t){

        return "* Temporada *" + "\n" +
                "Fecha -> " + fecha + "\n" +
                "Numero de capitulos -> " + numeroCapitulos + "\n";
    }

    //Metodo que muestra los capitulos que contiene la temporada
    public void mostrarCapitulos(){ //Esto deberia estar en la web?

        Iterator<cCapitulos> iter = getListaCapitulos().listIterator();
        while (iter.hasNext()){
            cCapitulos c = iter.next();
            System.out.println(c.toString(c));
        }
    }

    public ArrayList<cCapitulos> getListaCapitulos(){

        return this.listaCapitulos;
    }
}