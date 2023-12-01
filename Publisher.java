
public interface Publisher {

    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void removeAllObserver();

    void sendOffer(String companyName, int salary);
    void sendOffer(String companyName, JobVacancy jobVacancy);


    void sendOffer(String companyName, JobVacancy jobVacancy, int step);
}
