package ventas;

public class Request {
    private int fila;
    private int columna;
    private Funcion funcion;
    private int accepted = 0;
    private String cliente;

    public Request(int fila, int columna, Funcion funcion, String cliente) {
        this.fila = fila;
        this.columna = columna;
        this.funcion = funcion;
        this.cliente = cliente;
    }

    public int getFila() {
        return fila;
    }

    public int getColumna() {
        return columna;
    }

    public Funcion getFuncion() {
        return funcion;
    }

    public void sendRequest() {
        Broker broker = Broker.getInstance();
        broker.addRequest(this);
    }

    public int isAccepted() {
        return accepted;
    }

    public String getCliente() {
        return cliente;
    }

    public void setAccepted(int accepted) {
        this.accepted = accepted;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }
}
