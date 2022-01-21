package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Table(name = "hobbies")
public class Hobby {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
    private Long Id;

    @Column(name = "hobby")
    private String hobby;
    
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "employeeId")
    private Employees employees;

    public Hobby() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
    
    
    public Hobby(String hobby) {
		super();
		this.hobby = hobby;
	}




	public String getHobby() {
		return hobby;
	}

			
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}



	public Long getId() {
		return Id;
	}



	public void setId(Long id) {
		Id = id;
	}



	public Employees getEmployees() {
		return employees;
	}



	public void setEmployees(Employees employees) {
		this.employees = employees;
	}
    
    
    
}
