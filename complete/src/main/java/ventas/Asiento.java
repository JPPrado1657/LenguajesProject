package ventas;

public class Asiento {
    private boolean taken;

    public Asiento(){
        this.taken = false;
    }

    public boolean isTaken() {
        return taken;
    }

    public void setTaken(boolean taken) {
        this.taken = taken;
    }
}

