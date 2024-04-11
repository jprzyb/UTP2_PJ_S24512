/**
 *
 *  @author Przybylski Jakub S24512
 *
 */

package zad2;


public class Main {
  public static void main(String[] args) {

    Purchase purch = new Purchase("komputer", "nie ma promocji", 3000.00);
    System.out.println(purch);

    // --- tu należy dodać odpowiedni kod
      purch.addPropertyChangeListener(evt -> {
          System.out.println(evt.getPropertyName() + " change to: " + evt.getNewValue());
          if ("price".equals(evt.getPropertyName())) {
              Double newValue = (Double) evt.getNewValue();
              if (newValue < 1000) {
                  System.out.println("Price change to: " + newValue + " not allowed");
              }
          }
      });
      System.out.println("beeep beeep");
    // ----------------------------------

    try {
      purch.setData("w promocji");
      purch.setPrice(2000.00);
      System.out.println(purch);

      purch.setPrice(500.00);

    } catch (PropertyVetoException exc) {
      System.out.println(exc.getMessage());
    }
    System.out.println(purch);

  }
}
