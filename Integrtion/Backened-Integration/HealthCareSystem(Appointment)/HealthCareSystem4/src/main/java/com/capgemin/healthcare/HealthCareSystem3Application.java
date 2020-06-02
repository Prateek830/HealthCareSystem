package com.capgemin.healthcare;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.capgemin.healthcare.dao.DiagnosticCenterDao;
import com.capgemin.healthcare.dao.TestDao;
import com.capgemin.healthcare.dao.UsersDao;
import com.capgemin.healthcare.entity.DiagnosticCenter;
import com.capgemin.healthcare.entity.Test;
import com.capgemin.healthcare.entity.Users;

@SpringBootApplication
public class HealthCareSystem3Application 
{

	public static void main(String[] args)
	{
		SpringApplication.run(HealthCareSystem3Application.class, args);
	}
}
	