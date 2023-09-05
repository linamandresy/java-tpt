package mbds.tpt.egouvernance_javaserver.api;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mbds.tpt.egouvernance_javaserver.helpers.web.WebResponse;
import mbds.tpt.egouvernance_javaserver.interfaces.TypeResourceRepository;
import mbds.tpt.egouvernance_javaserver.models.TypeResource;

@RestController
@RequestMapping("type-resource")
@CrossOrigin(origins = "*")
public class TypeResourceAPI {
    private final TypeResourceRepository repo;

    TypeResourceAPI(TypeResourceRepository repo){
        this.repo = repo;
    }

    @GetMapping("")
    public WebResponse liste(){
        try {
            return new WebResponse(repo.findAll());
        } catch (Exception e) {
            return new WebResponse(400, e.getMessage());
        }
    }

    @PostMapping("")
    public WebResponse create(@RequestBody TypeResource resource){
        try {
            return new WebResponse(repo.save(resource));
        } catch (Exception e) {
            return new WebResponse(400, e.getMessage());
        }
    }
}
