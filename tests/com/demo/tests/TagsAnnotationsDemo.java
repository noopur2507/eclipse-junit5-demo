package com.demo.tests;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TagsAnnotationsDemo {

	@Test
	@Tag("fast")
	@DisplayName("Fast test")
	void testFastTagged() {
	}

	@Test
	@Tag("slow")
	@DisplayName("Slow test")
	void testSlowComposed() {
	}

}

@Target({ ElementType.TYPE, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Test
@Tag("slow")
@interface SlowTest {
}
