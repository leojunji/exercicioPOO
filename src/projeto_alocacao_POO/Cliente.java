package projeto_alocacao_POO;

import java.io.Serializable;

public class Cliente implements Serializable {


    private static final long serialVersionUID = 6529985098267757690L;
    private String nome;
    private String endereco ;
    private String data_nascimento;
    private String identificador;



    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereço() {
        return endereco;
    }

    public String getData_nascimento() {
        return data_nascimento;
    }

    public String getIdentificador() {
        return identificador;
    }


    public void formularioCliente(){

        this.nome = VerificadoresTipo.verificarCampo("nome: ");

        this.endereco = VerificadoresTipo.verificarCampo("endereço: ");

        this.data_nascimento = VerificadoresTipo.verificarData("Data de nascimento: ");

        this.identificador = VerificadoresTipo.verificarCampo("Coloque um identificador: ");

    }


}
