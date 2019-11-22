package ventas;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestController {

    @RequestMapping("/add_request")
    public boolean add_request(@RequestParam("name") String name,
                               @RequestParam("fila") int fila,
                               @RequestParam("columna") int columna) {
        Init init = Init.getInstance();
        Funcion miFuncion = init.getFunciones()[3];
        Request r = new Request(fila,columna,miFuncion,name);
        Broker b = Broker.getInstance();
        b.addRequest(r);
        while(r.isAccepted()==0){

        }
        if(r.isAccepted()==1){
            return true;
        }else{
            return false;
        }
    }
}
