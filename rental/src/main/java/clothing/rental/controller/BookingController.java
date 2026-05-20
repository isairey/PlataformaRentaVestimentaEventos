package clothing.rental.controller;


import java.util.List;
import org.springframework.web.bind.annotation.*;

import clothing.rental.model.Booking;
import clothing.rental.service.BookingService;


@RestController
@RequestMapping("/api/bookings")
@CrossOrigin(origins = "http://localhost:5173/")
public class BookingController {
    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping
    public List<Booking> getAllBookings() {
        return bookingService.getAllBookings();
    }

    @PostMapping
    public Booking createBooking(@RequestBody Booking booking) {
        return bookingService.createBooking(booking);
    }
}
