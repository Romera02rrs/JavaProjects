public class cCrucero extends cBarcos {

    //Constructor de la clase Crucero
    public cCrucero() {
        GRANDARIA = 2;
        id = 'C';
        vida = 2;
        navegando = true;
        nombre = "Crucero";
    }

    public void colocar(int f, int c, boolean d) {
        fila = f;
        columna = c;
        horizontal = d;
    }
}