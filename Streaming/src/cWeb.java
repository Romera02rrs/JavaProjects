import javax.swing.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class cWeb {

    Scanner sc = new Scanner(System.in);
    Scanner scLine = new Scanner(System.in);

    public ArrayList<cUsuario> listaUsuarios;
    public ArrayList<cPelicula> listaPeliculas;
    public ArrayList<cSerie> listaSeries;

    String[][] menu;
    String[] generos;

    public cWeb(){

        menu = new String[4][9];
        generos = new String[10];
        setGeneros();
        setMenu();

        listaPeliculas = new ArrayList<>();
        listaUsuarios = new ArrayList<>();
        listaSeries = new ArrayList<>();
    }

    public static void main(String[] args) {

        int opcion1, opcion2;
        boolean inicioCorrecto = false;
        cWeb w = new cWeb();
        w.mostrarInicio();

        //Bucle que se ejecutara hasta que finalice el programa
        do{
            //Bucle que se ejecutara hasta que se inicie sesion
            do{
                w.mostrarMenu1();
                opcion1 = w.getOpcion1();
                switch (opcion1){
                    case 1 -> w.nuevoUsuario();
                    case 2 -> inicioCorrecto = w.iniciarSesion();
                    case 3 -> w.mostrarInfo();
                    case 0 -> {
                        w.mostrarFinal();
                        System.exit(0);
                    }
                }
            }while (!(inicioCorrecto));
            //Bucle del segundo menu que maeja los metodos de las peliculas y series
            do{
                w.mostrarMenu2();
                opcion2 = w.getOpcion2();
                w.ejecutarOpcion2(opcion2);
            }while (opcion2 != 0);
        }while (true);
    }

    private void ejecutarOpcion2(int opcion2){

        //Opciones del menu
        switch (opcion2){
            case 1 -> mostrarPeliculas();
            case 2 -> mostrarSeries();
            case 3 -> valorarPelicula();
            case 4 -> valorarSerie();
            case 5 -> insertarPelicula();
            case 6 -> insertarSerie();
            case 7 -> editarPelicula();
            case 8 -> editarSerie();
        }
    }

    //Metodo que escanea la primera opcion del menu
    private int getOpcion1(){

        int opcion;
        do{
            System.out.print("Opcion: ");
            opcion = sc.nextInt();
        }while (opcion < 0 || opcion > 3);
        return opcion;
    }

    //Metodo que escanea la segunda opcion del menu
    private int getOpcion2(){

        int opcion;
        do{
            System.out.print("Opcion: ");
            opcion = sc.nextInt();
        }while (opcion < 0 || opcion > 8);
        return opcion;
    }

    //Metodo que Inicializa el menu
    private void setMenu(){

        menu [0][0] = "\n[1] Registrarse";
        menu [0][1] = "[2] Iniciar sesion";
        menu [0][2] = "[3] Informacion";
        menu [0][3] = "[0] <- Salir";

        menu [1][0] = "\n[1] Ver lista de peliculas";
        menu [1][1] = "[2] Ver lista de series";
        menu [1][2] = "[3] Valorar una pelicula";
        menu [1][3] = "[4] Valorar una serie";
        menu [1][4] = "[5] insertar una nueva pelicula";
        menu [1][5] = "[6] insertar una nueva serie";
        menu [1][6] = "[7] editar una pelicula";
        menu [1][7] = "[8] editar una serie";
        menu [1][8] = "[0] <- atras";
    }

    //Metodo que muestra el primer menu
    private void mostrarMenu1(){

        for (int i = 0; i < 1; i++){
            for (int j = 0; j < 4; j++){
                System.out.println(menu[i][j]);
            }
        }
    }

    //Metodo que muestra el segundo menu
    private void mostrarMenu2(){

        for (int i = 1; i < 2; i++){
            for (int j = 0; j < 9; j++){
                System.out.println(menu[i][j]);
            }
        }
    }
    //

    //Metodo que llama al metodo de crear un usuario y lo introduce a la arrayList
    private void nuevoUsuario(){

        cUsuario u = setUsuario();
        altaUsuario(u);
    }

    //Metodo que llama al metodo de crear una pelicula y la introduce a la arrayList
    private void insertarPelicula(){

        cPelicula p = setPelicula();
        altaPelicula(p);
    }

    //Metodo que llama al metodo de crear una serie y la introduce a la arrayList
    private void insertarSerie(){

        cSerie s = setSerie();
        altaSerie(s);
    }

    //Metodo que crea un usuario e introduce los valores al objeto usuario
    private cUsuario setUsuario() {

        cUsuario u = new cUsuario();
        String correo, clave;
        do{
            correo = verificaCorreo();
        }while (compruebaCorreoExistente(correo, true));
        u.correo = correo;
        u.contra = verificaClave();
        System.out.print("\nIntroduzca su nombre: ");
        u.nombre = scLine.nextLine();
        System.out.print("\nIntroduzca su primer apellido: ");
        u.apellido = scLine.nextLine();
        return u;
    }

    //Metodo que pida usuario y clave para iniciar sesion
    private boolean iniciarSesion(){

        String correo, clave;
        if (noHayUsuarios()){
            return false;
        }
        do{
            System.out.print("\nCorreo: ");
            correo = scLine.nextLine();
        }while (!(compruebaCorreoExistente(correo, false)));
        do{
            System.out.print("\nClave:  ");
            clave = scLine.nextLine();
        }while (compruebaClaveCorrecta(correo, clave));
        return true;
    }

    //Metodo que comprueba si existe el correo que se pretende registrar
    private boolean compruebaCorreoExistente(String correo, boolean registrarse){

        Iterator<cUsuario> iter;
        iter = listaUsuarios.iterator();
        while (iter.hasNext()){
            cUsuario u = iter.next();
            if (u.correo.equalsIgnoreCase(correo)){
                if(registrarse){
                    System.out.println("\nEl correo introducido ya existe");
                }
                return true;
            }
        }
        return false;
    }

    //Metodo que comprueba que la clave sea igual a la clave del usuario
    private boolean compruebaClaveCorrecta(String correo, String clave){

        Iterator<cUsuario> iter;
        iter = listaUsuarios.iterator();
        while (iter.hasNext()){
            cUsuario u = iter.next();
            if (u.correo.equalsIgnoreCase(correo) && u.contra.equals(clave)){
                System.out.println("\nClave correcta\n\nInicio de sesion ¡EXITOSO!\n\n¡Bienvenido " + u.nombre + "!");
                return false;
            }
        }
        return true;
    }

    //Metodo que crea una pelicula e introduce los valores al objeto pelicula
    private cPelicula setPelicula(){

        cPelicula p = new cPelicula();

        cActor a;
        cDirector d;
        System.out.print("\nIntroduce el titulo de la pelicula: ");
        p.titulo = scLine.nextLine();
        System.out.print("Introduce la fecha de salida: ");
        p.fecha = scLine.nextLine();
        System.out.print("Introduce el pais de produccion: ");
        p.paisDeProduccion = scLine.nextLine();
        p.genero = getGenero();
        System.out.print("\nIntroduce un resumen de la pelicula: ");
        p.resumen = scLine.nextLine();
        System.out.print("\nActores y Actrices. ");
        System.out.print("Quieres introducir un nuevo actor/actriz? (S/N): ");
        while (pregunta()){
            a = setActor();
            p.altaActor(a);
            System.out.print("Quieres introducir un nuevo actor/actriz? (S/N): ");
        }
        System.out.print("\nDirector de pelicula. ");
        System.out.print("Quieres introducir un nuevo director? (S/N): ");
        while (pregunta()){
            d = setDirector();
            p.altaDirector(d);
            System.out.print("Quieres introducir un nuevo director? (S/N): ");
        }
        return p;
    }

    //Metodo que crea una serie introduce los valores al objeto serie
    private cSerie setSerie(){

        cSerie s = new cSerie();

        cActor a;
        cDirector d;
        cTemporada t;
        cCapitulos c;
        System.out.print("\nIntroduce el titulo de la serie: ");
        s.titulo = scLine.nextLine();
        System.out.print("Introduce la fecha de salida: ");
        s.fecha = scLine.nextLine();
        System.out.print("Introduce el pais de produccion: ");
        s.paisDeProduccion = scLine.nextLine();
        s.genero = getGenero();
        System.out.print("\nIntroduce un resumen de la serie: ");
        s.resumen = scLine.nextLine();
        System.out.print("Introduce el numero de temporadas: ");
        s.numeroTemporadas = scLine.nextLine();
        System.out.print("\nTemporadas. Quieres insertar una nueva temporada? (S/N): ");
        while (pregunta()){
            t = setTemporada();
            s.altaTemporada(t);
            System.out.print("\nCapitulos. Quieres introducir un nuevo capitulo? (S/N): ");
            while (pregunta()){
                c = setCapitulo();
                t.altaCapitulo(c);
                System.out.print("\nQuieres introducir un nuevo capitulo? (S/N): ");
            }
            System.out.print("\nQuieres insertar una nueva temporada? (S/N): ");
        }
        System.out.print("\nActores y Actrices. Quieres introducir un nuevo actor/actriz? (S/N): ");
        while (pregunta()){
            a = setActor();
            s.altaActor(a);
            System.out.print("Quieres introducir un nuevo actor/actriz? (S/N): ");
        }
        System.out.print("\nDirector de pelicula. ");
        System.out.print("Quieres introducir un nuevo director? (S/N): ");
        while (pregunta()){
            d = setDirector();
            s.altaDirector(d);
            System.out.print("Quieres introducir un nuevo director? (S/N): ");
        }
        return s;
    }

    //Metodo que devuelve un booleano dependioendo de las respuestas ("S") o ("N")
    private boolean pregunta(){

        String opcion;
        do{
            opcion = scLine.nextLine();
        }while (!(opcion.equalsIgnoreCase("S") || opcion.equalsIgnoreCase("N")));
        if (opcion.equalsIgnoreCase("S")){
            return true;
        }else{
            return false;
        }
    }

    //Metodo que devuelve un actor creandolo e insertando sus valores
    private cActor setActor(){

        cActor a = new cActor();
        System.out.print("Introduce el genero del actor: ");
        a.genero = scLine.nextLine();
        System.out.print("Introduce el nombre: ");
        a.nombre = scLine.nextLine();
        System.out.print("Introduce el apellido: ");
        a.apellido = scLine.nextLine();
        System.out.print("Introduce la fecha de nacimiento: ");
        a.fechaNacimiento = scLine.nextLine();
        System.out.print("Introduce la nacionalidad: ");
        a.nacionalidad = scLine.nextLine();
        return a;
    }

    //Metodo que crea un director e inserta sus valores
    private cDirector setDirector(){

        cDirector d = new cDirector();
        System.out.print("Introduce el genero del director: ");
        d.genero = scLine.nextLine();
        System.out.print("Introduce el nombre: ");
        d.nombre = scLine.nextLine();
        System.out.print("Introduce el apellido: ");
        d.apellido = scLine.nextLine();
        System.out.print("Introduce la fecha de nacimiento: ");
        d.fechaNacimiento = scLine.nextLine();
        System.out.print("Introduce la nacionalidad: ");
        d.nacionalidad = scLine.nextLine();
        return d;
    }

    //Metodo que crea una temporada e inserta sus valores
    private cTemporada setTemporada(){

        cTemporada t = new cTemporada();
        System.out.print("Introduce la fecha de la temporada: ");
        t.fecha = scLine.nextLine();
        System.out.print("Introduce el numero de capitulos (Requiere un numero): ");
        t.numeroCapitulos = sc.nextInt();
        return t;
    }

    //Metodo que crea un capitulo e inserta sus valores
    private cCapitulos setCapitulo(){

        cCapitulos c = new cCapitulos();
        System.out.print("Introduce el titulo del capitulo: ");
        c.titulo = scLine.nextLine();
        System.out.print("Introduce la sinopsis del capitulo: ");
        c.sinopsis = scLine.nextLine();
        return c;
    }

    //Metodo que muestra las peliculas
    private void mostrarPeliculas(){

        String noHayNota;
        if(noHayPeliculas()){
            return;
        }
        System.out.println();
        Iterator<cPelicula> iter = getListaPeliculas().listIterator();
        while (iter.hasNext()){
            cPelicula p = iter.next();
            System.out.println(p.toString(p));
            p.mostrarActores();
            p.mostrarDirectores();
        }
    }

    //Metodo que muestra las series
    private void mostrarSeries(){

        if (noHaySeries()){
            return;
        }
        System.out.println();
        Iterator<cSerie> iter = getListaSeries().listIterator();
        while (iter.hasNext()){
            cSerie s = iter.next();
            System.out.println(s.toString(s));
            s.mostrarTemporadas();
            s.mostrarActores();
            s.mostrarDirectores();
        }
    }

    //Metodo que edita un una pelicula creando una nueva sustituyendola en la array
    private void editarPelicula(){

        String titulo;
        int contador = -1;
        if(noHayPeliculas()){
            return;
        }
        System.out.println("\nSi editas una pelicula tendras que volver a puntuarla");
        titulo = compruebaTituloPelicula();
        Iterator<cPelicula> iter;
        iter = listaPeliculas.iterator();
        while (iter.hasNext()){
            cPelicula p = iter.next();
            contador ++;
            if (p.titulo.equalsIgnoreCase(titulo)){
                this.listaPeliculas.set(contador, setPelicula());
                return;
            }
        }
    }

    //Metodo que edita un una pelicula creando una nueva sustituyendola en la array
    private void editarSerie(){

        String titulo;
        int contador = -1;
        if (noHaySeries()){
            return;
        }
        System.out.println("\nSi editas una serie tendras que volver a puntuarla");
        titulo = compruebaTituloSerie();
        Iterator<cSerie> iter;
        iter = listaSeries.iterator();
        while (iter.hasNext()){
            cSerie s = iter.next();
            contador ++;
            if (s.titulo.equalsIgnoreCase(titulo)){
                this.listaSeries.set(contador, setSerie());
                return;
            }
        }
    }

    //Este metood verifica que buscas un numero de referencia que exista y devuelve un entero
    private String compruebaTituloPelicula(){

        String titulo;
        do{
            System.out.print("\nIntrocuce el titulo de la pelicula: ");
            titulo = scLine.nextLine();
            Iterator<cPelicula> iter;
            iter = listaPeliculas.iterator();
            while (iter.hasNext()){
                cPelicula p = iter.next();
                if (p.titulo.equalsIgnoreCase(titulo)){
                    System.out.println("\nPelicula encontrada");
                    return titulo;
                }
            }
            System.err.println("\npelicula no encontrada");
        }while (true);
    }

    //Este metood verifica que buscas un numero de referencia que exista y devuelve un entero
    private String compruebaTituloSerie(){

        String titulo;
        do{
            System.out.print("\nIntrocuce el titulo de la serie: ");
            titulo = scLine.nextLine();
            Iterator<cSerie> iter;
            iter = listaSeries.iterator();
            while (iter.hasNext()){
                cSerie s = iter.next();
                if (s.titulo.equalsIgnoreCase(titulo)){
                    System.out.println("\nSerie encontrada");
                    return titulo;
                }
            }
            System.err.println("\nSerie no encontrada");
        }while (true);
    }

    //Metodo que introduce la nota y el comentario de una pelicula, tambien puede ediatar los valores ya establecida
    private void valorarPelicula(){

        String titulo;
        if (noHayPeliculas()){
            return;
        }
        mostrarPeliculas();
        titulo = compruebaTituloPelicula();
        Iterator<cPelicula> iter;
        iter = listaPeliculas.iterator();
        while (iter.hasNext()){
            cPelicula p = iter.next();
            if (p.titulo.equalsIgnoreCase(titulo)){
                p.nota = puntua();
                System.out.print("\nIntroduce un comentario sobre tu puntuacion: ");
                p.comentario = scLine.nextLine();
            }
        }
    }

    //Metodo que introduce la nota y el comentario de una serie, tambien puede ediatar los valoes ya establecida
    private void valorarSerie(){

        String titulo;
        if (noHaySeries()){
            return;
        }
        if (listaSeries.isEmpty()){
            System.out.println("\nNo hay Series introducidas");
            return;
        }
        mostrarSeries();
        titulo = compruebaTituloSerie();
        Iterator<cSerie> iter;
        iter = listaSeries.iterator();
        while (iter.hasNext()){
            cSerie s = iter.next();
            if (s.titulo.equalsIgnoreCase(titulo)){
                s.nota = puntua();
                System.out.print("\nIntroduce un comentario sobre tu puntuacion: ");
                s.comentario = scLine.nextLine();
            }
        }
    }

    //Metodo que recibe el numero para la nota con un limite del 0 al 10
    private int puntua(){

        int nota;
        do{
            System.out.print("\nPuntua del 0 al 10 (Requiere un numero): ");
            nota = sc.nextInt();
        }while (nota < 0 || nota > 10);
        return nota;
    }

    //Metodo que comprueba si hay usuarios en la ArrayList
    private boolean noHayUsuarios(){

        if (listaUsuarios.isEmpty()){
            System.out.println("\nNo hay ningun usuario registrado");
            return true;
        }else{
            return false;
        }
    }

    //Metodo que comprueba si hay peliculas en la ArrayList
    private boolean noHayPeliculas(){

        if (listaPeliculas.isEmpty()){
            System.out.println("\nNo hay peliculas introducidas");
            return true;
        }else{
            return false;
        }
    }

    //Metodo que comprueba si hay series en la ArrayList
    private boolean noHaySeries(){

        if (listaSeries.isEmpty()){
            System.out.println("\nNo hay Series introducidas");
            return true;
        }else{
            return false;
        }
    }

    //Metodo que verifica que el correo lleve un arroba y seguido un punto
    private String verificaCorreo(){

        boolean valido = false;
        String correo;
        do{
            System.out.print("\nIntroduce tu correo: ");
            correo = scLine.nextLine();
            for (int i = 0; i < correo.length(); i++){
                if(correo.charAt(i) == '@'){
                    valido = verificaPunto(i, correo);
                }
            }
            if (valido == false){
                System.out.println("El correo debe contener un (@) y seguido un (.)");
            }
        }while (valido == false);
        System.out.println("\nEl correo es verdadero");
        return correo;
    }

    //Verifica que despues de una arroba haya un punto en el correo
    private boolean verificaPunto(int pos, String correo){

        for (int i = pos; i < correo.length(); i++){
            if(correo.charAt(i) == '.'){
                return true;
            }
        }
        return false;
    }

    //Comprueba que la clave tenga una grandaria de 8 caracteres como minimo
    private String verificaClave(){

        String clave;
        do {
            System.out.print("\nIntroduce una clave (Minimo 8 caracteres): ");
            clave = scLine.nextLine();
        }while (clave.length() < 8);
        return clave;
    }

    //Metodo que s eencarga de escoger un genero para la pelicula
    private String getGenero(){

        muestraGeneros();
        int opcion;
        do{
            System.out.print("Escoge un Género: ");
            opcion = sc.nextInt();
        }while(opcion < 1 || opcion > 10);
        switch (opcion){
            case 1 -> {
                return "Accion";
            }
            case 2 -> {
                return "Aventuras";
            }
            case 3 -> {
                return "Animacion";
            }
            case 4 -> {
                return "Comedia";
            }
            case 5 -> {
                return "Documental";
            }
            case 6 -> {
                return "Drama";
            }
            case 7 -> {
                return "Terror";
            }
            case 8 -> {
                return "Musical";
            }
            case 9 -> {
                return "Romantica";
            }
            case 10 -> {
                return "Ciencia Ficcion";
            }
        }
        return null;
    }

    //Inicializacion de la array de los generos de pelicula
    private void setGeneros(){

        generos[0] = "\n[1] - Accion";
        generos[1] = "[2] - Aventuras";
        generos[2] = "[3] - Animacion";
        generos[3] = "[4] - Comedia";
        generos[4] = "[5] - Documental";
        generos[5] = "[6] - Drama";
        generos[6] = "[7] - Terror";
        generos[7] = "[8] - Musical";
        generos[8] = "[9] - Romantica";
        generos[9] = "[10] - Ciencia Ficcion";
    }

    //Salida por pantalla de todos los generos de pelicula
    private void muestraGeneros(){

        for (String i : generos) {
            System.out.println(i);
        }
    }

    private void mostrarInfo(){

        System.out.println("""
                
                * Bienvenido a la web de puntuacion de peliculas y series.
                * Primero debes registrarte con tu correo y clave.
                * El correo debe contener un (@) y seguido un (.) ej: (nombre@correo.com)
                * La clave debe ser mayor de 8 digitos.
                * Una vez registrado debera iniciar sesion con sus credenciales.
                * Una vez dentro no podra realizar ninguna funcion hasta que inserte -
                    peliculas o series, el programa le avisara.
                * A la hora de insertar las peliculas y series ten en cuenta el mensaje -
                    que dice (Requiere un numero), el mensaje no aparecera en los menus -
                    ni a la hora de escoger un genero pero igualmente se bebera de -
                    introducir un numero.
                * Cuando una pelicula o serie sea editada se perdera la valoracion -
                    en caso de que estuviera previamente valorada.
                * Y por ultimo ¡MAY THE FORCE BE WITH YOU!
                """);
    }

    //Bienvenida que se muestra una sola vez al ejecutar el programa
    private void mostrarInicio(){
        System.out.println("""
                
                     _______.___________..______       _______     ___      .___  ___.  __  .__   __.   _______\s
                    /       |           ||   _  \\     |   ____|   /   \\     |   \\/   | |  | |  \\ |  |  /  _____|
                   |   (----`---|  |----`|  |_)  |    |  |__     /  ^  \\    |  \\  /  | |  | |   \\|  | |  |  __ \s
                    \\   \\       |  |     |      /     |   __|   /  /_\\  \\   |  |\\/|  | |  | |  . `  | |  | |_ |\s
                .----)   |      |  |     |  |\\  \\----.|  |____ /  _____  \\  |  |  |  | |  | |  |\\   | |  |__| |\s
                |_______/       |__|     | _| `._____||_______/__/     \\__\\ |__|  |__| |__| |__| \\__|  \\______|\s
                """);
    }


    //Despedida que se ejecuta una sola vez cuando el programa va a cerrarse
    private void mostrarFinal(){

        System.out.println("""
                
                ____    ____  __    __   _______  __      ____    ____  ___        \s
                \\   \\  /   / |  |  |  | |   ____||  |     \\   \\  /   / /   \\       \s
                 \\   \\/   /  |  |  |  | |  |__   |  |      \\   \\/   / /  ^  \\      \s
                  \\      /   |  |  |  | |   __|  |  |       \\      / /  /_\\  \\     \s
                   \\    /    |  `--'  | |  |____ |  `----.   \\    / /  _____  \\    \s
                    \\__/      \\______/  |_______||_______|    \\__/ /__/     \\__\\   \s
                                                                                   \s
                .______   .______        ______   .__   __. .___________.  ______  \s
                |   _  \\  |   _  \\      /  __  \\  |  \\ |  | |           | /  __  \\ \s
                |  |_)  | |  |_)  |    |  |  |  | |   \\|  | `---|  |----`|  |  |  |\s
                |   ___/  |      /     |  |  |  | |  . `  |     |  |     |  |  |  |\s
                |  |      |  |\\  \\----.|  `--'  | |  |\\   |     |  |     |  `--'  |\s
                | _|      | _| `._____| \\______/  |__| \\__|     |__|      \\______/ \s
                """);
    }

    //-------------------------------------------------------------------------------------------------------//

    private void altaUsuario(cUsuario u){

        this.listaUsuarios.add(u);
    }

    private void altaPelicula(cPelicula p){

        this.listaPeliculas.add(p);
    }

    private void altaSerie(cSerie s){

        this.listaSeries.add(s);
    }

    private ArrayList<cPelicula> getListaPeliculas(){

        return this.listaPeliculas;
    }

    private ArrayList<cSerie> getListaSeries(){

        return this.listaSeries;
    }
}
