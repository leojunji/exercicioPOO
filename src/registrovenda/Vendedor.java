package registrovenda;

public class Vendedor {

    private String nome;
    private int codigo;
    private static final float comissao = 5.0f;//percentual
    private String endereco;


    public Vendedor(String nome, int codigo, String endereco) { //construtor
        this.nome = nome;
        this.codigo = codigo;
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public float getComissao(){
        return this.comissao;
    }


}
