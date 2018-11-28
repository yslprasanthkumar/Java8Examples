import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.function.ToIntBiFunction;
import java.util.stream.Collectors;

public class Testing {
	public static void main(String[] args) throws FileNotFoundException, ParseException {
 		
 		lambdaFiltre();
    	orderItem();
 		streamSetflatMap();
 		groupBy();
	}
	
	private static void groupBy() {
		List<String> items1 =
                Arrays.asList("apple", "apple", "banana",
                        "apple", "orange", "banana", "papaya");

		Map<String, Long> result = items1.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		
		System.out.println(result);
		
		
		
		Map<String, Long> finalMap = new LinkedHashMap<>();
		//Sort a map and add to finalMap
		result.entrySet().stream().sorted(Map.Entry.<String, Long>comparingByValue().reversed()).forEachOrdered(e -> finalMap.put(e.getKey(), e.getValue()));
		System.out.println(finalMap);
		
		
		
		List<Item> items = Arrays.asList(
                new Item("apple", 10, new BigDecimal("9.99")),
                new Item("banana", 20, new BigDecimal("19.99")),
                new Item("orang", 10, new BigDecimal("29.99")),
                new Item("watermelon", 10, new BigDecimal("29.99")),
                new Item("papaya", 20, new BigDecimal("9.99")),
                new Item("apple", 10, new BigDecimal("9.99")),
                new Item("banana", 10, new BigDecimal("19.99")),
                new Item("apple", 20, new BigDecimal("9.99"))
        );
		
		Map<String, Long> counting = items.stream().collect(Collectors.groupingBy(Item::getName,Collectors.counting()));
		System.out.println(counting);
		
		Map<String, Integer> sum = items.stream().collect(Collectors.groupingBy(Item::getName,Collectors.summingInt(Item::getQty)));
		System.out.println(sum);
		
		
		
		//group by price
        Map<BigDecimal, List<Item>> groupByPriceMap = 
			items.stream().collect(Collectors.groupingBy(Item::getPrice));

        System.out.println(groupByPriceMap);

		// group by price, uses 'mapping' to convert List<Item> to Set<String>
        Map<BigDecimal, Set<String>> resultMap =
                items.stream().collect(
                        Collectors.groupingBy(Item::getPrice,
                                Collectors.mapping(Item::getName, Collectors.toSet())
                        )
                );

        System.out.println(resultMap);
        
        
        System.out.println("--->"+counting.entrySet().stream().findFirst());
        System.out.println("------------------------------------- Printing values based on Particular Key");
        counting.forEach((k,v)-> System.out.println(k+", "+v));
        Map<String, Long> result1 = counting.entrySet().stream().filter(x->"apple".equals(x.getKey())).collect(Collectors.toMap(map -> map.getKey(), map -> map.getValue()));
		System.out.println(result1);
	}

	private static void lambdaFiltre() {
		List names = new ArrayList();
		
	       names.add("Mahesh");
	       names.add("Suresh");
	       names.add("Ramesh");
	       names.add("Naresh");
	       names.add("Kalpesh");
	 		
	       names.forEach(System.out::println);
	       

	       names.stream().sorted().forEach(System.out::println);
	       System.out.println(names); 
	       
	       
	       ToIntBiFunction<Integer,Integer> add = (a,b) -> a + b;
	       
	       System.out.println(add.applyAsInt(1, 2));
	       
	       
	       
	       
	       
	       
	       List<Movie> movies = Arrays.asList(
	    	        new Movie(1000,"Lord of the rings"),
	    	        new Movie(200,"Back to the future"),
	    	        new Movie(300,"Carlito's way"),
	    	        new Movie(400,"Pulp fiction"));

	    	movies.sort(Comparator.comparing(Movie::getName));

	    	movies.forEach(System.out::println);
	    	
	    	
	    	movies.sort(Comparator.comparing(Movie::getName).reversed());
	    	movies.forEach(System.out::println);
	    	
	    	movies.sort((o1,o2)-> o1.getNameId().compareTo(o2.getNameId()));
	    	    	movies.forEach(System.out::println);
	    	    	

	    	    	
	    	    	List<Employee> employees = Arrays.asList(
	    	    			new Employee(1, 1000,"Chandra Shekhar", 6000),
	    	                new Employee(1, 1000, "Rajesh", 8000), 
	    	                new Employee(1, 1004,"Rahul", 9000), 
	    	                new Employee(1, 1001, "Suresh", 12000),
	    	                new Employee(1, 1004, "Satosh", 8500));

	    	    	 int total = employees.stream()
	    	                 .collect(Collectors.summingInt(Employee::getSalary));
	    	    	 
	    	    	 int totalSalByDept = employees.stream().
	    	                 filter(name-> 1000 == name.getDeptId())
	    	                 .collect(Collectors.summingInt(Employee::getSalary));
	    	    	
	    	    	System.out.println("Total Employees Salary : "+total);
	    	        System.out.println("Total Employees Salary of 1000 Dept : "+totalSalByDept);
	    	        
	    	        System.out.println(employees.stream().filter(emp->emp.getSalary() > 100).count());//.forEach(System.out::println);
		
	}

	private static void streamSetflatMap() {
		Student obj1 = new Student();
        obj1.setName("mkyong");
        obj1.addBook("Java 8 in Action");
        obj1.addBook("Spring Boot in Action");
        obj1.addBook("Effective Java (2nd Edition)");

        Student obj2 = new Student();
        obj2.setName("zilap");
        obj2.addBook("Learning Python, 5th Edition");
        obj2.addBook("Effective Java (2nd Edition)");

        List<Student> list = new ArrayList<>();
        list.add(obj1);
        list.add(obj2);
        
        List<String> collect = list.stream().
        		map(x->x.getBook())//Stream<Set<String>>
        		.flatMap(x->x.stream())//Stream<String>
        		.collect(Collectors.toList());
        
        collect.forEach(x->System.out.println(x));
		
	}
	
	private static void orderItem(){
		List<Item> items = new ArrayList<Item>();
		Item  item = new Item(1, true);
		items.add(item);
		item = new Item(2, true);
		items.add(item);
		item = new Item(3, false);
		items.add(item);
		item = new Item(4, false);
		items.add(item);
		item = new Item(5, false);
		items.add(item);
		item = new Item(6, true);
		items.add(item);
		Order order = new Order(1,items);
		List<Order> orders = new ArrayList<Order>();
		orders.add(order);
		
		List<Item> item1 = items.stream().filter(Item.isItemAvailable()).collect(Collectors.toList());
		
		System.out.println("Count ::::"+items.stream().filter(Item.isItemAvailable()).collect(Collectors.toList()));
		
		
		System.out.println(orders.stream()
        .filter(e -> (items.stream()
                .filter(d -> d.isAvailable()==true)
                .count())<100)
                .collect(Collectors.toList()));
		
		List<List<Order>> ordersFunal = item1.stream().map(temp->{
			return orders.stream().collect(Collectors.toList());
			}
		).collect(Collectors.toList());
		
		System.out.println(ordersFunal.get(0).get(0).getOrderId());
		System.out.println(ordersFunal.size());
		
	}
	
	
	 
}
