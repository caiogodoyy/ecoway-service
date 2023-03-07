public class Building {
    private String name;
    private String address;
    private int numApartments;

    public Building(String name, String address, int numApartments) {
        this.name = name;
        this.address = address;
        this.numApartments = numApartments;
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

    public int getNumApartments() {
        return numApartments;
    }

    public void setNumApartments(int numApartments) {
        this.numApartments = numApartments;
    }

}
