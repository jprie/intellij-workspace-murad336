public class Main {

    public static void main(String[] args) {

        Text text = new Text("Hello", true, false);
        Rectangle rectangle = new Rectangle(23.0, 34.0);

        text.draw();
        rectangle.printBeautifully();
        System.out.println(text.getContent());

        Printable[] printerQueue = new Printable[] {text, rectangle};

        for (Printable p : printerQueue) {
            p.print();
            p.printBeautifully();
        }

        Drawable[] drawables = new Drawable[] {text, rectangle};

        for (Drawable drawable : drawables) {
            drawable.draw();
        }

    }


}
