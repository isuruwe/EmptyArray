import java.util.List;

public class NegativeNumberFoundException extends Exception {
    private final List<String> negativeIndices;

    public NegativeNumberFoundException(List<String> negativeIndices) {
        this.negativeIndices = negativeIndices;
    }

    public List<String> getNegativeIndices() {
        return negativeIndices;
    }
}