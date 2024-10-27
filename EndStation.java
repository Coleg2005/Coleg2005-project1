public class EndStation extends Station{

    // constructer
    public EndStation(String line, String name){
        super(line,name);
    }

    // makes next and prev the same
    public void makeEnd(){
        if(next != null){
            this.prev = this.next;
        } else {
            this.next = this.prev;
        }
    }

    // connects them so that next and prev are the same
    public void connect(Station a){
        this.prev = a;
        this.next = a;
        a.prev = this;
    }

    // Builds the fields into strings
    public String toString(){
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

        return "ENDSTATION " + name + ": " + line + " line, in service: " + avail + ", previous station: " + temp + ", next station: " + temp2;

    }
    
}
