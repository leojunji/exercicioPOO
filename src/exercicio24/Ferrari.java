package exercicio24;

import java.util.concurrent.atomic.AtomicBoolean;

public class Ferrari extends Automovel {



    @Override
    public void acelerar() {

        if (this.carroMovimentando) {

            System.out.println(this.automovel + " já está em movimento");
            linha();

        } else {

            System.out.println("Acelerando " + this.automovel + "...");
            this.carroMovimentando = true;
            System.out.println(this.automovel +  " acelerando!!!VRUM, VRUMMMMMMMMM");
            linha();
        }
    }
}
