public class cLancha extends cBarcos {

    //Constructor de la clase Lancha
    public cLancha(){
        GRANDARIA = 1;
        id = 'L';
        vida = 1;
        navegando = true;
        nombre = "Lancha";
    }

    public void colocar(int f, int c, boolean d) {
        fila = f;
        columna = c;
        direccion = d;
    }
}