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

    public static void computeBulkTaxes(List<? extends Taxable> lt) {
        for (Taxable t : lt) {
            computeTaxes(t);
        }


        //? will not work!?
//        Taxable t = null;
//        lt.add(t);
    }

    public static void addIndividualClients(List<Individual> lt) {
        Individual t = null;
        lt.add(t);
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
