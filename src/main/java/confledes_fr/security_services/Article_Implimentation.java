package confledes_fr.security_services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import confledes_fr.models.Article;
import confledes_fr.repository.ArticleRepository;


public class Article_Implimentation implements Article_Interface{
	@Autowired
	ArticleRepository arepo;
	@Override
	public List<Article> findAllArticle() {
		// TODO Auto-generated method stub
		return arepo.findAll();
	}

	@Override
	public Article saveArticle(Article article) {
		// TODO Auto-generated method stub
		return arepo.save(article);
	}

	@Override
	public Article findById(int id) {
		// TODO Auto-generated method stub
		return arepo.findById(id);
	}

}
