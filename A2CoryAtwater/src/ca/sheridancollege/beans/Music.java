package ca.sheridancollege.beans;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Music {
	
	private final String[] GENRES = {"Pop", "Indie", "Spoken Word", "Electronic", "Classic"};
	
	private String instrument;
	private boolean songWriter;
	private String genre;
	
}
