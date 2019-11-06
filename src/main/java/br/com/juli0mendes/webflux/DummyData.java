//package br.com.juli0mendes.webflux;
//
//import static java.util.UUID.randomUUID;
//import static reactor.core.publisher.Flux.just;
//
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//import br.com.juli0mendes.webflux.document.Playlist;
//import br.com.juli0mendes.webflux.repository.PlaylistRepository;
//
//@Component
//public class DummyData implements CommandLineRunner {
//
//	private final PlaylistRepository playlistRepository;
//	
//	public DummyData(PlaylistRepository playlistRepository) {
//		this.playlistRepository = playlistRepository;
//	}
//	
//	@Override
//	public void run(String... args) throws Exception {
//		
//		this.playlistRepository.deleteAll()
//				.thenMany(just("Playlist 1", "Playlist 2", "Playlist 3", "Playlist 4", "Playlist 5")
//						.map(nome -> new Playlist(randomUUID().toString(), nome))
//						.flatMap(this.playlistRepository::save))
//				.subscribe(System.out::println);
//	}
//}