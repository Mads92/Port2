import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {


        Port[] ports = createPorts();//new Port[] {jawah,tanju,dares,momba,zanzi,jebel,salah};
        //AdjacencyGraph portGraph = addPorts(ports);

        System.out.println("INDEN SENDING");
        for (int i = 0; i < ports.length; i++) {
            System.out.println(ports[i].name + " Containers: " + ports[i].containers + " TEU: " + ports[i].teu + " Correct TEU: " + ports[i].correctTEU);
        }


        Port jawah = ports[0];
        Port tanju = ports[1];
        Port dares= ports[2];
        Port momba = ports[3];
        Port zanzi = ports[4];
        Port jebel = ports[5];
        Port salah = ports[6];
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
        for (int i = 0; i < ports.length; i++) {
            Port p = ports[i]; // Used here so it doesn't have to be written out each time
            //Deprecated possibly
            //System.out.println(p.name + " Current number of containers: " + p.containers + " Difference from correct number of containers: " + p.containerDifference());
            System.out.println(p.name + " Correct TEU " + p.correctTEU + " Current TEU: " + p.teu);
        }
        myAlg(ports);
        /*
        System.out.println("Jawaharal Nehru:");
        System.out.println(jawah.hasRequiredContainers());
        System.out.println(jawah.containerDifference());
        System.out.println("Momba:");
        System.out.println(momba.hasRequiredContainers());
        System.out.println(momba.containerDifference());
         */
    }

    public static Port[] createPorts(){
        Port[] arr;
        Port jawah = new Port("Jawaharal Nehru", 2,4000);
        Port tanju = new Port("Tanjung Pelepas", 5,24000);
        Port dares = new Port("Dar Es Salaam", 3,10000);
        Port momba = new Port("Mombasa", 2,2500);
        Port zanzi = new Port("Zanzibar", 0,0);
        Port jebel = new Port("Jebel Ali Dubai",0,0);
        Port salah = new Port("Salalah", 0,0);
        arr = new Port[]{jawah, tanju, dares, momba, zanzi, jebel, salah};
        return arr;
    }
    public static void printPorts(ArrayList<Port> ports){
        for (int i = 0; i < ports.size(); i++) {
            System.out.println(ports.get(i).name + " difference from needed containers: " + ports.get(i).containerDifference() );
        }
        return;
    }

    public static ArrayList<ArrayList<Port>> splitPorts(Port[] ports){
        ArrayList<Port> surplusPorts = new ArrayList<>();
        ArrayList<Port> manglerPorts = new ArrayList<>();
        ArrayList<ArrayList<Port>> collection = new ArrayList<>();
        for (int i = 0; i < ports.length; i++) {
            if(ports[i].containerDifference()>0){
                surplusPorts.add(ports[i]);
                //System.out.println(ports[i].name + " Surplus");
            }
            if(ports[i].containerDifference()<0){
                manglerPorts.add(ports[i]);
                //System.out.println(ports[i].name+ " mangler");
            }
        }
        Collections.sort(surplusPorts,new PortSorter());

        Collections.sort(manglerPorts, new PortSorter());

        collection.add(surplusPorts);
        collection.add(manglerPorts);
        return collection;
    }
    public static void myAlg(Port[] ports){
        ArrayList<ArrayList<Port>>sortedLists =splitPorts(ports);
        ArrayList<Port> surplusPorts = sortedLists.get(0);
        ArrayList<Port> lackingPorts = sortedLists.get(1);
        System.out.println("Surplus");
        printPorts(surplusPorts);
        System.out.println("Lacking");
        printPorts(lackingPorts);
        surplusPorts.get(0).sentExcess(lackingPorts.get(0));
        System.out.println("First send, surplus");
        printPorts(surplusPorts);
        System.out.println("Lacking");
        printPorts(lackingPorts);
        /*
        System.out.println("Sorted Mangler: ");
        for (int i = 0; i < lackingPorts.size(); i++) {
            System.out.println(lackingPorts.get(i).name + " Teu: " + lackingPorts.get(i).teu);
        }
        System.out.println("Sorted Surpus:");
        for (int i = 0; i < surplusPorts.size(); i++) {
            System.out.println(surplusPorts.get(i).name + " Teu: " + surplusPorts.get(i).teu);

        }
        */

    }
}
    //GRAVEYARD
      /*  Port jawah = new Port("Jawaharal Nehru", 2,4000);
        Port tanju = new Port("Tanjung Pelepas", 5,24000);
        Port dares = new Port("Dar Es Salaam", 3,10000);
        Port momba = new Port("Mombasa", 2,2500);
        Port zanzi = new Port("Zanzibar", 0,0);
        Port jebel = new Port("Jebel Ali Dubai",0,0);
        Port salah = new Port("Salalah", 0,0);

    public static AdjacencyGraph addPorts(Port[] ports){
        AdjacencyGraph p = new AdjacencyGraph();
        for (int i = 0; i < ports.length; i++) {
            p.addVertex(ports[i]);
        }
        return p;
    }

       */