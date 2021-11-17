package Objetos;

public class Clientes {


    private int id;
    private String[] clientes = {"Sermieh", "Jacinta"};
    private int[] salarios = { 45000, 55000};

    public Clientes(){

        id = 1;
    }

    public Clientes(int id, String[] clientes) {
        this.id = id;
        this.clientes = clientes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String[] getClientes() {
        return clientes;
    }

    public void setClientes(String[] clientes) {
        this.clientes = clientes;
    }

    public int calcularValorSermieh(int precio, int adicional){
        return 45000 - (precio + adicional);
    }

    public int calcularValorJacinta(int precio, int adicional){
        return 55000 - (precio + adicional);
    }
}
