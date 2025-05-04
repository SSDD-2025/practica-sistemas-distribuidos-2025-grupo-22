import codigo.demo.model.Deck;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

package codigo.demo.repository;


@Repository
public interface DeckRepository extends JpaRepository<Deck, Long> {
    // Add custom query methods if needed
}