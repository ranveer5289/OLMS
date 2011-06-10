/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package scheduler;

/**
 *
 * @author ranveer
 */
import java.text.ParseException;
import org.quartz.CronTrigger;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;

public class MailScheduler {
 

   public  MailScheduler() throws Exception,SchedulerException,ClassNotFoundException, ParseException {
        
         SchedulerFactory sf = new StdSchedulerFactory();
        Scheduler sche = sf.getScheduler();
        
        
        JobDetail jDetail = new JobDetail("Mail", "SampleMailSchedulerJob", SchedulerJob.class);
       CronTrigger crTrigger = new CronTrigger("cronTrigger", "Sam", "0 0/2 * * * ?"); // every 2 minutes
        
        
        sche.scheduleJob(jDetail, crTrigger);
        sche.start();
             
    }
 public static void main(String args[]){
  try{
            MailScheduler mailScheduler = new MailScheduler();
            //System.out.println("hello");
  }catch(Exception e){}  
  }

   
}
