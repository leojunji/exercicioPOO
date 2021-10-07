package deducao_logica;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("entrada 1 e 2 ficam separadas por virgula");
        System.out.println("Exemplo de entrada: (A->B),(B->C)");
        System.out.println("Digite a expressao: ");
        String resp = input.nextLine();
        resp = resp.strip();

        boolean negacao = resp.contains("~");

        //remover espacos
        for(int c = 0;c < resp.length();c++){
            if(resp.contains(" ")){
                resp = resp.replaceAll(" ", "");
            }
        }


        resp = resp.replace(")", "");
        resp = resp.replace("(", "");
        resp = resp.replace(",", " ");

        ArrayList<String> lst_conectivos = new ArrayList<>();
        String[] conectivos_posicionados = new String[resp.length()];
        ArrayList<String> lst_expr = new ArrayList<>();




        for(int c = 0;c < resp.length();c++){

            if(resp.contains("->")) {

                conectivos_posicionados[resp.indexOf("->")] = "->";
                resp = resp.replaceFirst("->", "/");

            }else if(resp.contains("~")) {

                conectivos_posicionados[resp.indexOf("~")] = "~";
                resp = resp.replaceFirst("~", "/");

            }

        }


        String[] expr_auxiliar = resp.strip().split("");

        for(String c : conectivos_posicionados){
            if(c != null)
                lst_conectivos.add(c);
        }


        System.out.println("conectivos_lst: " + lst_conectivos);//----

        int indice_conectivos =  0;
        int count = 0;
        if(lst_conectivos.size()!=0) {
            while (count < expr_auxiliar.length) {

                if (expr_auxiliar[count].equals("/") & !lst_conectivos.get(indice_conectivos).equals("~")) {
                    expr_auxiliar[count] = lst_conectivos.get(indice_conectivos);
                    indice_conectivos += 1;
                    count += 1;
                } else if (expr_auxiliar[count].equals("/") & lst_conectivos.get(indice_conectivos).equals("~")) {
                    expr_auxiliar[count] = "";
                    count += 1;
                    expr_auxiliar[count] = lst_conectivos.get(indice_conectivos) + expr_auxiliar[count];
                    indice_conectivos += 1;
                    count += 1;
                } else {
                    count += 1;
                }

                if (indice_conectivos == lst_conectivos.size()) {
                    break;
                }

            }
        }

        for(String c : expr_auxiliar){
            if(!c.equals(" ") & !c.equals("")){
                lst_expr.add(c);
            }
        }



        System.out.println("lst_expr: " + lst_expr);//--
        System.out.println("size: " + lst_expr.size());//--


        String resultado = "";
        if(lst_expr.contains("^") | lst_expr.contains("v")) {
            if(lst_expr.size()==1) {
                System.out.println("Adicao: ");
                System.out.println("resultado: " + lst_expr.get(0).toUpperCase(Locale.ROOT) + " v B");
            }else if(lst_expr.size()==2){
                System.out.println("Conjuncao: ");
                System.out.print("resultado: " + lst_expr.get(0).toUpperCase(Locale.ROOT));
                System.out.print(" ^ ");
                System.out.print(lst_expr.get(1).toUpperCase(Locale.ROOT));
            }else if(lst_expr.size()==3){
                System.out.println("Simplificação: ");
                System.out.println("resultado: " + lst_expr.get(0).toUpperCase(Locale.ROOT));
            }else if(lst_expr.size()==4){
                System.out.println("Silogismo disjuntivo: ");
                System.out.println("resultado: " + lst_expr.get(2).toUpperCase(Locale.ROOT));
            }
        }else if(lst_expr.contains("->")){
            if(lst_expr.size()==4 & negacao){

                System.out.println("Modus Tollens: ");


                resultado = lst_expr.get(lst_expr.indexOf("->")-1);

                System.out.println("resultado: ~" + resultado.toUpperCase(Locale.ROOT));
            }else if(lst_expr.size()==4){

                System.out.println("Modus Ponens: ");
                resultado = lst_expr.get(lst_expr.indexOf("->")+1);
                System.out.println("resultado: " + resultado.toUpperCase(Locale.ROOT));

            }else if(lst_expr.size()==6){

                System.out.println("Silogismo hipotetico: ");

                if(lst_expr.get(2).equals(lst_expr.get(3)))
                    resultado = lst_expr.get(0) + "->" + lst_expr.get(5);
                else{
                    resultado =  lst_expr.get(2) + "->" + lst_expr.get(3);
                }

                System.out.print("resultado: " + resultado.toUpperCase(Locale.ROOT));

            }
        }

    }
}