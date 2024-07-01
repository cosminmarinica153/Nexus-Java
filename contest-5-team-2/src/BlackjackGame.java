public class BlackjackGame {
    public static Deck deck = new Deck();


    public static void main(String[] args) {

    }
}


//
/*
 * Ne trebuie 4 deck-uri de carti cu 52 de carti
 * Se impart cate 2 carti la fiecare jucator si la dealer
 * Cartile jucatorilor se pot vedea amandoua, pe cand una din cartile dealerului trebuie sa fie ascunsa
 * Fiecare jucator isi verifica cartile si decide daca sa mai ceara una sau nu
 * Valorile cartilor sunt de la 1 la 11, 1-9 valori normale, J, Q, K = 10, A = 11/1
 * Daca un jucator mai cere carti iar suma cartilor trece de 21, jucatorul pierde
 * Daca toti jucatorii nu mai cer carti, dealer-ul arata cartea ascunsa si se verifica suma cartilor lui
 * Daca suma cartilor DEALER-ULUI este mai mica decat 17, dealer-ul mai ceara carti
 * Daca suma cartilor DEALER-ULUI este 21, dealer-ul are un blackjack
 * Daca suma cartilor DEALER-ULUI este mai mare decat 21, dealer-ul pierde
 * Se compara suma cartilor jucatorilor cu suma cartilor dealerului
 * Daca Dealer-ul are blackjack (suma cartilor 21) iar jucatorii au suma cartilor < 21, jucatorii pierd
 * Daca Dealer-ul are blackjack (suma cartilor 21) iar jucatorii/unul din jucator are si el blackjack,
 * jucatorul isi ia banii inapoi
 * Daca Dealer-ul NU are blackjack si jucatorii au suma cartilor mai mare decat a dealer-ului dar sub 21,
 * jucatorii/jucatorul castiga
 *
 *
 *
 */

//TODO: Player
//TODO: Deck
//TODO: Card