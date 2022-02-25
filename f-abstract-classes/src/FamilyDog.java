public abstract class FamilyDog extends TaxedDog {

    // Klasse bleibt abstrakt, da es noch Unterkategorien gibt
    // kommerziell vs. nicht-kommerziell

    protected FamilyDog(String taxId) {
        super(taxId);
    }

    // abstract int getTaxes();
}
