package confledes_fr.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Article implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "article_id")
	private int id;
	
	private String articleName ;
	private String ref ;
	private String disponible ;
	private int nbre ;
	private String selected ;
	
	public Article(int id, String articleName, String ref, String disponible, int nbre, String selected) {
		super();
		this.id = id;
		this.articleName = articleName;
		this.ref = ref;
		this.disponible = disponible;
		this.nbre = nbre;
		this.selected = selected;
	}
	public String getSelected() {
		return selected;
	}
	public void setSelected(String selected) {
		this.selected = selected;
	}
	public String getDisponible() {
	
		return disponible;
	}
	public void setDisponible(String disponible) {
		this.disponible = disponible;
	}
	public int getNbre() {
		return nbre;
	}
	public int getNbredispo() {
	
	//	n = nbre - 1 ;
	
		return nbre ;
	}
	public void setNbre(int nbre) {
		this.nbre = nbre;
	}
	public Article(int id, String articleName, String ref, String disponible, int nbre) {
		super();
		this.id = id;
		this.articleName = articleName;
		this.ref = ref;
		this.disponible = disponible;
		this.nbre = nbre;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getArticleName() {
		return articleName;
	}
	public void setArticleName(String articleName) {
		this.articleName = articleName;
	}
	public String getRef() {
		return ref;
	}
	public void setRef(String ref) {
		this.ref = ref;
	}
	public Article(int id, String articleName, String ref) {
		super();
		this.id = id;
		this.articleName = articleName;
		this.ref = ref;
	}
	public Article() {
		super();
	}

}


