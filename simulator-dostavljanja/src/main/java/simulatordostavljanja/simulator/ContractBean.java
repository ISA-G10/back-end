package simulatordostavljanja.simulator;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ContractBean{

    private List<String> equipmentNames;
    private List<Integer> quantity;
    private LocalDateTime exactDeliveryTime;
    private String hospitalName;
    private double hospitalAddressLong;
    private double hospitalAddressLat;
    private String companyName;

    public ContractBean(LocalDateTime exactDeliveryTime, String hospitalName,String companyName, double hospitalAddressLong, double hospitalAddressLat) {
        this.exactDeliveryTime = exactDeliveryTime;
        this.hospitalName = hospitalName;
        this.hospitalAddressLong = hospitalAddressLong;
        this.hospitalAddressLat = hospitalAddressLat;
        this.companyName = companyName;
        this.equipmentNames = new ArrayList<>();
        this.quantity = new ArrayList<>();
    }


    public LocalDateTime getExactDeliveryTime() {
        return exactDeliveryTime;
    }

    public void setExactDeliveryTime(LocalDateTime exactDeliveryTime) {
        this.exactDeliveryTime = exactDeliveryTime;
    }

    public List<String> getEquipmentNames() {
        return equipmentNames;
    }

    public void setEquipmentNames(List<String> equipmentNames) {
        this.equipmentNames = equipmentNames;
    }

    public List<Integer> getQuantity(){
        return quantity;
    }

    public  void setQuantity(List<Integer> quantity){
        this.quantity = quantity;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }


    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public double getHospitalAddressLong() {
        return hospitalAddressLong;
    }

    public void setHospitalAddressLong(double hospitalAddressLong) {
        this.hospitalAddressLong = hospitalAddressLong;
    }

    public double getHospitalAddressLat() {
        return hospitalAddressLat;
    }

    public void setHospitalAddressLat(double hospitalAddressLat) {
        this.hospitalAddressLat = hospitalAddressLat;
    }

    @Override
    public String toString() {
        return "ContractBean{" +
                "equipmentNames=" + equipmentNames +
                ", quantity=" + quantity +
                ", exactDeliveryTime=" + exactDeliveryTime +
                ", hospitalName='" + hospitalName + '\'' +
                ", hospitalAddressLong=" + hospitalAddressLong +
                ", hospitalAddressLat=" + hospitalAddressLat +
                ", companyName='" + companyName + '\'' +
                '}';
    }
}