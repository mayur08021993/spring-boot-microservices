package io.javabrains.moviecatalogservice.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MovieInfoService {
	
	@Autowired
	private RestTemplate restTemplate;
	
	/*@HystrixCommand(fallbackMethod="getFallbackMovieInfo")*/
	public List<CatalogItem> getMovieInfo(UserRating ratings) {
		
		List<CatalogItem> items = new ArrayList<>();
			for(Rating rating:ratings.getRatings()){
				Movie movie= restTemplate.getForObject("http://movie-info-service/movies/"+rating.getMovieId(), Movie.class);
				items.add(new CatalogItem(movie.getName(), "Test", rating.getRating()));
			}
			return items;
		}
	
	@SuppressWarnings("unused")
	private List<CatalogItem> getFallbackMovieInfo(){
		return Arrays.asList(new CatalogItem[] {new CatalogItem("No movie found", "", 0)});
	}
}
