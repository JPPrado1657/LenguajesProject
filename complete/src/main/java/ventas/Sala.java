package ventas;

public class Sala {
    private int filas;
    private int columnas;
    private int number;

    public Sala(int filas, int columnas, int number) {
        this.filas = filas;
        this.columnas = columnas;
        this.number = number;
    }

    public int getFilas() {
        return filas;
    }

    public int getColumnas() {
        return columnas;
    }

    public int getNumber() {
        return number;
    }
}
