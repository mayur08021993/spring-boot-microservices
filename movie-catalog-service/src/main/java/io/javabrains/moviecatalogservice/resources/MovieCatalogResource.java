package io.javabrains.moviecatalogservice.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {
	
	@Autowired
	private MovieInfoService movieInfo;
	
	@Autowired
	private MovieRatingsService movieRatings;
	
	@GetMapping(value= "/{userId}",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<CatalogItem> getCaltalogItems(@PathVariable("userId") String userId){
		
		UserRating ratings = movieRatings.getRatingsInfo(userId); 
		
		List<CatalogItem> items = movieInfo.getMovieInfo(ratings);
		
		return items;
		
	}

}
