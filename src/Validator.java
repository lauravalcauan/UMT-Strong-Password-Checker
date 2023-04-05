public interface Validator<T> {

    public boolean isValidLength(String password);
    public boolean validCharacters(String password);
    public boolean repeatedCharacters(String password);
}
