import java.util.Scanner;

public class MMD {

    //Drclaracion de los escaner.
    Scanner leerInt = new Scanner(System.in);

    //Declaracion de arrays.
    String[] arrayMenu;

    //Declaracion de las matrices.
    int[][] matriz1;
    int[][] matriz2;
    int[][] matrizSumas;
    int[][] matrizEscalar1;
    int[][] matrizEscalar2;
    int[][] matrizProducto;
    int[][] matrizTransporta1;
    int[][] matrizTransporta2;

    //Declaracion de variables.
    int tituloMenu = 1;
    int numeroEscalar;

    //Constructor de la clase.
    public MMD() {

        //Inicializacion de las arrays.
        arrayMenu = new String[8];
        inicializarmatriz();

        //Inicializacion de las matrices.
        matriz1 = new int[3][3];
        matriz2 = new int[3][3];
        matrizSumas = new int[3][3];
        matrizEscalar1 = new int[3][3];
        matrizEscalar2 = new int[3][3];
        matrizProducto = new int[3][3];
        matrizTransporta1 = new int[3][3];
        matrizTransporta2 = new int[3][3];

        //Inizializacion de las variables.
    }

    //Metodo main inicio del programa.
    public static void main(String[] args) {

        //Opcion que se ejecutara en el switchcase.
        int opcionmenu;

        //Instancia del constructor de la clase.
        MMD programa = new MMD();

        //bucle para para que el programa no acabe.
        do {
            programa.mostrarMenu();
            opcionmenu = programa.leeropcion();
            programa.ejecutaropcion(opcionmenu);
        } while (!(opcionmenu == 8));
        //programa.finalizarMenu();
    }

    private void inicializarmatriz() {

        arrayMenu[0] = "[1] - Emplena la primera matriu.";
        arrayMenu[1] = "[2] - Emplena la segona matriu";
        arrayMenu[2] = "[3] - Visualitza les matrius.";
        arrayMenu[3] = "[4] - Suma les matrius.";
        arrayMenu[4] = "[5] - Multiplica per un escalar.";
        arrayMenu[5] = "[6] - Producte de matrius.";
        arrayMenu[6] = "[7] - Transporta.";
        arrayMenu[7] = "[8] - Eixir.";
    }

    public void mostrarMenu() {

        while (tituloMenu == 1) {
            System.out.print("""
                                        
                     ___   ___   ___   _  _  __   __  ___   _  _   ___   ___     ___ \s
                    | _ ) |_ _| | __| | \\| | \\ \\ / / | __| | \\| | |_ _| |   \\   / _ \\\s
                    | _ \\  | |  | _|  | .` |  \\ V /  | _|  | .` |  | |  | |) | | (_) |
                    |___/ |___| |___| |_|\\_|   \\_/   |___| |_|\\_| |___| |___/   \\___/\s
                       _     _
                      /_\\   | |
                     / _ \\  | |__
                    /_/ \\_\\ |____|
                     ___   ___    ___     ___   ___     _     __  __     _     \s
                    | _ \\ | _ \\  / _ \\   / __| | _ \\   /_\\   |  \\/  |   /_\\        \s
                    |  _/ |   / | (_) | | (_ | |   /  / _ \\  | |\\/| |  / _ \\      \s
                    |_|   |_|_\\  \\___/   \\___| |_|_\\ /_/ \\_\\ |_|  |_| /_/ \\_\\ \s
                     __  __   __  __   ___      _\s
                    |  \\/  | |  \\/  | |   \\    | |
                    | |\\/| | | |\\/| | | |) |   |_|
                    |_|  |_| |_|  |_| |___/    (_)
                    """);
            tituloMenu++;
        }
        System.out.println("\n");
        for (String i : arrayMenu) {
            System.out.println(i);
        }
        System.out.print("""
                ----------------------------------
                Escoge una opcion:""");
    }

    public int leeropcion() {
        return leerInt.nextInt();
    }

    public void ejecutaropcion(int opcionmenu) {

        switch (opcionmenu) {
            case 1 -> llenarmatriz1();
            case 2 -> llenarmatriz2();
            case 3 -> mostrarmatrices();
            case 4 -> {
                suma();
                mostrarsuma();
            }
            case 5 -> {
                escalar();
                mostrarescalar();
            }
            case 6 -> {
                producto();
                mostrarProducto();
            }
            case 7 -> {
                transporta();
                mostrarTransporta();
            }
            case 8 -> salir();
        }
    }

    private void llenarmatriz1() {

        System.out.println();
        for (int i = 0; i < matriz1.length; i++) {
            for (int j = 0; j < matriz1[i].length; j++) {
                System.out.print("Introduce en la primera matriz el valor de la posicion ["+i+"]["+j+"]: ");
                matriz1[i][j] = leerInt.nextInt();
            }
        }
    }

    private void llenarmatriz2() {

        System.out.println();
        for (int i = 0; i < matriz2.length; i++) {
            for (int j = 0; j < matriz2[i].length; j++) {
                System.out.print("Introduce en la segunda matriz el valor de la posicion ["+i+"]["+j+"]: ");
                matriz2[i][j] = leerInt.nextInt();
            }
        }
    }

    public void mostrarmatrices() {

        System.out.println("""
                
                Primera matriz
                ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓""");
        for (int[] i : matriz1) {
            System.out.println();
            for (int j : i) System.out.print(j + " ");
        }
        System.out.println("""
                
                
                Segunda matriz
                ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓""");
        for (int[] i : matriz2) {
            System.out.println();
            for (int j : i) System.out.print(j + " ");
        }
    }

    public void suma() {

        System.out.println("""
                
                Suma de la primera y la segunda matriz
                ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓""");
        for (int x = 0; x < matriz1.length; x++) {
            for (int y = 0; y < matriz2[x].length; y++) {
                matrizSumas[x][y] = matriz1[x][y] + matriz2[x][y];
            }
        }
    }

    public void mostrarsuma(){

        for(int[] i : matrizSumas){
            System.out.println();
            for(int j : i) System.out.print(j + " ");
        }
    }

    public void escalar(){

        System.out.print("\nIntroduce un numero para multiplicarlo por las dos matrices: ");
        numeroEscalar = leerInt.nextInt();
        for(int i = 0; i < matrizEscalar1.length; i++){
            for (int j = 0; j < matrizEscalar1[i].length; j++){
                matrizEscalar1[i][j] = matriz1[i][j] * numeroEscalar;
                matrizEscalar2[i][j] = matriz2[i][j] * numeroEscalar;
            }
        }
    }

    public void mostrarescalar(){

        System.out.println("\nPrimera matriz multiplicada por → "+ numeroEscalar);
        for(int[] i : matrizEscalar1){
            System.out.println();
            for (int j : i){
                System.out.print(j + " ");
            }
        }
        System.out.println();
        System.out.println("\nSegunda matriz multiplicada por → "+ numeroEscalar);
        for(int[] i : matrizEscalar2){
            System.out.println();
            for (int j : i){
                System.out.print(j + " ");
            }
        }
    }

    private void producto(){

        System.out.println("""
                
                Primera y segunda matriz multiplicadas entre si
                ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓""");
        for (int i = 0 ; i < matrizProducto.length; i++){
            for (int j = 0; j < matrizProducto[i].length; j++){
                for (int k = 0; k < matrizProducto.length; k++){
                    matrizProducto[i][j] = matrizProducto[i][j] + matriz1[i][k] * matriz2[k][j];
                }
            }
        }
    }

    public void mostrarProducto(){

        for (int[] i : matrizProducto){
            System.out.println();
            for (int j : i){
                System.out.print(j + " ");
            }
        }
    }

    private void transporta(){

        for (int i = 0; i < matrizTransporta1.length; i++){
            for (int j = 0; j < matrizTransporta1[i].length; j++){
                matrizTransporta1[i][j] = matriz1[j][i];
            }
        }
        for (int i = 0; i < matrizTransporta2.length; i++){
            for (int j = 0; j < matrizTransporta2[i].length; j++){
                matrizTransporta2[i][j] = matriz2[j][i];
            }
        }
    }

    public void mostrarTransporta(){

        System.out.println("""
                
                Valores de la primera array intercambiados por el metodo → transporta
                ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓""");
        for (int []i : matrizTransporta1){
            System.out.println();
            for ( int j : i){
                System.out.print(j + " ");
            }
        }
        System.out.println("""
                
                
                Valores de la segunda array intercambiados por el metodo → transporta
                ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓""");
        for (int []i : matrizTransporta2){
            System.out.println();
            for (int j : i){
                System.out.print(j + " ");
            }
        }
    }

    public void salir(){

        System.out.println("""
                                       __
                                     .'  '.
                                 _.-'/  |  \\
                    ,        _.-"  ,|  /  0 `-.
                    |\\    .-"       `--""-.__.'=====================-,
                    \\ '-'`        .___.--._)=========================|
                     \\            .'      |                          |
                      |     /,_.-'        |   PROGRAMA MMD CERRADO   |
                    _/   _.'(             |      CORRECTAMENTE       |
                   /  ,-' \\  \\            |    ¡HASTA LA PROXIMA!    |
                   \\  \\    `-'            |                          |
                    `-'                   '--------------------------'""");
    }

}