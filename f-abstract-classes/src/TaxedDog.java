public abstract class TaxedDog {

    public static final int baseTax = 150;
    private String taxId;

    public TaxedDog(String taxId) {
        this.taxId = taxId;
    }

    public String getTaxId() {
        return taxId;
    }

    public void setTaxId(String taxId) {
        this.taxId = taxId;
    }

    // abstrakte Methode ist nur Deklaration ohne Implementierung
    public abstract int getTaxes();

}
