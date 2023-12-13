package lesson27.exercise01;

public interface Observable {
    void registerObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObservers();
}
