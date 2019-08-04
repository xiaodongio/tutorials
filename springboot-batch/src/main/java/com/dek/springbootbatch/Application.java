package com.dek.springbootbatch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.configuration.JobRegistry;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Date;

@SpringBootApplication
public class Application {


	public static void main(String[] args) {
		try {

			ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
//			JobRegistry jobRegistry = context.getBean(JobRegistry.class);
//			Job job = jobRegistry.getJob("stringJob");
//			JobLauncher jobLauncher = context.getBean(JobLauncher.class);
//			JobExecution jobExecution = jobLauncher.run(job, createJobParams());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static JobParameters createJobParams() {
		return new JobParametersBuilder().addDate("date", new Date()).toJobParameters();
	}

}
