package figures;

public class Figure {
    public int posX;
    public int posY;

    public Figure() {}
    
    public Figure(int x, int y) {
        this.posX = x;
        this.posY = y;
    }
    
    public void display() {
        System.out.println("Отображаю фигуру!");
    }
    
    public void displayPosition() {
        System.out.printf("Координаты фигуры {x: %d, y: %d}\n", this.posX, this.posY);
    }
}
