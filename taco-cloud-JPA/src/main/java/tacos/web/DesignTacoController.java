package tacos.web;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tacos.Taco;
import tacos.data.TacoRepository;

import java.util.Optional;

@RestController
@RequestMapping(path = "/design", produces = "application/json")
@CrossOrigin(origins = "*")
public class DesignTacoController {
    private TacoRepository tacoRepo;
//    @Autowired
//    EntityLinks entityLinks;
    public DesignTacoController(TacoRepository tacoRepo) {
        this.tacoRepo = tacoRepo;
    }
    @GetMapping("/recent")
    public Iterable<Taco> recentTacos() {
        return tacoRepo.findAll();
    }
    @GetMapping("/{id}")
    public Taco tacoById(@PathVariable("id") Long id) {
        Optional<Taco> optTaco = tacoRepo.findById(id);
        if (optTaco.isPresent()) {
            return optTaco.get();
        }
        return null;
    }
    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Taco postTaco(@RequestBody Taco taco) {
        return tacoRepo.save(taco);
    }
}

