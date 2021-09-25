package listaExercicios02_POO.ex2;

public class Circulo extends FormaGeometrica {

    private float raio;


    public Circulo(float perimetro, float area, float raio) {
        super(perimetro, area);
        this.raio = raio;
    }

    public float getRaio() {
        return raio;
    }

    public void setRaio(float raio) {
        this.raio = raio;
    }

    public void imprimirMedidas() {

        System.out.println("Circulo");
        System.out.println("Raio: " + this.raio);
        System.out.println("Area: " + this.area);
        System.out.println("Perimetro: " + this.perimetro);
        System.out.println("========================");

    }
}
