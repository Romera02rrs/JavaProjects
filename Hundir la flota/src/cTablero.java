import java.util.Scanner;

public class cTablero {

    Scanner leer = new Scanner(System.in);

    //Variables constates
    private final int FILA = 8;      //Tamaño de la fila en el tablero
    private final int COLUMNA = 8;   //Tamaño de la columna en el tablero

    //Declaracion de los Objetos
    private cPortaAviones p;       //Tamaño 5
    private cBuque bb;             //Tamaño 4
    private cSubmarino s;          //Tamaño 3
    private cCrucero c;            //Tamaño 2
    private cLancha l;             //Tamaño 1

    //Declaracion de matrices
    private char[][] ocupados;   //Tablero visual que muestra la posicion de los barcos
    private char[][] disparos;   //Tablero que almacena los disparos

    //Constructor de la clase Tablero
    public cTablero() {

        //Inicializacion de los objetos
        p = new cPortaAviones();     //Tamaño 5
        bb = new cBuque();           //Tamaño 4
        s = new cSubmarino();        //Tamaño 3
        c = new cCrucero();          //Tamaño 2
        l = new cLancha();           //Tamaño 1

        //Inicializacionde matrices
        ocupados = new char[FILA][COLUMNA];  //Tablero de 8x8
        disparos = new char[FILA][COLUMNA];  //Tablero de 8x8
    }

    //Metodo que obtiene la posicion de la columna ↓ A-H
    public int leerColumna() {
        String posColumnaString;
        int posColumna;
        boolean datoValido = false;
        int dato;
        do {
            System.out.print("Introduce la columna (A - H): ");
            posColumnaString = leer.next();
        }while(!(posColumnaString.equalsIgnoreCase("A") || posColumnaString.equalsIgnoreCase("B") ||
                posColumnaString.equalsIgnoreCase("C") || posColumnaString.equalsIgnoreCase("D") ||
                posColumnaString.equalsIgnoreCase("E") || posColumnaString.equalsIgnoreCase("F") ||
                posColumnaString.equalsIgnoreCase("G") || posColumnaString.equalsIgnoreCase("H")));
        posColumnaString = posColumnaString.toUpperCase();
        switch (posColumnaString) {
            case ("A") -> {
                return posColumna = 0;
            }
            case ("B") -> {
                return posColumna = 1;
            }
            case ("C") -> {
                return posColumna = 2;
            }
            case ("D") -> {
                return posColumna = 3;
            }
            case ("E") -> {
                return posColumna = 4;
            }
            case ("F") -> {
                return posColumna = 5;
            }
            case ("G") -> {
                return posColumna = 6;
            }
            case ("H") -> {
                return posColumna = 7;
            }
        }
        return posColumna = 0;
    }

    //Metodo que obtiene la posicion de la fila → 1-8
    public int leerFila() {
        int posFila;
        String dato;
        do {
            System.out.print("Introduce la fila (1 - 8): ");
            dato = leer.next();
            posFila = Integer.parseInt(dato);
            //Comprueba que los numeros introducidos esten dentro del rango permitido
        }while (!(posFila >= 1 && posFila <= 8));
        return posFila -1;
    }

    //Metodo que obtiene la direccion en la que quieres colocar el barco
    public boolean leerDireccion() {
        boolean direccion;
        String hv;
        do{
            System.out.print("introduce la direccion del barco (V - H): ");
            hv = leer.next();
        }while(!(hv.equalsIgnoreCase("V") || hv.equalsIgnoreCase("H")));
        if (hv.equalsIgnoreCase("V")) {
            return direccion = true;
        } else {
            return direccion = false;
        }
    }

    //Metodo que coloca cada barco en orden ascendente segun el tamaño del barco
    public void colocaBarcos() {

        int columna, fila;
        boolean direccion, posicionValida;

        //Porta Aviones
        do{
            System.out.println("Introduce el "+p.nombre+" (tamaño 5)");
            columna = leerColumna();
            fila = leerFila();
            direccion = leerDireccion();
            //Asigna al barco los valores de posicion
            p.asignarCoordenadas(fila, columna, direccion);
            //Comprueba que los valores introducidos son validos
            posicionValida = validaOpcion(p);
        }while(posicionValida==false);
        System.out.println("Posicion valida");
        introduceBarco(p);
        mostrarTablero();

        //Buque
        do{
            System.out.println("Introduce el "+bb.nombre+" (tamaño 4)");
            columna = leerColumna();
            fila = leerFila();
            direccion = leerDireccion();
            //Asigna al barco los valores de posicion
            bb.asignarCoordenadas(fila, columna, direccion);
            //Comprueba que los valores introducidos son validos
            posicionValida = validaOpcion(bb);
        }while(posicionValida==false);
        System.out.println("Posicion valida");
        introduceBarco(bb);
        mostrarTablero();

        //Submarino
        do{
            System.out.println("Introduce el "+s.nombre+" (tamaño 3)");
            columna = leerColumna();
            fila = leerFila();
            direccion = leerDireccion();
            //Asigna al barco los valores de posicion
            s.asignarCoordenadas(fila, columna, direccion);
            //Comprueba que los valores introducidos son validos
            posicionValida = validaOpcion(s);
        }while(posicionValida==false);
        System.out.println("Posicion valida");
        introduceBarco(s);
        mostrarTablero();

        //Crucero
        do{
            System.out.println("Introduce el "+c.nombre+" (tamaño 2)");
            columna = leerColumna();
            fila = leerFila();
            direccion = leerDireccion();
            //Asigna al barco los valores de posicion
            c.asignarCoordenadas(fila, columna, direccion);
            //Comprueba que los valores introducidos son validos
            posicionValida = validaOpcion(c);
        }while(posicionValida==false);
        System.out.println("Posicion valida");
        introduceBarco(c);
        mostrarTablero();

        //Lancha
        do{
            System.out.println("Introduce la "+l.nombre+" (tamaño 1)");
            columna = leerColumna();
            fila = leerFila();
            //Asigna al barco los valores de posicion
            l.asignarCoordenadas(fila, columna, true);
            //Comprueba que los valores introducidos son validos
            posicionValida = validaOpcion(l);
        }while(posicionValida==false);
        System.out.println("Posicion valida");
        introduceBarco(l);
        mostrarTablero();
    }

    //Metodo que se encarga de introducir el barco seleccionado por "colocaBarcos()" en el tablero
    public void introduceBarco(cBarcos b) {
        if(b.direccion == true){
            for (int i = 0; i < b.GRANDARIA; i++) {
                ocupados[b.fila+i][b.columna] = b.id;
            }
        } else {
            for (int i = 0; i < b.GRANDARIA; i++) {
                ocupados[b.fila][b.columna+i] = b.id;
            }
        }
    }

    //Metodo que se encarga de verificar si la posicion en el tablero es valida
    public boolean validaOpcion(cBarcos b) {

        boolean opcionValida = false;
        if (b.direccion == true) { //Direccion true es igual a VERTICAL
            //Compreuba que el barco no se salga por abajo
            if ((b.fila + b.GRANDARIA) > 8) {
                System.out.println("Error, el barco no cabe verticalmente");
                return opcionValida = false;
            } else {
                //Comprueba que no hayan barcos ya colocados
                for (int i = 0; i < b.GRANDARIA; i++) {
                    if (ocupados[b.fila+i][b.columna] != ' ') {
                        System.out.println("Error, ya hay un barco en esa posicion");
                        return opcionValida = false;
                    }
                }
                return opcionValida = true;
            }
        } else {
            //Compreuba que el barco no se salga por la derecha
            if ((b.columna + b.GRANDARIA) > 8) {
                System.out.println("Error, el barco no cabe horizontalmente");
                return opcionValida = false;
            } else {
                //Comprueba que no hayan barcos ya colocados
                for (int i = 0; i < b.GRANDARIA; i++) {
                    if (ocupados[b.fila][b.columna+i] != ' ') {
                        System.out.println("Error, ya hay un barco en esa posicion");
                        return opcionValida = false;
                    }
                }
                return opcionValida = true;
            }
        }
    }

    //Metodo que mantendra el juego en ejecucion hasta que no queden barcos
    public void jugar () {

        int posColumna, posFila, comprobacionDisparo;
        boolean acabarJuego;

        do {
            do{
                posColumna = leerColumna();
                posFila = leerFila();
                //Compreuba que no se dispare dos veces en el mismo lugar
                comprobacionDisparo = compruebaDisparo(posColumna, posFila);
                //Hasta que el disparo no sea valido no continua la ejecucion del programa
            }while(comprobacionDisparo == 1);
            dispara(posColumna, posFila);
            mostrarDisparos();
            acabarJuego = navegacionFlota();
        } while (acabarJuego == false);
    }

    //Metodo que comprueba donde se esta disparando
    public int compruebaDisparo(int posColumna, int posFila){

        //Dispara al agua
        if (disparos[posFila][posColumna] == ' '){
            return 0;
            //Dispara donde ya ha disparado
        }else if (disparos[posFila][posColumna] == '-'){
            System.out.println("Ya has disparado aqui");
            return 1;
            //Dispara a la misma posicion del barco dos veces
        } else {
            System.out.println("Estas disparando a un barco que ya has disparado");
            return 1;
        }
    }

    //Marca en la matriz de ocupados si ha tocado un barco o si a dispaado al agua
    public int dispara (int posColumna, int posFila) {

        //Si hay agua
        if (ocupados[posFila][posColumna] == ' '){
            System.out.println("¡AGUA!");
            disparos[posFila][posColumna] = '-';
        }else{
            //Si hay un Porta Aviones
            if(ocupados[posFila][posColumna]=='P'){
                disparos[posFila][posColumna] = 'X';
                compruebaVida(p);
                //Si hay un Buque
            }else if(ocupados[posFila][posColumna]=='B'){
                disparos[posFila][posColumna] = 'X';
                compruebaVida(bb);
                //Si hay un Submarino
            }else if(ocupados[posFila][posColumna]=='S'){
                disparos[posFila][posColumna] = 'X';
                compruebaVida(s);
                //Si hay un Crucero
            }else if(ocupados[posFila][posColumna]=='C'){
                disparos[posFila][posColumna] = 'X';
                compruebaVida(c);
                //Si hay una Lancha
            }else if(ocupados[posFila][posColumna]=='L'){
                disparos[posFila][posColumna] = 'X';
                compruebaVida(l);
            }
        }
        return 1;
    }

    //Metodo que comprueba el estado del barco y la vida que tiene
    public void compruebaVida (cBarcos b) {

        //Resta uno de vida
        b.vida --;
        //Si no le queda vida a sido hundido
        if (b.vida == 0){
            System.out.println("EL "+b.nombre+" ha sido ¡TOCADO Y HUNDIDO!");
            //Si le quedaba vida entonces ha sido tocado
        }else {
            System.out.println("EL "+b.nombre+" ha sido ¡TOCADO!" +
                "\nLe queda "+b.vida+" de vida" );
        }
    }

    //Metodo que comprueba si quedan barcos a flote
    public boolean navegacionFlota(){

        //Si se cumple entonces los barcos no tienen vida y acaba el juego
        if(p.vida == 0 && bb.vida == 0 && s.vida == 0 && c.vida == 0 && l.vida == 0){
            return true;
        }else{
            return false;
        }
    }

    //Metodo que muesrta el tablero por pantalla
    public void mostrarTablero () {
        System.out.println("    A    B    C    D    E    F    G    H");
        for (int i = 0; i < FILA; i++) {
            System.out.println("  ╔═══╗╔═══╗╔═══╗╔═══╗╔═══╗╔═══╗╔═══╗╔═══╗");
            System.out.print((i + 1) + " ");
            for (int j = 0; j < COLUMNA; j++) {
                System.out.print("║ " + ocupados[i][j] + " ║");
            }
            System.out.println("\n  ╚═══╝╚═══╝╚═══╝╚═══╝╚═══╝╚═══╝╚═══╝╚═══╝");
        }
    }

    //Metodo que muesrta el tablero de disparos por pantalla
    public void mostrarDisparos () {
        System.out.println("    A    B    C    D    E    F    G    H");
        for (int i = 0; i < FILA; i++) {
            System.out.println("  ╔═══╗╔═══╗╔═══╗╔═══╗╔═══╗╔═══╗╔═══╗╔═══╗");
            System.out.print((i + 1) + " ");
            for (int j = 0; j < COLUMNA; j++) {
                System.out.print("║ " + disparos[i][j] + " ║");
            }
            System.out.println("\n  ╚═══╝╚═══╝╚═══╝╚═══╝╚═══╝╚═══╝╚═══╝╚═══╝");
        }
    }

    //Metodo que muestra reinicializa los tableros
    public void reinicializarTableros () {

        for (int i = 0; i < FILA; i++) {
            for (int j = 0; j < COLUMNA; j++) {
                ocupados[i][j] = ' ';
            }
        }
        for (int i = 0; i < FILA; i++) {
            for (int j = 0; j < COLUMNA; j++) {
                disparos[i][j] = ' ';
            }
        }
    }
}