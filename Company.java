
import java.util.Random;

public class Company {

    private Random random = new Random();

    private String name;

    private Publisher jobAgency;

    private int maxSalary;

    public String getName() {
        return name;
    }

    public Company(String name, Publisher jobAgency, int maxSalary) {
        this.name = name;
        this.jobAgency = jobAgency;
        this.maxSalary = maxSalary;
    }

    public void needEmployee(){
        int salary = random.nextInt(maxSalary);
        jobAgency.sendOffer(name, salary);
    }

    public void needEmployee(JobVacancy jobVacancy){
        jobAgency.sendOffer(this.name, jobVacancy);
    }

    public void needEmployee(JobVacancy jobVacancy, int step){
        jobAgency.sendOffer(this.name, jobVacancy, step);
    }
}
