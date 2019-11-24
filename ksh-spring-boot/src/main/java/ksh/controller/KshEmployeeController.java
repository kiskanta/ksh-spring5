package ksh.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.dozermapper.core.Mapper;

import ksh.dozer.pojo.AddressBean;
import ksh.dozer.pojo.AddressType;
import ksh.dozer.pojo.Employee;
import ksh.dozer.pojo.Student;
import ksh.dozer.pojo.StudentDestination;
import ksh.dozer.pojo.StudentSource;

@RestController
public class KshEmployeeController {

	@Autowired(required = true)
	private Mapper mapper;

	@RequestMapping("/")
	public List<Employee> getEmployes() {
		AddressType addrType = new AddressType();
		addrType.setAddrLine1("121 Howard Lane");
		addrType.setAddrLine2("APT 222");
		addrType.setCity("Austin");
		addrType.setState("Florida");
		addrType.setZipCode(32050);

		List<Employee> employeesList = new ArrayList<>();
		employeesList.add(new Employee(1, "lokesh", "gupta", "howtodoinjava@gmail.com"));

		AddressBean addressBean = mapper.map(addrType, AddressBean.class);

		StudentSource ss = new StudentSource();
		 ss.setName("Sajal");
	     ss.setAddress("India");
	 
	     ss.getStudents().add(new Student("S1", "C1", "diffField1"));
	     ss.getStudents().add(new Student("S2", "C2", "diffField2"));
	     ss.getStudents().add(new Student("S3", "C3", "diffField3"));
		
	     StudentDestination sd = mapper.map(ss, StudentDestination.class);
	     System.out.println(sd);
	     
		System.out.println(addressBean);
		return employeesList;
	}
}
