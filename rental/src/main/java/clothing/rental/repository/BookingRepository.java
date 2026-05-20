package clothing.rental.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import clothing.rental.model.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}
