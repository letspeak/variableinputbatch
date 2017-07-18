package com.san.batch;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;

public class InitialProcessor implements StepExecutionListener{
	
	@Override
	public void beforeStep(StepExecution stepExecution) {
		
		
	}

	@Override
	public ExitStatus afterStep(StepExecution stepExecution) {
		System.err.println("############# InitialProcessor ############");
		return ExitStatus.COMPLETED;
	}
	
}
