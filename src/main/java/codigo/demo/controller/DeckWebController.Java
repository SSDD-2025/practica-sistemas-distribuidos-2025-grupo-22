package codigo.demo.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import es.codeurjc.daw.library.model.Deck;
import codigo.demo.model.Deck;
import codigo.demo.service.DeckService;
import codigo.demo.service.ShopService;

@Controller
public class DeckWebController {

    @Autowired
    private DeckService deckService;

    @Autowired
    private ShopService shopService;

    @GetMapping("/")
    public String showDecks(Model model) {
        model.addAttribute("decks", deckService.findAll());
        return "decks";
    }

    @GetMapping("/decks/{id}")
    public String showDeck(Model model, @PathVariable long id) {

        Optional<Deck> deck = deckService.findById(id);
        if (deck.isPresent()) {
            model.addAttribute("deck", deck.get());
            return "deck";
        } else {
            return "decks";
        }

    }



    @PostMapping("/newdeck")
    public String newDeckProcess(Model model, Deck deck, MultipartFile imageField, @RequestParam(required = false) List<Long> selectedShops) throws IOException {

        Deck newDeck = deckService.save(deck, selectedShops, imageField);

        model.addAttribute("deckId", newDeck.getId());

        return "redirect:/decks/" + newDeck.getId();
    }

}