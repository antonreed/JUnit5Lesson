package com.antonreed;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Triangle {
    private static final Logger logger = LoggerFactory.getLogger(Triangle.class);

    public static Double calculateSquare(int a, int b, int c) {
        double square = 0;
        try {
            double semiPerimeter = (a + b + c) / 2;
            square = Math.sqrt(semiPerimeter *
                    (semiPerimeter - a) *
                    (semiPerimeter - b) -
                    (semiPerimeter - c));
            logger.info("Площадь треугольника посчитана.");
        } catch (Exception e) {
            logger.error("Во время расчёта площади произошла ошибка.");
        }
        return square;
    }
}