package be.cegeka.batchers.taxcalculator.application;

import be.cegeka.batchers.taxcalculator.application.domain.generation.EmployeeGenerator;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

public class ApplicationInitializer implements ApplicationListener<ContextRefreshedEvent> {

    private EmployeeGenerator employeeGenerator;

    private boolean generateEmployees = true;

    public void onApplicationEvent(ContextRefreshedEvent event) {
        runEmployeesGenerator();
    }

    private void runEmployeesGenerator() {
        if (generateEmployees) {
            employeeGenerator.resetEmployees();
        }
    }

    public void setEmployeeGenerator(EmployeeGenerator employeeGenerator) {
        this.employeeGenerator = employeeGenerator;
    }

    public void setGenerateEmployees(boolean generateEmployees) {
        this.generateEmployees = generateEmployees;
    }
}
