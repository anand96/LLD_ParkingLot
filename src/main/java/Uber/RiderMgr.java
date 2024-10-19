package Uber;

import java.util.HashMap;
import java.util.Map;

public class RiderMgr {
    private static RiderMgr riderMgrInstance;
    private static final Object mtx = new Object();
    private Map<String,  Rider> ridersMap = new HashMap<>();

    private RiderMgr() {}

    public static RiderMgr getRiderMgr() {
        if (riderMgrInstance == null) {
            synchronized (mtx) {
                if (riderMgrInstance == null) {
                    riderMgrInstance = new RiderMgr();
                }
            }
        }
        return riderMgrInstance;
    }

    public void addRider(String pRiderName, Rider pRider) {
        ridersMap.put(pRiderName, pRider);
    }

    public Rider getRider(String pRiderName) {
        return ridersMap.get(pRiderName);
    }
}
