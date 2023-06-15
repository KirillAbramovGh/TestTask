package com.test.task;

import java.util.*;

public class BracketsValidationService implements ValidationService {

    private static BracketsValidationService instance;

    public static BracketsValidationService getInstance() {
        if (instance == null) {
            instance = new BracketsValidationService();
        }
        return instance;
    }

    private final Map<Character, Character> bracketPairs = new HashMap<>();

    private BracketsValidationService() {
        bracketPairs.put(')', '(');
        bracketPairs.put('}', '{');
        bracketPairs.put(']', '[');
    }

    @Override
    public boolean isValid(String input) {
        Stack<Character> openingBrackets = new Stack<>();

        for (int position = 0; position < input.length(); position++) {
            char currentBracket = input.charAt(position);

            if (bracketPairs.containsValue(currentBracket)) {
                openingBrackets.push(currentBracket);
            } else if (bracketPairs.containsKey(currentBracket)) {
                if (openingBrackets.isEmpty() || openingBrackets.pop() != bracketPairs.get(currentBracket)) {
                    return false;
                }
            } else {
                throw new IllegalArgumentException("Строка может содержать только скобки (){}[]");
            }
        }

        return openingBrackets.isEmpty();
    }

    @Override
    public String getDescription(String candidate) {
        String description;
        try {
            if (isValid(candidate)) {
                description = getPairs(candidate).toString();
            } else {
                description = "Скобки в строке расставлены не корректно";
            }
        } catch (Exception e) {
            description = e.getMessage();
        }
        return description;
    }

    private List<BracketPair> getPairs(String input) {
        Stack<BracketPair> stack = new Stack<>();
        List<BracketPair> result = new LinkedList<>();

        for (int position = 0; position < input.length(); position++) {
            char currentBracket = input.charAt(position);

            if (bracketPairs.containsValue(currentBracket)) {
                stack.push(new BracketPair(currentBracket, position));
            } else if (bracketPairs.containsKey(currentBracket)) {
                BracketPair pair = stack.peek();
                if (stack.isEmpty() || pair.getOpeningBracket() != bracketPairs.get(currentBracket)) {
                    throw new RuntimeException("Строка не была провалидирована!");
                }
                stack.pop();
                pair.setClosingBracketAndPosition(currentBracket, position);
                result.add(pair);
            } else {
                throw new IllegalArgumentException("Строка может содержать только скобки (){}[]");
            }
        }

        if (!stack.isEmpty()) {
            throw new RuntimeException("Строка не была провалидирована!");
        }

        return result;
    }
}
