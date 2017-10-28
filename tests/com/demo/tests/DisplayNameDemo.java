package com.demo.tests;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("My special test ☺ ♫")
class DisplayNameDemo {

	@DisplayName("(⊃｡•́‿•̀｡)⊃━☆★ﾟ.*･｡ﾟ")
	@Test
	void testName() throws Exception {
		assertTrue(true);
	}
}
