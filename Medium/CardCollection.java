import java.util.*;

class CardCollection {
    private HashMap<String, List<String>> cardMap;

    public CardCollection() {
        cardMap = new HashMap<>();
    }

    public void addCard(String symbol, String cardName) {
        cardMap.computeIfAbsent(symbol, k -> new ArrayList<>()).add(cardName);
    }

    public List<String> getCardsBySymbol(String symbol) {
        return cardMap.getOrDefault(symbol, new ArrayList<>());
    }

    public void displayAllCards() {
        for (Map.Entry<String, List<String>> entry : cardMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CardCollection collection = new CardCollection();

        collection.addCard("Hearts", "Ace");
        collection.addCard("Hearts", "King");
        collection.addCard("Spades", "Queen");
        collection.addCard("Diamonds", "Jack");
        collection.addCard("Clubs", "10");

        System.out.print("Enter a card symbol to search (e.g., Hearts, Spades): ");
        String symbol = scanner.nextLine();
        List<String> cards = collection.getCardsBySymbol(symbol);

        if (cards.isEmpty()) {
            System.out.println("No cards found for " + symbol);
        } else {
            System.out.println("Cards of " + symbol + ": " + cards);
        }

        scanner.close();
    }
}
