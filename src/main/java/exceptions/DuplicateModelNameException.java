package exceptions;

public class DuplicateModelNameException extends Exception {
    public DuplicateModelNameException(String massage) {
        super(massage);
    }
}
