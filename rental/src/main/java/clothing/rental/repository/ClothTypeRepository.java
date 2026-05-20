package clothing.rental.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import clothing.rental.model.ClothType;


@Repository
public interface ClothTypeRepository extends JpaRepository<ClothType, Long> {
}
