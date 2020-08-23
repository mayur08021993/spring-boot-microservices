package io.javabrains.moviecatalogservice.resources;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MovieRatingsService {
	
	@Autowired
	private RestTemplate restTemplate;
	
	/*@HystrixCommand(fallbackMethod="getfallBackRatingsInfo")*/
	public UserRating getRatingsInfo(String userId) {
		return restTemplate.getForObject("http://movie-rating-service/ratingsData/"+userId, UserRating.class);
	}
	
	@SuppressWarnings("unused")
	private UserRating getfallBackRatingsInfo(String userId) {
		
		UserRating rating = new UserRating();
		rating.setRatings(Arrays.asList(new Rating[] {new Rating("No Movie Found", 0)}));
		
		return rating;
	}
}
