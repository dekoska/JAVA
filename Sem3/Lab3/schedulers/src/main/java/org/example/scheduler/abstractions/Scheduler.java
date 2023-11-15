package org.example.scheduler.abstractions;

import java.util.List;

public class Scheduler implements IScheduleWork{

    private static Scheduler instance;
    private List<IWork> jobs;
    private Scheduler(){}

    static{
        instance = new Scheduler();
    }

    public static Scheduler getInstance(){
        return instance;
    }

    public IWork forAction(IRunNotSafeAction action){
        return  null;
    }
    public List<IWork> getJobs(){
        return  null;
    }
    public void addJob(IWork job){
    }

}
