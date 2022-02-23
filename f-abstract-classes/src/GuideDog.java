public class GuideDog extends TaxedDog {


    public GuideDog(String taxId) {
        // setzt taxId im TaxedDog
        super(taxId);
    }

    @Override
    public int getTaxes() {
        // Zahlt keine Steuern
        return 0;
    }
}
