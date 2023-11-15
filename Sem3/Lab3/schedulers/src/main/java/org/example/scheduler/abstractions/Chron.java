package org.example.scheduler.abstractions;

import java.time.Duration;
import java.time.LocalDateTime;

public class Chron{

    private LocalDateTime startTime=LocalDateTime.now();
    private LocalDateTime endDate=null;
    private int maxExecutionTimes=-1;
    private Duration intervalDuration=Duration.ofSeconds(1);
    private int counter;

        private Chron(){}
        public static Chron builder(){
            return new Chron();
        }
        public Chron setStartTime (LocalDateTime startTime){
            this.startTime = startTime;
            return this;
        }
        public Chron setEndDate (LocalDateTime endDate){
            this.endDate = endDate;
            return this;
        }
        public Chron setMaxExecutionTimes (int maxExecutionTimes){
            this.maxExecutionTimes = maxExecutionTimes;
            return this;
        }
        public Chron setIntervalDuration (Duration intervalDuration){
            this.intervalDuration = intervalDuration;
            return this;
        }

        public IProvideNextExecutionTime buildNextTimeExecutionProvider(){
            return ()->nextTime();
        }

        public LocalDateTime nextTime(){
            if(endDate!=null && endDate.isBefore(startTime))
                return null;
            if(maxExecutionTimes>0 && counter>maxExecutionTimes)
                return null;
            if(counter==0) {
                counter++;
                return startTime;
            }
            counter++;
            startTime=startTime.plus(intervalDuration);
            return startTime;

        }
}
