package mbds.tpt.egouvernance_javaserver.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import mbds.tpt.egouvernance_javaserver.helpers.JwtTokenUtil;
import mbds.tpt.egouvernance_javaserver.helpers.web.WebResponse;
import mbds.tpt.egouvernance_javaserver.interfaces.SondageCitizenRepository;
import mbds.tpt.egouvernance_javaserver.models.SondageCitizen;

@RestController
@RequestMapping("sondage-citizen")
@CrossOrigin(origins = "*")
public class SondageCitizenAPI {
    
    private final SondageCitizenRepository repo;

    @Autowired
    private JwtTokenUtil jwt;

    SondageCitizenAPI(SondageCitizenRepository repo){
        this.repo = repo;
    }

    @GetMapping("")
    public WebResponse list(
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "10") int size,
        @RequestParam(value = "sort",defaultValue = "")String[] sort
    ){
        try {
            return new WebResponse(repo.findAll(PageRequest.of(page, size,Sort.by(sort))));
        } catch (Exception e) {
            return new WebResponse(400, e.getMessage());
        }
    }

    @PostMapping("")
    public WebResponse create(
        @RequestBody SondageCitizen sondage,
        @RequestHeader("Authorization") String bearer
    ){
        try {
            bearer = bearer.split( " ")[1];
            String id = jwt.getUserIdFromToken(bearer);
            sondage.setIdUser(id);
            return new WebResponse(repo.save(sondage));
        } catch (Exception e) {
            return new WebResponse(400, e.getMessage());
        }
    }
}
