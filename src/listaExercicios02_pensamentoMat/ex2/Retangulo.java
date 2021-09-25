package listaExercicios02_pensamentoMat.ex2;

public class Retangulo extends FormaGeometrica{

    private float lado;




    public Retangulo(float lado) {
        this.lado = lado;
        setAreaQuadrado(lado);
        setPerimetroQuadrado(lado);
    }

    public Retangulo(float perimetro, float area, float lado) {
        super(perimetro, area);
        this.lado = lado;
    }

    public float getLado() {
        return lado;
    }

    public void setLado(float lado) {
        this.lado = lado;
    }

    public void setAreaQuadrado(float lado) {
        this.area = lado*lado;
    }

    public void setPerimetroQuadrado(float lado) {
        this.perimetro = 4*lado;
    }

    public void imprimirMedidas(String forma) {

        System.out.println(forma);
        System.out.println("Lado: " + this.lado);
        System.out.println("Perimetro: " + this.perimetro);
        System.out.println("Area: " + this.area);
        System.out.println("========================");

    }

}
