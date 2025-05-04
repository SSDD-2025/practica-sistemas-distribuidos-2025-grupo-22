import codigo.demo.model.Card;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

package codigo.demo.service;


public class CardService {

    private final List<Card> cards = new ArrayList<>();

    // Add a new card
    public Card addCard(Card card) {
        cards.add(card);
        return card;
    }

    // Get all cards
    public List<Card> getAllCards() {
        return new ArrayList<>(cards);
    }

    // Get a card by ID
    public Optional<Card> getCardById(Long id) {
        return cards.stream().filter(card -> card.getId().equals(id)).findFirst();
    }

    // Update a card
    public Optional<Card> updateCard(Long id, Card updatedCard) {
        Optional<Card> existingCard = getCardById(id);
        existingCard.ifPresent(card -> {
            card.setImagen(updatedCard.getImagen());
            card.setNombre(updatedCard.getNombre());
            card.setDescripcion(updatedCard.getDescripcion());
            card.setCoste(updatedCard.getCoste());
        });
        return existingCard;
    }

    // Delete a card by ID
    public boolean deleteCard(Long id) {
        return cards.removeIf(card -> card.getId().equals(id));
    }
}