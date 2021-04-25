public class cCalculadora{

    public cCalculadora(){

    }
    public String calcula(String op){

        double resultado;
        double numero1 = 0;
        double numero2 = 0;
        String resultadoTxt;

        if(!op.isEmpty()){
            String[] calculo = op.split("\\+");
            numero1 = Integer.parseInt(calculo[0]);
            numero2 = Integer.parseInt(calculo[1]);
        }

        resultado = numero1 + numero2;
        resultadoTxt = resultado+"";

        return resultadoTxt;
    }
}