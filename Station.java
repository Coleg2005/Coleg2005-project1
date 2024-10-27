import java.util.*;

public class Station {

    // fields for all stations
    Station next;
    Station prev;
    String name;
    String line;
    boolean available = true;

    // constructer
    public Station(String line, String name){
        this.line = line;
        this.name = name;
    }

    public String toString(){

        // also ugly but builds the fields into strings
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

        return "STATION " + name + ": " + line + " line, in service: " + avail + ", previous station: " + temp + ", next station: " + temp2;

    }

    public int tripLength(Station a){
        
        // Initializes the arrayList of visited stops and returns the outout of the recursive function
        ArrayList<Station> visited = new ArrayList<>();
        return helper(this, a, visited);

    }

    public int helper(Station cur, Station dest, ArrayList<Station> visited){

        // base cases
        // Could only happen if there was no endstation
        if(cur == null){
            return -1;
        }
        // if the stops had already been visited, returns -1
        if(visited.contains(cur)){
            return -1;
        }
        // if dest is found returns 0;
        if(cur == dest){
            return 0;
        }

        //adds cur to list of visited
        visited.add(cur);

        // if an error is not returned increases length
        int nextStop = helper(cur.next, dest, visited);
        if(nextStop != -1){
            return 1 + nextStop;
        }

        // if cur is a transferstation, goes through each of the tranfers until it finds the dest
        if(cur instanceof TransferStation){
            TransferStation transfer = (TransferStation) cur;
            for(int i = 0; i < transfer.otherStations.size(); i++){
                int transferStop = helper(transfer.otherStations.get(i) , dest, visited);
                if(transferStop != -1){
                    return 1 + transferStop;
                }
            }
        }
            
        // else returns -1;
        return -1;
    }

    public void connect(Station a){

        // is this is a transfer station and this has a next, sends it to be added to the otherstatiosn aList, makes it so that primary line stops arent added to alist
        if(this instanceof TransferStation && this.next != null){
            TransferStation temp = (TransferStation) this;
            temp.addTransferStationNext(a);
        }
        // saem thing as above, i probably only need one to be chekcing all this but Im not gonna mess with the code
        if(a instanceof TransferStation && a.prev != null){
            TransferStation temp = (TransferStation) a;
            temp.addTransferStationPrev(this);
        }
        // if a is an endstations makes prev and next the same
        if(a instanceof EndStation){
            a.next = this;
            a.prev = this;
            this.next = a;
            return;
        }
        // basic connect
        if(this.next == null){
            this.next = a;
        }
        if(a.prev == null){
            a.prev = this;
        }

    }

    // basic
    public void addNext(Station a){
        this.next = a;
        a.prev = this;
    }

    // basic
    public void addPrev(Station a){
        this.prev = a;
        a.next = this;
    }

    // basic
    public boolean isAvailable(){
        return this.available;
    }

    // basic 
    public void switchAvailable(){
        if(this.available == false){
            this.available = true;
            return;
        } 
        this.available = false;
        return;
    }

    // basic
    public boolean equals(Station a){
        if(this.line == a.line && this.name == a.name){
            return true;
        }
        return false;
    }
    
}
