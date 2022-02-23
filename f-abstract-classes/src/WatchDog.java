public class WatchDog extends TaxedDog {

    public WatchDog(String taxId) {
        super(taxId);
    }

    public void barkForAlarm() {
        System.out.println("wauwau");
    }

    @Override
    public int getTaxes() {
        return baseTax/2;
    }
}
