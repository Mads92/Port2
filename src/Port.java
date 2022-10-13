public class Port {
    String name;
    int containers;
    int requiredContainers;

    public Port(String name, int containers){
        this.name = name;
        this.containers = containers;
        this.requiredContainers = containers;
    }

    public void shipContainers(Port p, int TEU){
        containers = containers - 1;
        p.containers += 1;

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
