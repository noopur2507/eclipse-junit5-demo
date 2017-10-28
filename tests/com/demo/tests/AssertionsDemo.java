package com.demo.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;

import org.junit.jupiter.api.Test;

import com.demo.src.Person;

class AssertionsDemo {

	@Test
	void testStandardAssertions() {
		// Failure message comes at the end of arguments list
		assertTrue("".isEmpty(), "Should be empty.");
		
		// Failure message can be retrieved lazily
		assertTrue("".isEmpty(), () -> evaluateFailureMessage());
	}

	private String evaluateFailureMessage() {
		// expensive evaluation of the failure message...
		return "Evaluated message: " + "Should be empty.";
	}

	@Test
	void testGroupedAssertions() {
		Person p= new Person("Johny", "Depp", 30); 
		// execute all assertions and report all failures together
		assertAll("Person details",
				() -> assertEquals("Johnny", p.getFirstName()),
				() -> assertEquals("Depp", p.getLastName()),
				() -> assertEquals(53, p.getAge()));
	}

	@Test
	void testException() {
		// assert and evaluate a thrown exception
		Exception exception = assertThrows(StringIndexOutOfBoundsException.class, () -> printSubstring(-1));
		assertEquals(exception.getMessage(), "String index out of range: -1");
	}

	private void printSubstring(int a) {
		System.out.println("".substring(a));
	}

	@Test
	void testTimeoutExceeded() {
		// assert that execution of given task completes before given timeout
		assertTimeout(Duration.ofMillis(10), () -> {
			Thread.sleep(50); // task taking more than 10 ms
		});
	}

	@Test
	void testTimeoutExceededAndAborted() {
		// executed in a different thread and preemptively aborted if timeout is exceeded
		assertTimeoutPreemptively(Duration.ofMillis(10), () -> {
			Thread.sleep(50); // task taking more than 10 ms
		});
	}

}
