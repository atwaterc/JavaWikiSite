package ca.sheridancollege.dao;

import java.util.List;

import ca.sheridancollege.beans.Wiki;

public interface DAO {
	public void Populate();
	
	public List<Wiki> getWikiList();
	
	public void deleteWiki(Long wikiId);

	public void insertWiki(Wiki wiki);
	
	public List<Wiki> getSimilarWiki(String wikiCategory);
}
