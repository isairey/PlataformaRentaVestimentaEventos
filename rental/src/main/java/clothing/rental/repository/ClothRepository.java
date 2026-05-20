package clothing.rental.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import clothing.rental.model.Cloth;


@Repository
public interface ClothRepository extends JpaRepository<Cloth, Long> {
    List<Cloth> findByClothTypeId(Long clothTypeId);
    List<Cloth> findByGender(String gender);
}
