package zad1_2015;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Player {
    private final String nick;
    private int score;
    private int lives;

    private static int playerCount = 0;
    private static Set<String> usedNames = new HashSet<>();

    public Player(String nick) {
        if (playerCount >= 4)
            throw new IllegalStateException("W danej chwili może być max 4 graczy");

        if (nick.length() < 3)
            throw new IllegalArgumentException("Nazwa gracza musi mieć co najmniej 3 znaki");
        if (usedNames.contains(nick))
            throw new IllegalArgumentException("Nazwa gracza jest już zajęta");

        this.nick = nick;
        lives = 5;
        score = 0;

        playerCount++;
        usedNames.add(nick);
    }

    @Override
    public void finalize() {
        playerCount--;
        usedNames.remove(nick);
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        if (lives < 1)
            throw new IllegalStateException("Nie można zmienić wyniku gdy gracz jest martwy");

        this.score = score;
    }

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        if (lives >= this.lives)
            throw new IllegalArgumentException("Nowa liczba żyć musi być miniejsza od aktualnej");

        this.lives = lives;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return nick.equals(player.nick);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nick);
    }
}
