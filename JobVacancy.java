public class JobVacancy {

    public Applicants position;
    public int salary;


    public String getPosition() {
        return position.toString();
    }

    public int getSalary() {
        return salary;
    }

    public JobVacancy(Applicants position, int salary) {
        this.position = position;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "JobVacancy{" +
                "position='" + position + '\'' +
                ", salary=" + salary +
                '}';
    }
}
