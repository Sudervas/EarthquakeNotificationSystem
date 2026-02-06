//this class is constituted for earthquake objects
//several methods have for adding,removing and find the largest earthquake
public class EarthquakeList {
    //from the doubly linked list class an object instantiated and the list constructed
    //to store earthquake objects
    private DoublyLinkedList<Earthquake> list = new DoublyLinkedList<>();
//this method add earthquake object to the linked list
    public void addEarthQuake(Earthquake e) {
        //every earthquake added end of the list
        list.addLast(e);
        //suitable message showed
        System.out.println("Earthquake " + e.getPlace() + " is inserted into the earthquake list");

    }
    //this method shows the largest earthquake in the linked list
    public void queryLargestEarthquake() {
        //if the list is empty show the apporipiate message and exit
        if(list.isEmpty()){
            System.out.println("No record on the list");
            return;
        }
        //if the list is not empty iterator class's object instantiated to travel the earthquake list
        //as a parameter this list declared
        MyIterator<Earthquake>iterator=new MyIterator<>(list);
        //iterator return the first earthquake object
       Earthquake firstEarthquake=iterator.next();
          //if the iterator has next this block runs
        while(iterator.hasNext()) {
            //second earthquake object returns from the iterator next
        Earthquake current=iterator.next();
        //comparing with first and second earthquake objects as a magnitude
            //if the second object is bigger than first
            //changed the first with second and continue to compare for finding the largest
          if (firstEarthquake.getMagnitude() < current.getMagnitude()) {
        firstEarthquake = current;

    }
}
        //finding the largest earthquake showed with apporipiate message
System.out.println("Largest earthquake in the past 6 hours:\nMagnitude "+firstEarthquake.getMagnitude()+" at "+firstEarthquake.getPlace());
    }
    //this method removes the earthquake if its time past than 6 hours from the current time
    public void removeEarthquake(int currentTime){
        //if the list is empty exit the method
        if(list.isEmpty())
            return;
        // iterator class's object instantiated to travel the earthquake list
        //as a parameter this list declared
        MyIterator<Earthquake>iterator=new MyIterator<>(list);
        //if the iterator has next this block runs
        while(iterator.hasNext()){
            //iterator return the first earthquake object
            Earthquake earthquake=iterator.next();
            //if earthquake time past than 6 hours from the current time
            if(earthquake.getTime()+6<=currentTime){
                //remove the returning object
                iterator.remove();
            }


        }
    }
    //this method calculate the distance with earthquake and watchers accor ing to their coordinates
    public boolean calculateDistance(Earthquake e,Watcher w){
        //difference of the latitudes
        double lat=w.getLatitude()-e.getLatitude();
        //difference of the longitudes
        double longi=w.getLongitude()-e.getLongitude();
        //power the difference of the latitudes
            double distanceOfLatitude=Math.pow(lat,2);
        //power the difference of the longitudes
        double distanceOfLongitude=Math.pow(longi,2);
        //sqrt of the differences the coordinates
            double totalDistance=Math.sqrt(distanceOfLongitude+distanceOfLatitude);
            //limit indicated according to calculation pow of magnitudes 3 and product 2
            double limit = 2 * Math.pow(e.getMagnitude(), 3);
            //if the limit bigger than total distance return true
            if(limit>=totalDistance){
              return true;

            }
            //else return false
               return false;
        }
        //this method send messages to watchers if the earthquake occurs close to them
        public void notifyWatchers(DoublyLinkedList<Watcher> list,Earthquake e){
        //iterator instantiated to travel the list
        MyIterator<Watcher>iterator=new MyIterator<>(list);
        //if the iterator has next value this block runs
        while ((iterator.hasNext())){
            //watcher object declared the returning object
            Watcher watcher=iterator.next();
            //above  calculate distance method runs according to this earthquake and watcher
            //if the returns true
            if(calculateDistance(e,watcher)){
                //send message to user
                System.out.println("Earthquake "+ e.getPlace()+" is close to "+watcher.getWatcherName());
            }
            //if not true continue with next watcher while end of the list
        }
        }
    }




