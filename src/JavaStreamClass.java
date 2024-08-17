import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.testng.annotations.Test;
import org.testng.Assert;
public class JavaStreamClass {
	
    @Test
	public void regular() {
		// TODO Auto-generated method stub
		int count = 0;
		int count1 = 0;
		ArrayList<String> names = new ArrayList<String>();
		names.add("Abhisek");
		names.add("abraham");
		names.add("Bhaweshmita");
		names.add("virndha");
		names.add("Sachin");
		for(String name : names) {
			System.out.println(name);
			count ++;
			if(name.startsWith("A")) {
				System.out.println("name starts with A: "+name);
				count1 ++;
				System.out.println("name starts with A Count: "+count1);
			}
		}
		System.out.println(count);
	}
   
   @Test
   public void streamFilter() {
	   ArrayList<String> names = new ArrayList<String>();
		names.add("Abhisek");
		names.add("abraham");
		names.add("Bhaweshmita");
		names.add("virndha");
		names.add("Sachin");
		
	long countResult =	names.stream().filter(s -> s.startsWith("A")).count();
	System.out.println(countResult);
	
	long d = Stream.of("raju","Abhi","Amatya","Ashok","Ria").filter(s->s.startsWith("A")).count();
	System.out.println(d);
	// to print word whose length > 4 and only one result
	names.stream().filter(s->s.length() > 4).limit(1).forEach(s->System.out.println(s));
	
	// to print word whose length > 4 
		names.stream().filter(s->s.length() > 4).forEach(s->System.out.println(s));
   }
   
   
   @Test
   public void mapStream() {
	   //map can use to manipulate the stream
	   //print names which have last letter a with Uppercase
	   Stream.of("raju","Abhi","Amatya","Ashoka","Ria").filter(s->s.endsWith("a")).map(s->s.toUpperCase()).forEach(s->System.out.println(s));
	   
	   //first covert arrat to list then print names which have first letter as "a" with uppercase and sorted
	  List<String> namesLst =    Arrays.asList("raju","Abhi","Amatya","Ashoka","Ria");
	  namesLst.stream().filter(s->s.endsWith("a")).sorted().map(s->s.toUpperCase()).forEach(s->System.out.println("List:"+s));
	  
	  ArrayList<String> names = new ArrayList<String>();
		names.add("Abhisek");
		names.add("abraham");
		names.add("Bhaweshmita");
		names.add("virndha");
		names.add("Sachin");
		
	  //merging 2 different lists
		
	  Stream<String> newStream =Stream.concat(names.stream(), namesLst.stream());
	  newStream.map(s->s.toUpperCase()).sorted().forEach(s->System.out.println("MergList:"+s));
	  
	  //match if substring is presnet in the merged list or not -> result be in boolean
	 Stream<String> newStream1 =Stream.concat(names.stream(), namesLst.stream());
	 boolean flag = newStream1.anyMatch(s->s.equalsIgnoreCase("raju"));
	 Assert.assertTrue(flag);
   }
   
   @Test
   public void collectStream() {
	  //collect method -> collects all the result from previous method 
	 List<String> ls =  Stream.of("Kar_raju","Kar_Abhi","Kar_Amatya","Ashoka","Ria").filter(s->s.startsWith("K")).collect(Collectors.toList());
	 System.out.println(ls.get(0));
	 
	 //Print unique number from this array
	 //sort the array
	 List<Integer> values = Arrays.asList(3,2,2,7,5,1,9,7);
	 values.stream().sorted().collect(Collectors.toSet()).forEach(s->System.out.println(s));
	 values.stream().distinct().sorted().forEach(s->System.out.println("Distinct Number: "+s));
	 
	 //after sorting give me the -5
	 List<Integer> lst =values.stream().distinct().sorted().collect(Collectors.toList());
	 System.out.println(lst.get(3));
   }
   
  

}
