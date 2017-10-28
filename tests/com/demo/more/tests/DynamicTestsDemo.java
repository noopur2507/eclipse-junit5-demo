package com.demo.more.tests;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.DynamicContainer.*;
import static org.junit.jupiter.api.DynamicTest.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.DynamicNode;
import org.junit.jupiter.api.TestFactory;

class DynamicTestsDemo {
	
	// test_factory template
	
	@TestFactory
	Stream<DynamicNode> dynamicTests() throws Exception {
		return Stream.of("A", "B").map(input -> 
			dynamicContainer("Container " + input, 
				Stream.of(1, 2).map(number -> 
					dynamicTest("dynamic test for " + number, () -> isEven(number)))));
	}

	private void isEven(int i) {
		assertTrue(i % 2 == 0, () -> i + " is not an even number.");
	}

}
