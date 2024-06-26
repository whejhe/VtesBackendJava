package com.vtes.backend_vtes.Services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vtes.backend_vtes.Entities.Library;
import com.vtes.backend_vtes.Repositories.LibraryRepository;

@Service
public class LibraryService {
    @Autowired
    private LibraryRepository libraryRepository;

    // GETTERS
    public List<Library> getAllLibraries() {
        try{
            return libraryRepository.findAll();
        }catch(Exception e){
            throw new RuntimeException("Error al obtener todas las bibliotecas: " + e.getMessage());
        }
    }

    public Optional<Library> getLibraryById(Integer id) {
        try{
            return libraryRepository.findById(id);
        }catch(Exception e){
            throw new RuntimeException("Error al obtener la biblioteca con ID " + id + ": " + e.getMessage());
        }
    }

    public List<Library> getLibrariesByUserId(Integer userId) {
        try{
            return libraryRepository.findByUser_id(userId);
        }catch(Exception e){
            throw new RuntimeException("Error al obtener las bibliotecas del usuario " + userId + ": " + e.getMessage());
        }
    }

    public List<Library> getLibrariesByDeckId(Integer deckId) {
        try{
            return libraryRepository.findByDeck_id(deckId);
        }catch(Exception e){
            throw new RuntimeException("Error al obtener las bibliotecas del deck " + deckId + ": " + e.getMessage());
        }
    }

    public List<Library> getLibrariesByCardId(Integer cardId) {
        try{
            return libraryRepository.findByCard_id(cardId);
        }catch(Exception e){
            throw new RuntimeException("Error al obtener las bibliotecas del card " + cardId + ": " + e.getMessage());
        }
    }

    // SAVE
    public Library saveLibrary(Library library) {
        try{
            return libraryRepository.save(library);
        }catch(Exception e){
            throw new RuntimeException("Error al guardar la biblioteca: " + e.getMessage());
        }
    }

    // UPDATE
    public Library updateLibrary(Library library) {
        try{
            Optional<Library> existingLibrary = libraryRepository.findById(library.getLibrary_id());
            if (existingLibrary.isPresent()) {
                Library updatedLibrary = existingLibrary.get();
                updatedLibrary.setUser_id(library.getUser_id());
                updatedLibrary.setDeck_id(library.getDeck_id());
                updatedLibrary.setCard_id(library.getCard_id());
                return libraryRepository.save(updatedLibrary);
            } else {
                throw new RuntimeException("Library not found with id: " + library.getLibrary_id());
            }
        }catch(Exception e){
            throw new RuntimeException("Error al actualizar la biblioteca: " + e.getMessage());
        }
    }

    // DELETE
    public void deleteLibrary(Integer id) {
        try{
            libraryRepository.deleteById(id);
        }catch(Exception e){
            throw new RuntimeException("Error al borrar la biblioteca: " + e.getMessage());
        }
    }

    // DELETE BY USER ID
    public void deleteLibrariesByUserId(Integer userId) {
        try{
            libraryRepository.deleteByUser_id(userId);
        }catch(Exception e){
            throw new RuntimeException("Error al borrar las bibliotecas del usuario " + userId + ": " + e.getMessage());
        }
    }

    // DELETE BY DECK ID
    public void deleteLibrariesByDeckId(Integer deckId) {
        try{
            libraryRepository.deleteByDeck_id(deckId);
        }catch(Exception e){
            throw new RuntimeException("Error al borrar las bibliotecas del deck " + deckId + ": " + e.getMessage());
        }
    }

    // DELETE BY CARD ID
    public void deleteLibrariesByCardId(Integer cardId) {
        try{
            libraryRepository.deleteByCard_id(cardId);
        }catch(Exception e){
            throw new RuntimeException("Error al borrar las bibliotecas del card " + cardId + ": " + e.getMessage());
        }
    }
}
