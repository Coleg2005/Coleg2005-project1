import java.util.*;

public class TransferStation extends Station{

    // the array of stations to transfer to
    ArrayList<Station> otherStations;    

    // constructer
    public TransferStation(String line, String name){
        super(line,name);
        otherStations = new ArrayList<>();
    }

    public void addTransferStationPrev(Station a){

        // checks for no dupes in otherStations and that the primary line isn't in the transfer stations list
        if(!otherStations.contains(a) && this.next != a && this.prev != a){
            otherStations.add(a);
        }
        // sets a.next to this
        if(a.next == null){
            a.next = this;
        }
    }

    public void addTransferStationNext(Station a){

        // checks for no dupes in otherStations and that the primary line isn't in the transfer stations list
        if(!otherStations.contains(a) && this.next != a && this.prev != a){
            otherStations.add(a);
        }
        // sets a.prev to this
        if(a.prev == null){
            a.prev = this;
        }
    }

    public String toString(){

        // Definitely could've made this prettier but turns the fields into string format
        String avail;
        if(available == true){
            avail = "true";
        } else {
            avail = "false";
        }

        String temp;
        String temp2;
        if(next == null){
            temp2 = "none";
        } else {
            temp2 = next.name;
        }
        if(prev == null){
            temp = "none";
        } else {
            temp = prev.name;
        }

        // Builds the otherstatiosn arraylist into string format
        String transferNext = "";
        for(int i = 0; i < otherStations.size(); i++)
        {
            transferNext += "\t" + otherStations.get(i).toString() + "\n";
        } 
        return "TRANSFERSTATION " + name + ": " + line + " line, in service: " + avail + ", previous station: " + temp + ", next station: " + temp2 + "\n\tTransfers: \n" + transferNext;

    }

    
}
