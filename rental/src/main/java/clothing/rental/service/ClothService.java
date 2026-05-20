package clothing.rental.service;

import java.util.List;
import org.springframework.stereotype.Service;

import clothing.rental.model.Cloth;
import clothing.rental.repository.ClothRepository;

@Service
public class ClothService {
    private final ClothRepository clothRepository;

    public ClothService(ClothRepository clothRepository) {
        this.clothRepository = clothRepository;
    }

    public List<Cloth> getAllClothes() {
        return clothRepository.findAll();
    }

    public List<Cloth> getClothesByClothType(Long clothTypeId) {
        return clothRepository.findByClothTypeId(clothTypeId);
    }
    
    public List<Cloth> getClothesByGender(String gender) {
        return clothRepository.findByGender(gender); // New method to filter by gender
    }
}
