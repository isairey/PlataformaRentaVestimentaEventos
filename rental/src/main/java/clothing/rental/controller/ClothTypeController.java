package clothing.rental.controller;

import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import clothing.rental.model.ClothType;
import clothing.rental.service.ClothTypeService;


@RestController
@RequestMapping("/api/cloth-types")
@CrossOrigin(origins = "http://localhost:5173/")
public class ClothTypeController {
    private final ClothTypeService clothTypeService;

    public ClothTypeController(ClothTypeService clothTypeService) {
        this.clothTypeService = clothTypeService;
    }

    @GetMapping
    public List<ClothType> getAllClothTypes() {
        return clothTypeService.getAllClothTypes();
    }
}
