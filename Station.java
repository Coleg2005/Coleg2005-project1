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

        // Recursive backtracking

        // Write recursive helper method

        //Base cases:
        // if node had already been visisted, return
        // if node found, 

        // Find the station then start the count on the way back 
        // Find the station by going through the whole primarty line, then if not found, switching at transfer station to line not equal to the line just completed.
        // Could even make another array list of stations weve been to. 
        // BC: If end station go back 
        // once at the transfer station - arraylist. contains any lines youve looked at


        // Check the current line until transfer and until endstation

        ArrayList<Station> visited = new ArrayList<>();
        Station cur = this;
        int times = 0;
        while(times != 2){
            if(cur == a){
                // Do what 
                break;
            }
            visited.add(cur);
        }


        return 0;

    }

    public int helper(){
        
        return 0;
    }

    public void connect(Station a){

        this.next = a;
        a.prev = this;

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
