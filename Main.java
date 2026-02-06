import java.io.*;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        //time initializes with 0
        int currentTime=0;
        //to enter user values scanner opened
        Scanner input=new Scanner(System.in);
        //asked to enter file name to user for watchers
        System.out.println("please enter the file name to read watchers");
        String lineWatcher= input.nextLine();
        //asked to enter file name to user for earthquakes
        System.out.println("please enter the file name to read earthquakes");
        String lineEarthquake= input.nextLine();
        //initializes the files with scanner object to watcher file
        Scanner watcherScanner=null;
        //initializes the earthquake file with scanner object
        Scanner earthquakeScanner=null;
        //try blocks begins if the system does not find the files
        try {
            //files begins
            watcherScanner = new Scanner(new File(lineWatcher));
           earthquakeScanner = new Scanner(new File(lineEarthquake));
           //if we catch file not found exception catch block runs
        }catch (FileNotFoundException e){
            System.out.println(e);
            //exit system
            return;
        }
        //returned watcher object from the readWatcherFile method declared to currentWatcher
        Watcher currentWatcher=readWatcherFile(watcherScanner);
        //returned earthquake object from the readEarthquakeFile method declared to currentEarthquake
        Earthquake currentEarthquake=readEarthquakeFile(earthquakeScanner);
        //EarthquakeList class instantiated
        EarthquakeList earthquakeList=new EarthquakeList();
        //WatcherList class instantiated
        WatcherList watcherList=new WatcherList();
        //while the currentEarthquake object or currentWatcher object not equal to null
        //these blocks are run
        while(currentEarthquake!=null||currentWatcher!=null){
            //if both of the objects not equal to null these blocks run
            if(currentWatcher!=null&&currentEarthquake!=null) {
                //to add events order the time correctly comparing the events time
                //if the earthquake occurs the first time to watcher requests
                //this block rus
                if (currentEarthquake.getTime() < currentWatcher.getTime()) {
                    //current earthquake object added to earthquakeList
                    earthquakeList.addEarthQuake(currentEarthquake);
                    //notify methods runs from the earthquakeList class to send earthquake notification
                    earthquakeList.notifyWatchers(watcherList.getList(), currentEarthquake);
                    //current time declared as an earthquake occur time
                    currentTime = (int) currentEarthquake.getTime();
                    //currentEarthquake object changed according to files next row
                    currentEarthquake = readEarthquakeFile(earthquakeScanner);
                    //if the earthquakes hour before the 6 hours from current time
                    //these earthquakes should remove from the earthquakeList so this method calls
                    earthquakeList.removeEarthquake(currentTime);
                    //if the watcher requests earlier than earthquake events these blocks run
                } else if (currentEarthquake.getTime() >= currentWatcher.getTime()) {
                    //time changed according to watcher requests time
                    currentTime = currentWatcher.getTime();
                    //if the earthquakes hour before the 6 hours from current time
                    //these earthquakes should remove from the earthquakeList so this method calls
                    earthquakeList.removeEarthquake(currentTime);
                    //according to watcher requests this switch blocks runs
                    switch (currentWatcher.getWatcherRequest()) {
                        //if the request is 'add' this case runs
                        case "add":
                            //currentWatcher object added the watcher list
                            watcherList.addWatcher(currentWatcher);
                            break;
                            //if the request is 'delete' this case runs
                        case "delete":
                            //currentWatcher remove from the list
                            watcherList.removeWatcher(currentWatcher.getWatcherName());
                            break;
                            //if the request is 'query largest' this block runs
                        case "query-largest":
                            //largest earthquake showed
                            earthquakeList.queryLargestEarthquake();
                            break;
                    }

                    //currentWatcher changed as a watcher file's next row
                    currentWatcher = readWatcherFile(watcherScanner);


                }

            }
            //if the current earthquake is null but currentWatcher is not null these blocks runs
            else if(currentEarthquake==null&&currentWatcher!=null){
                //time changed according to watcher requests time
                currentTime = currentWatcher.getTime();
                //if the earthquakes hour before the 6 hours from current time
                //these earthquakes should remove from the earthquakeList so this method calls
                earthquakeList.removeEarthquake(currentTime);
                //according to watcher requests this switch blocks runs
                switch (currentWatcher.getWatcherRequest()) {
                    //if the request is 'add' this case runs
                    case "add":
                        watcherList.addWatcher(currentWatcher);
                        break;
                    //if the request is 'delete' this case runs
                    case "delete":
                        watcherList.removeWatcher(currentWatcher.getWatcherName());
                        break;
                    //if the request is 'query largest' this block runs
                    case "query-largest":
                        earthquakeList.queryLargestEarthquake();
                        break;
                }

                //currentWatcher changed as a watcher file's next row
                currentWatcher = readWatcherFile(watcherScanner);


            }
            //if the current earthquake object is not null but watcher is null this block runs
            else if(currentEarthquake!=null&&currentWatcher==null){
                //current earthquake object added to earthquakeList
                earthquakeList.addEarthQuake(currentEarthquake);
                //notify methods runs from the earthquakeList class to send earthquake notification
                earthquakeList.notifyWatchers(watcherList.getList(), currentEarthquake);
                //time changed according to watcher requests time
                currentTime = (int) currentEarthquake.getTime();
                currentEarthquake = readEarthquakeFile(earthquakeScanner);
                //if the earthquakes hour before the 6 hours from current time
                //these earthquakes should remove from the earthquakeList so this method calls
                earthquakeList.removeEarthquake(currentTime);
            }


        }

            }

    //this method read the file line by line and returns watcher object
    public static Watcher readWatcherFile(Scanner fileReader) {
        //try block runs if  any exception happens
        try {
       //while watcher file has line these block runs
            while (fileReader.hasNextLine()) {
                //line declared as a string
                String line = fileReader.nextLine().trim();
                //if the line is empty do not do anything just continue
                if (line.isEmpty()) {
                    continue;
                }
                //each line splitting with spaces and filled string array
                String arr[] = line.split(" ");
                Watcher watcher;
                //arrays 0.index is time and parsing string to int
                int time = Integer.parseInt(arr[0]);
                //watcher request is array's 1.index
                String watcherRequest = arr[1];
                //latitude longitude and watcherName variables instantiate as a default value
                double latitude = 0, longitude = 0;
                String watcherName = "";
                //according to watcher request type this switch block runs
                switch (watcherRequest) {
                    //if the request is 'add':
                    case "add":
                        //latitude object declared array's 2.index with parsing
                        latitude = Double.parseDouble(arr[2]);
                        //longitude object declared array's 3.index with parsing
                        longitude = Double.parseDouble(arr[3]);
                        //watcherName declared array's 4.index
                        watcherName = arr[4];
                        //watcher object instantiate according to read file info
                        watcher = new Watcher(time, watcherRequest, latitude, longitude, watcherName);
                        //the object returns
                        return watcher;
                    //if the request is 'delete':
                    case "delete":
                        //watcher name declared array's 2.index
                        watcherName = arr[2];
                        //new watcher object instantiated and returns
                        return new Watcher(time,watcherRequest,watcherName);
                    //if the request is 'query largest':
                    case "query-largest":
                        //new watcher object instantiated and returns
                        return new Watcher(time,watcherRequest);
                        //if the request different from the above default case runs
                    default:
                        System.out.println("not accessible watcher request");

                }

            }
            //if any exception catches this block runs and send appropriate message
        } catch(Exception e){
            System.out.println(e);
        }
        return null;
    }
    //this method read the file line by line and returns earthquake object
    public static Earthquake readEarthquakeFile(Scanner fileReader) {
         //needed variables declared as a default values
        String type = "";
        int id = 0;
        int time = 0;
        String place = "";
        double latitude = 0, longitude = 0, depth = 0, magnitude = 0;
        //try block runs if  any exception happens
        try {
            //while watcher file has line these block runs
            while (fileReader.hasNextLine()) {
                //line declared as a string
                String line = fileReader.nextLine().trim();
                //if the line is empty do not do anything just continue
                if (line.isEmpty()) {
                    continue;
                }
                //if the line equals earthquake :
                if (line.equals("</earthquake>")) {
                    //new earthquake object instantiated with variables and returns
                    return new Earthquake(id, time, place, latitude, longitude, depth, magnitude);
                }
                //if the line equals id:
                if (line.contains("<id>")) {
                    //if the line contains any character different from the digit delete
                    //remaining statement parsing to integer and declared id
                    id = Integer.parseInt(line.replaceAll("\\D", ""));
                    //if the line equals time:
                } else if (line.contains("<time>")) {
                    //if the line contains any character different from the digit, delete
                    //remaining statement parsing to integer and declared time
                    time = Integer.parseInt(line.replaceAll("\\D", ""));
                    //if the line equals place:
                } else if (line.contains("<place>")) {
                    //place words deleted and remaining part declared as a place
                    place = line.replace("<place>", "")
                            .replace("</place>", "")
                            .trim();
                    //if the line equals coordinates:
                } else if (line.contains("<coordinates>")) {
                    //coordinates words deleted and remaining part declared as a string
                    String coords = line.replace("<coordinates>", "")
                            .replace("</coordinates>", "")
                            .trim();
                    //this string parsing with',' and filling the array
                    String[] c = coords.split(",");
                    //array's 0.index parsing and declared latitude
                    latitude = Double.parseDouble(c[0].trim());
                    //array's 1.index parsing and declared longitude
                    longitude = Double.parseDouble(c[1].trim());
                    //array's 2.index parsing and declared depth
                    depth = Double.parseDouble(c[2].trim());
                    //if the line equals magnitude:
                } else if (line.contains("<magnitude>")) {
                    //magnitude words deleted and remaining part declared and parsing with magnitude
                    magnitude = Double.parseDouble(
                            line.replace("<magnitude>", "")
                                    .replace("</magnitude>", "")
                                    .trim()
                    );


                }

            }
            //if any exception catches this block runs and send appropriate message
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
}









