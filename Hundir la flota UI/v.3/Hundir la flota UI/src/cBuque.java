public class cBuque extends cBarcos{

    //Constructor de la clase Bucque
    public cBuque(){

        GRANDARIA = 4;
        id = 'B';
        vida = 4;
        navegando = true;
        nombre = "Buque";
    }

    public void colocar(int f, int c, boolean d){
        fila = f;
        columna = c;
        horizontal = d;
    }
}