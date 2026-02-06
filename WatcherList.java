//this class stock the watcher objects
//it has various methods like adding removing watcher
public class WatcherList {
    //from the doubly linked list class an object instantiated and the list constructed
    // to store watcher objects
    private DoublyLinkedList<Watcher>list=new DoublyLinkedList<>();
    //this method add watcher object to the linked list
    public void addWatcher(Watcher watcher){
        //every watcher added end of the list
        list.addLast(watcher);
        //suitable message showed
        System.out.println(watcher.getWatcherName()+" is added to the watcher-list");
    }
//this method removes the watcher object in the linked list
   public void removeWatcher(String name){
       //if the list is empty show the apporipiate message and exit
        if(list.isEmpty()){
            System.out.println("watcher list is empty");
            return;
        }
       //if the list is not empty iterator class's object instantiated to travel the watcher list
       //as a parameter this list declared
        MyIterator<Watcher>iterator=new MyIterator<>(list);
       //if the iterator has next this block runs
        while (iterator.hasNext()){
            //iterator return the first watcher object
            Watcher watcher=iterator.next();
            //if the returning watcher object's name is equal to taken parameter's name
            //this block runs
            if(watcher.getWatcherName().equals(name)) {
                //remove from the list last returning watcher
                iterator.remove();
                //send suitable message
                System.out.println(name+ " is removed from watcher-list");
                //and exit the loop
                break;
            }


        }
   }
   //this method returns the list
    public DoublyLinkedList<Watcher> getList() {
        return list;
    }





}








