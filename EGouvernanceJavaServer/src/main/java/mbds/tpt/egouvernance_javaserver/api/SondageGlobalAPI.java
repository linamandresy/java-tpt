package mbds.tpt.egouvernance_javaserver.api;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mbds.tpt.egouvernance_javaserver.helpers.web.WebResponse;
import mbds.tpt.egouvernance_javaserver.interfaces.SondageMereRepository;
import mbds.tpt.egouvernance_javaserver.interfaces.SondageOptionRepository;
import mbds.tpt.egouvernance_javaserver.models.SondageMere;
import mbds.tpt.egouvernance_javaserver.models.SondageOption;
import mbds.tpt.egouvernance_javaserver.models.web.SondageGlobal;

@RestController
@RequestMapping("sondage")
@CrossOrigin(origins = "*")
public class SondageGlobalAPI {
    private final SondageMereRepository sondageMereRepository;
    private final SondageOptionRepository sondageOptionRepository;

    SondageGlobalAPI(SondageMereRepository mere,SondageOptionRepository option){
        sondageMereRepository=mere;
        sondageOptionRepository=option;
    }

    @GetMapping("/{id}")
    public WebResponse sondageGlobal(
        @PathVariable(name="id") String id
    ){
        try {
            SondageMere mere = sondageMereRepository.findById(id).get();
            List<SondageOption> option = sondageOptionRepository.findByIdSondageMere(id);                         
            SondageGlobal resultat = new SondageGlobal();
            resultat.setMere(mere);
            resultat.setOptions(option);
            return new WebResponse(200, resultat);
        } catch (Exception e) {
            return new WebResponse(400, e.getMessage());
        }
    }
}
