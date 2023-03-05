package taxable2;

import java.util.ArrayList;
import java.util.List;

public class TaxAdvisor {
    public static void computeTaxes(Taxable t) {
    }

    public static void computeBulkTaxes(Taxable[] ta) {
        for (Taxable t : ta) {
            computeTaxes(t);
        }
        //Runtime error - ArrayStoreException
//        Corporation c = null;
//        ta[0] = c;
    }

    /**
     * ? represents the caller's type, and we are constraining the relationship between
     * that type and our Taxable (I call this the "Anchor" type) but we have no other
     * use for the caller's type.
     */
    public static void computeBulkTaxes(List<? extends Taxable> lt) {
        for (Taxable t : lt) {
            computeTaxes(t);
        }

//        lt.add(new Individual()); //ERROR

        //? will not work!?
//        Taxable t = null;
//        lt.add(t);
    }

    public static <E extends Taxable> void prepareBulkExample(List<E> lt, E item) {
        lt.add(item);
        for (int i = 0; i < lt.size(); i++) {
            System.out.println(i);
        }
    }

    public static void computeBulkTaxes_old(List<Taxable> lt) {

        Taxable t = null;
        lt.add(t);
        lt.add(new Individual());
    }

    public static void addIndividualClients(List<Individual> lt) {
        Individual t = null;
        lt.add(t);
        lt.add(new Individual());
        lt.add(new Individual());
    }

    public static void addClients(List<? super Individual> lt) {
        Individual t = null;
        lt.add(t);
        lt.add(new Employee());
    }

    /**
     * List<?> == List<? extends Object>
     *         != List<Object>
     *
     *
     * if solely iterate the content, use List<?>
     *
     */
    public static void main(String[] args) {
        List<Taxable> il = new ArrayList<>();
        computeBulkTaxes_old(il);

        List<Taxable> clients = new ArrayList<>();
        computeBulkTaxes(clients);

        List<Individual> li = new ArrayList<>();
        computeBulkTaxes(li);

        Individual[] ia = new Individual[3];
        computeBulkTaxes(ia);

        List<Individual> liClients = new ArrayList<>();
        addIndividualClients(liClients);

        addClients(clients);

    }
}
