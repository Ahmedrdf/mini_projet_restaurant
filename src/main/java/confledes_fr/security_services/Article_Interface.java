package confledes_fr.security_services;

import java.util.List;

import confledes_fr.models.Article;


public interface Article_Interface {
	List<Article> findAllArticle();

	Article saveArticle(Article article);

	//List<Article> findBy(String description);

	//List<Article> findByEquipe(String equipe);

	Article findById(int id);

}
