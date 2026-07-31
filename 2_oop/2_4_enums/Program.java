public class Program {
    public static void main(String[] args) {
        Player player = new Player();
        player.play();
    }
}

enum State {
    STOPPED,
    PAUSED,
    WORKING,
}

class Player {
    private State state = State.STOPPED;

    public State getState() { return this.state; }

    public void setState(State state) {
        this.state = state;
    }

    public Player() {
        
    }

    public void play() {
        
    }
}
