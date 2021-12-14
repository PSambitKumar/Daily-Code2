package com.article;

import java.util.List;


public interface ArticleService {

 public List<Article> getAllArticles();
 
 public Article getArticleById(long id);
 
 public void saveOrUpdate(Article article);
 
 public void deleteArticle(long id);
}
