public class cSubmarino extends cBarcos {

    //Constructor de la clase Sumarino
    public cSubmarino(){

        GRANDARIA = 3;
        id = 'S';
        vida = 3;
        navegando = true;
        nombre = "Submarino";
    }

    public void colocar(int f, int c, boolean d){
        fila = f;
        columna = c;
        direccion = d;
    }
}