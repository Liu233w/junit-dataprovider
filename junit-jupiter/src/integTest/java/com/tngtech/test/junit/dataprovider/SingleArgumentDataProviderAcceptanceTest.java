package com.tngtech.test.junit.dataprovider;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.TestTemplate;
import org.junit.jupiter.api.extension.ExtendWith;

import com.tngtech.junit.dataprovider.DataProvider;
import com.tngtech.junit.dataprovider.UseDataProvider;
import com.tngtech.junit.dataprovider.UseDataProviderExtension;

@ExtendWith(UseDataProviderExtension.class)
class SingleArgumentDataProviderAcceptanceTest {

    @DataProvider
    static Object[] dataProviderSingleArgObjectArray() {
        // @formatter:off
        return new Object[] {
            0,
            1,
            123,
        };
        // @formatter:on
    }

    @TestTemplate
    @UseDataProvider("dataProviderSingleArgObjectArray")
    void testSingleArgObjectArray(long l) {
        // Expected:
        assertThat(l).isNotEqualTo(1234);
    }

    @DataProvider
    static List<Object> dataProviderSingleArgListOfObject() {
        return Arrays.asList(null, "", "1", "123");
    }

    @TestTemplate
    @UseDataProvider("dataProviderSingleArgListOfObject")
    void testSingleArgListOfObject(String string) {
        // Expected:
        assertThat(string).isNotEqualTo("1234");
    }

    @DataProvider
    static Iterable<String> dataProviderSingleArgIterableOfString() {
        Set<String> result = new HashSet<>();
        result.add(null);
        result.add("");
        result.add("1");
        result.add("123");
        return result;
    }

    @TestTemplate
    @UseDataProvider
    void testSingleArgIterableOfString(String string) {
        // Expected:
        assertThat(string).isNotEqualTo("1234");
    }
}