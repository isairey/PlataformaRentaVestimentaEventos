package clothing.rental.model;



import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String customerName;

    private String customerContact;

    private LocalDate startDate;

    private LocalDate endDate;

    private Double totalRent;
    

    public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getCustomerName() {
		return customerName;
	}


	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}


	public String getCustomerContact() {
		return customerContact;
	}


	public void setCustomerContact(String customerContact) {
		this.customerContact = customerContact;
	}


	public LocalDate getStartDate() {
		return startDate;
	}


	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}


	public LocalDate getEndDate() {
		return endDate;
	}


	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}


	public Double getTotalRent() {
		return totalRent;
	}


	public void setTotalRent(Double totalRent) {
		this.totalRent = totalRent;
	}


	public Cloth getCloth() {
		return cloth;
	}


	public void setCloth(Cloth cloth) {
		this.cloth = cloth;
	}


	@ManyToOne
    @JoinColumn(name = "cloth_id", nullable = false)
    private Cloth cloth;

    // Getters and Setters (Lombok will handle this if @Data is used)
}
