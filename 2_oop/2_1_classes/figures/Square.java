package figures;

import figures.Rectangle;

// Класс final, то есть от него невозможно создать наследников
public final class Square extends Rectangle {
    public Square(int side) {
	    super(side, side);
    }

    @Override
    public void display() {
        System.out.printf("Сторона квадрата = %d\n", super.getWidth());
    }
}