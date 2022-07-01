package comparing;

import java.time.LocalDate;

public class Student {

  private LocalDate dob;
  private Integer grade;
  private String name;

  public Student(LocalDate dob, Integer grade, String name) {
    this.dob = dob;
    this.grade = grade;
    this.name = name;
  }

  public Student() {

  }

  public LocalDate getDob() {
    return dob;
  }

  public void setDob(LocalDate dob) {
    this.dob = dob;
  }

  public Integer getGrade() {
    return grade;
  }

  public void setGrade(Integer grade) {
    this.grade = grade;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "Student{" +
        "dob=" + dob +
        ", grade=" + grade +
        ", name='" + name + '\'' +
        '}';
  }
}
