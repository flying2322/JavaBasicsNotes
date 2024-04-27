package interfaces;

import java.util.Objects;
import java.time.*;

 public class Employee implements Comparable<Employee>
{
  private String name;
  private double salary;
  private LocalDate hireday;

  public Employee(String name, double salary) 
  {
    this.name = name;
    this.salary = salary;
  }

  public Employee(String name, double salary, int year, int month, int day){
    this.name = name;
    this.salary = salary;
    hireday = LocalDate.of(year, month, day);
  }

  public String getName() {
    return name;
  }

  public double getSalary() {
    return salary;
  }

  public LocalDate getHireDay() {
    return hireday;
  }

  public void raiseSalary(double byPercent) {
    double raise = salary * byPercent / 100;
    salary += raise;
  }

  /**
   * Compares employee by salary
   * @param other another Employee Objects
   * @return a negative value if this employee has a lower salary than
   * otherObject, o if the salaryes are the same, a positive value otheswise
   */
  public int compareTo(Employee other)
  {
    return Double.compare(salary, other.salary);
  }

  public boolean equals(Object otherObject) {
    if (this == otherObject) return true;

    if (otherObject == null) return false;

    if (getClass() != otherObject.getClass()) return false;

    var other = (Employee) otherObject;
    return Objects.equals(name, other.name) && salary == other.salary && Objects.equals(hireday, other.hireday);
  }

  public int hashCode() {
    return Objects.hash(name, salary, hireday);
  }

  public String toString() {
    return getClass().getName() + "[name=" + name + ", salary=" + salary + ", hireDay=" + hireday + "]";
  }
}
