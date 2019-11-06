package br.com.juli0mendes.webflux.controller;

import java.time.Duration;

import javax.validation.Valid;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.juli0mendes.webflux.document.Playlist;
import br.com.juli0mendes.webflux.service.PlaylistService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

@RestController
@RequestMapping(value = "/playlist")
public class PlaylistController {

	private final PlaylistService playlistService;

	public PlaylistController(PlaylistService playlistService) {
		this.playlistService = playlistService;
	}

	@GetMapping
	public Flux<Playlist> findAll() {
		return this.playlistService.findAll();
	}

	@GetMapping(value = "/{id}")
	public Mono<Playlist> getOne(@PathVariable("id") String id) {
		return this.playlistService.findById(id);
	}
	
	@PostMapping
	public Mono<Playlist> save(@RequestBody @Valid Playlist playlist) {
		return this.playlistService.save(playlist);
	}
	
	@GetMapping(value = "/events", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<Tuple2<Long, Playlist>> findPlaylistByEvents() {
		
		// intervalo de cada resposta (stream)
		Flux<Long> interval = Flux.interval(Duration.ofSeconds(10));
		
		Flux<Playlist> events = this.playlistService.findAll();
		
		System.out.println("Passou aqui (events)");
		
		return Flux.zip(interval, events);
	}
}