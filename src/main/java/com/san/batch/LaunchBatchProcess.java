package com.san.batch;

import java.util.LinkedList;
import java.util.Queue;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionException;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SuppressWarnings("resource")
public class LaunchBatchProcess {

	public static void main(String[] args) {
		
		//if Control-M will pass specific entity name , set it here
		Queue<String> stepQueue = new LinkedList<String>();
		//steps.add("stepOne");
		//stepQueue.add("stepTwo");
		//steps.add("stepThree");

		String[] springConfig  =
			{
				"classpath*:/META-INF/spring-batch-config.xml"
			};
		ApplicationContext context = new ClassPathXmlApplicationContext(springConfig);
		JobLauncher jobLauncher = (JobLauncher) context.getBean("jobLuncher");
		Job job = (Job) context.getBean("stepProcessorJob");
		
		SmartStepDecider smartDecider = (SmartStepDecider) context.getBean("decider");
		if(!stepQueue.isEmpty())
			smartDecider.setStepQueue(stepQueue);
		
		try {
			JobExecution execution = jobLauncher.run(job , new JobParameters());
			System.out.println("Job Exit Status : " + execution.getStatus());
		} catch (JobExecutionException e) {
			System.err.println("Job Execution Result failed");
			e.printStackTrace();
		}
	}
}
