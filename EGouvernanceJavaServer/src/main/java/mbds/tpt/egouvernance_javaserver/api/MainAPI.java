package mbds.tpt.egouvernance_javaserver.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainAPI {

    @GetMapping("")
    public String index(){
        return " Hello World";
    }    
}
