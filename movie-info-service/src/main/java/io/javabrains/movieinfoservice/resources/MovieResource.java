package io.javabrains.movieinfoservice.resources;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
public class MovieResource {
	
	@Autowired
	private RabbitMQPublisher publisher;

	private List<Movie> movieData = Arrays
			.asList(new Movie[] { new Movie("1234", "The Prestige"), new Movie("5678", "Interstellar") });

	@GetMapping(value= "/{movieId}",produces=MediaType.APPLICATION_JSON_VALUE)
	public Movie getMovieInfo(@PathVariable("movieId") String movieId){
		
		Movie movie = movieData.stream().
				filter(data -> data.getMovieId().equals(movieId)).collect(Collectors.toList())
				.get(0);
		
		publisher.publish(movie);
		return movie;
		
	}
}
