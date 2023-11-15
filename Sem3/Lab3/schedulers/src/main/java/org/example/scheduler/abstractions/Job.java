package org.example.scheduler.abstractions;

public class Job implements IWork{

    private IRunNotSafeAction action;
    private IProvideNextExecutionTime nextTimeProvider = ()->null;
    private IHandleErrors handleExceptions = ex->{};
    private IComplete singleActionCompleted = ()->{};
    private IComplete completed = ()->{};
    private IScheduleWork scheduler;

    public Job(IRunNotSafeAction action, IScheduleWork scheduler){
        this.action=action;
        this.scheduler=scheduler;
    }

    public IWork useExecutionTimeProvider(IProvideNextExecutionTime timeProvider){
        this.nextTimeProvider=timeProvider;
        return this;
    }
    public IWork onError(IHandleErrors errorHandler){
        this.handleExceptions=errorHandler;
        return this;
    }
    public IWork onSingleActionCompleted(IComplete onSingleActionCompleted){
        this.singleActionCompleted=onSingleActionCompleted;
        return this;
    }
    public IWork onCompleted(IComplete onCompleted){
        this.completed=onCompleted;
        return this;
    }
    public void schedule(){
        this.scheduler.addJob(this);
    }
    public void execute(){}













}
