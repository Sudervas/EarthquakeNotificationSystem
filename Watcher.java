//watcher class is constituted for watcher objects
public class Watcher {
//the instance variables
    private String watcherName;//to name
    private String watcherRequest;//to request
    private int time;//time
    private double latitude;//latitude
    private double longitude;//longitude
    //the constructor of the all fields contains
    public Watcher(int time,String watcherRequest,double latitude,double longitude,String watcherName){
        this.latitude=latitude;
        this.longitude=longitude;
        this.time=time;
        this.watcherName=watcherName;
        this.watcherRequest=watcherRequest;
    }
    //the constructor of the just time request and name fields contains
    public Watcher(int time,String watcherRequest,String watcherName){
        this.watcherName=watcherName;
        this.time=time;
        this.watcherRequest=watcherRequest;
    }
    //the constructor of the just time request fields contains
    public Watcher(int time,String watcherRequest){
        this.watcherRequest=watcherRequest;
        this.time=time;
    }
    //returns the name
    public String getWatcherName() {
        return watcherName;
    }
    //set the watcher name like the parameter
    public void setWatcherName(String watcherName) {
        this.watcherName = watcherName;
    }
    //returns the request
    public String getWatcherRequest() {
        return watcherRequest;
    }
    //set the request like the parameter
    public void setWatcherRequest(String watcherRequest) {
        this.watcherRequest = watcherRequest;
    }
    //returns the latitude
    public double getLatitude() {
        return latitude;
    }
    //set the latitude like the parameter
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }
    //returns the time
    public int getTime() {
        return time;
    }
    //set the time like the parameter
    public void setTime(int time) {
        this.time = time;
    }
    //returns the longitude
    public double getLongitude() {
        return longitude;
    }
    //set the longitude like the parameter
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }


}
