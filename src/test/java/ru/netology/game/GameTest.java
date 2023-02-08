package ru.netology.game;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;

class GameTest {

    @Test

    public void testRoundWhenFirstPlayerStronger() {
        Game game = new Game();
        Player player1 = new Player(1, "Ivan", 50);
        Player player2 = new Player(2, "Vasya", 30);

        game.register(player1);
        game.register(player2);

        int actual = game.round("Ivan", "Vasya");
        int expected = 1;

        Assertions.assertEquals(expected, actual);

    }

    @Test

    public void testRoundWhenSecondPlayerStronger() {

        Game game = new Game();
        Player player1 = new Player(1, "Ivan", 30);
        Player player2 = new Player(2, "Vasya", 50);

        game.register(player1);
        game.register(player2);

        int actual = game.round("Ivan", "Vasya");
        int expected = 2;

        Assertions.assertEquals(expected, actual);

    }

    @Test

    public void testRoundWhenBothPlayersEqual() {
        Game game = new Game();
        Player player1 = new Player(1, "Ivan", 50);
        Player player2 = new Player(2, "Vasya", 50);

        game.register(player1);
        game.register(player2);

        int actual = game.round("Ivan", "Vasya");
        int expected = 0;

        Assertions.assertEquals(expected, actual);


    }

    @Test

    public void testRoundWithUnregisteredBothPlayer() {
        Game game = new Game();
        Player player3 = new Player(3, "Petr", 60);

        game.register(player3);

        try {
            game.round("Player 1", "Player 2");
            fail("Expected NotRegisteredException not thrown");
        } catch (NotRegisteredException e) {
            Assertions.assertEquals("Player Player 1 isn't exist", e.getMessage());

        }

    }

    @Test
    public void testRoundWithUnregisteredSecondPlayer() {
        Game game = new Game();
        Player player3 = new Player(3, "Petr", 60);

        game.register(player3);

        try {
            game.round("Petr", "Player 2");
            fail("Expected NotRegisteredException not thrown");
        } catch (NotRegisteredException e) {

            Assertions.assertEquals("Player Player 2 isn't exist", e.getMessage());
        }
    }

}









