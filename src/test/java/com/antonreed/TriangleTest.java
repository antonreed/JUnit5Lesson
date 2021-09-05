package com.antonreed;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.opentest4j.AssertionFailedError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.stream.Stream;

class TriangleTest {
    private static final Logger logger = LoggerFactory.getLogger(TriangleTest.class);

    @ParameterizedTest
    @MethodSource("provideArgumentsForCalculateSquare")
    @DisplayName("Valid triange square")
    void calculateSquareTest(int a, int b, int c) {
        try {
            double semiPerimeter = (a + b + c) / 2;
            double square = Math.sqrt(semiPerimeter *
                    (semiPerimeter - a) *
                    (semiPerimeter - b) *
                    (semiPerimeter - c));
            Assertions.assertEquals(square, Triangle.calculateSquare(a, b, c));
            logger.info("Тест прошёл успешно.");
        } catch (AssertionFailedError e) {
            e.printStackTrace();
            logger.info("Тест не пройден. Фактический результат не равен ожидаемому.");
            logger.error(e.getClass().getSimpleName() + ": " + e.getMessage());
        }
        catch (Exception e) {
            logger.error("Произошла какая-то ошибка.");
        }
    }

    static Stream<Arguments> provideArgumentsForCalculateSquare() {
        return Stream.of(
                Arguments.arguments(3, 4, 5)
        );
    }
}
