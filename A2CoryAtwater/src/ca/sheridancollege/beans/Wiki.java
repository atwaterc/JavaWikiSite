package ca.sheridancollege.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@NamedQuery(name="Wiki.getWikiList", query="from Wiki")
@NamedQuery(name="Wiki.getSimilarWiki", query="from Wiki where wikiCategory =:wikiCategory")
public class Wiki {
	
	@Id
	@GeneratedValue
	private Long wikiId;
	
	@Length(min=3, max=25)
	private String wikiName;
	@Length(min=1, max=50)
	private String wikiCategory;
	
	@Length(min=1, max=5000)
	private String wikiInfo;
	@Length(min=10, max=2000)
	private String wikiPicture;
	
	public Wiki(String wikiName, String wikiCategory, String wikiInfo, String wikiPicture) {
		super();
		this.wikiName = wikiName;
		this.wikiCategory = wikiCategory;
		this.wikiInfo = wikiInfo;
		this.wikiPicture = wikiPicture;
	}
	
	
	
}
