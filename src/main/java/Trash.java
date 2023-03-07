public class Trash {
    private String type;
    private float maxCapacity;
    private float currentCapacity;

    public Trash(String type, float maxCapacity, float currentCapacity) {
        this.type = type;
        this.maxCapacity = maxCapacity;
        this.currentCapacity = currentCapacity;
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

}
