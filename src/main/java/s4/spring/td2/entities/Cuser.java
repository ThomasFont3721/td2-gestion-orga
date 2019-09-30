package s4.spring.td2.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Cuser {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String firstname;
	private String lastname;
	private String email;
	private String password;
	private String suspended;
	@ManyToOne
	private Corganization organization;
	@ManyToMany(mappedBy = "users")
	private List<Cgroupe> groupes;
	

	public Cuser(String firstname, String lastname) {
		super();
		this.id = (long) 0;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = "";
		this.password = "";
		this.suspended = "";
		this.organization = new Corganization();
		this.groupes = new ArrayList<Cgroupe>();
	}
	public Cuser() {
		this("", "");
	}
	
	public List<Cgroupe> getGroupes() {return groupes;}
	public void setGroupes(List<Cgroupe> groupes) {this.groupes = groupes;}
	public String getFirstname() {return firstname;}
	public void setFirstname(String firstname) {this.firstname = firstname;}
	public String getLastname() {return lastname;}
	public void setLastname(String lastname) {this.lastname = lastname;}
	public String getEmail() {return email;}
	public void setEmail(String email) {this.email = email;}
	public String getPassword() {return password;}
	public void setPassword(String password) {this.password = password;}
	public String getSuspended() {return suspended;}
	public void setSuspended(String suspended) {this.suspended = suspended;}
	public Corganization getOrganization() {return organization;}
	public void setOrganization(Corganization organization) {this.organization = organization;}
	public Long getId() {return id;}
	public void setId(Long id) {this.id=id;}
}
