import java.util.Scanner;

public class TAD {

    // Declaracion de constantes
    Scanner leerint = new Scanner(System.in);
    Scanner leerstring = new Scanner(System.in);
    Scanner leerchar = new Scanner(System.in);

    static final int MAX = 10; // Numero maximo de posiciones en la array de enteros y caracteres.
    static final int MENU = 11; // Numero maximo de posiciones en la array del menu.

    // Declaracion de las arrays.
    private int[] arrayEnters;
    private char[] arrayCaracters;
    private String[] menu;

    // Declaracion de variables globales.
    private int posCentro;
    private int clau;
    private int contador;
    private int cont;

    public static void main(String[] args) {

        int iopcio;
        TAD programa = new TAD();
        do {
            programa.mostrarMenu();
            iopcio = programa.llegirOpcio();
            programa.executarOpcio(iopcio);
            programa.enter(); // preionar enter y repetir el bucle.
        } while (true);
    }

    // Constructor de classe TAD.
    public TAD() {

        arrayEnters = new int[MAX];
        arrayCaracters = new char[MAX];

        // Inicialitzar arrayEnters i arrayCaracters.
        generarArraysAleatorisEnters();
        generarArraysAleatorisCaracters();

        // Inicialitzar el menu d'opcions.
        incialitzarMenu();

    }

    // Metido para dar los valores a la array del menu.
    private void incialitzarMenu() {

        menu = new String[MENU];
        menu[0] = "[00] - Salir del programa";
        menu[1] = "[01] - Mostrar array de enteros";
        menu[2] = "[02] - Mostrar array caracteres";
        menu[3] = "[03] - Reinicializar vectores";
        menu[4] = "[04] - Busqueda sequencial";
        menu[5] = "[05] - Busqueda binaria";
        menu[6] = "[06] - Ordenar con burbuja";
        menu[7] = "[07] - Ordenar con quicksort";
        menu[8] = "[08] - Ordenar con shell";
        menu[9] = "[09] - Ordenar con Seleccion";
        menu[10] = "[10] - Ordenar con Inserci�n";
    }

    // Metodo que imprime por pantalla los valores de la array del menu.
    private void mostrarMenu() {

        System.out.println("\n*****************************************"
                + "\n*      Bienvenido al programa TAD!      *\n" + "*****************************************\n");
        for (String i : menu)
            System.out.println(i);
        System.out.println("\n" + "-----------------------------------------" + "\nEscoge una opci�n: \n"
                + "-----------------------------------------");
    }

    // Escaner del teclado para el switch-case.
    private int llegirOpcio() {

        int opcio;
        opcio = leerint.nextInt();
        return opcio;
    }

    // Switch-Case
    public void executarOpcio(int iopcio) {
        while (iopcio > 10 || iopcio < 0) {
            System.out.println("\nOpcion incorrecta, escoge una valida: ");
            iopcio = leerint.nextInt();
        }
        System.out.print("\n");
        switch (iopcio) {
            case 0:
                salir();
            case 1:
                mostrarArrayEnters();
                break;
            case 2:
                mostrarArrayCaracters();
                break;
            case 3:
                reinicializarvectores();
                break;
            case 4:
                sequencial();
                break;
            case 5:
                binaria(0);
                mostrarBinaria();
                break;
            case 6:
                ordenarLlistaAsc();
                break;
            case 7:
                Quicksort(0, 9);
                mostrarquicksort();
                break;
            case 8:
                shell();
                mostrarshell();
                break;
            case 9:
                seleccio();
                mostrarseleccio();
                break;
            case 10:
                insercion();
                mostrarinserccio();
        }
    }

    // 00 -- Metodo para salir del programa.
    private void salir() {

        System.out.println("Hasta pronto! ^_^");

        System.out.print("\nSaliendo de TAD ");
        System.out.print(".");
        System.out.print(".");
        System.out.print(".");

        // Funcion para apagar el programa.
        System.exit(0);

    }

    // 01 -- Metode que mostra per pantalla l'array d'enters.
    private void mostrarArrayEnters() {

        System.out.print("Array de enteros = {");
        for (int k : arrayEnters) {
            System.out.print(k + ", ");
        }
        System.out.println("}");
    }

    // 02 -- Metode que mostra per pantalla l'array de caracters.
    private void mostrarArrayCaracters() {
        System.out.print("Array de caracteres = {");
        for (int i : arrayCaracters) {
            System.out.print((char) i + ", ");
        }
        System.out.println("}");
    }

    // 03 -- Metodo para escoger que array reinicializar.
    private void reinicializarvectores() {

        System.out.println("Que array deseas reinicializar?");
        System.out.println("--> La de Enteros (E)");
        System.out.println("--> La de Caracteres (C)");
        System.out.println("--> Ambas (A)");
        System.out.print("--> : ");
        String letra = leerstring.nextLine();
        // En caso de no introducir una opcion valida.
        while (!(letra.equalsIgnoreCase("E") || letra.equalsIgnoreCase("C") || letra.equalsIgnoreCase("A"))) {
            System.out.println("\n--> Escriba (E) para reinicializar la array de enteros");
            System.out.println("--> Escriba (C) para reinicializar la de caracteres");
            System.out.println("--> Escriba (A) para reinicializar ambas");
            letra = leerstring.nextLine();
        }
        // Selector de opciones.
        if (letra.equalsIgnoreCase("E")) {
            generarArraysAleatorisEnters();
            System.out.println("\nArray de enteros reinicializada con exto!");
        } else if (letra.equalsIgnoreCase("C")) {
            generarArraysAleatorisCaracters();
            System.out.println("\nArray de caracteres reinicializada con exto!");
        } else if (letra.equalsIgnoreCase("A")) {
            generarArraysAleatorisEnters();
            generarArraysAleatorisCaracters();
            System.out.println("\nArray de numeros y caracteres reinicializadas con exto!");
        }
    }

    // 04 -- Metode de recerca sequencial.
    public void sequencial() {

        int vueltas = -1;
        System.out.println("Introduce el n�mero que buscas: ");
        int llave = leerint.nextInt();
        for (int a : arrayEnters) {
            vueltas++;
            if (a == llave) {
                System.out.println(
                        "\nNumero encontrado, se encuentra en el indice " + vueltas + " de la array de enteros");
                return;
            }
        }
        // Error por no haber encontrado el numero dentro de la array.
        System.out.println("\nNo se ha encontrado el nuemero, ");
        System.out.println("--> Si necesitas volver a ver la array de numeros presiona (A), ");
        System.out.println("--> Si deseas volver a probar con otro numero, presiona (B), ");
        System.out.println("--> Presiona (ENTER) para volver al menu ");
        String volver = leerstring.nextLine();
        // En caso de no introducir una opcion valida.
        while (!(volver.equalsIgnoreCase("A") || volver.equalsIgnoreCase("B") || volver.isEmpty())) {
            System.out.println("--> Presiona la tecla (A) para volver a ver la array de numeros, ");
            System.out.println("--> Presiona (B) para probar otro numero, ");
            System.out.println("--> Presiona (ENTER) para volver al menu ");
            volver = leerstring.nextLine();
        }
        if (volver.equalsIgnoreCase("a")) {
            System.out.println();
            mostrarArrayEnters();
            System.out.println();
            sequencial();
        } else if (volver.equalsIgnoreCase("B")) {
            System.out.println();
            sequencial();
            System.out.println();
        } else if (volver.isEmpty()) {
            return;
        }
    }

    // Metodo de comprobacion de ordenacion de la array para el metodo de ordenamiento.
    public boolean estaOrdenado() {

        boolean ordenado = true;
        int i;
        do {
            for (i = 0; i < MAX - 1; i++) {
                if (arrayEnters[i] <= arrayEnters[i + 1]) {
                } else {
                    ordenado = false;
                }
            }
        } while (i < MAX - 1);
        return ordenado;
    }

    // 05 -- Metodo para buscar de forma binaria (solo con la array ordenada).
    public int binaria(int clau) {

        int posInicio, posFinal, valorCentral;
        boolean ordenado = estaOrdenado();
        String comprobar;
        if (ordenado == true) {
            System.out.println("Introduce el numero que deseas busacar con el metodo binario: ");
            clau = leerint.nextInt();
            posInicio = 0;
            posFinal = arrayEnters.length - 1;
            while (posInicio <= posFinal) {
                posCentro = (posInicio + posFinal) / 2;
                valorCentral = arrayEnters[posCentro];
                if (clau == valorCentral) {
                    return valorCentral;
                } else if (clau < valorCentral) {
                    posFinal = posCentro - 1;
                } else {
                    posInicio = posCentro + 1;
                }
            }
            return posCentro;
            // En caso de que la array no este ordenada.
        } else {
            System.out.println("Para usar la b�squeda binaria la array debe estar ordenada,");
            System.out.println("Deseas ordenar la array? (S/N)");
            comprobar = leerstring.nextLine();
            // En caso de no introducir una opcion valida.
            while (!(comprobar.equalsIgnoreCase("S") || comprobar.equalsIgnoreCase("N"))) {
                System.out.println("Deseas ordenar la array? (S/N)");
                comprobar = leerstring.nextLine();
            }
            if (comprobar.equalsIgnoreCase("S")) {
                ordenarLlistaAsc();
                binaria(clau);
            } else {
                main(menu);
            }
        }
        return posCentro;
    }

    public void mostrarBinaria() {

        System.out.println("\nEl numero " + clau + " se encuentra en el indice " + posCentro + " de la array");
    }

    // 06 -- Metode d'ordenaci� per bombolla ascendent.
    public void ordenarLlistaAsc() {

        System.out.println("Quieres cambiar los indices de la array y ordenar los numeros? (S/N)");
        String sn = leerstring.nextLine();
        // En caso de no introducir una opcion valida.
        while (!(sn.equalsIgnoreCase("S") || sn.equalsIgnoreCase("N"))) {
            System.out.println(
                    "Presiona (S) para cambiar los indices de la array y ordenar los numeros o (N) para volver al menu: ");
            sn = leerstring.nextLine();
        }
        if (sn.equalsIgnoreCase("S")) {
            for (int i = 0; i < arrayEnters.length - 1; i++) {
                for (int j = i + 1; j < arrayEnters.length; j++) {
                    if (arrayEnters[i] > arrayEnters[j]) {
                        int aux = arrayEnters[i];
                        arrayEnters[i] = arrayEnters[j];
                        arrayEnters[j] = aux;
                        // Para mostrar todos los cambios que hace en la array de enteros.
                        mostrarArrayEnters();
                    }
                }
            }
            System.out.print("\nArray de enteros ordeanada con el metodo burbuja = {");
            for (int z : arrayEnters) {
                System.out.print(z + ", ");
            }
            System.out.println("}\n");
        } else {
            return;
        }
    }

    // 07 -- Metodo de ordenacion con Quicksort.
    public void Quicksort(int primer, int ultim) {

        int i, j, central, pivot, tmp;
        central = (primer + ultim) / 2;
        pivot = arrayEnters[central];
        i = primer;
        j = ultim;
        do {
            while (arrayEnters[i] < pivot)
                i++;
            while (arrayEnters[j] > pivot)
                j--;
            if (i <= j) {
                tmp = arrayEnters[i];
                arrayEnters[i] = arrayEnters[j];
                arrayEnters[j] = tmp;
                i++;
                j--;
                // Para mostrar todos los cambios que hace en la array de enteros.
                mostrarArrayEnters();
            }
        } while (i <= j);
        if (primer < j)
            Quicksort(primer, j);
        if (i < ultim)
            Quicksort(i, ultim);
    }

    public void mostrarquicksort() {

        System.out.print("\nArray de enteros ordeanada con el metodo quicksort = {");
        for (int z : arrayEnters) {
            System.out.print(z + ", ");
        }
        System.out.println("}\n");
    }

    // 08 -- Metodo de ordenacion con shell.
    public void shell() {

        int interval, n = 0, i, j, k, temp;
        n = arrayEnters.length;
        interval = arrayEnters.length / 2;
        interval /= 2;
        while (interval > 0) {
            for (i = interval; i < n; i++) {
                j = i - interval;
                while (j >= 0) {
                    k = j + interval;
                    if (arrayEnters[j] <= arrayEnters[k]) {
                        j = -1;
                        // Para mostrar todos los cambios que hace en la array de enteros.
                        mostrarArrayEnters();
                    } else {
                        temp = arrayEnters[j];
                        arrayEnters[j] = arrayEnters[k];
                        arrayEnters[k] = temp;
                        j -= interval;
                    }
                }
            }
            interval = interval / 2;
        }
    }

    public void mostrarshell() {

        System.out.print("\nArray de enteros ordeanada con el metodo Shell = {");
        for (int i : arrayEnters) {
            System.out.print(i + ", ");
        }
        System.out.println("}\n");
    }

    // 09 -- Metodo de ordenacion mediante seleccion.
    public void seleccio() {

        int i, j, menor, posicion, aux;
        for (i = 0; i < arrayEnters.length - 1; i++) {
            menor = arrayEnters[i];
            posicion = i;
            for (j = i + 1; j < arrayEnters.length; j++) {
                if (arrayEnters[j] < menor) {
                    menor = arrayEnters[j];
                    posicion = j;
                    // Para mostrar alguno de los cambios que hace en la array de enteros.
                    mostrarArrayEnters();
                }
            }
            if (posicion != i) {
                aux = arrayEnters[i];
                arrayEnters[i] = arrayEnters[posicion];
                arrayEnters[posicion] = aux;
                // Para mostrar el resto de los cambios que hace en la array de enteros.
                mostrarArrayEnters();
            }
        }
    }

    public void mostrarseleccio() {
        System.out.print("\nArray de enteros ordeanada con el metodo de seleccion = {");
        for (int i : arrayEnters) {
            System.out.print(i + ", ");
        }
        System.out.println("}\n");
    }

    // 10 -- Metodo de ordenacion mediante insercion.
    public void insercion() {

        int i, j;
        int aux;
        for (i = 1; i < arrayEnters.length; i++) {
            aux = arrayEnters[i];
            j = i - 1;
            while ((j >= 0) && (aux < arrayEnters[j])) {
                arrayEnters[j + 1] = arrayEnters[j];
                j--;
                // Para mostrar todos los cambios que hace en la array de enteros.
                mostrarArrayEnters();
            }
            arrayEnters[j + 1] = aux;
        }
    }

    public void mostrarinserccio() {

        System.out.print("\nArray de enteros ordeanada con el metodo de insercion = {");
        for (int i : arrayEnters) {
            System.out.print(i + ", ");
        }
        System.out.println("}\n");
    }

    // Metodo para generar numeros aleatorios en la array de numeros.
    private void generarArraysAleatorisEnters() {

        // rellenar la array o sobreescribir los valores.
        for (int i = 0; i < MAX; i++) {
            arrayEnters[i] = (int) (Math.random() * 100) + 1;
        }
    }

    // Metodo para generar caracteres aleatorios en la array de caracteres.
    private void generarArraysAleatorisCaracters() {

        // rellenar la array o sobreescribir los valores.
        for (int i = 0; i < MAX; i++) {
            arrayCaracters[i] = (char) (Math.random() * (122 - 97) + 97);
        }
    }

    // Metodo para detectar la tecla enter y mostrar el menu.
    private void enter() {

        String enter;
        do {
            System.out.println("\nPresiona la tecla ENTER para volver al menu -->");
            enter = leerstring.nextLine();
            // Hasta que no se aprete la tecla ENTER haber escrito ningun valor antes.
        } while (!(enter.isEmpty()));
    }
}
