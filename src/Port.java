public class Port {
    String name;
    int containers;
    int requiredContainers;
    int correctTEU;
    int teu;

    public Port(String name, int containers, int teu){
        this.name = name;
        this.containers = containers;
        this.requiredContainers = containers;
        this.correctTEU = teu;
        this.teu =teu;
    }

    public void shipContainers(Port p, int transferredTeu){
        containers = containers - 1;
        p.containers += 1;
        teu -= transferredTeu;
        p.teu += transferredTeu;

    }

    public boolean hasRequiredContainers(){
        return (requiredContainers == containers);
    }

    public int containerDifference(){
        //If containerDifference is positive, the port has too many containers,
        //if negative, the port needs containers,
        //if 0, the port has the correct amount of containers
        return  containers - requiredContainers;
    }
}
