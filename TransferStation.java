import java.util.*;

public class TransferStation extends Station{

    ArrayList<Station> otherStations;    

    public TransferStation(String line, String name){
        super(line,name);
        otherStations = new ArrayList<>();
    }

    public void addTransferStationPrev(Station a){

        if(!otherStations.contains(a) && this.next != a && this.prev != a){
            otherStations.add(a);
        }
        if(a.next == null){
            a.next = this;
        }
    }

    public void addTransferStationNext(Station a){

        if(!otherStations.contains(a) && this.next != a && this.prev != a){
            otherStations.add(a);
        }
        if(a.prev == null){
            a.prev = this;
        }
    }

    public String toString(){

        //TRANSFERSTATION Museum: pink line, in service: true, previous station: none, next station: none\n\tTransfers: \n";       
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

        // print transfers
        String transferNext = "";
        for(int i = 0; i < otherStations.size(); i++)
        {
            transferNext += "\t" + otherStations.get(i).toString() + "\n";
        } 
        return "TRANSFERSTATION " + name + ": " + line + " line, in service: " + avail + ", previous station: " + temp + ", next station: " + temp2 + "\n\tTransfers: \n" + transferNext;

    }

    
}
