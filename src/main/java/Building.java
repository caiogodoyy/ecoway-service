public class Building {
    private int buildingCode;
    private String name;
    private String address;
    private String neighborhood;
    private int numApartments;

    public Building(int buildingCode, String name, String address, String neighborhood, int numApartments) {
        this.buildingCode = buildingCode;
        this.name = name;
        this.address = address;
        this.neighborhood = neighborhood;
        this.numApartments = numApartments;
    }

    public int getBuildingCode() {
        return buildingCode;
    }

    public void setBuildingCode(int buildingCode) {
        this.buildingCode = buildingCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public int getNumApartments() {
        return numApartments;
    }

    public void setNumApartments(int numApartments) {
        this.numApartments = numApartments;
    }

}
