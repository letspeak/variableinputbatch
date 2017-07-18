package com.san.batch;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;

public class StepOneProcessor implements StepExecutionListener{

	@Override
	public void beforeStep(StepExecution stepExecution) {
		
	}

	@Override
	public ExitStatus afterStep(StepExecution stepExecution) {
		System.err.println("############# StepOneProcessor ############");
		return ExitStatus.COMPLETED;
	}


	
}
