public abstract class JobSeeker implements Observer{
    protected String name;
    protected int salary;
    protected Applicants applicants;

    public JobSeeker(String name, int salary, Applicants applicants) {
        this.name = name;
        this.salary = salary;
        this.applicants = applicants;
    }

    @Override
    public void receiveOffer(String nameCompany, int salary) {
        if (this.salary <= salary){
            System.out.printf("%s %s: Мне нужна эта работа! (компания: %s; заработная плата: %d)\n",
                    this.getClass().getName(),name, nameCompany, salary);
            this.salary = salary;
        }
        else {
            System.out.printf("%s %s: Я найду работу получше! (компания: %s; заработная плата: %d)\n",
                    this.getClass().getName(), name, nameCompany, salary);
        }
    }

    @Override
    //для однопроходного - что выше порога для человека
    public void receiveOffer(String nameCompany, JobVacancy jobVacancy) {
        if (this.getClass().getName().equals(jobVacancy.getPosition())) {
            if (this.salary <= jobVacancy.getSalary()) {
                System.out.printf("%s %s: Мне нужна эта работа! (компания: %s; заработная плата: %d), моя ЗП в " +
                                "резюме %d\n",
                        this.getClass().getName(), name, nameCompany, jobVacancy.getSalary(), this.salary);
//                this.salary = jobVacancy.getSalary();
            } else {
                System.out.printf("%s %s: Я найду работу получше! (компания: %s; заработная плата: %d), моя ЗП в " +
                                "резюме %d\n",
                        this.getClass().getName(), name, nameCompany, jobVacancy.getSalary(), this.salary);
            }
        }
    }

    @Override
    // для двухпроходного определения лучших компаний
    public void receiveOffer(String nameCompany, JobVacancy jobVacancy, int step) {
        if (this.getClass().getName().equals(jobVacancy.getPosition())) {
            if (this.salary <= jobVacancy.getSalary()) {
                if (step > 0){
                    System.out.printf("%s %s: Мне нужна эта работа! (компания: %s; заработная плата: %d)\n",
                        this.getClass().getName(), name, nameCompany, jobVacancy.getSalary());}
                this.salary = jobVacancy.getSalary();
            } else {
                if (step > 0){
                System.out.printf("%s %s: Я найду работу получше! (компания: %s; заработная плата: %d)\n",
                        this.getClass().getName(), name, nameCompany, jobVacancy.getSalary());}
            }
        }
    }

}
