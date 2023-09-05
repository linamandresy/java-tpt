package mbds.tpt.egouvernance_javaserver.api;

import java.sql.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.ReturnedType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import mbds.tpt.egouvernance_javaserver.helpers.web.WebResponse;
import mbds.tpt.egouvernance_javaserver.interfaces.CitizenRepository;
import mbds.tpt.egouvernance_javaserver.models.Citizen;

@RestController
@RequestMapping("citizens")
@CrossOrigin(origins = "*")
public class CitizenAPI {
    private final CitizenRepository repo;

    CitizenAPI(CitizenRepository repo) {
        this.repo = repo;
    }

    @GetMapping("")
    public WebResponse list(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(value = "sort", defaultValue = "") String[] sort) {
        try {

            return new WebResponse(repo.findAll(PageRequest.of(page, size, Sort.by(sort))));
        } catch (Exception e) {
            return new WebResponse(400, e.getMessage());
        }
    }

    @PostMapping("")
    public WebResponse create(@RequestBody Citizen citizen) {
        try {
            return new WebResponse(repo.save(citizen));
        } catch (Exception e) {
            return new WebResponse(400, e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public WebResponse fiche(@PathVariable(name = "id") String id) {
        try {

            return new WebResponse(repo.findById(id).get());
        } catch (Exception e) {
            return new WebResponse(400, e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public WebResponse update(@PathVariable(name = "id") String id, @RequestBody Citizen citizen) {
        try {
            citizen.setId(id);
            return new WebResponse(repo.save(citizen));
        } catch (Exception e) {
            return new WebResponse(400, e.getMessage());
        }

    }

}
