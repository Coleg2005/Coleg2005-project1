import java.util.*;

public class TransferStation extends Station{

    ArrayList<Station> otherStations;    

    public TransferStation(String line, String name){
        super(line,name);
        otherStations = new ArrayList<>();
    }

    public void addTransferStationPrev(Station a){

        otherStations.add(a);
        a.next = this;

    }

    public void addTransferStationNext(Station b){

        otherStations.add(b);
        b.prev = this;

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
        for(Station It : otherStations)
            transferNext += "\t" + It.toString() + "\n";

        return "TRANSFERSTATION " + name + ": " + line + " line, in service: " + avail + ", previous station: " + temp + ", next station: " + temp2 + "\n\tTransfers: \n" + transferNext;

    }

    
}
