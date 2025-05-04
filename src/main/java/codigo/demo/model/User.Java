package codigo.demo.model;

public class User {
    private String name;
    private String password;
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id = null;
    private String role;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Deck> decks = new ArrayList<>();
    // Constructor
    public User(String name, String password, Long id, String role, List<Deck> decks) {
        this.name = name;
        this.password = password;
        this.id = id;
        this.role = role;
        this.decks = decks;
    }

    public List<Deck> getDecks() {
        return decks;
    }

    public void setDecks(List<Deck> decks) {
        this.decks = decks;
    }

    public void addDeck(Deck deck) {
        this.decks.add(deck);
        deck.setUser(this);
    }

    public void removeDeck(Deck deck) {
        this.decks.remove(deck);
        deck.setUser(null);
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", role='" + role + '\'' +
                '}';
    }
}