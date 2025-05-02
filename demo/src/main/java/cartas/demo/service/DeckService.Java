import cartas.demo.model.Deck;
import cartas.demo.model.Card;
import cartas.demo.repository.DeckRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


package cartas.demo.service;



@Service
public class DeckService {

    @Autowired
    private DeckRepository deckRepository;

    public Deck createDeck(Deck deck) {
        return deckRepository.save(deck);
    }

    public Optional<Deck> getDeckById(Long id) {
        return deckRepository.findById(id);
    }

    public List<Deck> getAllDecks() {
        return deckRepository.findAll();
    }

    public Deck updateDeck(Long id, Deck updatedDeck) {
        return deckRepository.findById(id).map(deck -> {
            deck.setName(updatedDeck.getName());
            deck.setDescription(updatedDeck.getDescription());
            deck.setUser(updatedDeck.getUser());
            deck.setCards(updatedDeck.getCards());
            return deckRepository.save(deck);
        }).orElseThrow(() -> new RuntimeException("Deck not found with id " + id));
    }

    public void deleteDeck(Long id) {
        deckRepository.deleteById(id);
    }

    public void addCardToDeck(Long deckId, Card card) {
        Deck deck = deckRepository.findById(deckId)
                .orElseThrow(() -> new RuntimeException("Deck not found with id " + deckId));
        deck.addCard(card);
        deckRepository.save(deck);
    }

    public void removeCardFromDeck(Long deckId, Card card) {
        Deck deck = deckRepository.findById(deckId)
                .orElseThrow(() -> new RuntimeException("Deck not found with id " + deckId));
        deck.removeCard(card);
        deckRepository.save(deck);
    }
}