
public interface Observer {

    void receiveOffer(String nameCompany, int salary);
    void receiveOffer(String nameCompany, JobVacancy jobVacancy);
    void receiveOffer(String nameCompany, JobVacancy jobVacancy, int step);
}
