import java.util.ArrayList;

public class AdjacencyGraph {
    ArrayList<Port> ports;
    public AdjacencyGraph(){
        ports=new ArrayList<Port>();
    }
    public void addVertex(Port p){
        ports.add(p);
    }
    public void addEdge(Port from, Port to, Integer weight){
        if(!(ports.contains(from) && ports.contains(to)))
        {
            System.out.println("Vertices missing from graph");
            return;
        }
        Edge newE=new Edge(from, to, weight);

    }
    public void addUnDirectedEdge(Port from, Port to, Integer weight){
        if(!(ports.contains(from) && ports.contains(to)))
        {
            System.out.println("Vertices missing from graph");
            return;
        }
        Edge newE=new Edge(from, to, weight);
        Edge newE2=new Edge( to, from, weight);
    }
    /*public void PrintGraph(){
        for(int i=0;i<ports.size();i++){
            System.out.println(" Vertex "+ports.get(i).name+" is connecte to: ");
            Port current=ports.get(i);
            for (Edge e: current.OutEdge) {
                System.out.println(e.to.name +" with weight: "+e.weight);
            }
        }
    }*/

}


class Edge{
    Port from;
    Port to;
    Integer weight;
    public Edge(Port from,Port to, Integer weight){
        this.from=from;
        this.to=to;
        this.weight=weight;
        //from.OutEdge.add(this);
    }
}