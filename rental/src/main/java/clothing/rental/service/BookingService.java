package clothing.rental.service;



import java.util.List;
import org.springframework.stereotype.Service;

import clothing.rental.model.Booking;
import clothing.rental.repository.BookingRepository;


@Service
public class BookingService {
    private final BookingRepository bookingRepository;

    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public Booking createBooking(Booking booking) {
        return bookingRepository.save(booking);
    }
}
