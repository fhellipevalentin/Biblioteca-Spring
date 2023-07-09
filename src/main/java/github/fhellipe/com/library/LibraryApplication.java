package github.fhellipe.com.library;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import github.fhellipe.com.library.model.Author;
import github.fhellipe.com.library.model.Authority;
import github.fhellipe.com.library.model.Book;
import github.fhellipe.com.library.model.Customer;
import github.fhellipe.com.library.model.Genre;
import github.fhellipe.com.library.repository.AuthorRepository;
import github.fhellipe.com.library.repository.AuthorityRepository;
import github.fhellipe.com.library.repository.BookRepository;
import github.fhellipe.com.library.repository.CustomerRepository;
import github.fhellipe.com.library.repository.GenreRepository;

@SpringBootApplication
public class LibraryApplication implements CommandLineRunner {

	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private AuthorityRepository authorityRepository;
	@Autowired
	private BookRepository bookRepository;
	@Autowired
	private GenreRepository genreRepository;
	@Autowired
	private AuthorRepository authorRepository;

	@Autowired
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	public static void main(String[] args) {
		SpringApplication.run(LibraryApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Authority auth1 = new Authority(null, "ROLE_ADMIN");
		Authority auth2 = new Authority(null, "ROLE_SECRETARIA");

		authorityRepository.saveAll(Arrays.asList(auth1, auth2));

		Customer c1 = new Customer(null, "Admito", "admito@example.com", "11994212145", passwordEncoder().encode("12345"), "admin", LocalDateTime.now());

		customerRepository.saveAll(Arrays.asList(c1));

		Author a1 = new Author(null, "Jurencio");
		Author a2 = new Author(null, "Comerciante Anônimo");
		Author a3 = new Author(null, "Maguire Goodman");
		Author a4 = new Author(null, "John Grisham");
		Author a5 = new Author(null, "Scott Turow");
		Author a6 = new Author(null, "Michael J. Sandel");
		Author a7 = new Author(null, "Sergio Moro");
		Author a8 = new Author(null, "Manoel de Oliveira Franco Sobrinho");
		Author a9 = new Author(null, "Guilherme de Souza Nucci");
		Author a10 = new Author(null, "Carlos Roberto Gonçalves");
		Author a11 = new Author(null, "Patricia Peck Pinheiro");
		Author a12 = new Author(null, "Sílvio Meira");
		Author a13 = new Author(null, "Ludwing Von Mises");
		Author a14 = new Author(null, "Hans Kelsen");

		authorRepository.saveAll(Arrays.asList(a1,a2,a3,a4,a5,a6,a7,a8,a9,a10,a11,a12,a13,a14));

		Genre genre1 = new Genre(null, "Economia");
		Genre genre2 = new Genre(null, "Teórico");
		Genre genre3 = new Genre(null, "Literatura Jurídica");
		Genre genre4 = new Genre(null, "Biografias");

		genreRepository.saveAll(Arrays.asList(genre1, genre2, genre3, genre4));


		Book b1 = new Book(null, "Juridico e Minha vida", null, 1, LocalDateTime.parse("02/02/2021 00:00:00", DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")), LocalDateTime.parse("22/11/2022 00:00:00", DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")), a1, Instant.now());
		Book b2 = new Book(null, "As Cronicas do Comércio", "Economia sec XXI", 1, LocalDateTime.parse("02/02/2002 00:00:00", DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")), LocalDateTime.parse("01/05/2010 00:00:00", DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")), a2, Instant.now());
		Book b3 = new Book(null, "Suits, uma lição para a Vida", null, 1, LocalDateTime.parse("05/10/2019 00:00:00", DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")), LocalDateTime.parse("12/07/2018 00:00:00", DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")), a3, Instant.now());
		Book b4 = new Book(null, "O Júri", null, 1, LocalDateTime.parse("02/02/2021 00:00:00", DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")), LocalDateTime.parse("22/11/2022 00:00:00", DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")), a4, Instant.now());
		Book b5 = new Book(null, "O Primeiro Ano: Como Se Faz Um Advogado",null, 5, LocalDateTime.parse("11/04/2010 00:00:00", DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")), LocalDateTime.parse("10/10/2015 00:00:00", DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")), a5, Instant.now());
		Book b6 = new Book(null, "Justiça: o que é a coisa certa a fazer", null, 2, LocalDateTime.parse("02/02/2021 00:00:00", DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")), LocalDateTime.parse("10/10/2015 00:00:00", DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")), a6, Instant.now());
		Book b7 = new Book(null, "Contra o sistema da corrupção", null, 10, LocalDateTime.parse("10/04/2018 00:00:00", DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")), LocalDateTime.parse("10/10/2015 00:00:00", DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")), a7, Instant.now());
		Book b8 = new Book(null, "Desapropriação", null, 12, LocalDateTime.parse("10/04/2018 00:00:00", DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")), LocalDateTime.parse("10/10/2015 00:00:00", DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")), a8, Instant.now());
		Book b9 = new Book(null, "Manual de Direito Penal", null, 2, LocalDateTime.parse("10/04/2018 00:00:00", DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")), LocalDateTime.parse("10/10/2015 00:00:00", DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")), a9, Instant.now());
		Book b10 = new Book(null, "Direito Civil Brasileiro", null, 3, LocalDateTime.parse("10/04/2018 00:00:00", DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")), LocalDateTime.parse("10/10/2015 00:00:00", DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")), a10, Instant.now());
		Book b11 = new Book(null, "Direito Digital e Proteção de Dados", null, 2, LocalDateTime.parse("10/04/2018 00:00:00", DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")), LocalDateTime.parse("10/10/2015 00:00:00", DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")), a11, Instant.now());
		Book b12 = new Book(null, "Clóvis Beviláqua: sua vida, sua obra", null, 1, LocalDateTime.parse("10/04/2018 00:00:00", DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")), LocalDateTime.parse("10/10/2015 00:00:00", DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")), a12, Instant.now());
		Book b13 = new Book(null, "Ação Humana", "Mises", 7, LocalDateTime.parse("10/04/2018 00:00:00", DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")), LocalDateTime.parse("10/10/2015 00:00:00", DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")), a13, Instant.now());
		Book b14 = new Book(null, "The Theory of Money and Credit", "Mises", 2, LocalDateTime.parse("10/04/2018 00:00:00", DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")), LocalDateTime.parse("10/10/2015 00:00:00", DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")), a13, Instant.now());
		Book b15 = new Book(null, "A Teoria Comunista do Direito", null, 1, LocalDateTime.parse("10/04/2018 00:00:00", DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")), LocalDateTime.parse("10/10/2015 00:00:00", DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")), a14, Instant.now());

		b1.getGenres().add(genre3);
		b2.getGenres().add(genre1);
		b3.getGenres().add(genre2);
		b4.getGenres().add(genre3);
		b5.getGenres().add(genre2);
		b6.getGenres().add(genre2);
		b7.getGenres().add(genre4);
		b8.getGenres().add(genre2);
		b9.getGenres().add(genre2);
		b10.getGenres().add(genre2);
		b11.getGenres().add(genre2);
		b12.getGenres().add(genre4);
		b13.getGenres().add(genre1);
		b14.getGenres().add(genre1);
		b15.getGenres().add(genre3);

		bookRepository.saveAll(Arrays.asList(b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14, b15));

	}
}
