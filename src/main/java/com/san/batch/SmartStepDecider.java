package com.san.batch;

import java.util.LinkedList;
import java.util.Queue;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.job.flow.FlowExecutionStatus;
import org.springframework.batch.core.job.flow.JobExecutionDecider;

public class SmartStepDecider implements JobExecutionDecider  {

	private Queue<String> stepQueue = new LinkedList<String>();

	@Override
	public FlowExecutionStatus decide(JobExecution jobExecution, StepExecution stepExecution) {
		if (!stepQueue.isEmpty()) {
			String stepName = stepQueue.poll();
			return new FlowExecutionStatus(stepName);
		} else {
			return new FlowExecutionStatus("END");
		}
	}

	public Queue<String> getStepQueue() {
		return stepQueue;
	}

	public void setStepQueue(Queue<String> stepQueue) {
		this.stepQueue = stepQueue;
	}
	
}
