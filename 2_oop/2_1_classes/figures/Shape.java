package figures;

// Абстрактный класс – класс, от которого нельзя создать экземляр 
// Он предоставляет базовый функционал для своих наследников

public abstract class Shape {
    public int posX;
    public int posY;

    public Shape() {}
    
    public Shape(int x, int y) {
        this.posX = x;
        this.posY = y;
    }

    public abstract void display();
}