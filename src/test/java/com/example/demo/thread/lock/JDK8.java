package com.example.demo.thread.lock;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Month;
import java.util.stream.Stream;

public class JDK8 {
	public static void main(String[] args){
		
        Instant start = Instant.now();
        
        String[] strArr = { "Java8", "new", "feature", "Stream", "API" };
        long count = 0;
        for (String s : strArr) {
            if (s.length() > 3)
                count++;
        }
        count = Stream.of(strArr).filter(w -> w.length() > 3).count();
        
        
        Instant end = Instant.now();
        Duration timeElapsed = Duration.between(start, end);
        long millis = timeElapsed.toMillis();
        System.out.println(millis);
        
        
        LocalDate today = LocalDate.now();
        LocalDate myBirthday = LocalDate.of(1994, 03, 15);
        // use Enum
        myBirthday = LocalDate.of(1994, Month.MARCH, 15);

        System.out.println(today);
        System.out.println(myBirthday); // 1994-03-15
        
        String joined = String.join(".", "www", "cnblogs", "com");
        System.out.println(joined); // www.cnblogs.com
	}
}
