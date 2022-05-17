package tacos.web;

import org.springframework.web.bind.annotation.*;
import tacos.Ingredient;
import tacos.data.IngredientRepository;

import java.util.Optional;

@RestController
@RequestMapping(path = "/ingredients", produces = "application/json")
@CrossOrigin(origins = "*")
public class IngredientController {
    private IngredientRepository ingredientRepo;
//    @Autowired
//    EntityLinks entityLinks;
    public IngredientController(IngredientRepository ingredientRepo) {
        this.ingredientRepo = ingredientRepo;
    }
    @GetMapping
    public Iterable<Ingredient> getAllIngredients() {
        return ingredientRepo.findAll();
    }
    @GetMapping("/{id}")
    public Ingredient ingredientById(@PathVariable("id") String id) {
        Optional<Ingredient> optIngredient = ingredientRepo.findById(id);
        if (optIngredient.isPresent()) {
            return optIngredient.get();
        }
        return null;
    }
}
