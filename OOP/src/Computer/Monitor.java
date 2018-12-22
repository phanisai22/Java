package Computer;

class Monitor {

    private String model;
    private String manufacturer;

    private int size;
    private Resolution nativeResolution;

    public Monitor(String model, String manufacturer, int size  , Resolution nativeResolution) {
        this.model = model;
        this.size = size;
        this.size = size;
        this.nativeResolution = nativeResolution;
    }

    public void drawPixelAt(int x, int y, String color) {
        System.out.println("Drawing pixel at " + x + " , " + y + " in " + color + " color.");
    }

    public String getManufacturer() {
        return this.manufacturer;
    }

    public String getModel() {
        return this.model;
    }

    public int getSize() {
        return this.size;
    }

    public Resolution getNativeResolution() {
        return this.nativeResolution;
    }

}