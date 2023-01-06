package taxable;

import java.util.ArrayList;
import java.util.List;

public class TaxAdvisor {
  public static void calculateTaxes(Taxable t) {}
//  public static void calculateBatchTaxes(List<Taxable> lt) {
//  public static void calculateBatchTaxes(List of "something" lt) {
  // Covariance
  public static void calculateBatchTaxes(List<? extends Taxable> lt) {
    Taxable tx = lt.get(0);
//    lt.add(new Taxable());
//    lt.add(new Corporation());
//    lt.add(new Individual());
    for (Taxable t : lt) {
      calculateTaxes(t);
    }
  }

//  public static void getClients(List<Individual> clients) {
//  public static void getClients(List<Individual extends ?> clients) {
  // "contravariance"
  public static void getClients(List<? super Individual> clients) {
//    Individual tx = clients.get(0);
//    Retiree ret = new Individual(); // Nope, never...
    clients.add(new Individual());
    clients.add(new Retiree());
  }

  // List<? extends Object> => List<?>

  public static void main(String[] args) {
    List<Taxable> clients = new ArrayList<>();
    clients.add(new Corporation());
    clients.add(new Corporation());
    clients.add(new Individual());
    clients.add(new Corporation());
    clients.add(new Individual());

    getClients(clients);
    calculateBatchTaxes(clients);

    List<Individual> joesClients = new ArrayList<>();
    joesClients.add(new Individual());
    joesClients.add(new Individual());
    joesClients.add(new Individual());

    getClients(joesClients);
    calculateBatchTaxes(joesClients);
  }
}
