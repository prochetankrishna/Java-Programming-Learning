package java8.streams;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamMethods {

    public static void main(String[] args) {

        List<String> cityList = new ArrayList<>();
        cityList.add("New Delhi");
        cityList.add("Mumbai");
        cityList.add("New York");
        cityList.add("Washington");
        cityList.add("New Jersey");
        cityList.add("Kolkata");
        cityList.add("London");
        cityList.add("Amsterdam");
        cityList.add("Sydney");

        List<String> cityStartsWithNew = cityList.stream().filter(cityName -> cityName.startsWith("New")).collect(Collectors.toList());

        System.out.println("*******************************************************************");
        cityStartsWithNew.forEach(cityName -> System.out.println(cityName));
        System.out.println("*******************************************************************");

        HashMap<String, String> cityCountryMap = new HashMap<>();
        cityCountryMap.put("New Delhi", "India");
        cityCountryMap.put("New York", "United States of America");
        cityCountryMap.put("New Jersey", "United States of America");

        List<String> cityCountryList = cityStartsWithNew.stream()
                                    .map(cityName -> cityName + " is in " + cityCountryMap.get(cityName))
                                    .collect(Collectors.toList());
        System.out.println("*******************************************************************");
        cityCountryList.forEach(cityCountry -> System.out.println(cityCountry));
        System.out.println("*******************************************************************");

        Long cityCountInUSA = cityStartsWithNew.stream()
                .filter(cityName -> cityCountryMap.get(cityName).equals("United States of America"))
                .count();
        System.out.println("*******************************************************************");
        System.out.println("There are " + cityCountInUSA + " cities starting with 'New' in United States of America");
        System.out.println("*******************************************************************");

        //Sorting Default Order
        List<String> sortedCityListAsc = cityList.stream().sorted().collect(Collectors.toList());
        System.out.println("*******************************************************************");
        sortedCityListAsc.forEach(cityName -> System.out.println(cityName));
        System.out.println("*******************************************************************");

        //Sorting Descending Order
        List<String> sortedCityListDesc = cityList.stream()
                    .sorted((cityOne, cityTwo) -> -cityOne.compareTo(cityTwo))
                    .collect(Collectors.toList());
        System.out.println("*******************************************************************");
        sortedCityListDesc.forEach(cityName -> System.out.println(cityName));
        System.out.println("*******************************************************************");

        System.out.println("*******************************************************************");
        String firstCityNameAscendingOrder = cityList.stream()
                                    .min((cityOne, cityTwo) -> cityOne.compareTo(cityTwo)).get();
        System.out.println("First City Name in Ascending Order : " + firstCityNameAscendingOrder);

        String lastCityNameAscendingOrder = cityList.stream()
                .max((cityOne, cityTwo) -> cityOne.compareTo(cityTwo)).get();
        System.out.println("Last City Name in Ascending Order : " + lastCityNameAscendingOrder);
        System.out.println("*******************************************************************");

        System.out.println("*******************************************************************");
        String firstCityNameDescendingOrder = cityList.stream()
                .min((cityOne, cityTwo) -> -cityOne.compareTo(cityTwo)).get();
        System.out.println("First City Name in Descending Order : " + firstCityNameDescendingOrder);

        String lastCityNameDescendingOrder = cityList.stream()
                .max((cityOne, cityTwo) -> -cityOne.compareTo(cityTwo)).get();
        System.out.println("Last City Name in Descending Order : " + lastCityNameDescendingOrder);
        System.out.println("*******************************************************************");

        System.out.println("*******************************************************************");
        //ToArray
        String[] cityNames = cityList.stream().toArray(String[]::new);
        for (String eachCityName : cityNames) {
            System.out.println(eachCityName);
        }
        System.out.println("*******************************************************************");

        System.out.println("*******************************************************************");
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5);
        integerStream.forEach(eachNumber -> System.out.println(eachNumber));
        Double[] doubles = {100.0, 101.0, 102.0, 103.0, 104.0};
        Stream.of(doubles).forEach(eachDouble -> System.out.println(eachDouble));
        System.out.println("*******************************************************************");

        System.out.println("*******************************************************************");
        //Reduce Method
        /*
        T reduce(T identity, BinaryOperator<T> accumulator);
        Where, identity is initial value of type T and accumulator is a function for combining two values.
         */
        List<String> programmingLanguagesList = new ArrayList<>();
        programmingLanguagesList.add("Java");
        programmingLanguagesList.add("C++");
        programmingLanguagesList.add("Python");
        programmingLanguagesList.add("JavaScript");
        programmingLanguagesList.add("C");
        Optional<String> longestString = programmingLanguagesList.stream()
                                    .reduce((languageOne, languageTwo) -> languageOne.length() > languageTwo.length() ? languageOne : languageTwo);
        if (longestString.isPresent()) {
            System.out.println(longestString.get());
        }

        Optional<String> programmingLanguageConcat = programmingLanguagesList.stream()
                                .reduce((languageOne, languageTwo) -> languageOne + " - " + languageTwo);
        if (programmingLanguageConcat.isPresent()) {
            System.out.println(programmingLanguageConcat.get());
        }

        List<Integer> array = Arrays.asList(-2, 0, 4, 6, 8);
        int sum = array.stream().reduce(0, (numberOne, numberTwo) -> numberOne + numberTwo);
        System.out.println(sum);
        System.out.println("*******************************************************************");
    }
}
