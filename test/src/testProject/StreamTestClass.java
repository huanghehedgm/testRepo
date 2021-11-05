package testProject;

import java.io.*;
import java.util.*;
import java.util.Map;
import java.util.Map.Entry;

public class StreamTestClass {
	
  public static void main(String[] argv) {
    String[][] studentCoursePairs1 = {
      {"58", "Linear Algebra"},
      {"94", "Art History"},
      {"94", "Operating Systems"},
      {"17", "Software Design"},
      {"58", "Mechanics"},
      {"58", "Economics"},
      {"17", "Linear Algebra"},
      {"17", "Political Science"},
      {"94", "Economics"},
      {"25", "Economics"},
      {"58", "Software Design"}
    };
    
    findCommonClasses(studentCoursePairs1);

    String[][] studentCoursePairs2 = {
      {"0", "Advanced Mechanics"},
      {"0", "Art History"},
      {"1", "Course 1"},
      {"1", "Course 2"},
      {"2", "Computer Architecture"},
      {"3", "Course 1"},
      {"3", "Course 2"},
      {"4", "Algorithms"}
    };
    
    findCommonClasses(studentCoursePairs2);

    String[][] studentCoursePairs3 = {
      {"23", "Software Design"}, 
      {"3",  "Advanced Mechanics"}, 
      {"2",  "Art History"}, 
      {"33", "Another"},
    };
    findCommonClasses(studentCoursePairs3);


  }
  
  public static void findCommonClasses(String[][] pairs) {
	  TreeMap<String, List<String>> map = new TreeMap<String, List<String>>();

		
		for (int i = 0; i < pairs.length - 1; i++) {
			for (int j = i + 1; j < pairs.length; j++) {
				if ((!pairs[i][0].equals(pairs[j][0]))) {
					String key = pairs[i][0] + "," + pairs[j][0];
					String course = pairs[i][1];

					List<String> courses = map.get(key);
					List<String> courses2 = map.get(pairs[j][0] + "," + pairs[i][0]);

					if (pairs[i][1].equals(pairs[j][1])) {
						if (courses == null && courses2 == null) {
							courses = new ArrayList<String>();
							courses.add(course);
							map.put(key, courses);
						} else if (courses != null) {
							courses.add(course);
						} else if (courses2 != null) {
							courses2.add(course);
						}
					} else {
						if (courses == null && courses2 == null) {
							courses = new ArrayList<String>();
							map.put(key, courses);
						}
					}
				}
			}
		}


		/*
		List<Entry<String, List<String>>> list = new ArrayList<>(map.entrySet());
		for (Entry<String, List<String>> entry : list) {
			System.out.println(entry.getKey() + ":" + entry.getValue().toString());
		}
		*/
		
		map.forEach((k, v)->System.out.println(k + ":" + v.toString()));

	}   
}

