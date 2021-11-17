package Objetos;

public class Accesorios {

    private int id;
    private String[] jarrones = {"Collar", "Cepillo", "Pelota"};
    private int precios[] = { 4500, 12500, 25000 };
    private int adicional[]= { 150, 350, 500 };

    public Accesorios(){

        id = 1;
    }

    public Accesorios(int id, String[] jarrones) {
        this.id = id;
        this.jarrones = jarrones;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String[] getJarrones() {
        return jarrones;
    }

    public void setJarrones(String[] jarrones) {
        this.jarrones = jarrones;
    }

    public int[] getPrecios() {
        return precios;
    }

    public void setPrecios(int[] precios) {
        this.precios = precios;
    }

    public int[] getAdicional() {
        return adicional;
    }

    public void setAdicional(int[] adicional) {
        this.adicional = adicional;
    }

}
