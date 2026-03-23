package Lab2;

public class Principal {

    public static void main(String[] args) {


        System.out.println(" Bolsa de Chocolatinas ");

        Bolsa<Chocolatina> bolsa = new Bolsa<>();
        
        bolsa.add(new Chocolatina("Milka"));
        bolsa.add(new Chocolatina("Ferrero"));
        bolsa.add(new Chocolatina("Sublime"));

        for (Chocolatina c : bolsa) {
            System.out.println(c.getMarca());
        }

        System.out.println("\n Bolsa de Golosinas ");

        Bolsa<Golosina> bolsa2 = new Bolsa<>();

        bolsa2.add(new Golosina("Caramelo", 10));
        bolsa2.add(new Golosina("Chicle", 5));
        bolsa2.add(new Golosina("Gomita", 8));

        for (Golosina g : bolsa2) {
            System.out.println(g); // usa toString()
        }
    }
}
