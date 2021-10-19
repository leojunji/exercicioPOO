package registrovenda;

public class Venda{


    private Produto produto;
    private Vendedor vendedor;
    private float desconto = 0;
    private int quantidadeDeItens = 1;
    private float valor;

    public float getValor_comissao() {
        return valor_comissao;
    }

    public void setValor_comissao(float valor_comissao) {
        this.valor_comissao = valor_comissao;
    }

    private float valor_comissao; //valor da comissao com base no preço do produto


    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public int getQuantidadeDeItens() {
        return quantidadeDeItens;
    }

    public void setQuantidadeDeItens(int quantidadeDeItens){
        this.quantidadeDeItens = quantidadeDeItens;
    }

    public void efetuarDesconto(int porcentagemDesconto){

        float valorVenda = produto.getValorVenda();


        float desconto = (porcentagemDesconto*valorVenda)/100;

        // se com o desconto o valor não ficar menor que o custo de produção e se o produto estiver em promocao
        if ((valorVenda-desconto) >= produto.getValorCusto() && produto.isPromocao())
            this.desconto = desconto;
        System.out.println("descont=-------: " + this.desconto);


        //--System.out.println("desconto --> " + this.desconto);

    }

    public void caucularValor(){

        float valorVenda = produto.getValorVenda();

        //Desconto aplicado em cada unidade
        this.valor = this.quantidadeDeItens*(valorVenda-this.desconto);

        //--System.out.printf("Valor total R$ %s, com desconto de %s aplicado em cada unidade\n"
               // --, this.valor, this.desconto);

    }

    public void caucularComissao(){

        float percentComissao = vendedor.getComissao();

        this.valor_comissao = (percentComissao*this.valor)/100;

        // é necessário chamar o método efetuarDesconto() antes de cacularComissao();
        if (this.desconto>0 && produto.isPromocao())
            this.valor_comissao /= 2;


        //--System.out.println("comissao " + comissao);

    }

    public void imprimir(){

        System.out.println("VENDEDOR: ");

        System.out.println("Nome: " + vendedor.getNome() + "\n"
        + "Código: " + vendedor.getCodigo());

        System.out.println("====================");

        System.out.println("Comissão pela venda:R$" + this.valor_comissao + "\n"
        + "Quantidade de intens vendidos: " + getQuantidadeDeItens() + "\n"
        + "Código produto: " + produto.getCodigo() + "\n"
        + "Descrição do produto: " + produto.getDescricao()  +"\n"
        + "Valor unitário: R$" + produto.getValorVenda() + "\n"
        + "Produto está em promoção: " + (produto.isPromocao() ? "sim" : "não") + "\n"
        + "Valor do desconto sobre cada produto: R$" + this.desconto + "\n"
        + "Valor final da venda: R$" + this.valor);

    }



}
