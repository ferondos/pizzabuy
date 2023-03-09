package com.academy.utils;

import java.util.HashMap;
import java.util.Map;

public class MethodCallCounter {

    private static Map<String, Integer> methodCalls = new HashMap<>();

    public static void addMethod(String methodName) {
        Integer nodeValue = methodCalls.get(methodName);
        if (!methodCalls.containsKey(methodName)) {
            methodCalls.put(methodName, 1);
        } else {
            methodCalls.replace(methodName, ++nodeValue);
        }
    }

    public static Map<String, Integer> getMethodCalls() {
        return methodCalls;
    }
    public static void printMethodCallsOnConsole(){
        for (Map.Entry<String, Integer> node : MethodCallCounter.getMethodCalls().entrySet()) {
            System.out.println("Method "
                    + node.getKey()
                    + " executed "
                    + node.getValue()
                    + " times");
        }
    }
}
