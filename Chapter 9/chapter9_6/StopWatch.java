
package chapter9_6;

public class StopWatch {
    private long startTime;
    private long endTime;
    
    //no-args constructor
    public StopWatch(){
        startTime = System.currentTimeMillis();
    }
    //get StartTime
    public long getStartTime(){
        return startTime;
    }
    //get endTime
    public long getEndTime(){
        return endTime;
    }
    //start
    public void start(){
        startTime = System.currentTimeMillis();
    }
    //stop
    public void stop(){
        endTime = System.currentTimeMillis();
    }
    //get elapsed time
    public long getElapsedTime(){
        return endTime - startTime;
    }
}
