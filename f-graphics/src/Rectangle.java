public class Rectangle implements Printable, Drawable {

    private double height;
    private double width;

    public Rectangle(double height, double width) {
        this.height = height;
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    @Override
    public int print() {
        System.out.println("Format Rectangle for printing");
        return 0;
    }

    @Override
    public void printBeautifully() {
        System.out.println("Format Rectangle for beautiful printing");
    }

    @Override
    public void draw() {
        System.out.println("Draw a Rectangle");
    }

    @Override
    public void erase() {
        System.out.println("Erase a Rectangle");
    }
}
