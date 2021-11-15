package projeto_alocacao_POO;

import javax.swing.*;

public class Cliente {

    private String nome;
    private String endereco ;
    private String data_nascimento;
    private String identificador;
    private String arquivo_cliente;


    public Cliente(String arquivo_cliente) {
        //this.nome = nome;
        //this.endereco = endereço;
        //this.data_nascimento = data_nascimento;
        //this.identificador = senha;
        this.arquivo_cliente = arquivo_cliente;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getArquivo_cliente() {
        return arquivo_cliente;
    }

    public void setArquivo_cliente(String arquivo_cliente) {
        this.arquivo_cliente = arquivo_cliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereço() {
        return endereco;
    }

    public void setEndereço(String endereço) {
        this.endereco = endereço;
    }

    public String getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(String data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }



    public void cadastrarCliente() {

        String dados = this.nome + ";" +
                this.identificador + ";" +
                this.endereco + ";" +
                this.data_nascimento + ";\n";

        if(BancoDados.appendArquivo(dados, this.arquivo_cliente))
        {
            JOptionPane.showMessageDialog(null,
                    "Cadastro realizazdo com sucesso");
        }else{
            JOptionPane.showMessageDialog(null,
                    "Não foi possível realizar o cadastro");
        };

    }

    public boolean formularioCadastroCLiente() {

        try {

            JOptionPane.showMessageDialog(null, "CADASTRAR CLIENTE");

            this.nome = JOptionPane.showInputDialog("nome: ");

            this.endereco = JOptionPane.showInputDialog("endereço: ");

            this.data_nascimento = JOptionPane.showInputDialog("Data de nascimento: ");

            this.identificador = JOptionPane.showInputDialog("Coloque um identificador: ");

            if (this.nome.equals("") | this.endereco.equals("") | this.data_nascimento
                    .equals("") | this.identificador.equals("")) {

                JOptionPane.showMessageDialog(null, "Todos os campos devem ser preenchidos");
                return false;
            }

            return true;

        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "O cadastro não foi realizado");
            return false;
        }
    }

}
