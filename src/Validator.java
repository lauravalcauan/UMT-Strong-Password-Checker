public interface Validator { // interface with the necessary methods

    // declare the methods that classes implementing this interface must define
    public boolean isValidLength(String password);
    public boolean validCharacters(String password);
    public boolean repeatedCharacters(String password);
}
