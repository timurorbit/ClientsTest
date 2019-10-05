package ru.javawebinar.topjava.util;

import org.springframework.lang.Nullable;
import ru.javawebinar.topjava.model.Client;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class MealsUtil {
    public static final int DEFAULT_CALORIES_PER_DAY = 2000;
}