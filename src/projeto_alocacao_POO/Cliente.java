package projeto_alocacao_POO;

import java.io.Serializable;
import java.util.ArrayList;

public class Cliente implements Serializable {

    private String nome;
    private String endereco ;
    private String data_nascimento;
    private String identificador;
    private ArrayList<Object> cliente;
    private Carro carro; //locadora.getCarro().getTipo() ...
    private Moto moto;

    public Cliente(String nome, String endereco, String data_nascimento, String identificador) {
        this.nome = nome;
        this.endereco = endereco;
        this.data_nascimento = data_nascimento;
        this.identificador = identificador;
        cliente = new ArrayList<>();
    }

    public ArrayList<Object> getCliente() {
        return cliente;
    }

    public void setCliente(ArrayList<Object> cliente) {
        this.cliente = cliente;
    }

    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }

    public Moto getMoto() {
        return moto;
    }

    public void setMoto(Moto moto) {
        this.moto = moto;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
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

}
