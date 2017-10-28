package com.demo.more.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestReporter;

class DependencyInjectionDemo {

	@Test
	@DisplayName("TestInfo demo")
	@Tag("my-tag")
	void testDependencyInjection(TestInfo testInfo) throws Exception {
		assertEquals("TestInfo demo", testInfo.getDisplayName());
		assertTrue(testInfo.getTags().contains("my-tag"));
	}

	@Test
	@DisplayName("TestReporter demo")
	void testDependencyInjection(TestReporter testReporter) {
		testReporter.publishEntry("a key", "a value");
	}

}
