import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Port[] ports = createPorts();

        Port jawah = ports[0];
        Port tanju = ports[1];
        Port dares = ports[2];
        Port momba = ports[3];
        Port zanzi = ports[4];
        Port jebel = ports[5];
        Port salah = ports[6];
        jawah.shipContainers(momba, 2000);
        jawah.shipContainers(dares, 2000);

        tanju.shipContainers(momba, 5000);
        tanju.shipContainers(dares, 3000);
        tanju.shipContainers(zanzi, 2000);
        tanju.shipContainers(jebel, 7000);
        tanju.shipContainers(salah, 7000);

        dares.shipContainers(tanju, 5000);
        dares.shipContainers(jawah, 3000);
        dares.shipContainers(jebel, 2000);

        momba.shipContainers(salah, 2000);
        momba.shipContainers(jebel, 500);

        System.out.println("Calculating using myAlg");
        System.out.println(" cost using algortihm: " + myAlg(ports));
    }

    public static Port[] createPorts() {
        Port[] arr;
        Port jawah = new Port("Jawaharal Nehru", 2, 4000);
        Port tanju = new Port("Tanjung Pelepas", 5, 24000);
        Port dares = new Port("Dar Es Salaam", 3, 10000);
        Port momba = new Port("Mombasa", 2, 2500);
        Port zanzi = new Port("Zanzibar", 0, 0);
        Port jebel = new Port("Jebel Ali Dubai", 0, 0);
        Port salah = new Port("Salalah", 0, 0);
        arr = new Port[]{jawah, tanju, dares, momba, zanzi, jebel, salah};
        return arr;
    }

    public static void printPorts(ArrayList<Port> ports) {
        for (int i = 0; i < ports.size(); i++) {
            System.out.println(ports.get(i).name + " difference from needed containers: " + ports.get(i).containerDifference());
        }
    }

    public static ArrayList<ArrayList<Port>> splitPorts(Port[] ports) {
        ArrayList<Port> surplusPorts = new ArrayList<>();
        ArrayList<Port> lackingPorts = new ArrayList<>();
        ArrayList<ArrayList<Port>> collection = new ArrayList<>();
        for (int i = 0; i < ports.length; i++) {
            if (ports[i].containerDifference() > 0) {
                surplusPorts.add(ports[i]);
            }
            if (ports[i].containerDifference() < 0) {
                lackingPorts.add(ports[i]);
            }
        }
        Collections.sort(surplusPorts, new PortSorter());

        Collections.sort(lackingPorts, new PortSorter());

        collection.add(surplusPorts);
        collection.add(lackingPorts);

        Collections.sort(collection.get(1), new PortSorter());
        return collection;
    }

    public static int sendExcess(Port from, Port to) {
        int cost = 0;
        if (from.containerDifference() <= Math.abs(to.containerDifference())) {
            cost += from.containerDifference();
            System.out.println("Sending " + from.containerDifference() + " from " + from.name + " to " + to.name);
            from.shipContainers(to, from.containerDifference());
        }
        if (from.containerDifference() > Math.abs(to.containerDifference())) {
            cost +=Math.abs(to.containerDifference());
            System.out.println("Sending " +(  Math.abs(to.containerDifference())) + " from " + from.name + " to " + to.name);
            from.shipContainers(to,  Math.abs(to.containerDifference()));
        }

        else {cost += 0;}
        return cost*100;
    }

    public static int myAlg(Port[] ports) {
        int cost = 0;
        ArrayList<ArrayList<Port>> sortedLists = splitPorts(ports);
        ArrayList<Port> surplusPorts = sortedLists.get(0);
        ArrayList<Port> lackingPorts = sortedLists.get(1);

        ArrayList<Port> checkSurp = new ArrayList<>(); //Not needed for the algorithm, used to confirm every is as expected
        ArrayList<Port> checkLack = new ArrayList<>();

        while (!lackingPorts.isEmpty()) {
            cost +=sendExcess(surplusPorts.get(0), lackingPorts.get(lackingPorts.size() - 1));

            if (lackingPorts.get(lackingPorts.size() - 1).containerDifference() == 0) {
                checkLack.add(lackingPorts.get(lackingPorts.size() - 1));
                System.out.println((lackingPorts.get(lackingPorts.size() - 1).name) + " has recieved it's needed number of containers");
                lackingPorts.remove(lackingPorts.size() - 1);

            }
            if (surplusPorts.get(0).containerDifference() == 0) {
                System.out.println((surplusPorts.get(0).name) + " has shipped it's excess containers");
                checkSurp.add(surplusPorts.get(0));
                surplusPorts.remove(0);
            }
        }
        System.out.println("Surplus check");
        printPorts(checkSurp);
        System.out.println("");
        System.out.println("Lacking check");
        printPorts(checkLack);
        return cost;
    }
}