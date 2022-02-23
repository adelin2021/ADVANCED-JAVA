package Cafe.cafe;

import java.util.ArrayList;
import java.util.List;

public class Cafe {


    private String name;
    private int capacity;
    private List<Employee> employees;

    public Cafe(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        if (this.employees.size() < this.capacity) {
            this.employees.add(employee);
        }
    }
    public boolean removeEmployee(String name) {
        int index = -1;
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getName().equals(name)) {
                index = i;
            }
        }
        if (index != -1) {
            employees.remove(index);
            return true;
        }
        return false;
    }

    public Employee getOldestEmployee() {
        return this.employees.stream().max((p1, p2) -> Integer.compare(p1.getAge(), p2.getAge())).get();
    }

    public Employee getEmployee(String name) {
        for (Employee employee : employees) {
            if (employee.getName().equals(name)) {
                return employee;
            }
        }
        return null;
    }

    public int getCount() {
        return employees.size();
    }

    public String report() {
        StringBuilder builder = new StringBuilder("Employees working at Cafe " + name +  ":" + System.lineSeparator());
        for (Employee employee1 : employees) {
            builder.append(employee1.toString()).append(System.lineSeparator());
        }
        return builder.toString().trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}

