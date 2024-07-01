import utils.Card;
import utils.Deck;
import utils.Player;

import java.util.ArrayList;

public class WarCardGame {
    // Cards
    private final ArrayList<Card> cardsOnTable;


    // Players
    private final Player player;
    private final Player ai;

    public WarCardGame() {
        Deck deckObj = new Deck(2, 14);
        ArrayList<Card> deck = deckObj.getDeck();

        this.cardsOnTable = new ArrayList<>();

        this.player = new Player(
                "Player",
                new ArrayList<>(deck.subList(0, deck.size() / 2))
        );
        this.ai = new Player(
                "Computer",
                new ArrayList<>(deck.subList(deck.size() / 2, deck.size()))
        );
    }

    private void pickUp(Player player) {
        player.addCards(this.cardsOnTable);
        this.cardsOnTable.clear();
        System.out.println(player.getType() + " picks up!");
    }

    private void handleWar(Player player, Player ai) {
        System.out.println("Let the war begin! ⚔️");

        // If a player cannot continue the war, they lose
        if (player.getCards().size() < 4 || ai.getCards().size() < 4) {
            if (player.getCards().size() < 4) {
                System.out.println("Player does not have enough cards for war. Computer wins!");
            } else {
                System.out.println("Computer does not have enough cards for war. Player wins!");
            }
        }

        for (int i = 0; i < 4; i++) {
            this.cardsOnTable.add(player.putCardOnTable());
            this.cardsOnTable.add(ai.putCardOnTable());
        }

        if (!player.hasCards() || !ai.hasCards()) {
            return;
        }

        Card playerWarCard = player.putCardOnTable();
        Card aiWarCard = ai.putCardOnTable();

        this.cardsOnTable.add(playerWarCard);
        this.cardsOnTable.add(aiWarCard);

        assert playerWarCard != null;
        assert aiWarCard != null;
        if (playerWarCard.getValue() > aiWarCard.getValue()) {
            pickUp(player);
        } else if (aiWarCard.getValue() > playerWarCard.getValue()) {
            pickUp(ai);
        } else {
            handleWar(player, ai); // Continue war if still tied
        }
    }

    public void play() {
        while (this.player.hasCards() && this.ai.hasCards()) {

            Card lastPlayerCard = this.player.putCardOnTable();
            Card lastAiCard = this.ai.putCardOnTable();

            this.cardsOnTable.add(lastPlayerCard);
            this.cardsOnTable.add(lastAiCard);

            assert lastPlayerCard != null;
            assert lastAiCard != null;
            if (lastPlayerCard.getValue() > lastAiCard.getValue()) {
                pickUp(this.player);
            } else if (lastAiCard.getValue() > lastPlayerCard.getValue()) {
                pickUp(this.ai);
            } else {
                handleWar(this.player, this.ai);
            }
        }

        if (this.player.getCards().isEmpty()) {
            System.out.println("Computer wins!");
        } else if (this.ai.getCards().isEmpty()) {
            System.out.println("Player wins");
        }
    }
}