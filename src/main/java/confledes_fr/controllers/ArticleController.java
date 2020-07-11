package confledes_fr.controllers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import confledes_fr.exception.ResourceNotFoundException;
import confledes_fr.models.Article;
import confledes_fr.repository.ArticleRepository;
//import confledes_fr.security_services.Article_Interface;
import confledes_fr.security_services.Article_Interface;


@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class ArticleController {
	private List<String> tasks1 = Arrays.asList("a", "b", "c", "d", "e", "f", "g");
	@Autowired
	ArticleRepository ar;

	@GetMapping("/test")
	// @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	List<String> findAllarb() {
		return tasks1;
	}

	@GetMapping("/article")
	public List<Article> getAllAr() {
		List<Article> art = ar.findAll();
		return art;
	}
	@GetMapping("/article/{id}")
	public Article getArticle(@PathVariable(value = "id") int sid) {
		Article art = ar.findById(sid);
		return art;

	}
	@GetMapping("/disponibilite/{selected}")
	public List<Article> getProduitdisponible(@PathVariable(value = "selected") String selected) {
		List<Article> prod = ar.findBySelected(selected);
;	        return prod;     
        }

@PostMapping("/addarticle")
	// @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public Article createProject(@Valid @RequestBody Article arb) {
	arb.setDisponible("Disponible");
		return ar.save(arb);
	}
	@PutMapping("article/update/{id}")
	public ResponseEntity<Article> updateArticle(@PathVariable(value = "id") int articleId,
			@Valid @RequestBody Article articledetails) throws ResourceNotFoundException {
		Article article= ar.findById(articleId);
		article.setId(articledetails.getId());
		article.setArticleName(articledetails.getArticleName());
		article.setRef(articledetails.getRef());
		final Article updatearticle = ar.save(article);
		return ResponseEntity.ok(updatearticle);
	}
	
	@PutMapping("article/panier/{id}")
	public ResponseEntity<Article> PanierArticle(@PathVariable(value = "id") int articleId,
			@Valid @RequestBody Article articledetails) throws ResourceNotFoundException {
		Article article= ar.findById(articleId);
		int n = 0;
	//	int status = article.get;
		article.setId(articledetails.getId());
		article.setArticleName(articledetails.getArticleName());
		article.setRef(articledetails.getRef());
		article.setSelected("selected");
		article.setNbre(article.getNbredispo() -1 );
	if(article.getNbredispo() <= 0 ||article.getNbre() <=0 ) {
		article.setDisponible("Non Disponible");
	}
	if(article.getNbredispo() == 0) {
		article.setDisponible("Disponible");
	}
		final Article updatearticle = ar.save(article);
		return ResponseEntity.ok(updatearticle);
	}

	@DeleteMapping("/delete/{id}")
	public Map<String, Boolean> deleteArticle(@PathVariable(value = "id") int arbitreId)
			throws ResourceNotFoundException {
		Article arbitre = ar.findById(arbitreId);
		ar.delete(arbitre);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}


}