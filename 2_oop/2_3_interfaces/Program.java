public class Program {
    public static void main(String[] args) {
        Point point = new Point(0, 0);
        Grid grid = new Grid(point);

        grid.draw();

        grid.moveSelected(5, 3);
        grid.draw();
    }
}

interface IMovable2D {
    public void move(int dx, int dy);

    public int getX();
    public int gety();
}

 class Point implements IMovable2D {
     public int x;
     public int y;
     
     public Point(int x, int y) {
         this.x = x;
         this.y = y;
     }
     
	@Override
	public void move(int dx, int dy) {
        System.out.printf("Перемещаю %s на x:%d y:%d\n\n", this, dx, dy);
	    this.x += dx;
	    this.y += dy;
	}

	@Override
	public int getX() {
	    return this.x;
	}

	@Override
	public int gety() {
	    return this.y;
	}
}

class Grid {
    IMovable2D movableObject;
    private final int WIDTH = 10;
    private final int HEIGHT = 10;

    public Grid(IMovable2D object) {
        this.movableObject = object;
    }

    public void moveSelected(int dx, int dy) {
        this.movableObject.move(dx, dy);
    }

    public void draw() {
        for (int y = 0; y < HEIGHT; y++) {            
            for (int x = 0; x < WIDTH; x++) {
                if (x == this.movableObject.getX() && y == this.movableObject.gety()) {
                    System.out.print("\033[31mP\033[0m ");
                    continue;
                }
                
                System.out.print("0 ");
            }
            System.out.println();
        }
    System.out.println();
    }
}