package ventas;

public class Reader extends Thread {
    public Reader(){}

    @Override
    public void run() {
        while(Broker.getInstance().isActive()){
            Broker broker = Broker.getInstance();
            Request reading = broker.getRequest();
            // Not needed to ask if queue its empty, it will wait till something comes in
            if(reading.getCliente() != null){
                System.out.println("I'm processing " + reading.getCliente() + " request with seat: " + reading.getFila());
            }
            if(reading.getFuncion() != null){
                reading.setAccepted(2);
                if(reading.getFuncion().takeAsiento(reading.getFila(),reading.getColumna())){
                    reading.setAccepted(1);
                }
            }
            synchronized(reading.getCliente()){
                reading.getCliente().notifyAll();
            }
        }
    }
}
