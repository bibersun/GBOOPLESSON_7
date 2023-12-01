
import java.util.ArrayList;
import java.util.Collection;

public class JobAgency implements Publisher {

    private Collection<Observer> observers = new ArrayList<>();


    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void removeAllObserver() {
        observers.clear();
    }

    @Override
    public void sendOffer(String companyName, int salary) {
        for (Observer observer : observers){
            observer.receiveOffer(companyName, salary);
        }
    }

    @Override
    public void sendOffer(String companyName, JobVacancy jobVacancy){
        for (Observer observer : observers){
            observer.receiveOffer(companyName, jobVacancy);
        }
    }

    @Override
    public void sendOffer(String companyName, JobVacancy jobVacancy, int step){
        for (Observer observer : observers){
            observer.receiveOffer(companyName, jobVacancy, step);
        }
    }
}
