package mbds.tpt.egouvernance_javaserver.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import mbds.tpt.egouvernance_javaserver.helpers.HashUtil;
import mbds.tpt.egouvernance_javaserver.helpers.JwtTokenUtil;
import mbds.tpt.egouvernance_javaserver.helpers.web.WebResponse;
import mbds.tpt.egouvernance_javaserver.interfaces.UserRepository;
import mbds.tpt.egouvernance_javaserver.models.User;

@RestController
@RequestMapping("users")
@CrossOrigin(origins = "*")
public class UserAPI {
    private final UserRepository repo;

    @Autowired
    private JwtTokenUtil jwt;

    public UserAPI(UserRepository repo) {
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
    public WebResponse create(@RequestBody User user) {
        user.setUserPassword(HashUtil.sha1(user.getUserPassword()));
        try {
            return new WebResponse(repo.save(user));
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
    public WebResponse update(@PathVariable(name = "id") String id, @RequestBody User user) {
        try {
            user.setId(id);
            return new WebResponse(repo.save(user));
        } catch (Exception e) {
            return new WebResponse(400, e.getMessage());
        }

    }

    @PostMapping("authenticate")
    public WebResponse login(String login, String password) {
        try {
            password = HashUtil.sha1(password);
            User logged = repo.findOneByUserNameAndUserPassword(login, password);
            if(logged==null) return new WebResponse(400, "Nom d'utilisateur ou mot de passe incorrect");
            String token = jwt.generateToken(logged);
            return new WebResponse(200, token);
        } catch (Exception e) {
            return new WebResponse(400, e.getMessage());
        }
    }

    @GetMapping("valid-session")
    public WebResponse validToken(
        @RequestHeader("Authorization") String bearer
    ){
        try {
            bearer = bearer.split(" ")[1];
            String id = jwt.getUserIdFromToken(bearer);
            User user = repo.findById(id).get();
            boolean validToken = jwt.validateToken(bearer, user);
            return new WebResponse( validToken);
        } catch (Exception e) {
            return new WebResponse( false);
        }
        

    }
}
