//this class is constituted for travel list of the nodes
public class MyIterator<E> {
    //doubly lined list class object called
   private DoublyLinkedList<E>list;
   //this i shows out position for begin 0
    private int i=0;
    //this variable help us the find and do not lose position
    private int lastIndex=-1;
    //this method indicate for next element exist or not
    public boolean hasNext(){
        //if the list is empty return false
       if(list.isEmpty())
           return false;
       //if the i<list size it indicates the next element exist so return true
       if(i<list.size())
           return true;
       //i>list size it indicates the next element does not exist so return false
       return false;
    }
    //this method returns next object
    public E next(){
        //if the i is equal to size it shows iterator is end of the list
        //so there is no next element
       if(i==list.size()){
           System.out.println("There is no next element");
       }
       //last index declared as an i for do not lose our position
       lastIndex=i;
       //return the list's next node
       return list.getNode(i++);
    }
    //this method removes the last returned element
    public void remove(){
        //if the list is empty return
        if(list.isEmpty())
            return;
        //call the list's remove method to remove last index
        list.removeNode(lastIndex);
        //i minus 1 because of the list's size declared iterator remain the same position
        i--;
        lastIndex=-1;

    }
    //constructor take the list as a parameter
    public MyIterator(DoublyLinkedList<E>list){
        this.list=list;
    }

}
