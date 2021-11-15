package projeto_alocacao_POO;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Veiculo {

    protected String tipo;
    protected double valor_locacao;
    protected String descricao;
    protected String placa;
    protected String arquivo_veiculo;
    protected boolean disponibilidade;

    public Veiculo(String arquivo_veiculo) {

        this.arquivo_veiculo = arquivo_veiculo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getArquivo_veiculo() {
        return arquivo_veiculo;
    }

    public void setArquivo_veiculo(String arquivo_veiculo) {
        this.arquivo_veiculo = arquivo_veiculo;
    }

    public boolean isDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(boolean disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    public double getValor_locacao() {
        return valor_locacao;
    }

    public void setValor_locacao(double valor_locacao) {
        this.valor_locacao = valor_locacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }


    public static boolean isVeiculoDiponivel(String tipo, String placa, String arquivo)  {

        boolean veiculo_disponivel = false;


        try {

            ArrayList<String> dados_veiculos = BancoDados.readArquivo(arquivo);

            for(String dados : dados_veiculos){


                String[] valor = dados.split("~");


                if(placa.equals(valor[1]) & tipo.equals(valor[2])){

                    if(valor[0].equals("true")){
                        return true;
                    }else {
                        return false;
                    }

                }

            }
        }
        catch (FileNotFoundException fio){
            JOptionPane.showMessageDialog(null, "O arquivo " + arquivo +
                    " não foi localizado");
            veiculo_disponivel = true;
        }
        catch (Exception e){

            JOptionPane.showMessageDialog(null, "Erro ao acessar arquivo: " + arquivo);
            veiculo_disponivel = true;
            e.printStackTrace();
        }

        return veiculo_disponivel;
    }


}
