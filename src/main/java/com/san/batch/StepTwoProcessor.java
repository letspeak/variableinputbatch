package com.san.batch;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;

public class StepTwoProcessor implements StepExecutionListener{

	@Override
	public void beforeStep(StepExecution stepExecution) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ExitStatus afterStep(StepExecution stepExecution) {
		System.err.println("############# StepTwoProcessor ############");
		return ExitStatus.COMPLETED;
	}


	
}
