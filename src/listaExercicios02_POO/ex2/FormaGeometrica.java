package listaExercicios02_POO.ex2;

public class FormaGeometrica {

    protected float perimetro = 0.0f;
    protected float area;

    public FormaGeometrica(){}//default constructor

    public FormaGeometrica(float perimetro, float area) {
        this.perimetro = perimetro;
        this.area = area;
    }

    public float getPerimetro() {
        return perimetro;
    }

    public void setPerimetro(float perimetro) {
        this.perimetro = perimetro;
    }

    public float getArea() {
        return area;
    }

    public void setArea(float area) {
        this.area = area;
    }



}
