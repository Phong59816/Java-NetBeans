
package chapter11_ex02;
import java.util.GregorianCalendar;
public class MyDate {
  private int day;
  private int month;
  private int year;
  
  //constructor no args
  public MyDate(){
      GregorianCalendar calander = new GregorianCalendar();
      year = calander.get(GregorianCalendar.YEAR);
      month = calander.get(GregorianCalendar.MONTH);
      day = calander.get(GregorianCalendar.DAY_OF_MONTH);
  }
  
  //constructor with specified date
  public MyDate(int day,int month,int year){
      this.day = day;
      this.month = month;
      this.year = year;
  }
  
  //getter day
  public int getDay(){
      return day;
  }
  
  //getter month
  public int getMonth(){
      return month;
  }
  
  //getter year
  public int getYear(){
      return year;
  }
  
  //set current date method
  public void setDate(long elapsedTime){
      GregorianCalendar calander = new GregorianCalendar();
      calander.setTimeInMillis(elapsedTime);
      year = calander.get(GregorianCalendar.YEAR);
      month = calander.get(GregorianCalendar.MONTH);
      day = calander.get(GregorianCalendar.DAY_OF_MONTH);
  }
}
