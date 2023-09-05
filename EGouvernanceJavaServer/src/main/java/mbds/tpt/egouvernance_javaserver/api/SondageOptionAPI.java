package mbds.tpt.egouvernance_javaserver.api;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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
import mbds.tpt.egouvernance_javaserver.interfaces.SondageOptionRepository;
import mbds.tpt.egouvernance_javaserver.models.SondageOption;

@RestController
@RequestMapping("sondage-option")
@CrossOrigin(origins = "*")
public class SondageOptionAPI {
    private final SondageOptionRepository repo;

    public SondageOptionAPI(SondageOptionRepository repo) {
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
    public WebResponse create(@RequestBody SondageOption option) {
        try {
            return new WebResponse(repo.save(option));
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
    public WebResponse update(@PathVariable(name = "id") String id, @RequestBody SondageOption option) {
        try {
            option.setId(id);
            return new WebResponse(repo.save(option));
        } catch (Exception e) {
            return new WebResponse(400, e.getMessage());
        }

    }

    @GetMapping("/sondage")
    public WebResponse findByMere(@RequestParam String idMere) {
        try {
            return new WebResponse(repo.findByIdSondageMere(idMere));
        } catch (Exception e) {
            return new WebResponse(400, e.getMessage());
        }
    }
}
