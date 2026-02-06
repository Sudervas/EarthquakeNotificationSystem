//this class is constituted earthquake objects
public class Earthquake {
    //the instance variables
    private int id;
    private double time;
    private String place;
    private double latitude,longitude,depth,magnitude;
    //the constructor of the all fields contains
public Earthquake(int id,double time,String place,double latitude,double longitude,double depth,double magnitude){
    this.id=id;
    this.depth=depth;
    this.longitude=longitude;
    this.latitude=latitude;
    this.time=time;
    this.place=place;
    this.magnitude=magnitude;
}
    //returns the id
    public int getId() {
        return id;
    }
    //set the id like the parameter
    public void setId(int id) {
        this.id = id;
    }
    //returns the time
    public double getTime() {
        return time;
    }
    //set the time like the parameter
    public void setTime(double time) {
        this.time = time;
    }
    //returns the place
    public String getPlace() {
        return place;
    }
    //set the place like the parameter
    public void setPlace(String place) {
        this.place = place;
    }
    //returns the latitude
    public double getLatitude() {
        return latitude;
    }
    //set the latitude like the parameter
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }
    //returns the longitude
    public double getLongitude() {
        return longitude;
    }
    //set the longitude like the parameter
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
    //returns the depth
    public double getDepth() {
        return depth;
    }
    //set the depth like the parameter
    public void setDepth(double depth) {
        this.depth = depth;
    }
    //returns the magnitude
    public double getMagnitude() {
        return magnitude;
    }
    //set the magnitude like the parameter
    public void setMagnitude(double magnitude) {
        this.magnitude = magnitude;
    }

}
