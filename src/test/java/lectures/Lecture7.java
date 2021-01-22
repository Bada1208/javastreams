package lectures;


import static org.assertj.core.api.Assertions.assertThat;

import beans.Car;
import beans.Person;
import com.google.common.collect.ImmutableList;

import java.math.BigDecimal;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

import mockdata.MockData;
import org.junit.Test;

public class Lecture7 {

    @Test
    public void count() throws Exception {
        Long count = MockData.getPeople().stream()
                .filter(person -> person.getGender().equalsIgnoreCase("female"))
                .count();
        System.out.println(count);
    }

    @Test
    public void min() throws Exception {
        Double minPrice = MockData.getCars().stream()
                .filter(car -> car.getColor().equalsIgnoreCase("red"))
                .mapToDouble(Car::getPrice)
                .min()
                .orElse(0);
        System.out.println(minPrice);
    }

    @Test
    public void max() throws Exception {
        Double maxPrice = MockData.getCars().stream()
                .filter(car -> car.getColor().equalsIgnoreCase("red"))
                .mapToDouble(Car::getPrice)
                .max()
                .orElse(0);
        System.out.println(maxPrice);
    }


    @Test
    public void average() throws Exception {
        List<Car> cars = MockData.getCars();
        Double averagePrice = MockData.getCars().stream()
                .filter(car -> car.getColor().equalsIgnoreCase("red"))
                .mapToDouble(Car::getPrice)
                .average()
                .getAsDouble();
        System.out.println(averagePrice);

    }

    @Test
    public void sum() throws Exception {
        List<Car> cars = MockData.getCars();
        double sum = cars.stream()
                .mapToDouble(Car::getPrice)
                .sum();
        BigDecimal bigDecimalSum = BigDecimal.valueOf(sum);
        System.out.println(sum);
        System.out.println(bigDecimalSum);

    }

    @Test
    public void statistics() throws Exception {
        List<Car> cars = MockData.getCars();
        DoubleSummaryStatistics statistics = cars.stream()
                .mapToDouble(Car::getPrice)
                .summaryStatistics();
        System.out.println(statistics);
        System.out.println(statistics.getMin());
        System.out.println(statistics.getMax());
        System.out.println(statistics.getAverage());
        System.out.println(statistics.getSum());
        System.out.println(statistics.getCount());
    }

}