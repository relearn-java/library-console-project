package com.springbootlearning.learningspringboot;

import com.springbootlearning.learningspringboot.domain.*;
import com.springbootlearning.learningspringboot.repository.BookRepository;
import com.springbootlearning.learningspringboot.repository.UserRepository;
import com.springbootlearning.learningspringboot.repository.inmemory.InMemoryBookRepository;
import com.springbootlearning.learningspringboot.repository.inmemory.InMemoryUserRepository;

import java.time.LocalDate;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        BookRepository bookRepo = new InMemoryBookRepository();
        UserRepository userRepo = new InMemoryUserRepository();

        // Créer des livres
        Book b1 = bookRepo.save(new Book(null, "978-2-07-040850-4",
                "Les Misérables", "Gallimard", 1862, 1L));
        Book b2 = bookRepo.save(new Book(null, "978-2-07-041238-8",
                "Notre-Dame de Paris", "Gallimard", 1831, 1L));
        Book b3 = bookRepo.save(new Book(null, "978-2-07-036024-6",
                "Le Comte de Monte-Cristo", "Gallimard", 1844, 1L));

        System.out.println("=== TOUS LES LIVRES ===");
        bookRepo.findAll().forEach(System.out::println);

        System.out.println("\n=== RECHERCHE 'mise' ===");
        bookRepo.findByTitle("mise").forEach(System.out::println);

        System.out.println("\n=== RECHERCHE PAR CATEGORIE 1 ===");
        bookRepo.findByCategoryId(1L).forEach(System.out::println);

        // Créer un utilisateur
        User user = userRepo.save(new User(null, "Dupont", "Jean",
                "jean.dupont@email.com", "0612345678",
                "12 rue de la Paix, Paris", LocalDate.now(),
                "hashed_password", UserStatus.ACTIVE, Role.MEMBER));

        System.out.println("\n=== UTILISATEUR CRÉÉ ===");
        System.out.println(user);

        System.out.println("\n=== RECHERCHE PAR EMAIL ===");
        userRepo.findByEmail("jean.dupont@email.com")
                .ifPresentOrElse(
                        System.out::println,
                        () -> System.out.println("Aucun utilisateur trouvé")
                );
    }

}