import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SampleTest {
	
	public static void main(String[] args) {
		List<Employee> l = new ArrayList<Employee>();
		
		//l.sort(Co(Employee::getDeptId));
		
		l.forEach(Employee::getDeptId);
		//l.stream().filter(predicate);
		
		//l.stream().filter(e-> e.getDeptId()>1).collect(collector)
		
		
		
	}

}
