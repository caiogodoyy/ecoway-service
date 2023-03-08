public class Trash {
    private int trashCode;
    private String type;
    private float maxCapacity;
    private float currentCapacity;
    private Building building;

    public Trash(int trashCode, String type, float maxCapacity, float currentCapacity, Building building) {
        this.trashCode = trashCode;
        this.type = type;
        this.maxCapacity = maxCapacity;
        this.currentCapacity = currentCapacity;
        this.building = building;
    }

    public int getTrashCode() {
        return trashCode;
    }

    public void setTrashCode(int trashCode) {
        this.trashCode = trashCode;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(float maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public float getCurrentCapacity() {
        return currentCapacity;
    }

    public void setCurrentCapacity(float currentCapacity) {
        this.currentCapacity = currentCapacity;
    }

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }
}
