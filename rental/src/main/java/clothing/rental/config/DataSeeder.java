
package clothing.rental.config;

import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import clothing.rental.model.Booking;
import clothing.rental.model.Cloth;
import clothing.rental.model.ClothType;
import clothing.rental.repository.BookingRepository;
import clothing.rental.repository.ClothRepository;
import clothing.rental.repository.ClothTypeRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Component
public class DataSeeder implements CommandLineRunner {

    private final ClothRepository clothRepository;
    private final ClothTypeRepository clothTypeRepository;
    private final BookingRepository bookingRepository;

    @PersistenceContext
    private EntityManager entityManager;

    public DataSeeder(ClothRepository clothRepository, ClothTypeRepository clothTypeRepository, BookingRepository bookingRepository) {
        this.clothRepository = clothRepository;
        this.clothTypeRepository = clothTypeRepository;
        this.bookingRepository = bookingRepository;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        // Clear all existing data
        bookingRepository.deleteAll();
        clothRepository.deleteAll();
        clothTypeRepository.deleteAll();

        // Reset AUTO_INCREMENT counters
        entityManager.createNativeQuery("ALTER TABLE booking AUTO_INCREMENT = 1").executeUpdate();
        entityManager.createNativeQuery("ALTER TABLE cloth AUTO_INCREMENT = 1").executeUpdate();
        entityManager.createNativeQuery("ALTER TABLE cloth_type AUTO_INCREMENT = 1").executeUpdate();

        // Create Cloth Types
        ClothType gown = new ClothType();
        gown.setName("Gown");

        ClothType saree = new ClothType();
        saree.setName("Saree");

        ClothType sherwani = new ClothType();
        sherwani.setName("Sherwani");

        ClothType lehenga = new ClothType(); // New Cloth Type for Lehenga
        lehenga.setName("Lehenga");

        clothTypeRepository.saveAll(Arrays.asList(gown, saree, sherwani, lehenga)); // Save all types

        // Create Clothes with Gender
        Cloth gown1 = new Cloth();
        gown1.setName("Elegant Evening Gown");
        gown1.setImageUrl("/images/gown.jpg");
        gown1.setSize("Medium");
        gown1.setRentPrice(500.0);
        gown1.setDescription("A stunning evening gown perfect for formal occasions.");
        gown1.setAvailability(true);
        gown1.setGender("Female");  // Set Gender
        gown1.setClothType(gown);

        Cloth saree1 = new Cloth();
        saree1.setName("Traditional Silk Saree");
        saree1.setSize("Free Size");
        saree1.setImageUrl("/images/saree.jpg");
        saree1.setRentPrice(300.0);
        saree1.setDescription("A beautiful traditional silk saree.");
        saree1.setAvailability(true);
        saree1.setGender("Female");  // Set Gender
        saree1.setClothType(saree);

        Cloth sherwani1 = new Cloth();
        sherwani1.setName("Royal Sherwani");
        sherwani1.setSize("Large");
        sherwani1.setRentPrice(800.0);
        sherwani1.setImageUrl("/images/sherwani.jpg");
        sherwani1.setDescription("A royal sherwani for wedding ceremonies.");
        sherwani1.setAvailability(true);
        sherwani1.setGender("Male");  // Set Gender
        sherwani1.setClothType(sherwani);

        // Adding Lehenga
        Cloth lehenga1 = new Cloth(); // New Female Cloth for Lehenga
        lehenga1.setName("Bridal Lehenga");
        lehenga1.setImageUrl("/images/lehenga.jpg");
        lehenga1.setSize("Free Size");
        lehenga1.setRentPrice(1200.0);
        lehenga1.setDescription("A beautiful bridal lehenga for weddings.");
        lehenga1.setAvailability(true);
        lehenga1.setGender("Female");  // Set Gender
        lehenga1.setClothType(lehenga);

        clothRepository.saveAll(Arrays.asList(gown1, saree1, sherwani1, lehenga1)); // Save all clothes

        // Create Bookings
        Booking booking1 = new Booking();
        booking1.setCustomerName("John Doe");
        booking1.setCustomerContact("1234567890");
        booking1.setStartDate(LocalDate.now().plusDays(2));
        booking1.setEndDate(LocalDate.now().plusDays(5));
        booking1.setTotalRent(500.0);
        booking1.setCloth(gown1);

        Booking booking2 = new Booking();
        booking2.setCustomerName("Jane Smith");
        booking2.setCustomerContact("9876543210");
        booking2.setStartDate(LocalDate.now().plusDays(3));
        booking2.setEndDate(LocalDate.now().plusDays(7));
        booking2.setTotalRent(300.0);
        booking2.setCloth(saree1);

        Booking booking3 = new Booking(); // Adding a booking for Lehenga
        booking3.setCustomerName("Sarah Khan");
        booking3.setCustomerContact("1122334455");
        booking3.setStartDate(LocalDate.now().plusDays(1));
        booking3.setEndDate(LocalDate.now().plusDays(3));
        booking3.setTotalRent(1200.0);
        booking3.setCloth(lehenga1); // Set the Lehenga cloth for booking

        bookingRepository.saveAll(Arrays.asList(booking1, booking2, booking3)); // Save all bookings
    }
}
