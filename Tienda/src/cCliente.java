public class cCliente {

    //Inicializacion de las variables donde se guardara la informacion de los clientes
    public String nombre;
    public String apellido1;
    public String apellido2;
    public String NIF;

    public cCliente(){}

    //Array donde se guarara la informacion de las lineas sacadas del txt
    public cCliente(String str){

        if(!str.isEmpty()){
            String[] info = str.split(";");
            this.nombre = info[0];
            this.apellido1 = info[1];
            this.apellido2 = info[2];
            this.NIF = info[3];
        }
    }

    //Metodo que muestra por pantalla la informacion del cliente seleccinado
    public String toString(){
        return this.nombre + " " + this.apellido1 + " " + this.apellido2 + ", NIF = " + this.NIF;
    }
}
