package com.vtes.backend_vtes.Controllers;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.vtes.backend_vtes.Entities.Library;
import com.vtes.backend_vtes.Services.LibraryService;

@RestController
@RequestMapping("/libraries")
public class LibraryController {
    @Autowired
    private LibraryService libraryService;

    @GetMapping
    public List<Library> getAllLibraries() {
        return libraryService.getAllLibraries();
    }

    @GetMapping("/{id}")
    public Optional<Library> getLibraryById(@PathVariable Integer id) {
        return libraryService.getLibraryById(id);
    }

    @GetMapping("/user/{userId}")
    public List<Library> getLibrariesByUserId(@PathVariable Integer userId) {
        return libraryService.getLibrariesByUserId(userId);
    }

    @GetMapping("/deck/{deckId}")
    public List<Library> getLibrariesByDeckId(@PathVariable Integer deckId) {
        return libraryService.getLibrariesByDeckId(deckId);
    }

    @GetMapping("/card/{cardId}")
    public List<Library> getLibrariesByCardId(@PathVariable Integer cardId) {
        return libraryService.getLibrariesByCardId(cardId);
    }

    @PostMapping
    public Library saveLibrary(@RequestBody Library library) {
        return libraryService.saveLibrary(library);
    }

    @PutMapping("/{id}")
    public Library updateLibrary(@PathVariable Integer id, @RequestBody Library library) {
        library.setLibraryId(id);
        return libraryService.saveLibrary(library);
    }

    @DeleteMapping("/{id}")
    public void deleteLibrary(@PathVariable Integer id) {
        libraryService.deleteLibrary(id);
    }

    @DeleteMapping("/user/{userId}")
    public void deleteLibrariesByUserId(@PathVariable Integer userId) {
        libraryService.deleteLibrariesByUserId(userId);
    }

    @DeleteMapping("/deck/{deckId}")
    public void deleteLibrariesByDeckId(@PathVariable Integer deckId) {
        libraryService.deleteLibrariesByDeckId(deckId);
    }

    @DeleteMapping("/card/{cardId}")
    public void deleteLibrariesByCardId(@PathVariable Integer cardId) {
        libraryService.deleteLibrariesByCardId(cardId);
    }
}
