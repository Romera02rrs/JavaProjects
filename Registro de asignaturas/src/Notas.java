import java.util.Scanner;

public class Notas {

    //Declaracion del escaner.
    Scanner leerInt = new Scanner(System.in);
    Scanner leerFloat = new Scanner(System.in);
    Scanner leerString = new Scanner(System.in);
    //Declaracion de arrays.
    String[] arrayMenu;
    //Declaracion de matrices.
    float[][] asignaturas;
    //Declaracion de variables.
    int asciiArt;
    int opcionAsignatura;
    String opcionNotasAsignatura;
    String opcionOtraAsignatura;
    String opcionVerTodasAsignatura;

    public Notas(){

        //Inicializacion de arrays.
        arrayMenu = new String[6];
        iniciarMenu();
        //Inicializacion de matrices.
        asignaturas = new float[3][15];
        //Inicializacion de variables.
        asciiArt=0;
    }

    public static void main(String[] args){

        //Valor que se ejecutara en el switch case.
        int opcionMenu;
        //Instancia del constructor de la clase.
        Notas programa = new Notas();
        //Bucle del programa.
        do{
            programa.mostrarMenu();
            opcionMenu = programa.leerOpcionMenu();
            programa.ejecutarOpcionMenu(opcionMenu);
        }while(!(opcionMenu==6));
    }

    public void iniciarMenu(){

        arrayMenu[0] ="[1] → Insertar las notas de la asignatura seleccionada.";
        arrayMenu[1] ="[2] → Insertar todas las notas.";
        arrayMenu[2] ="[3] → Calcular la nota media de la asignatura seleccionada.";
        arrayMenu[3] ="[4] → Ordenar las asignaturas de forma ascendente.";
        arrayMenu[4] ="[5] → Estadistica";
        arrayMenu[5] ="[6] → Salir de la aplicacion";
    }

    public void mostrarMenu(){

        while(asciiArt == 0){
            System.out.println("""
                    
                        _____
                       /    /|_ ___________________________________________
                      /    // /|                                          /|
                     (====|/ //        Bienvenido al...                  / |
                      (=====|/           programa NOTAS!!!              /  |
                     (====|/                                           / /||
                    /_________________________________________________/ / ||
                    |  _____________________________________________  ||  ||
                    | ||                                            | ||
                    | ||                                            | ||
                    | |                                             | |  
                    """);
            asciiArt ++;
        }
        System.out.println("\n");
        for(String i : arrayMenu)
            System.out.println(i);

        System.out.print("""
                ------------------
                Escoge la opcion → """);
    }

    public int leerOpcionMenu(){

        return leerInt.nextInt();
    }

    public void ejecutarOpcionMenu(int opcionMenu){

        switch (opcionMenu) {
            case 1 -> insertarNotasAsignatura();
            case 2 -> insertarTodasNotas();
            case 3 -> CalcularNotaMedia();
            case 4 -> ordenarNotas();
            case 5 -> estadistica();
            case 6 -> salir();
        }
    }

    public void insertarNotasAsignatura(){

        System.out.print("""
                
                [1] → Asignatura 1
                [2] → Asignatura 2
                [3] → Asignatura 3
                ----------------------------------------------
                Selecciona la asignatura que deseas rellenar → """);
        opcionAsignatura = leerInt.nextInt();
        switch (opcionAsignatura) {
            case 1 -> {
                for (int i = 0; i < 1; i++) {
                    for (int j = 0; j < asignaturas[i].length; j++) {
                        System.out.print("\nAsignatura1, alumno " + (j + 1) + ", nota = ");
                        asignaturas[i][j] = leerFloat.nextFloat();
                    }
                }
                System.out.println("\nVer las notas de las asignaturas? (S/N)");
                opcionNotasAsignatura = leerString.nextLine();
                if (opcionNotasAsignatura.equalsIgnoreCase("s")) {
                    mostrarNotaAsignaturas();
                }
                System.out.println("\nQuieres insertar notas en otra asignatura? (S/N)");
                opcionOtraAsignatura = leerString.nextLine();
                if (opcionOtraAsignatura.equalsIgnoreCase("s")) {
                    insertarNotasAsignatura();
                }
            }
            case 2 -> {
                for (int i = 1; i < 2; i++) {
                    for (int j = 0; j < asignaturas[i].length; j++) {
                        System.out.print("\nAsignatura2, alumno " + (j + 1) + ", nota = ");
                        asignaturas[i][j] = asignaturas[i][j] = leerFloat.nextFloat();
                    }
                }
                System.out.println("\nVer las notas de las asignaturas? (S/N)");
                opcionNotasAsignatura = leerString.nextLine();
                if (opcionNotasAsignatura.equalsIgnoreCase("s")) {
                    mostrarNotaAsignaturas();
                }
                System.out.println("\nQuieres insertar notas en otra asignatura? (S/N)");
                opcionOtraAsignatura = leerString.nextLine();
                if (opcionOtraAsignatura.equalsIgnoreCase("s")) {
                    insertarNotasAsignatura();
                }
            }
            case 3 -> {
                for (int i = 2; i < 3; i++) {
                    for (int j = 0; j < asignaturas[i].length; j++) {
                        System.out.print("\nAsignatura3, alumno " + (j + 1) + ", nota = ");
                        asignaturas[i][j] = leerFloat.nextFloat();
                    }
                }
                System.out.println("\nVer las notas de las asignaturas? (S/N)");
                opcionNotasAsignatura = leerString.nextLine();
                if (opcionNotasAsignatura.equalsIgnoreCase("s")) {
                    mostrarNotaAsignaturas();
                }
                System.out.println("\nQuieres insertar notas en otra asignatura? (S/N)");
                opcionOtraAsignatura = leerString.nextLine();
                if (opcionOtraAsignatura.equalsIgnoreCase("s")) {
                    insertarNotasAsignatura();
                }
            }
        }
    }

    public void mostrarNotaAsignaturas(){

        System.out.println("\n| Asignatura 1     |    Asignatura 2    |    Asignatura 3 |");
        for (int i = 0; i < 15; i++){
            System.out.println();
            for (int j = 0; j < 3; j++){
                System.out.print("       "+asignaturas[j][i]+"          ");
            }
        }
        System.out.println();
        //System.out.print("       "+"alumno "+(i+1)+" nota "+asignaturas[j][i]+"          ");
    }

    public void insertarTodasNotas(){

        System.out.println("\n¡Todas las notas han sido insertadas correctamente!");
        for (int i = 0; i < asignaturas.length; i++){
            for (int j = 0; j < asignaturas[i].length; j++){
                asignaturas[i][j] = (float)Math.round((Math.random()*10) * 100) / 100;
            }
        }
        System.out.println("\nQuieres ver las notas de todas las asignaturas? (S/N)");
        opcionVerTodasAsignatura = leerString.nextLine();
        if(opcionVerTodasAsignatura.equalsIgnoreCase("s")){
            mostrarNotaAsignaturas();
        }
    }

    public void CalcularNotaMedia(){

        System.out.print("""
                
                [1] → Asignatura 1
                [2] → Asignatura 2
                [3] → Asignatura 3
                [4] → Todas las asignaturas
                ------------------------------------------------------
                Selecciona la asignatura para calcular la nota media →""");
        opcionAsignatura = leerInt.nextInt();
        switch (opcionAsignatura) {
            case 1 -> {
                float notaMediaAsignatura1 = 0;
                for (int i = 0; i < 1; i++) {
                    for (int j = 0; j < asignaturas[i].length; j++) {
                        notaMediaAsignatura1 += asignaturas[i][j];
                    }
                    System.out.println("\nAsignatura1, nota media = " +
                            "" + Math.round((notaMediaAsignatura1 / 15) * 100d) / 100d);
                }
                System.out.println("\nQuieres calcular la nota media de otra asignatura? (S/N)");
                opcionOtraAsignatura = leerString.nextLine();
                if (opcionOtraAsignatura.equalsIgnoreCase("s")) {
                    CalcularNotaMedia();
                }
            }
            case 2 -> {
                float notaMediaAsignatura2 = 0;
                for (int i = 1; i < 2; i++) {
                    for (int j = 0; j < asignaturas[i].length; j++) {
                        notaMediaAsignatura2 += asignaturas[i][j];
                    }
                    System.out.println("\nAsignatura2, nota media = " +
                            "" + Math.round((notaMediaAsignatura2 / 15) * 100d) / 100d);
                }
                System.out.println("\nQuieres calcular la nota media de otra asignatura? (S/N)");
                opcionOtraAsignatura = leerString.nextLine();
                if (opcionOtraAsignatura.equalsIgnoreCase("s")) {
                    CalcularNotaMedia();
                }
            }
            case 3 -> {
                float notaMediaAsignatura3 = 0;
                for (int i = 2; i < 3; i++) {
                    for (int j = 0; j < asignaturas[i].length; j++) {
                        notaMediaAsignatura3 += asignaturas[i][j];
                    }
                    System.out.println("\nAsignatura3, nota media = " +
                            "" + Math.round((notaMediaAsignatura3 / 15) * 100d) / 100d);
                }
                System.out.println("\nQuieres calcular la nota media de otra asignatura? (S/N)");
                opcionOtraAsignatura = leerString.nextLine();
                if (opcionOtraAsignatura.equalsIgnoreCase("s")) {
                    CalcularNotaMedia();
                }
            }
            case 4 -> {
                float notaMediaTodasAsignaturas = 0;
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < asignaturas[i].length; j++) {
                        notaMediaTodasAsignaturas += asignaturas[i][j];
                    }
                }
                System.out.println("\nTodas las asignaturas, nota media = " +
                        "" + Math.round((notaMediaTodasAsignaturas / 45) * 100d) / 100d);
                System.out.println("\nQuieres calcular la nota media de otra asignatura? (S/N)");
                opcionOtraAsignatura = leerString.nextLine();
                if (opcionOtraAsignatura.equalsIgnoreCase("s")) {
                    CalcularNotaMedia();
                }
            }
        }

    }

    public void ordenarNotas(){

        int posicion;
        float auxiliar;
        System.out.print("""
                
                [1] → Asignatura 1
                [2] → Asignatura 2
                [3] → Asignatura 3
                [4] → Todas las asignaturas
                ---------------------------------------------
                Selecciona la asignatura que deseas ordenar → """);
        opcionAsignatura = leerInt.nextInt();
        switch (opcionAsignatura) {
            case 1 -> {
                for (int i = 0; i < 1; i++) {
                    for (int j = 0; j < asignaturas[i].length; j++) {
                        posicion = j;
                        auxiliar = asignaturas[i][j];
                        while ((posicion > 0) && (asignaturas[i][posicion - 1] > auxiliar)) {
                            asignaturas[i][posicion] = asignaturas[i][posicion - 1];
                            posicion--;
                        }
                        asignaturas[i][posicion] = auxiliar;
                    }
                }
                System.out.println("\nNotas ordenadas con el metodo de insercion, quieres ver las notas ordenadas? (S/N)");
                opcionOtraAsignatura = leerString.nextLine();
                if (opcionOtraAsignatura.equalsIgnoreCase("s")) {
                    mostrarNotaAsignaturas();
                }
                System.out.println("\nQuieres ordenar las notas de otra asignatura? (S/N)");
                opcionOtraAsignatura = leerString.nextLine();
                if (opcionOtraAsignatura.equalsIgnoreCase("s")) {
                    ordenarNotas();
                }
            }
            case 2 -> {
                for (int i = 1; i < 2; i++) {
                    for (int j = 0; j < asignaturas[i].length; j++) {
                        posicion = j;
                        auxiliar = asignaturas[i][j];
                        while ((posicion > 0) && (asignaturas[i][posicion - 1] > auxiliar)) {
                            asignaturas[i][posicion] = asignaturas[i][posicion - 1];
                            posicion--;
                        }
                        asignaturas[i][posicion] = auxiliar;
                    }
                }
                System.out.println("\nNotas ordenadas con el metodo de insercion, quieres ver las notas ordenadas? (S/N)");
                opcionOtraAsignatura = leerString.nextLine();
                if (opcionOtraAsignatura.equalsIgnoreCase("s")) {
                    mostrarNotaAsignaturas();
                }
                System.out.println("\nQuieres ordenar las notas de otra asignatura? (S/N)");
                opcionOtraAsignatura = leerString.nextLine();
                if (opcionOtraAsignatura.equalsIgnoreCase("s")) {
                    ordenarNotas();
                }
            }
            case 3 -> {
                for (int i = 2; i < 3; i++) {
                    for (int j = 0; j < asignaturas[i].length; j++) {
                        posicion = j;
                        auxiliar = asignaturas[i][j];
                        while ((posicion > 0) && (asignaturas[i][posicion - 1] > auxiliar)) {
                            asignaturas[i][posicion] = asignaturas[i][posicion - 1];
                            posicion--;
                        }
                        asignaturas[i][posicion] = auxiliar;
                    }
                }
                System.out.println("\nNotas ordenadas con el metodo de insercion, quieres ver las notas ordenadas? (S/N)");
                opcionOtraAsignatura = leerString.nextLine();
                if (opcionOtraAsignatura.equalsIgnoreCase("s")) {
                    mostrarNotaAsignaturas();
                }
                System.out.println("\nQuieres ordenar las notas de otra asignatura? (S/N)");
                opcionOtraAsignatura = leerString.nextLine();
                if (opcionOtraAsignatura.equalsIgnoreCase("s")) {
                    ordenarNotas();
                }
            }
            case 4 -> {
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < asignaturas[i].length; j++) {
                        posicion = j;
                        auxiliar = asignaturas[i][j];
                        while ((posicion > 0) && (asignaturas[i][posicion - 1] > auxiliar)) {
                            asignaturas[i][posicion] = asignaturas[i][posicion - 1];
                            posicion--;
                        }
                        asignaturas[i][posicion] = auxiliar;
                    }
                }
                System.out.println("\nNotas ordenadas con el metodo de insercion, quieres ver las notas ordenadas? (S/N)");
                opcionOtraAsignatura = leerString.nextLine();
                if (opcionOtraAsignatura.equalsIgnoreCase("s")) {
                    mostrarNotaAsignaturas();
                }
            }
        }
    }

    public void estadistica(){

        int muyDeficiente, insuficiente, suficiente, notable, sobresaliente;
        int porcentajeMuyDeficientes, porcentajeInsuficientes,
                porcentajeSuficientes, porcentajNotable, porcentajeSobresaliente;

        System.out.print("""
                
                [1] → Asignatura 1
                [2] → Asignatura 2
                [3] → Asignatura 3
                [4] → Todas las asignaturas
                -------------------------------------------------------
                Selecciona la asignatura para calcular la estadistica →""");
        opcionAsignatura = leerInt.nextInt();
        switch (opcionAsignatura){
            case 1:
                muyDeficiente=0;
                insuficiente=0;
                suficiente=0;
                notable=0;
                sobresaliente=0;
                for (int i = 0; i < 1; i++){
                    for (int j = 0; j < asignaturas[i].length; j++){
                        if(asignaturas[i][j] < 3){
                            muyDeficiente ++;
                        }else if(asignaturas[i][j] < 5 && asignaturas[i][j] > 2){
                            insuficiente++;
                        }else if(asignaturas[i][j] < 7 && asignaturas[i][j] > 4){
                            suficiente++;
                        }else if(asignaturas[i][j] < 9 && asignaturas[i][j] > 6){
                            notable++;
                        }else{
                            sobresaliente++;
                        }
                    }
                }
                porcentajeMuyDeficientes = (Math.round(100 * muyDeficiente / 15));
                porcentajeInsuficientes = (Math.round(100 * insuficiente / 15));
                porcentajeSuficientes = (Math.round(100 * suficiente / 15));
                porcentajNotable = (Math.round(100 * notable / 15));
                porcentajeSobresaliente = (Math.round(100 * sobresaliente / 15));
                System.out.printf("""
                        
                        Asignatura 1: 
                        ↓ ↓ ↓ ↓ ↓ ↓ ↓
                        
                        %d muy deficiente/s, el: %d%%
                        
                        %d insuficiente/s, el: %d%%
                        
                        %d suficiente/s, el: %d%%
                        
                        %d notable/s, el: %d%%
                        
                        %d sobresaliente/s, el: %d%%\n""",
                        muyDeficiente,porcentajeMuyDeficientes,insuficiente,porcentajeInsuficientes,
                        suficiente,porcentajeSuficientes,notable,
                        porcentajNotable,sobresaliente, porcentajeSobresaliente);
                System.out.println("\nQuieres calcular la estadisitica de otra asignatura? (S/N)");
                opcionOtraAsignatura = leerString.nextLine();
                if(opcionOtraAsignatura.equalsIgnoreCase("s")){
                    estadistica();
                }
                break;
            case 2:
                muyDeficiente=0;
                insuficiente=0;
                suficiente=0;
                notable=0;
                sobresaliente=0;
                for (int i = 1; i < 2; i++){
                    for (int j = 0; j < asignaturas[i].length; j++){
                        if(asignaturas[i][j] < 3){
                            muyDeficiente ++;
                        }else if(asignaturas[i][j] < 5 && asignaturas[i][j] > 2){
                            insuficiente++;
                        }else if(asignaturas[i][j] < 7 && asignaturas[i][j] > 4){
                            suficiente++;
                        }else if(asignaturas[i][j] < 9 && asignaturas[i][j] > 6){
                            notable++;
                        }else{
                            sobresaliente++;
                        }
                    }
                }
                porcentajeMuyDeficientes = (Math.round(100 * muyDeficiente / 15));
                porcentajeInsuficientes = (Math.round(00 * insuficiente / 15));
                porcentajeSuficientes = (Math.round(100 * suficiente / 15));
                porcentajNotable = (Math.round(100 * notable / 15));
                porcentajeSobresaliente = (Math.round(100 * sobresaliente / 15));
                System.out.printf("""
                      
                        Asignatura 2: 
                        ↓ ↓ ↓ ↓ ↓ ↓ ↓
                        
                        %d muy deficiente/s, el: %d%%
                        
                        %d insuficiente/s, el: %d%%
                        
                        %d suficiente/s, el: %d%%
                        
                        %d notable/s, el: %d%%
                        
                        %d sobresaliente/s, el: %d%%\n""",
                        muyDeficiente,porcentajeMuyDeficientes,insuficiente,porcentajeInsuficientes,
                        suficiente,porcentajeSuficientes,notable,
                        porcentajNotable,sobresaliente, porcentajeSobresaliente);
                System.out.println("\nQuieres calcular la estadisitica de otra asignatura? (S/N)");
                opcionOtraAsignatura = leerString.nextLine();
                if(opcionOtraAsignatura.equalsIgnoreCase("s")){
                    estadistica();
                }
                break;
            case 3:
                muyDeficiente=0;
                insuficiente=0;
                suficiente=0;
                notable=0;
                sobresaliente=0;
                for (int i = 2; i < 3; i++){
                    for (int j = 0; j < asignaturas[i].length; j++){
                        if(asignaturas[i][j] < 3){
                            muyDeficiente ++;
                        }else if(asignaturas[i][j] < 5 && asignaturas[i][j] > 2){
                            insuficiente++;
                        }else if(asignaturas[i][j] < 7 && asignaturas[i][j] > 4){
                            suficiente++;
                        }else if(asignaturas[i][j] < 9 && asignaturas[i][j] > 6){
                            notable++;
                        }else{
                            sobresaliente++;
                        }
                    }
                }
                porcentajeMuyDeficientes = (Math.round(100 * muyDeficiente / 15));
                porcentajeInsuficientes = (Math.round(100 * insuficiente / 15));
                porcentajeSuficientes = (Math.round(100 * suficiente / 15));
                porcentajNotable = (Math.round(100 * notable / 15));
                porcentajeSobresaliente = (Math.round(100 * sobresaliente / 15));
                System.out.printf("""
                                      
                        Asignatura 3: 
                        ↓ ↓ ↓ ↓ ↓ ↓ ↓
                        
                        %d muy deficiente/s, el: %d%%
                        
                        %d insuficiente/s, el: %d%%
                        
                        %d suficiente/s, el: %d%%
                        
                        %d notable/s, el: %d%%
                        
                        %d sobresaliente/s, el: %d%%\n""",
                        muyDeficiente,porcentajeMuyDeficientes,insuficiente,porcentajeInsuficientes,
                        suficiente,porcentajeSuficientes,notable,
                        porcentajNotable,sobresaliente, porcentajeSobresaliente);
                System.out.println("\nQuieres calcular la estadisitica de otra asignatura? (S/N)");
                opcionOtraAsignatura = leerString.nextLine();
                if(opcionOtraAsignatura.equalsIgnoreCase("s")){
                    estadistica();
                }
            case 4:
                muyDeficiente=0;
                insuficiente=0;
                suficiente=0;
                notable=0;
                sobresaliente=0;
                for (int i = 0; i < 3; i++){
                    for (int j = 0; j < asignaturas[i].length; j++){
                        if(asignaturas[i][j] < 3){
                            muyDeficiente ++;
                        }else if(asignaturas[i][j] < 5 && asignaturas[i][j] > 2){
                            insuficiente++;
                        }else if(asignaturas[i][j] < 7 && asignaturas[i][j] > 4){
                            suficiente++;
                        }else if(asignaturas[i][j] < 9 && asignaturas[i][j] > 6){
                            notable++;
                        }else{
                            sobresaliente++;
                        }
                    }
                }
                porcentajeMuyDeficientes = (Math.round(100 * muyDeficiente / 45));
                porcentajeInsuficientes = (Math.round(100 * insuficiente / 45));
                porcentajeSuficientes = (Math.round(100 * suficiente / 45));
                porcentajNotable = (Math.round(100 * notable / 45));
                porcentajeSobresaliente = (Math.round(100 * sobresaliente / 45));
                System.out.printf("""
                         
                        Todas las asigaturas: 
                        ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓
                        
                        %d muy deficiente/s, el: %d%%
                        
                        %d insuficiente/s, el: %d%%
                        
                        %d suficiente/s, el: %d%%
                        
                        %d notable/s, el: %d%%
                        
                        %d sobresaliente/s, el: %d%%\n""",
                        muyDeficiente,porcentajeMuyDeficientes,insuficiente,porcentajeInsuficientes,
                        suficiente,porcentajeSuficientes,notable,
                        porcentajNotable,sobresaliente, porcentajeSobresaliente);
                System.out.println("\nQuieres calcular la estadisitica de otra asignatura? (S/N)");
                opcionOtraAsignatura = leerString.nextLine();
                if(opcionOtraAsignatura.equalsIgnoreCase("s")){
                    estadistica();
                }
        }
    }

    public void  salir(){

        System.out.println("""
                
                   ____________________________________________________
                  |____________________________________________________|
                  |        _     ___    ___    ___    ___   _\s         |
                  |       / \\   |   \\  |_ _|  / _ \\  / __| | |         |
                  |      / _ \\  | |) |  | |  | (_) | \\__ \\ |_|         |
                  |     /_/ \\_\\ |___/  |___|  \\___/  |___/ (_)         |
                  |____________________________________________________|
                  |____________________________________________________|
                  | _____________________           __   __  _  __    _|
                  ||=|=|=|=|=|=|=|=|=|=|=| _______ |  |_|  ||#||==|  / |
                  || | | | | | | | | | | |/       \\|++|=|  || ||==| / /|
                  ||_|_|_|_|_|_|_|_|_|_|_/_________\\__|_|__||_||__|/_/_|
                  |____________________ /\\~()/()~//\\ __________________|
                  | __   __    _  _     \\_  (_    _/ _    ___     _____|
                  ||~~|_|..|__| || |_ _   \\ //\\\\ /  |=|__|~|~|___| | | |
                  ||--|+|^^|==|1||2| | |_/ \\ __ /\\_ | |==|x|x|+|+|=|=|=|
                  ||__|_|__|__|_||_|_| /  \\ \\  / /  \\_|__|_|_|_|_|_|_|_|
                  |_________________ _/    \\/\\/\\/    \\_ _______________|
                  | _____   _   __  |/      \\../      \\|  __   __   ___|
                  ||_____|_| |_|##|_||   |   \\/ __|   ||_|==|_|++|_|-|||
                  ||______||=|#|--| |\\   \\   o    /   /| |  |~|  | | |||
                  ||______||_|_|__|_|_\\   \\  o   /   /_|_|__|_|__|_|_|||
                  |____________________\\___\\____/___/__________________|
                  |         /    ________     ______           /|      |
                  |        /   //    /| //   /  /  /   |      / |      |
                  |       /   //____// //   /__/__/   (_)    /  |      |
                  |      /   /(____|/ //                    /  /|      |  
                  |     /   /________//   ________         /  / |      |
                  |    /   (|________/   |\\_______\\       /  /| |      |
                  |   /                  \\|________)     /  / | |
                """);
    }
}
