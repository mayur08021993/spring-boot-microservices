package io.javabrains.ratingsdataservice.resources;

import java.util.Arrays;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ratingsData")
public class RatingsRexource {
	
	
	
	@GetMapping(value= "/{userId}",produces=MediaType.APPLICATION_JSON_VALUE)
	public UserRating getRating(@PathVariable("userId") String userId) {
		UserRating ratings = new UserRating();
		ratings.setRatings(Arrays.asList(new Rating[]{new Rating("1234", 8),new Rating("5678", 9)}));
		
		return ratings;
	}
}
