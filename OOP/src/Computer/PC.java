package Computer;

public class PC {

    private Case theCase;
    private Monitor monitor;
    private MotherBoard motherBoard;

    public Case getTheCase() {
        return this.theCase;
    }

    public Monitor getMonitor() {
        return this.monitor;
    }

    public MotherBoard getMotherBoard() {
        return this.motherBoard;
    }

    public PC(Case theCase, Monitor monitor, MotherBoard motherBoard) {
        this.theCase = theCase;
        this.monitor = monitor;
        this.motherBoard = motherBoard;
    }

}