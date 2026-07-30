package figures;

import figures.Figure;

// Наследуемся от родительского класса Figure:
// +posX
// +posY
// +display()
// +displayPosition()

public class Rectangle extends Figure {
    private int width;
	private int height;

    // Методы доступа, aka свойства (из C#)
	public int getWidth() {
	    return this.width;
    }
    
    public void setWidth(int width) {
        if (width <= 0) return;
        this.width = width;
	}

	public int getHeight() {
		return this.height;
	}

	public void setHeight(int height) {
	    if (height <= 0) return;
	    this.height = height;
	}

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    // Переопределение метода display() из родительского класса Figure
    @Override
    public void display() {
        System.out.printf("Ширина прямоугольника: %d\nВысота прямоугольника: %d\n\n", getWidth(), getHeight());
    }
}