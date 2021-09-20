package registrovenda;

public class DadosVendedor {

    private Vendedor vendedor;
    private boolean autorizado = false;

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public void autorizar(String nomeVendedor, int codigoVendedor){
        this.autorizado = vendedor.getCodigo()==codigoVendedor && vendedor.getNome()==nomeVendedor;
    }

    public void imprimirDadosVendedor(){

        if (this.autorizado) {

            System.out.println("NOME VENDEDOR: " + vendedor.getNome());

            System.out.println("CÓDIGO VENDEDOR :" + vendedor.getCodigo());

            System.out.println("ENDEREÇO VENDEDOR: " + vendedor.getEndereco());
        }

    }

}
