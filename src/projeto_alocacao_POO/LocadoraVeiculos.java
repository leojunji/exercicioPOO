package projeto_alocacao_POO;


import java.io.Serializable;
import java.util.ArrayList;


public class LocadoraVeiculos implements Serializable {

    private String nome_locadora;
    //------

    public LocadoraVeiculos(String nome_locadora) {
        this.nome_locadora = nome_locadora;
    }


    /**
     * retorna true se o cliente existir*/
    public boolean clienteExistente(String nome, String identificador, String arquivo_clientes){

        ArrayList<Object> banco_dados = BancoDados.lerArquivoBinario(arquivo_clientes);

        System.out.println("banco dados: " + banco_dados);

        if(!banco_dados.isEmpty()) {

            for (Object dado : banco_dados) {


                if (((Cliente)dado).getNome().equals(nome) & ((Cliente)dado).getIdentificador().equals(identificador)) {
                    return true;
                }
            }
        }

        return false;

    }

    public void cadastrarCliente(String arquivo_clientes, Cliente cliente) {

        ArrayList<Object> dados_clientes = new ArrayList<>();

        dados_clientes.add(cliente);

        dados_clientes.addAll(BancoDados.lerArquivoBinario(arquivo_clientes));


        BancoDados.gravarArquivoBinario(dados_clientes, arquivo_clientes);



    }

    public Cliente configurarCliente(String arquivo_cliente, String nome, String identificador){

        ArrayList<Object> dados_clientes = BancoDados.lerArquivoBinario(arquivo_cliente);

        Cliente cliente_dado = null;

        for(Object dado : dados_clientes){
            if(((Cliente)dado).getNome().equals(nome) & ((Cliente)dado).getIdentificador().equals(identificador))
                cliente_dado = ((Cliente)dado);

        }

        return cliente_dado;
    }


    //veiculo---------------------------------------------------------------------

    public boolean veiculoDisponivel(String arquivo_veiculos, String placa){

        ArrayList<Object> dados_veiculo = BancoDados.lerArquivoBinario(arquivo_veiculos);

        for(Object dado : dados_veiculo) {

            if (((Veiculo) dado).getPlaca().equals(placa)) {

                return ((Veiculo) dado).isDisponibilidade();

            }
        }

        return false;
    }

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

    public void cadastrarCarro(String arquivo_carros, Carro carro) {


        ArrayList<Object> dados_carro = new ArrayList<>();

        dados_carro.add(carro);

        dados_carro.addAll(BancoDados.lerArquivoBinario(arquivo_carros));

        BancoDados.gravarArquivoBinario(dados_carro, arquivo_carros);



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

    public void cadastrarMoto(String arquivo_motos, Moto moto) {



        ArrayList<Object> dados_moto = new ArrayList<>();

        dados_moto.add(moto);

        dados_moto.addAll(BancoDados.lerArquivoBinario(arquivo_motos));

        BancoDados.gravarArquivoBinario(dados_moto, arquivo_motos);



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

        dados_atualizado.add(alocacao_carro);

        for(Object dado : dados_banco){

            if(!((Veiculo)dado).getPlaca().equals(alocacao_carro.getPlaca()))
                dados_atualizado.add(dado);
        }

        BancoDados.gravarArquivoBinario(dados_atualizado, arquivos_veiculo);

    }

    public void realizarLocacaoMoto(String arquivos_veiculo, Moto alocacao_moto){

        ArrayList<Object> dados_banco = BancoDados.lerArquivoBinario(arquivos_veiculo);

        ArrayList<Object> dados_atualizado = new ArrayList<>();

        dados_atualizado.add(alocacao_moto);

        for(Object dado : dados_banco){

            if(!((Veiculo)dado).getPlaca().equals(alocacao_moto.getPlaca()))
                dados_atualizado.add(dado);
        }


        BancoDados.gravarArquivoBinario(dados_atualizado, arquivos_veiculo);

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


}

