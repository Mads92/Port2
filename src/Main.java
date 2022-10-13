import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Port jawah = new Port("Jawaharal Nehru", 2,4000);
        Port tanju = new Port("Tanjung Pelepas", 5,24000);
        Port dares = new Port("Dar Es Salaam", 3,10000);
        Port momba = new Port("Mombasa", 2,2500);
        Port zanzi = new Port("Zanzibar", 0,0);
        Port jebel = new Port("Jebel Ali Dubai",0,0);
        Port salah = new Port("Salalah", 0,0);

        Port[] ports = new Port[] {jawah,tanju,dares,momba,zanzi,jebel,salah};
        AdjacencyGraph portGraph = addPorts(ports);

        System.out.println("INDEN SENDING");
        for (int i = 0; i < portGraph.ports.size(); i++) {
            System.out.println(portGraph.ports.get(i).name + " Containers: " + portGraph.ports.get(i).containers + " TEU: " + portGraph.ports.get(i).teu + " Correct TEU: " + portGraph.ports.get(i).correctTEU);
        }

        jawah.shipContainers(momba, 2000);
        jawah.shipContainers(dares, 2000);

        tanju.shipContainers(momba,5000);
        tanju.shipContainers(dares,3000);
        tanju.shipContainers(zanzi,2000);
        tanju.shipContainers(jebel,7000);
        tanju.shipContainers(salah,7000);

        dares.shipContainers(tanju,5000);
        dares.shipContainers(jawah,3000);
        dares.shipContainers(jebel,2000);

        momba.shipContainers(salah,2000);
        momba.shipContainers(jebel,500);

        //printPorts(ports);
        //portGraph.PrintGraph();
        System.out.println("Efter: ");
        for (int i = 0; i < portGraph.ports.size(); i++) {
            Port p = portGraph.ports.get(i); // Used here so it doesn't have to be written out each time
            //Deprecated possibly
            //System.out.println(p.name + " Current number of containers: " + p.containers + " Difference from correct number of containers: " + p.containerDifference());
            System.out.println(p.name + " Correct TEU " + p.correctTEU + " Current TEU: " + p.teu);
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

    public static void printPorts(Port[] ports){
        for (int i = 0; i < ports.length; i++) {
            System.out.println(ports[i].name + " difference from needed containers: " + ports[i].containerDifference() );
        }
        return;
    }

    public static AdjacencyGraph addPorts(Port[] ports){
        AdjacencyGraph p = new AdjacencyGraph();
        for (int i = 0; i < ports.length; i++) {
            p.addVertex(ports[i]);
        }
        return p;
    }

    public static void reverseFlow(){

    }
}