package exercicios_TDE_POO;



/**Crie uma nova String, pegando o pedaço da primeira
 String que compreenda  a frase “Exemplo String”*/


public class Exercicio18 {


    public static void main(String[] args) {


        String textoUser;


        textoUser = "exemplo string";

        String texto = textoUser.substring(0, 7);
        System.out.println(texto);
    }
}
