public class Dispatcher {
    private Server.ClientHandler destination;
    private Actions action;
    private String message;

    public Dispatcher(Actions action, Server.ClientHandler destination){
        this.action = action;
        this.destination = destination;
    }
    public Dispatcher(String message, Server.ClientHandler destination){
        this.message = message;
        this.destination = destination;
    }
    public Dispatcher(String message){
        this.message = message;
    }
    public Dispatcher(Actions action){
        this.action = action;
    }
    public Dispatcher(){

    }
    
    public Server.ClientHandler getDestiantion(){
        return this.destination;
    }

    public String toString(){
        if (action != null) {
            return "Action: " + action;
        }
        return "Message: " + message;
    }

    
}
