package projeto_alocacao_POO;

import javax.swing.*;
import java.util.Locale;

public class VerificadoresTipo {


    /**
     * ira retornar apenas quando o campo nao estiver vazio*/
    public static String verificarCampo(String message){

        while(true){

            String valor = JOptionPane.showInputDialog(message).strip();

            if(valor.equals("")){
                JOptionPane.showMessageDialog(null, "Esse campo não pode ficar em branco");
            }else {
                return valor;
            }

        }
    }



    public static double verificarDouble(String message){

        while(true){

            String valor = JOptionPane.showInputDialog(message);

            try{

                double num_convertido = Double.parseDouble(valor);
                return num_convertido;

            }catch (Exception e){
                JOptionPane.showMessageDialog(null, "Digite um número do tipo double (ex: 1.0)");
            }

        }
    }

    public static int verificarInteiro(String message){

        while(true){

            String valor = JOptionPane.showInputDialog(message);

            try{

                int num_convertido = Integer.parseInt(valor);
                return num_convertido;

            }catch (Exception e){
                JOptionPane.showMessageDialog(null, "Digite um número do tipo int (ex: 1)");
            }

        }
    }

    public static boolean verificarBoolean(String message) {

        while(true){

            String valor = JOptionPane.showInputDialog(message).toLowerCase(Locale.ROOT);

            if(valor.equals("true") | valor.equals("false")) {
                return Boolean.parseBoolean(valor);
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Digite true ou false");
            }

        }

    }

    public static String verificarData(String message){


        while(true){

            String valor = JOptionPane.showInputDialog(message).strip();

            String[] data = valor.split("");

            try {

                if (!data[2].equals("/") | !data[5].equals("/") | data.length < 10) {
                    JOptionPane.showMessageDialog(null, "Digite uma data no padrão (ex: DD/MM/AAAA)");
                } else {
                    return valor;
                }
            }catch (Exception e){

                JOptionPane.showMessageDialog(null, "Digite uma data no padrão (ex: DD/MM/AAAA)");

            }

        }

    }
}
