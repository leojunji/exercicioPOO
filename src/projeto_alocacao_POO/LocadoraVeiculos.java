package projeto_alocacao_POO;


import javax.swing.*;

//[nome, identificador, endereco, ano_nascimento,[tempo_alocacao^data_alocacao^seguro?true:false^valor_desconto]*]
public class LocadoraVeiculos {

    private String nome_locadora;
    private String endereco_arquivo;
    private Cliente cliente;
    private double valor_seguro;
    private double porcentagem_desconto;
    String[] dados_veiculo;
    String[] dados_cliente;
    private int num_dias;
    private String data_locacao;
    private boolean seguro;

    public LocadoraVeiculos(String[] dados_veiculo, String[] dados_cliente) {
        this.dados_veiculo = dados_veiculo;
        this.dados_cliente = dados_cliente;
        this.valor_seguro = 0;
        this.porcentagem_desconto = 0;
        this.num_dias = 0;
        this.data_locacao = "";
    }

    public LocadoraVeiculos(String nome_locadora) {
        this.nome_locadora = nome_locadora;
    }

    public String getNome_locadora() {
        return nome_locadora;
    }

    public void setNome_locadora(String nome_locadora) {
        this.nome_locadora = nome_locadora;
    }

    public String getEndereco_arquivo() {
        return endereco_arquivo;
    }

    public void setEndereco_arquivo(String endereco_arquivo) {
        this.endereco_arquivo = endereco_arquivo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }


    public boolean formularioLocao(){


        try {

            this.num_dias = VerificadoresTipo.verificarInteiro("Digitar o tempo de locação(MÍNIMO DE 1 DIA):\n" +
                    "Deve ser uma valor positivo(+) maior ou igual a 1 ");

            this.data_locacao = JOptionPane.showInputDialog("Digitar a data de locacao: ");

            this.seguro = VerificadoresTipo.verificarBoolean("Digtar: \n" +
                    "true -- com seguro\n" +
                    "false -- sem seguro\n");

            this.porcentagem_desconto = VerificadoresTipo.verificarDouble("Digtar o valor do desconto(MÁXIMO 12%):\n" +
                    "OBS: deve ser uma valor positivo(+) entre 0% e 12% ");

            if(this.num_dias >= 1 & !data_locacao.equals("") & (this.porcentagem_desconto >=0 & this.porcentagem_desconto <= 12)) {

                return true;

            }else {

                JOptionPane.showMessageDialog(null, "É necessário preencher todos os campos e de forma correta");
                return false;
            }


        }catch (Exception e){

            JOptionPane.showMessageDialog(null, "Não foi possível realizar a locação");
            return false;
        }
    }


    public boolean confirmarLocacao(){


        if (seguro)
            caucularSeguro();

                            //num dias * (valor da diaria + valor diario do seguro)
        double valor_total = num_dias * (Double.parseDouble(dados_veiculo[3]) + valor_seguro);

        double valor_desconto = caucularDesconto(valor_total);

        valor_total -= valor_desconto;

        double tipo = VerificadoresTipo.verificarInteiro("Tipo de veículo: " + dados_veiculo[2] + "\n" +
                "Descrição: " + dados_veiculo[4] + "\n" +
                "Desconto: R$" + valor_desconto + "\n" +
                "Seguro: R$" + valor_seguro + "\n" +
                "Diária: " + dados_veiculo[3] + "\n" +
                "Quantidade de dias: " + num_dias + "\n" +
                "valor total: R$" + valor_total + "\n" +
                "1  --  Confirmar locação \n" +
                "2  --  Recusar locação \n");

        System.out.println("");


        if (tipo==1)
        {
            return true;
        }else
        {
            return false;
        }

    }


    public double caucularSeguro(){

        if (dados_veiculo[2].equals("Carro")) {

            valor_seguro = (0.05 * Double.parseDouble(dados_veiculo[3])) *
                    (1 + Double.parseDouble(dados_veiculo[5].replaceAll(";", "")) / 20);

        } else if(dados_veiculo[2].equals("Moto")) {

            valor_seguro = 0.09 * Double.parseDouble(dados_veiculo[3]);


        }

        return valor_seguro;

    }

    public double caucularDesconto(double valor_total){

        double valor_desconto = (this.porcentagem_desconto/ 100) * valor_total;

        return valor_desconto;
    }

}

