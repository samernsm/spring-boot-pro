package entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "Employees")
@EntityListeners(AuditingEntityListener.class)
public class Employees {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
    

	@Column(name= "firstNamre")
	private String firstName;
	
	@Column(name = "lastName")
	private String lastNAme;
	
	@Column(name = "age")
	private Integer age;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="employeeId")
	@JsonManagedReference
	private Set<Hobby> hobbies;

	public Employees() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	public Employees(Long id, String firstName, String lastNAme, Integer age, Set<Hobby> hobbies) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastNAme = lastNAme;
		this.age = age;
		this.hobbies = hobbies;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastNAme() {
		return lastNAme;
	}

	public void setLastNAme(String lastNAme) {
		this.lastNAme = lastNAme;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Set<Hobby> getHobbies() {
		return hobbies;
	}

	public void setHobbies(Set<Hobby> hobbies) {
		this.hobbies = hobbies;
	}
    
	
	
    
}
