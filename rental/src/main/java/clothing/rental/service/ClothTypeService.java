package clothing.rental.service;



import java.util.List;
import org.springframework.stereotype.Service;

import clothing.rental.model.ClothType;
import clothing.rental.repository.ClothTypeRepository;


@Service
public class ClothTypeService {
    private final ClothTypeRepository clothTypeRepository;

    public ClothTypeService(ClothTypeRepository clothTypeRepository) {
        this.clothTypeRepository = clothTypeRepository;
    }

    public List<ClothType> getAllClothTypes() {
        return clothTypeRepository.findAll();
    }
}
