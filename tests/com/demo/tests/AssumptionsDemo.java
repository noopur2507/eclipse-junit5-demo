package com.demo.tests;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assumptions.*;

import java.io.File;

import org.junit.jupiter.api.Test;

class AssumptionsDemo {

	@Test
	void testOnlyOnMac() throws Exception {
		assumeTrue("macOS".equals(System.getProperty("os.name")), () -> {
			return "Aborting test: requires macOS, found " + System.getProperty("os.name");
		});

		// test code for macOS
		assertTrue(new File("/Volumes/").exists());
		
	}
	
	@Test
	void testOnAllSystems() throws Exception {
		assumingThat("macOS".equals(System.getProperty("os.name")), () -> {
			assertTrue(new File("/Volumes/").exists());
		});

		// test code for all systems
		assertTrue(1 + 1 == 2);
	}
	
}
