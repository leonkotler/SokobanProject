package exceptions;

// Throws an execption if the level is empty
public class LevelEmptyException extends Exception{

    public LevelEmptyException() {
    }

    public LevelEmptyException(String message) {
        super(message);
    }
}
