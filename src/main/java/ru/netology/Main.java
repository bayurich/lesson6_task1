package ru.netology;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {

    // 1. функциональные интерфейсы и лямбда-выражения для написания детерминированных функций
    // 2. Stream API для реализации монад (выполнение последовательности более мелких операций без использования побочных эффектов и хранения промежуточных результатов)

    public static void main(String[] args) {

        Function<String, List<String>> myFunction = x -> {
            return Arrays.stream(x.split("\\s+"))
                    .map(y -> y.toLowerCase().replaceAll("[^а-яa-z]+",""))
                    .distinct()
                    .sorted()
                    .collect(Collectors.toList());
        };
        Consumer<List> printList = x -> x.stream().forEach(y -> System.out.println(y));


        String text = "Представьте, что вы попали на некоторый остров (вполне обитаемый), а местные жители пытаются с вами коммуницировать, записывая непонятные слова на бумажке. Вы хотите разобраться, что именно вам пишут и решаете начать с составления словаря.\n" +
                "\n" +
                "Задача заключается в том, чтобы написать генератор словаря аборигенов в функциональном стиле. Представьте, что у вас есть исходный текст сообщения местного жителя. Программа должна разбить текст на слова и отсортировать их в естесственном порядке. В комментариях укажите, какие отличительные черты функционального стиля присутствуют в вашей программе.\n" +
                "\n" +
                "Функция, которая составляет словарь, должна быть оформлена как реализатор Function";


        List<String> dictionary = myFunction.apply(text);
        printList.accept(dictionary);
    }
}
