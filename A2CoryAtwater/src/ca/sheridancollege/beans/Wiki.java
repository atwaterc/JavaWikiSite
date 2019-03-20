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
public class Wiki {
	
	@Id
	@GeneratedValue
	private Long wikiId;
	
	private String wikiName;
	@Length(min=1, max=5000)
	private String wikiInfo;
	private String wikiPicture;
	
	public Wiki(String wikiName, String wikiInfo, String wikiPicture) {
		super();
		this.wikiName = wikiName;
		this.wikiInfo = wikiInfo;
		this.wikiPicture = wikiPicture;
	}
	
	
	
}
