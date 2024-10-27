import java.util.*;

public class Station {

    Station next;
    Station prev;
    String name;
    String line;
    boolean available = true;

    public Station(String line, String name){
        this.line = line;
        this.name = name;
    }

    public String toString(){

        //"STATION Museum: pink line, in service: true, previous station: none, next station: none"
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
        
        ArrayList<Station> visited = new ArrayList<>();
        return helper(this, a, visited);

    }

    public int helper(Station cur, Station dest, ArrayList<Station> visited){

        if(cur == null){
            return -1;
        }
        if(visited.contains(cur)){
            return -1;
        }
        if(cur == dest){
            return 0;
        }

        visited.add(cur);

        int nextStop = helper(cur.next, dest, visited);
        if(nextStop != -1){
            return nextStop++;
        }

        if(cur instanceof TransferStation){
            TransferStation current = (TransferStation) cur;
            for(int i = 0; i < current.otherStations.size(); i++){
                int transferStop = helper(cur, dest, visited);
                if(transferStop != -1){
                    return transferStop++;
                }
            }
        }
                
        return -1;
    }

    public void connect(Station a){

        if(this instanceof TransferStation){
            TransferStation temp = (TransferStation) this;
            int idx = temp.otherStations.indexOf(a);
            if(temp.otherStations.get(idx) == ){

            }
            temp.addTransferStationNext(a);
        }
        if(a instanceof TransferStation){
            TransferStation temp = (TransferStation) a;
            temp.addTransferStationPrev(this);
        }
        if(this.next == null){
            this.next = a;
        }
        if(a.prev == null){
            a.prev = this;
        }

    }

    public void addNext(Station a){

        this.next = a;
        a.prev = this;
    }

    public void addPrev(Station a){

        this.prev = a;
        a.next = this;
    }

    public boolean isAvailable(){

        return this.available;
    }

    public void switchAvailable(){
        if(this.available == false){
            this.available = true;
            return;
        } 
        this.available = false;
        return;
    }

    public boolean equals(Station a){
        if(this.line == a.line && this.name == a.name){
            return true;
        }
        return false;
    }
    
}
