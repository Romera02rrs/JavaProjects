public class main {

    public static void main(String[] args) {

        cTablero tablero = new cTablero();
        cTableroUI tableroUI = new cTableroUI();

        /*//Imprime el titulo de letras ASCII
        mostrarTitulo();
        System.out.println("""
                        
                          *********************
                          * Coloca los barcos *
                          *********************
                """);*/
        //Inicializa todas las posiciones de los tableros a ' '
        tablero.reinicializarTableros();
        /*//Muestra el tablero por pantalla
        tablero.mostrarTablero();*/

        cTableroUI.ejecutaInterfaz();

        //Coloca todos los barcos por orden de tamaño de mayor a menor
        //tablero.colocaBarcos();
        System.out.println("""
                        
                          *************************
                          * Comienza a ¡DISPARAR! *
                          *************************
                """);
        //Muestra el tablero sin mostrar la posicion de los barcos
        //Muestra los disparos
        tablero.mostrarDisparos();
        //Bucle infinito de disparos hasta que los barcos hayan sido hundidos
        //tablero.jugar();
        System.out.println("""
                        
                          *************************
                          *    ¡Fin del juego!    *
                          *************************
                """);
    }

    //Imprime el titulo de letras ASCII
    private static void mostrarTitulo(){
        System.out.println("""
                  
                  ___ ___                   .___.__       \s
                 /   |   \\ __ __  ____    __| _/|__|______\s
                /    ~    \\  |  \\/    \\  / __ | |  \\_  __ \\
                \\    Y    /  |  /   |  \\/ /_/ | |  ||  | \\/
                 \\___|_  /|____/|___|  /\\____ | |__||__|  \s
                       \\/            \\/      \\/           \s
                 .__                                      \s
                 |  | _____                               \s
                 |  | \\__  \\                              \s
                 |  |__/ __ \\_                            \s
                 |____(____  /                            \s
                           \\/                             \s
                ___________.__          __                \s
                \\_   _____/|  |   _____/  |______         \s
                 |    __)  |  |  /  _ \\   __\\__  \\        \s
                 |     \\   |  |_(  <_> )  |  / __ \\_      \s
                 \\___  /   |____/\\____/|__| (____  /      \s
                     \\/                          \\/       \s
                """);
    }
}
