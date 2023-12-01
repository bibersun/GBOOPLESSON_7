
public class Program {

    /**
     *  TODO: Доработать приложение, которое разрабатывалось на семинаре,
     *  поработать с шаблоном проектирования Observer,
     *  добавить новый тип соискателя.
     *  Добавить новую сущность "Вакансия", компания должна рассылать вакансии.
     *  Только после этого вы можете усложнить ваше приложение (при желании), например,
     *  добавить тип вакансии (enum),
     *  учитывать тип вакансии при отправке предложения соискателю.
     * @param args
     */
    public static void main(String[] args) {
        Publisher publisher = new JobAgency();
        Company google = new Company("Google", publisher, 120000);
        Company yandex = new Company("Yandex", publisher, 95000);
        Company geekBrains = new Company("GeekBrains", publisher, 98000);

        Student student1 = new Student("Студент #1", 5000, Applicants.Student);
        Master master1 = new Master("Мастер #1", 120000, Applicants.Master);
        Master master2 = new Master("Мастер #2", 110000, Applicants.Master);
        Junior  junior1 = new Junior("Junior #1", 70000, Applicants.Junior);

        publisher.registerObserver(student1);
        publisher.registerObserver(master1);
        publisher.registerObserver(master2);
        publisher.registerObserver(junior1);

        for (int i = 0; i < 3; i++){
            google.needEmployee();
            yandex.needEmployee();
            geekBrains.needEmployee();
        }
        System.out.println("****************************");
        System.out.println("Через вакансии, в два прохода, первый раз - чтобы найти максимум, второй раз - для печати");
        System.out.println("Подбор лучших вакансий");
        //на самом деле есть что улучшать в проге и много чего, как минимум DRY
        System.out.println("****************************");

        Student student11 = new Student("Студент #11", 30000, Applicants.Student);
        Master master11 = new Master("Мастер #11", 130000, Applicants.Master);
        Master master21 = new Master("Мастер #21", 120000, Applicants.Master);
        Junior junior11 = new Junior("Junior #11", 80000, Applicants.Junior);

//        publisher.removeObserver(student1);
//        publisher.removeObserver(master1);
//        publisher.removeObserver(master2);
//        publisher.removeObserver(junior1);

        publisher.removeAllObserver();

        publisher.registerObserver(student11);
        publisher.registerObserver(master11);
        publisher.registerObserver(master21);
        publisher.registerObserver(junior11);


        JobVacancy jobVacancyStudent1 = new JobVacancy(Applicants.Student, 45000);
        JobVacancy jobVacancyStudent2 = new JobVacancy(Applicants.Student, 50000);
        JobVacancy jobVacancyStudent3 = new JobVacancy(Applicants.Student, 55000);
        JobVacancy jobVacancyJunior1 = new JobVacancy(Applicants.Junior, 65000);
        JobVacancy jobVacancyJunior2 = new JobVacancy(Applicants.Junior, 80000);
        JobVacancy jobVacancyMaster1 = new JobVacancy(Applicants.Master, 145000);
        JobVacancy jobVacancyMaster2 = new JobVacancy(Applicants.Master, 150000);

        for (int i = 0; i < 2; i++){
            google.needEmployee(jobVacancyStudent1, i);
            yandex.needEmployee(jobVacancyStudent2, i);
            geekBrains.needEmployee(jobVacancyStudent3, i);
            google.needEmployee(jobVacancyJunior1, i);
            yandex.needEmployee(jobVacancyJunior2, i);
            geekBrains.needEmployee(jobVacancyJunior2, i);
            google.needEmployee(jobVacancyMaster1, i);
            yandex.needEmployee(jobVacancyMaster2, i);
            geekBrains.needEmployee(jobVacancyMaster2, i);
        }

    System.out.println("****************************");
        System.out.println("Через вакансии, в один проход, все подходящие вакансии");
        System.out.println("****************************");

        Student student12 = new Student("Студент #12", 40000, Applicants.Student);
        Master master12 = new Master("Мастер #12", 110000, Applicants.Master);
        Master master22 = new Master("Мастер #22", 130000, Applicants.Master);
        Junior junior12 = new Junior("Junior #12", 70000, Applicants.Junior);

//        publisher.removeObserver(student11);
//        publisher.removeObserver(master11);
//        publisher.removeObserver(master21);
//        publisher.removeObserver(junior11);

        publisher.removeAllObserver();

        publisher.registerObserver(student12);
        publisher.registerObserver(master12);
        publisher.registerObserver(master22);
        publisher.registerObserver(junior12);


        JobVacancy jobVacancyStudent11 = new JobVacancy(Applicants.Student, 45000);
        JobVacancy jobVacancyStudent21 = new JobVacancy(Applicants.Student, 50000);
        JobVacancy jobVacancyStudent31 = new JobVacancy(Applicants.Student, 55000);
        JobVacancy jobVacancyJunior11 = new JobVacancy(Applicants.Junior, 65000);
        JobVacancy jobVacancyJunior21 = new JobVacancy(Applicants.Junior, 80000);
        JobVacancy jobVacancyMaster11 = new JobVacancy(Applicants.Master, 145000);
        JobVacancy jobVacancyMaster21 = new JobVacancy(Applicants.Master, 150000);

        google.needEmployee(jobVacancyStudent11);
        yandex.needEmployee(jobVacancyStudent21);
        geekBrains.needEmployee(jobVacancyStudent31);
        google.needEmployee(jobVacancyJunior11);
        yandex.needEmployee(jobVacancyJunior21);
        geekBrains.needEmployee(jobVacancyJunior21);
        google.needEmployee(jobVacancyMaster11);
        yandex.needEmployee(jobVacancyMaster21);
        geekBrains.needEmployee(jobVacancyMaster21);

    }

}
