package s4.spring.td2.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Cgroupe {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String email;
	private String aliases;
	@ManyToOne
	private Corganization organization;
	@ManyToMany
	@JoinTable(name = "user_has_group")
	private List<Cuser> users;

	public Cgroupe(String name) {
		super();
		this.id = (long) 0;
		this.name = name;
		this.email = "";
		this.aliases = "";
		this.organization = new Corganization();
		this.users = new ArrayList<Cuser>();
	}
	public Cgroupe() {
		this("");
	}
	
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	public String getEmail() {return email;}
	public void setEmail(String email) {this.email = email;}
	public String getAliases() {return aliases;}
	public void setAliases(String aliases) {this.aliases = aliases;}
	public Corganization getOrganization() {return organization;}
	public void setOrganization(Corganization organization) {this.organization = organization;}
	public List<Cuser> getUsers() {return users;}
	public void setUsers(List<Cuser> users) {this.users = users;}
	public Long getId() {return id;}
	public void setId(Long id) {this.id=id;}
}
