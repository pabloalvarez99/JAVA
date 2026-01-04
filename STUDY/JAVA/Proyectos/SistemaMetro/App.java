package Estudio;

class Station {
    // ATRIBUTOS PRIVADOS
    private String name;
    private Station previousStation;
    private Station nextStation;
    private Station interchange;

    // CONSTRUCTOR 
    public Station(String name) {
        this.name = name;
    }
    // GETTERS Y SETTERS
    public Station getPreviousStation() {
        return previousStation;
    }
    public void setPreviousStation(Station previousStation) {
        this.previousStation = previousStation; 
    }
    public Station getNextStation() {
        return nextStation;
    }
    public void setNextStation(Station nextStation) {
        this.nextStation = nextStation;
    }
    public Station getInterchange() {
        return interchange;
    }
    public void setInterchange(Station interchange) {
        this.interchange = interchange;
    }
    public String getName() {
        return name;
    }
}
class Line {
    private int number;
    private Station terminalStationBegin;
    private Station termianlStationEnd;

    public Line(int number) {
        this.number = number;
    }
    public void addStation(String names) {
        String[] stationNames = names.split(",");
        
    }
}
public class App {
    
}
