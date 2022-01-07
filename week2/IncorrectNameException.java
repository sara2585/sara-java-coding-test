import java.util.*;
// Create custom exceptions: if the vegetable name is not in {"pepper","cabbage","tomato","cucumber","ice plant"},throw exception.

class InvalidNameException extends Exception {
    public InvalidNameException(String str) {
        super(str);
    }
}
    
class InvalidInteger extends Exception {
    public InvalidInteger(String str) {
        super(str);
    }
}