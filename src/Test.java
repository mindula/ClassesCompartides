public class Test {

    public static void main(String[] args) {

        Graf<String> testGraf = new Graf<String>();

        try {
            testGraf.afegirNode("1");
            testGraf.afegirNode("2");
            testGraf.afegirNode("3");
            testGraf.afegirNode("4");
            testGraf.afegirNode("1");
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
        /*try {
            testGraf.afegirNode("1");
        } catch (RuntimeException ex) {
            System.out.println(ex.getLocalizedMessage());
        }*/

        System.out.println("ordre Graf:" + testGraf.ordre() + " :  4");

        Arc<String> a = new Arc<String>(1, "1", "2");
        testGraf.afegirArc(a);
        //testGraf.afegirArc("2", "1", 1);
        System.out.println("Mida Graf:" + testGraf.mida() + " :  2");

        try {
            testGraf.afegirArc(a);
            System.out.println("FUCK");
        }catch(RuntimeException ex){
            System.out.println(ex.getLocalizedMessage());
        }

        System.out.println("tostring preBorrat:" + testGraf.toString());
        Graf<String> copiaGraf = new Graf<String>(testGraf);

        testGraf.eliminarArc(a);
        System.out.println("Mida Graf:" + testGraf.mida() + " :  1");

        testGraf.eliminarNode("1");
        System.out.println("ordre Graf:" + testGraf.ordre() + " :  3");

        System.out.println("tostring postBorrat:" + testGraf.toString());

        System.out.println(testGraf);
        System.out.println(copiaGraf);

    }
}
