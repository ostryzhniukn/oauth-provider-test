package ostryzhniukn.oauth2.provider.domain;


import java.util.List;

public class WaterMeter {

    private int waterMeterId;
    private String name;
    private String description;
    private Address address;
    //private List<Indicator> indicators;

    public WaterMeter() {

    }

    public int getWaterMeterId() {
        return waterMeterId;
    }

    public void setWaterMeterId(int waterMeterId) {
        this.waterMeterId = waterMeterId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

//    public List<Indicator> getIndicators() {
//        return indicators;
//    }
//
//    public void setIndicators(List<Indicator> indicators) {
//        this.indicators = indicators;
//    }

    @Override
    public String toString() {
        return "WaterMeter{" +
                "id=" + waterMeterId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
