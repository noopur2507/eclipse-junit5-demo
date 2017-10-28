package com.demo.more.tests;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class ParameterizedTestsDemo {

	@ParameterizedTest
	@ValueSource(strings = { "X", "Y" })
	@EnumSource(value = TimeUnit.class, names = {"HOURS", "DAYS"})
	@MethodSource("stringProvider")
	@CsvSource({ "A, 1", "'B, C', 2" })
	@CsvFileSource(resources = "/two-column.csv")
	@ArgumentsSource(MyArgumentsProvider.class)
	void parameterizedTest(Object argument) {
		assertNotNull(argument);
	}

	static Stream<String> stringProvider() {
		return Stream.of("foo", "bar");
	}

	static class MyArgumentsProvider implements ArgumentsProvider {

		@Override
		public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
			return Stream.of("one", "two").map(Arguments::of);
		}
	}
}
