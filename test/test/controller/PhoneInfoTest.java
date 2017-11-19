package test.controller;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mk.controller.phone.PhoneController;
import com.mk.entity.Phone;
import com.mk.service.impl.PhoneService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml","file:WebRoot/WEB-INF/springmvc-servlet.xml"})
public class PhoneInfoTest {

	@Autowired
	PhoneController p;
	@Test
	public void testGet() {
		System.out.println(p.get(44));
	}

	@Test
	public void testSearch() {
		List<Phone> ps=p.search("8", 0, 10);
		for (Phone phone : ps) {
			System.out.println(phone.getPid()+" "+phone.getName());
		}

	}

	@Test
	public void testHobby() {
		List<Phone> ps=p.hobby(PhoneService.hobbys[0][3], 0, Integer.MAX_VALUE);
		for (Phone phone : ps) {
			System.out.println(phone.getPid()+" "+phone.getRam());
		}
		
	}

	@Test
	public void testSearchBy() {
		List<Phone> ps=p.searchBy("core","八核", 0, 100);
		for (Phone phone : ps) {
			System.out.println(phone.getPid()+" "+phone.getCore());
		}
	}

	@Test
	public void testTypeList() {

		List<Phone> ps=p.typeList("top", 0, 100);
		for (Phone phone : ps) {
			System.out.println(phone.getPid()+" "+phone.getYear()+" "+phone.getRank());
		}
	}

}
