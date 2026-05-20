package clothing.rental.controller;

import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import clothing.rental.model.Cloth;
import clothing.rental.service.ClothService;


@RestController
@RequestMapping("/api/clothes")
@CrossOrigin(origins = "http://localhost:5173/")
public class ClothController {
    private final ClothService clothService;

    public ClothController(ClothService clothService) {
        this.clothService = clothService;
    }

    @GetMapping
    public List<Cloth> getAllClothes() {
        return clothService.getAllClothes();
    }

    @GetMapping("/type/{clothTypeId}")
    public List<Cloth> getClothesByClothType(@PathVariable Long clothTypeId) {
        return clothService.getClothesByClothType(clothTypeId);
        }
    
    @GetMapping("/gender/{gender}")
    public List<Cloth> getClothesByGender(@PathVariable String gender) {
        return clothService.getClothesByGender(gender);
    }
}
