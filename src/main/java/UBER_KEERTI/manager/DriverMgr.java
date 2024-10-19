package UBER_KEERTI.manager;


import UBER_KEERTI.model.Driver;

import java.util.HashMap;
import java.util.Map;

public class DriverMgr {
    private static DriverMgr driverMgrInstance = null;
    private Map<String, Driver> driversMap;

    private DriverMgr(){
        this.driversMap =new HashMap<>();
    }

    public static DriverMgr getDriverMgr(){
        if(driverMgrInstance==null){
            driverMgrInstance = new DriverMgr();
        }
        return driverMgrInstance;
    }

    public void addDriver(String name, double rating){
        driversMap.put(name, new Driver(name, rating));
    }

    public Driver getDriver(String name){
        return driversMap.get(name);
    }
}
