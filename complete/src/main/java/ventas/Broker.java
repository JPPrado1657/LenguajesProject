package ventas;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Broker {
    private static Broker instance = null;
    private BlockingQueue<Request> requests;
    private boolean isActive = true;

    private Broker(){
        requests = new LinkedBlockingQueue<>();
        Reader r = new Reader();
        r.start();
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public void addRequest(Request request){
        try {
            requests.put(request);
            synchronized (request.getCliente()){
                request.getCliente().wait();
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public Request getRequest(){ // no need to be synchronized thus the blockingQueue
        try {
            return requests.take();
        }catch (InterruptedException e){
            e.printStackTrace();
            return null;
        }
    }

    public static Broker getInstance(){
        if(instance == null){
            synchronized (Broker.class){
                if(instance == null){
                    instance = new Broker();
                }
            }
        }
        return instance;
    }
}
