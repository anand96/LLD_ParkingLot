package UBER_KEERTI.manager;



import UBER_KEERTI.model.Rider;
import java.util.HashMap;
import java.util.Map;

public class RiderMgr {
    private static RiderMgr riderMgrInstance = null;
    private Map<String, Rider> ridersMap;

    private RiderMgr(){
        this.ridersMap = new HashMap<>();
    }

    //singleton
    public static  RiderMgr getRiderMgr(){
        if(riderMgrInstance == null){
            riderMgrInstance = new RiderMgr();
        }
        return riderMgrInstance;
    }

    public void addRaider(String name, double rating){
        ridersMap.put(name, new Rider(name, rating));
    }

    public Rider getRider(String name){
        return ridersMap.get(name);
    }
}
