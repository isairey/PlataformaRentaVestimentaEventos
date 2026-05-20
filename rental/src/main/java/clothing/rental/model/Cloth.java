package clothing.rental.model;


import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Cloth {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String size;
    private Double rentPrice;
    private String description;
    private Boolean availability;
    private String imageUrl; // Add this field
    private String gender; 
    

    public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getSize() {
		return size;
	}


	public void setSize(String size) {
		this.size = size;
	}


	public Double getRentPrice() {
		return rentPrice;
	}


	public void setRentPrice(Double rentPrice) {
		this.rentPrice = rentPrice;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Boolean getAvailability() {
		return availability;
	}


	public void setAvailability(Boolean availability) {
		this.availability = availability;
	}
	


	public String getImageUrl() {
		return imageUrl;
	}


	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}



	@ManyToOne
	@JsonBackReference 
    @JoinColumn(name = "cloth_type_id", nullable = false)
    private ClothType clothType;
	  public ClothType getClothType() {
			return clothType;
		}


		public void setClothType(ClothType clothType) {
			this.clothType = clothType;
		}
}
