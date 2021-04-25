public class cCapitulos {

    public String titulo;
    public String sinopsis;

    public cCapitulos(){

    }

    //Muestra las propiedades de las series
    public String toString(cCapitulos c){

        return "* Capitulo *" + "\n" +
                "Titulo -> " + titulo + "\n" +
                "Sinopsis -> " + sinopsis + "\n";
    }
}