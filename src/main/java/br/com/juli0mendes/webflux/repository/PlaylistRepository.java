package br.com.juli0mendes.webflux.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import br.com.juli0mendes.webflux.document.Playlist;

public interface PlaylistRepository extends ReactiveMongoRepository<Playlist, String> {

}