package com.san.batch;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;

public class StepThreeProcessor implements StepExecutionListener{

	@Override
	public void beforeStep(StepExecution stepExecution) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ExitStatus afterStep(StepExecution stepExecution) {
		System.err.println("############# StepThreeProcessor ############");
		return ExitStatus.COMPLETED;
	}
}
