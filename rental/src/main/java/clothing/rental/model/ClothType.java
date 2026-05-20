package clothing.rental.model;


import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class ClothType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    

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


	@OneToMany(mappedBy = "clothType", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	  @JsonManagedReference 
    private Set<Cloth> clothes;


	public Set<Cloth> getClothes() {
		return clothes;
	}


	public void setClothes(Set<Cloth> clothes) {
		this.clothes = clothes;
	}
	
	
}
