package confledes_fr.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import confledes_fr.models.Article;



public interface ArticleRepository extends CrudRepository<Article, Long> {

///	List<Article> findByArticleName(String name);

	List<Article> findAll();

	Article findById(int id);
	List<Article> findBySelected(String selected);



	/*@Transactional
	void deleteByArticleName(String name);*/

}
// Arbitre update();