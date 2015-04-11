public class Test {

    public static void main(String[] args) {

        Graf<String> testGraf = new Graf<String>();
        testGraf.afegirNode("1");
        testGraf.afegirNode("2");
        testGraf.afegirNode("3");
        testGraf.afegirNode("4");
        System.out.println("ordre Graf:" + testGraf.ordre() + " :  4");

        testGraf.afegirArc("1", "2", 1);
        testGraf.afegirArc("2", "1", 1);
        System.out.println("Mida Graf:" + testGraf.mida() + " :  2");

        try {
            testGraf.afegirArc("1", "2", 1);
            System.out.println("FUCK");
        }catch(RuntimeException ex){
            System.out.println(ex.getLocalizedMessage());
        }

        System.out.println("tostring preBorrat:" + testGraf.toString());

        testGraf.eliminarArc("1", "2");
        System.out.println("Mida Graf:" + testGraf.mida() + " :  1");

        testGraf.eliminarNode("1");
        System.out.println("ordre Graf:" + testGraf.ordre() + " :  3");

        System.out.println("tostring postBorrat:" + testGraf.toString());

        System.out.println(testGraf);
        Graf<String> copiaGraf = new Graf<String>(testGraf);
        System.out.println(copiaGraf);

    }
}
