package org.myautomation.template.custom_reporter;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.xml.XmlSuite;

public class CustomReporter implements IReporter {

	@Override
	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
		for(ISuite suite: suites){
			Map<String, ISuiteResult> results= suite.getResults();
			Set<String> keys= results.keySet();
			for(String key: keys){
				ITestContext context= results.get(key).getTestContext();
				System.out.println("Test Name: "+context.getName());
				System.out.println("Test Start Time: "+context.getStartDate());
				System.out.println("Test End Date: "+context.getEndDate());
				IResultMap allFailedTests= context.getFailedTests();
				Collection<ITestNGMethod> failedMethods= allFailedTests.getAllMethods();
				for(ITestNGMethod failedMethod: failedMethods){
					System.out.println("Failed Test Name: "+failedMethod.getMethodName());
					System.out.println("Test Description:"+ failedMethod.getDescription());
					System.out.println("Test Priority: "+failedMethod.getPriority());
				}
			}
		}
	}

}
