package projeto_alocacao_POO;

import java.io.Serializable;

public class Cliente implements Serializable {


    private static final long serialVersionUID = 6529985098267757690L;
    private String nome;
    private String endereco ;
    private String data_nascimento;
    private String identificador;
    private Carro carro; //locadora.getCarro().getTipo() ...
    private Moto moto;

    public Cliente(String nome, String endereco, String data_nascimento, String identificador) {
        this.nome = nome;
        this.endereco = endereco;
        this.data_nascimento = data_nascimento;
        this.identificador = identificador;
    }


    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
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

    public String getData_nascimento() {
        return data_nascimento;
    }

    public String getIdentificador() {
        return identificador;
    }


}
