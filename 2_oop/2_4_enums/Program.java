public class Program {
    public static void main(String[] args) {
        Player player = new Player("test.mp3");
        player.display();
        
        player.play();
        player.display();
    }
}

enum State {
    STOPPED,
    PAUSED,
    WORKING,
}

class Player {
    private State state = State.STOPPED;
    private String currentSong;

    public State getState() { return this.state; }

    public void setState(State state) {
        this.state = state;
    }

    public Player() {}
    public Player(String song) { this.currentSong = song; }

    public void play() {
        switch (getState()) {
            case State.STOPPED: {
                System.out.println("Музыка остановлена, запускаю!");
                setState(State.WORKING);
                break;
            }
            case State.PAUSED: { 
                System.out.println("Музыка на паузе, запускаю!"); 
                setState(State.WORKING);
                break;
            }
            case State.WORKING: System.out.println("Музыка уже проигрывается!"); break;
        }
    }

    public void display() {
        System.out.printf("Плеер [%s]", getState());

        if (this.currentSong != null) {
            System.out.println();
            System.out.printf("Выбрана песня - %s\n", this.currentSong);
        } else {
            System.out.println();
        }
    }
}
