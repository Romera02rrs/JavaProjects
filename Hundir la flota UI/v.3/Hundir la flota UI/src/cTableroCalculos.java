public class cTableroCalculos {

    //Declaracion de los Objetos
    public cPortaAviones p;       //Tamaño 5
    public cBuque bb;             //Tamaño 4
    public cSubmarino s;          //Tamaño 3
    public cCrucero c;            //Tamaño 2
    public cLancha l;             //Tamaño 1

    cBarcos b;
    cBarcos bMemoria;


    //Declaracion de matrices
    public char[][] ocupados;   //Tablero visual que muestra la posicion de los barcos
    public char[][] disparos;   //Tablero que almacena los disparos

    public int posiciones[];

    //Constructor de la clase Tablero
    public cTableroCalculos() {

        //Inicializacion de los objetos
        p = new cPortaAviones();     //Tamaño 5
        bb = new cBuque();           //Tamaño 4
        s = new cSubmarino();        //Tamaño 3
        c = new cCrucero();          //Tamaño 2
        l = new cLancha();           //Tamaño 1

        //Inicializacionde matrices
        ocupados = new char[8][8];  //Tablero de 8x8
        disparos = new char[8][8];  //Tablero de 8x8
    }

    public void setPropiedadesBarco(String coordenadas ,String barcoSeleccionado, boolean horizontal){

        /** Inserta las coordenadas en la array de posciones */
        setCoordenadas(coordenadas);

        b = getBarco(barcoSeleccionado);
        b.fila = posiciones[0];
        b.columna = posiciones[1];
        b.horizontal = horizontal;
    }

    public void setPropiedadesMemoria(){

        bMemoria = new cBarcos();

        bMemoria.GRANDARIA = b.GRANDARIA;
        bMemoria.fila = b.fila;
        bMemoria.columna = b.columna;
        bMemoria.horizontal = b.horizontal;
    }

    public void quitarPropiedadesBarco(){

        bMemoria = null;
    }

    public int[] setCoordenadas(String coordenadas){

        String[] posocionBarco;
        String stringI, stringJ;

        posiciones = new  int [2];
        posocionBarco = coordenadas.split("(?<=.)");
        stringI = posocionBarco[0];
        stringJ = posocionBarco[1];
        posiciones[0] = Integer.parseInt(stringI);
        posiciones[1] = Integer.parseInt(stringJ);

        return posiciones;
    }

    public void insertarBarco(boolean barcoDefinitivo) {

        if(barcoDefinitivo){
            colocaBarcoDefinitivo(b);
        }else{
            colocaBarcoProvisional(b);
        }
    }

    public void colocaBarcoDefinitivo(cBarcos b){

        if(b.horizontal == false){
            for (int i = 0; i < b.GRANDARIA; i++) {
                ocupados[b.fila+i][b.columna] = b.id;
            }
        } else {
            for (int i = 0; i < b.GRANDARIA; i++) {
                ocupados[b.fila][b.columna+i] = b.id;
            }
        }
    }

    public void colocaBarcoProvisional(cBarcos b){

        if(b.horizontal == false){
            for (int i = 0; i < b.GRANDARIA; i++) {
                ocupados[b.fila+i][b.columna] = 'o';
            }
        } else {
            for (int i = 0; i < b.GRANDARIA; i++) {
                ocupados[b.fila][b.columna+i] = 'o';
            }
        }
    }

    public void quitarBarcoMemoria(){


        if(bMemoria.horizontal == false){
            for (int i = 0; i < bMemoria.GRANDARIA; i++) {
                ocupados[bMemoria.fila+i][bMemoria.columna] = ' ';
            }
        } else {
            for (int i = 0; i < bMemoria.GRANDARIA; i++) {
                ocupados[bMemoria.fila][bMemoria.columna+i] = ' ';
            }
        }

    }

    public cBarcos getBarco(String barco){

        switch (barco){
            case "PortaAviones" -> {
                return p;
            }
            case "Buque" -> {
                return bb;
            }
            case "Submarino" -> {
                return s;
            }
            case "Crucero" -> {
                return c;
            }
            case "Lancha" -> {
                return l;
            }
        }
        return null;
    }

    public boolean getPosicionValida(){

        if(validaOpcion(b)){
            return true;
        }else{
            return false;
        }
    }

    //Metodo que se encarga de verificar si la posicion en el tablero es valida
    //Direccion true = a vertical
    public boolean validaOpcion(cBarcos b) {

        if (b.horizontal == false) {
            if ((b.fila + b.GRANDARIA) > 8) {
                return false;
            } else {
                for (int i = 0; i < b.GRANDARIA; i++) {
                    if (ocupados[b.fila+i][b.columna] != ' ' && ocupados[b.fila+i][b.columna] != 'o') {
                        return false;
                    }
                }
                return true;
            }
        } else {
            if ((b.columna + b.GRANDARIA) > 8) {
                return false;
            } else {
                for (int i = 0; i < b.GRANDARIA; i++) {
                    if (ocupados[b.fila][b.columna+i] != ' ' && ocupados[b.fila][b.columna+i] != 'o') {
                        return false;
                    }
                }
                return true;
            }
        }
    }

    //Metodo que muestra reinicializa los tableros
    public void reinicializarTableros () {

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                ocupados[i][j] = ' ';
            }
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                disparos[i][j] = ' ';
            }
        }
    }
}
