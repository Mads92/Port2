public class Main {
    public static void main(String[] args) {
        Port jawah = new Port("Jawaharal Nehru", 2);
        Port tanju = new Port("Tanjung Pelepas", 5);
        Port dares = new Port("Dar Es Salaam", 3);
        Port momba = new Port("Mombasa", 2);
        Port zanzi = new Port("Zanzibar", 0);
        Port jebel = new Port("Jebel Ali Dubai",0);
        Port salah = new Port("Salalah", 0);

        Port[] ports = new Port[] {jawah,tanju,dares,momba,zanzi,jebel,salah};
        for (int i = 0; i < ports.length; i++) {
            System.out.println(ports[i].name);
        }
        jawah.shipContainers(momba);
        jawah.shipContainers(dares);

        tanju.shipContainers(momba);
        tanju.shipContainers(dares);
        tanju.shipContainers(zanzi);
        tanju.shipContainers(jebel);
        tanju.shipContainers(salah);

        dares.shipContainers(tanju);
        dares.shipContainers(jawah);
        dares.shipContainers(jebel);

        momba.shipContainers(salah);
        momba.shipContainers(jebel);

        for (int i = 0; i < ports.length; i++) {
            System.out.println(ports[i].containerDifference());
        }
        /*
        System.out.println("Jawaharal Nehru:");
        System.out.println(jawah.hasRequiredContainers());
        System.out.println(jawah.containerDifference());
        System.out.println("Momba:");
        System.out.println(momba.hasRequiredContainers());
        System.out.println(momba.containerDifference());
         */
    }
}