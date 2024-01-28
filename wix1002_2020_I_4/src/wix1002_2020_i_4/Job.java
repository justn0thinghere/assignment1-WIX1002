
package wix1002_2020_i_4;

public class Job {
    protected String job;
    protected int task;
    protected int memory;
    public String getjob(){
        return job;
    }
    public int gettask(){
        return task;
    }
    public int getmem(){
        return memory;
    }
    public Job(String j,int t,int m){
        job = j;
        task = t;
        memory = m;
    }
    public String toString(){
        return "Job Name: " + job + " Memory: " + memory + " GB Number of Task: " + task;
    }
}
