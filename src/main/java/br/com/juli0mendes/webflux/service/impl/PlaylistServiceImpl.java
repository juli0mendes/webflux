package br.com.juli0mendes.webflux.service.impl;

import org.springframework.stereotype.Service;

import br.com.juli0mendes.webflux.document.Playlist;
import br.com.juli0mendes.webflux.repository.PlaylistRepository;
import br.com.juli0mendes.webflux.service.PlaylistService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PlaylistServiceImpl implements PlaylistService {
	
	private final PlaylistRepository playlistRepository;

	public PlaylistServiceImpl(PlaylistRepository playlistRepository) {
		this.playlistRepository = playlistRepository;
	}

	@Override
	public Flux<Playlist> findAll() {
		return this.playlistRepository.findAll();
	}

	@Override
	public Mono<Playlist> findById(String id) {
		return this.playlistRepository.findById(id);
	}

	@Override
	public Mono<Playlist> save(Playlist playlist) {
		return this.playlistRepository.save(playlist);
	}
}
