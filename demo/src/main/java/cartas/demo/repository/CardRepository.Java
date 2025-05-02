import cartas.demo.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

package cartas.demo.repository;


@Repository
public interface CardRepository extends JpaRepository<Card, Long> {
    // Add custom query methods if needed
}