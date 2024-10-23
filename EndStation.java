public class EndStation extends Station{

    public EndStation(String line, String name){
        super(line,name);
    }

    public void makeEnd(){

        if(next != null){
            this.prev = this.next;
        } else {
            this.next = this.prev;
        }
    }

    public void connect(Station a){
        this.prev = a;
        this.next = a;
        a.prev = this;
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

        return "ENDSTATION " + name + ": " + line + " line, in service: " + avail + ", previous station: " + temp + ", next station: " + temp2;

    }
    
}
