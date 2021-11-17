package projeto_alocacao_POO;


import javax.swing.*;
import java.util.ArrayList;

//[nome, identificador, endereco, ano_nascimento,[tempo_alocacao^data_alocacao^seguro?true:false^valor_desconto]*]
public class LocadoraVeiculos {

    private String nome_locadora;
    private String endereco_arquivo;
    private Cliente cliente_nao_usadoi;
    //------
    private ArrayList<Cliente> cliente;
    private ArrayList<Carro> carro;
    private ArrayList<Moto> moto;

    public LocadoraVeiculos(String nome_locadora) {
        this.nome_locadora = nome_locadora;
        this.cliente = new ArrayList<>();
        this.carro = new ArrayList<>();
        this.moto = new ArrayList<>();
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

    public Cliente getCliente_nao_usadoi() {
        return cliente_nao_usadoi;
    }

    public void setCliente_nao_usadoi(Cliente cliente_nao_usadoi) {
        this.cliente_nao_usadoi = cliente_nao_usadoi;
    }

    public void addCliente(Cliente  cliente){
        this.cliente.add(cliente);
    }

    public void addCarro(Carro  carro){
        this.carro.add(carro);
    }

    public void addMoto(Moto moto){
        this.moto.add(moto);
    }

    private ArrayList<Cliente> pegarDadosCliente(String arquivo_clientes){

        ArrayList<Object> dados_banco = BancoDados.lerArquivoBinario(arquivo_clientes);

        ArrayList<Cliente> dados_cliente = new ArrayList<>();

        for(Object dado : dados_banco)
            dados_cliente.add((Cliente)dado);

        return dados_cliente;
    }


    /**
     * retorna true se o cliente existir*/
    public boolean clienteExistente(String nome, String identificador, String arquivo_clientes){

        ArrayList<Object> dados_banco = BancoDados.lerArquivoBinario(arquivo_clientes);

        if(!dados_banco.isEmpty()) {

            for (Object dado : dados_banco) {

                if (((Cliente)dado).getNome().equals(nome) & ((Cliente)dado).getIdentificador().equals(identificador)) {
                    return true;
                }
            }

        }

        return false;

    }

    public void cadastrarCliente(String arquivo_clientes) {

        this.cliente.addAll(pegarDadosCliente(arquivo_clientes));

        ArrayList<Object> dados_clientes = new ArrayList<>();

        dados_clientes.addAll(this.cliente);


        BancoDados.gravarArquivoBinario(dados_clientes, arquivo_clientes);



    }

    public void mostrarClientes(String arquivo_clientes){

        ArrayList<Cliente> dados_cliente = pegarDadosCliente(arquivo_clientes);


        for(Cliente dado : dados_cliente){

            JOptionPane.showMessageDialog(null,"nome: " + dado.getNome() + "\n" +

                    "data nascimento: " + dado.getData_nascimento() + "\n" +

                    "identificador: " + dado.getIdentificador() + "\n" );//+

                    //"tipo: " + dado.getCarro().getTipo());



        }


    }


    //veiculo---------------------------------------------------------------------


    /**
     * retorna true se o veiculo existir*/
    public boolean veiculoExistente(String tipo, String placa, String arquivo_veiculos){

        ArrayList<Object> dados_veiculo = BancoDados.lerArquivoBinario(arquivo_veiculos);

        if(!dados_veiculo.isEmpty()) {

            for (Object dado : dados_veiculo) {

                System.out.println("((Veiculo)dado).getTipo(): " + ((Veiculo)dado).getTipo() + " User tipo: " + tipo);

                System.out.println("((Veiculo)dado).getPlaca() " + ((Veiculo)dado).getPlaca() + " User placa: " + placa);

                System.out.println("=====================================");

                if(((Veiculo)dado).getTipo().equals(tipo) & ((Veiculo)dado).getPlaca().equals(placa)){
                    return true;
                }
            }

        }

        return false;

    }



    //Carro--------------------------------------------------------------------------------------------------

    public void cadastrarCarro(String arquivo_carros) {


        ArrayList<Object> dados_banco = BancoDados.lerArquivoBinario(arquivo_carros);

        dados_banco.addAll(this.carro);

        BancoDados.gravarArquivoBinario(dados_banco, arquivo_carros);



    }

    public Carro configurarCarro(String arquivo_carros, String placa){

        ArrayList<Object> dados_banco =  BancoDados.lerArquivoBinario(arquivo_carros);

        Carro carro_dado=  null;


        for(Object dado : dados_banco){
            if(((Veiculo)dado).getPlaca().equals(placa))
                carro_dado = ((Carro)dado);

        }

        return carro_dado;
    }

    //Moto--------------------------------------------------------------------------------------------------

    public void realizarLocacaoMoto(String arquivos_veiculo, Moto alocacao_moto){

        ArrayList<Object> dados_banco = BancoDados.lerArquivoBinario(arquivos_veiculo);

        ArrayList<Object> dados_atualizado = new ArrayList<>();

        for(Object dado : dados_banco){

            if(!((Veiculo)dado).getPlaca().equals(alocacao_moto.getPlaca()))
                dados_atualizado.add(dado);
        }

        dados_atualizado.add(alocacao_moto);

        BancoDados.gravarArquivoBinario(dados_atualizado, arquivos_veiculo);

    }

    public void cadastrarMoto(String arquivo_motos) {



        ArrayList<Object> dados_banco = BancoDados.lerArquivoBinario(arquivo_motos);

        dados_banco.addAll(this.moto);

        BancoDados.gravarArquivoBinario(dados_banco, arquivo_motos);



    }

    public Moto configurarMoto(String arquivo_carros, String placa){

        ArrayList<Object> dados_banco =  BancoDados.lerArquivoBinario(arquivo_carros);

        Moto moto_dado = null;

        for(Object dado : dados_banco){
            if(((Veiculo)dado).getPlaca().equals(placa))
                moto_dado = ((Moto)dado);

        }

        return moto_dado;
    }

    //locacao-------------------------------------

    public void realizarLocacaoCarro(String arquivos_veiculo, Carro alocacao_carro){

        ArrayList<Object> dados_banco = BancoDados.lerArquivoBinario(arquivos_veiculo);

        ArrayList<Object> dados_atualizado = new ArrayList<>();

        for(Object dado : dados_banco){

            if(!((Veiculo)dado).getPlaca().equals(alocacao_carro.getPlaca()))
                dados_atualizado.add(dado);
        }

        dados_atualizado.add(alocacao_carro);

        BancoDados.gravarArquivoBinario(dados_atualizado, arquivos_veiculo);

    }

    public Cliente configurarCliente(String arquivo_cliente, String nome, String identificador){

        ArrayList<Cliente> dados_clientes = pegarDadosCliente(arquivo_cliente);

        Cliente cliente_dado = null;

        for(Cliente dado : dados_clientes){
            if(dado.getNome().equals(nome) & dado.getIdentificador().equals(identificador))
                cliente_dado = dado;

        }

        return cliente_dado;
    }

    public double fazerCauculoLocacao(int tempo_locacao, double valor_locacao, double valor_seguro, double porcentagem_desconto){

        double valor_total = (tempo_locacao * (valor_locacao + valor_seguro));

        valor_total -= ((porcentagem_desconto/100)*valor_total);

        return valor_total;

    }

    public double caucularSeguroCarro(double valor_locacao, int quant_passageiros){

        return (0.05 * valor_locacao) * (1 + (float)quant_passageiros / 20);
    }

    public double caucularSeguroMoto(double valor_locacao) {

        return 0.09 * valor_locacao ;
    }


    public boolean veiculoDisponivel(String arquivo_veiculos, String placa){

        ArrayList<Object> dados_veiculo = BancoDados.lerArquivoBinario(arquivo_veiculos);

        for(Object dado : dados_veiculo) {

            if (((Veiculo) dado).getPlaca().equals(placa)) {

                return ((Veiculo) dado).isDisponibilidade();

            }
        }

        return false;
    }

}

