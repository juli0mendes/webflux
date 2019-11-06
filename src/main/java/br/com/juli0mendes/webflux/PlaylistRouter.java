package br.com.juli0mendes.webflux;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class PlaylistRouter {

	private static final String ENDPOINT = "/playlist";

//	@Bean
	public RouterFunction<ServerResponse> route(PlaylistHandler playlistHandler) {
		return RouterFunctions
				.route(RequestPredicates.GET(ENDPOINT).and(RequestPredicates.accept(MediaType.APPLICATION_JSON)), playlistHandler::findAll)
				.andRoute(RequestPredicates.GET(ENDPOINT.concat("/{id}")).and(RequestPredicates.accept(MediaType.APPLICATION_JSON)), playlistHandler::findById)
				.andRoute(RequestPredicates.POST(ENDPOINT).and(RequestPredicates.accept(MediaType.APPLICATION_JSON)), playlistHandler::save);
	}
}