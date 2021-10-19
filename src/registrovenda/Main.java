package registrovenda;

public class Main {
    public static void main(String[] args) {






        //teste 1
        Produto produto1 = new Produto(1111, "xbox one",
                100.0f, 50.0f, false);


        Vendedor vendedor1 = new Vendedor("Ricardo", 62003, "Centro-Curitba,PR");

        Venda venda = new Venda();

        //Venda venda = new Venda();


        venda.setProduto(produto1);
        venda.setVendedor(vendedor1);

        //venda.efetuarDesconto(25); // indicar a porcentagem(%) de desconto e setar promocao==true
        venda.setQuantidadeDeItens(2);


        venda.caucularValor();
        venda.caucularComissao();
        //System.out.println("Comissao: " + vendedor1.getComissao());
        //venda.imprimir();


        //teste 2
        Produto produto2 = new Produto(2,"PS4", 100.0f, 80.0f, true);
        Vendedor vendedor2 = new Vendedor("fujioka", 1, "Rua do Limoeiro");

        venda.setProduto(produto2);
        venda.setVendedor(vendedor2);

        venda.setQuantidadeDeItens(3);
        venda.efetuarDesconto(10);
        venda.caucularValor();
        venda.caucularComissao();

        System.out.println("Comissao: " + vendedor2.getComissao());
        venda.imprimir();


        //teste 3
        //-----venda.setProduto(produto2);
        //-----venda.setVendedor(vendedor2);

        venda.setQuantidadeDeItens(2);
        // não vai ser aplicado o desconto, pois aqui vai dar menor que os custo
        //venda.efetuarDesconto(30);
        venda.caucularValor();
        venda.caucularComissao();

        //venda.imprimir();


        DadosVendedor dadosVendedor = new DadosVendedor();

        dadosVendedor.setVendedor(vendedor2);
        dadosVendedor.autorizar("Alberto", 2323);
        //dadosVendedor.imprimirDadosVendedor();


    }
}
