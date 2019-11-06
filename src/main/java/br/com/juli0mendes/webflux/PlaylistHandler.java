package br.com.juli0mendes.webflux;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import br.com.juli0mendes.webflux.document.Playlist;
import br.com.juli0mendes.webflux.service.PlaylistService;
import reactor.core.publisher.Mono;

@Component
public class PlaylistHandler {

	private final PlaylistService playlistService;

	public PlaylistHandler(PlaylistService playlistService) {
		this.playlistService = playlistService;
	}
	

	public Mono<ServerResponse> findAll(ServerRequest request) {
		return ServerResponse.ok()
				.contentType(MediaType.APPLICATION_JSON)
				.body(this.playlistService.findAll(), Playlist.class);
	}
	
	public Mono<ServerResponse> findById(ServerRequest request) {
		
		String id = request.pathVariable("id");
		
		return ServerResponse.ok()
				.contentType(MediaType.APPLICATION_JSON)
				.body(this.playlistService.findById(id), Playlist.class);
	}
	
	public Mono<ServerResponse> save(ServerRequest request) {
		
		final Mono<Playlist> playlist = request.bodyToMono(Playlist.class);
		
		return ServerResponse.ok()
				.contentType(MediaType.APPLICATION_JSON)
				.body(BodyInserters.fromPublisher(playlist.flatMap(this.playlistService::save), Playlist.class));
	}
}
