public class Text implements Printable, Drawable {

    private String content;
    private boolean isBold;
    private boolean isItalic;

    public Text(String content, boolean isBold, boolean isItalic) {
        this.content = content;
        this.isBold = isBold;
        this.isItalic = isItalic;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isBold() {
        return isBold;
    }

    public void setBold(boolean bold) {
        isBold = bold;
    }

    public boolean isItalic() {
        return isItalic;
    }

    public void setItalic(boolean italic) {
        isItalic = italic;
    }

    @Override
    public int print() {
        System.out.println("Format Text for printing");
        return 0;
    }

    @Override
    public void printBeautifully() {
        System.out.println("Format Text for beautiful printing");
    }

    // Implementierung von Drawable
    @Override
    public void draw() {
        System.out.println("Draw a Text");
    }

    // Implementierung von Erasable
    @Override
    public void erase() {
        System.out.println("Erase a Text");
    }
}
