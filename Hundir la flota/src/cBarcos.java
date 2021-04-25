public class cBarcos {

    //Declaracion de las variables que seran modificadas por cada barco.
    protected int GRANDARIA;        //Tamaño del barco
    protected char id;              //Char del barco
    protected int vida;             //La vida del barco
    protected boolean navegando;    //Si el barco sigue con vida
    protected String nombre;        //Nombre del barco

    //Variables que adquieren los valores de los metodos llegir...()
    protected int fila;
    protected int columna;
    protected boolean direccion;

    //Constructor de la super clase Barco
    public cBarcos(){
    }

    public void asignarCoordenadas(int f, int c, boolean d){
        fila = f;
        columna = c;
        direccion = d;
    }
}