import java.util.Comparator;

public class PortSorter implements Comparator <Port> {
    @Override
    public int compare(Port o1, Port o2) {

        if (o1.teu> o2.teu){
            return 1;
        }
        if (o1.teu < o2.teu){
            return -1;
        }
        return 0;
    }
}
