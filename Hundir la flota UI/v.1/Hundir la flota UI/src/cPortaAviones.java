public class cPortaAviones extends cBarcos {

    //Construcotr de la clase Porta Aviones
    public cPortaAviones(){

        GRANDARIA = 5;
        id = 'P';
        vida = 5;
        navegando = true;
        nombre = "PortaAviones";
    }

    public void colocar(int f, int c, boolean d){
        fila = f;
        columna = c;
        direccion = d;
    }
}