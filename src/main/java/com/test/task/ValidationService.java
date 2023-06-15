package com.test.task;

public interface ValidationService {
    boolean isValid(String candidate);

    String getDescription(String candidate);
}
