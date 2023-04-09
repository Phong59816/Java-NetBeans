package chapter6_ex14;

/*r
Name: Phong Tran
Date: 09/22/21
Project: Chapter 6 exercise 14
Description: This program compute and estimate pi using a given summation and i value
*/
public class Chapter6_ex14 {

    public static void main(String[] args) {
        //printing header
        System.out.println("i\t\t\tm(i)");
        //invoke pi method
        pi(1);
    }
    //create pi method to calculate and print table
    public static void pi(int i){
        //declaring variables
        double pi = 0;
        double sum = 0;
        //loop to calculate pi
        for (i = 1; i <= 901; i++){
            sum += Math.pow(-1, i + 1) / (2 * i - 1);
            pi = 4 * sum;
            //using continue to escape loop iteration to only print certain values
            if (i > 1 && i < 101)
                continue;
            if (i > 101 && i < 201)
                continue;
            if (i > 201 && i < 301)
                continue;
            if (i > 301 && i < 401)
                continue;
            if (i > 401 && i < 501)
                continue;
            if (i > 501 && i < 601)
                continue;
            if (i > 601 && i < 701)
                continue;
            if (i > 701 && i < 801)
                continue;
            if (i > 801 && i < 901)
                continue;
            //printing table
            System.out.println(i + "\t\t\t" + pi);
        }
            
    }
}
