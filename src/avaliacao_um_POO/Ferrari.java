package avaliacao_um_POO;

public class Ferrari extends Automovel{


    @Override
    public void acelerar() {
        super.acelerar();
        System.out.println("Ferrari: Vrummmmmmmmm!!!!!!!!!");

        linha();
    }
}
