package comparing;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Runner {

  public static void sort(List<Student> stuList){

    Comparator<Student> dobComparator =
        Comparator.comparing(Student::getDob);

//    stuList.sort(dobComparator);

    int[][] a1 = {{5,4},{6,4},{6,7},{6,5},{2,3}};

    Comparator<int[]> intComp = new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        if(o1[0]!=o2[0]){
          return (o1[0] > o2[0])?1:-1;
        }else if(o1[1]!=o2[1]){
          return (o1[1] > o2[1])?1:-1;
        }
        return 0;
      }
    };

    Arrays.sort(a1,intComp);
    for(int i=0;i<a1.length;i++){
      System.out.println("{"+a1[i][0]+" ,"+a1[i][1]+"}");
    }





//    Comparator<Student> comp = new Comparator<Student>() {
//      @Override
//      public int compare(Student o1, Student o2) {
//        return o1.getDob().compareTo(o2.getDob());
//      }
//    };
//    stuList.sort(comp);
  }

  public static void main(String args[]){

    List<Student> stuList = new ArrayList<>();

    LocalDate d1 = LocalDate.of(2010,9,21);
    Student s1 = new Student(d1,10,"Aman");

    LocalDate d2 = LocalDate.of(2001,9,21);
    Student s2 = new Student(d2,7,"Adi");

    LocalDate d3 = LocalDate.of(2009,9,21);
    Student s3 = new Student(d3,4,"Rahul");

    LocalDate d4 = LocalDate.of(2018,9,21);
    Student s4 = new Student(d4,9,"Neha");

    Student s5 = new Student(null,12,"Raj");

    stuList.add(s1); stuList.add(s2); stuList.add(s3); stuList.add(s4); stuList.add(s5);

    sort(stuList);

    for(Student s:stuList){
      System.out.println(s.toString());
    }



  }

}
