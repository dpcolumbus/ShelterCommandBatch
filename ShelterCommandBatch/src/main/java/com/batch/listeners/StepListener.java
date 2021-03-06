package com.batch.listeners;

import java.io.File;
import java.util.List;


import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;

import org.springframework.util.StringUtils;

public class StepListener implements StepExecutionListener  {

	
	
	public void beforeStep(StepExecution stepExecution) {
		String JobMethodName = null;
		String status = null;
		if(stepExecution.getJobParameters()!=null && 
			stepExecution.getJobParameters().getString("status") !=null && 
			stepExecution.getJobParameters().getString("JobMethodName")!=null ) {
			
			status=stepExecution.getJobParameters().getString("status").toString();
			JobMethodName=stepExecution.getJobParameters().getString("JobMethodName").toString();
		}
		
		if(StringUtils.isEmpty(status) && StringUtils.isEmpty(JobMethodName)) {				
			stepExecution.setExitStatus(new ExitStatus("Missing required Parameters JobMethodName and Status"));
			stepExecution.setTerminateOnly();
		
		}

		
	}
	
	
	
	public ExitStatus afterStep(StepExecution arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	

	
	
	
}


