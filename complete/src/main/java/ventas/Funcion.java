package ventas;

import java.util.Calendar;
import java.util.Date;

public class Funcion {
    private Sala sala;
    private Asiento[][] asientos;
    private Pelicula pelicula;
    private Date inicio;
    private Date fin;

    public Funcion(Sala sala, Pelicula pelicula, Date inicio) {
        this.sala = sala;
        asientos = new Asiento[sala.getFilas()][sala.getColumnas()];
        for(int i = 0; i < sala.getFilas(); i++){
            for(int j = 0; j < sala.getColumnas(); j++){
                asientos[i][j] = new Asiento();
            }
        }
        this.pelicula = pelicula;
        this.inicio = inicio;
        Calendar cal = Calendar.getInstance();
        cal.setTime(inicio);
        cal.add(Calendar.MINUTE, pelicula.getDuration());
        this.fin = cal.getTime();
    }

    public Sala getSala() {
        return sala;
    }

    public Asiento[][] getAsientos() {
        return asientos;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public Date getInicio() {
        return inicio;
    }

    public Date getFin() {
        return fin;
    }

    public boolean takeAsiento(int fila, int columna){
        if(fila >= sala.getFilas() || columna >= sala.getColumnas()){
            return false;
        }else{
            synchronized (asientos){
                if(asientos[fila][columna].isTaken()){
                    return false;
                }
                asientos[fila][columna].setTaken(true);
            }
        }
        return true;
    }
}

