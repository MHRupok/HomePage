/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homepage;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mehed
 */
public class DSIVehicleShowroom {

    private int expectedVisitors;
    private List<Vehicle> vehicleList;

    public DSIVehicleShowroom() {
        super();
        expectedVisitors = 30;
        setVehicleList(new ArrayList<>());
    }

    public int getExpectedVisitors() {
        return expectedVisitors;
    }

    public void setExpectedVisitors(int expectedVisitors) {
        this.expectedVisitors = expectedVisitors;
    }

    public List<Vehicle> getVehicleList() {
        return vehicleList;
    }

    public void setVehicleList(List<Vehicle> vehicleList) {
        this.vehicleList = vehicleList;
    }

}
