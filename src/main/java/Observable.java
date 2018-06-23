

public interface Observablew {
    public void addObserver(PlayerType playerType);
    public void removeObserver(PlayerType playerType);

    void notifyObserver();
}
