package figures;

import figures.Figure;

public class Circle extends Figure {
    private float radius;

    public Circle(float radius) {
        this.radius = radius;
    }

    @Override
    public void display() {
        System.out.printf("Радиус круга: %f\n", this.radius);
    }
}