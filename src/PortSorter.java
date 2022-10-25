import java.util.Comparator;

public class PortSorter implements Comparator <Port> {
    @Override
    public int compare(Port o1, Port o2) {

        return o1.containerDifference()-o2.containerDifference();
    }
}
