package s4.spring.td2.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "organization")
public class Corganization {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String domaine;
	private String alias;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "organization")
	private List<Cgroupe> groupes;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "organization")
	private List<Cuser> users;
	
	public Corganization() {
		super();
		this.id = (long) 0;
		this.name = "";
		this.domaine = "";
		this.alias = "";
		this.groupes = new ArrayList<Cgroupe>();
		this.users = new ArrayList<Cuser>();
	}
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	public String getDomaine() {return domaine;}	
	public void setDomaine(String domaine) {this.domaine = domaine;}
	public String getAlias() {return alias;}
	public void setAlias(String alias) {this.alias = alias;}
	public List<Cgroupe> getGroupes() {return groupes;}
	public void setGroupes(List<Cgroupe> groupes) {this.groupes = groupes;}
	public List<Cuser> getUsers() {return users;}
	public void setUsers(List<Cuser> users) {this.users = users;}
	public Long getId() {return id;}
	public void setId(Long id) {this.id=id;}
}
