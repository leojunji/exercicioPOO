package listaExercicios02_POO.ex2;


/**
 * Modele classes que representem um Circulo e um Retangulo. O círculo é definido pelo
 * seu raio. O Retangulo pela medida de dois dos seus lados. Adicione os atributos para o
 * perímetro e a área de cada um deles. No caso da classe do quadrilátero, adicione
 * também um construtor que receba um único lado e crie um quadrado.*/
public class Main {

    public static void main(String[] args) {



        Circulo circulo = new Circulo(18.84f,28.23f, 3.0f);

        circulo.imprimirMedidas();

        Retangulo retangulo = new Retangulo(2.0f, 30.f, 4.0f);

        retangulo.imprimirMedidas("retangulo");

        Retangulo quadrado = new Retangulo(7.5f);

        quadrado.imprimirMedidas("quadrado");



    }
}
