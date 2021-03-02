package com.example.annotations.example;

import com.example.annotations.example.anns.Constraints;
import com.example.annotations.example.anns.DBTable;
import com.example.annotations.example.anns.SQLInteger;
import com.example.annotations.example.anns.SQLString;
import com.example.annotations.example.pojo.Member;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TableCreator {

    public static String getConstraints(Constraints constraints){
        String constraintsProp = "";
        if (!constraints.allowNull()) {
            constraintsProp += " NOT NULL";
        }
        if (constraints.primaryKey()) {
            constraintsProp += " PRIMARY KEY";
        }
        if (constraints.unique()){
            constraintsProp += " UNIQUE";
        }
        return constraintsProp;
    }


    public static String createTable(String className) throws ClassNotFoundException {
        Class<?> clazz = Class.forName(className);
        // 获取DBTable注解
        DBTable dbTable = clazz.getAnnotation(DBTable.class);
        if (dbTable == null) {
            System.out.println("No DBTable annotations in class " + className);
            return null;
        }

        // 获取注解dbTable的name属性
        String tableName = dbTable.name();
        System.out.println(tableName);

        if (tableName.equals("")) {
            tableName = clazz.getName();
        }
        List<String> columns = new ArrayList<String>();
        // 获取Member所有的成员字段
        for(Field field:clazz.getDeclaredFields()){
            // 获取所有成员字段的字段注解
            Annotation[] fieldAnnotaion = field.getDeclaredAnnotations();

            for (Annotation annotation:fieldAnnotaion) {
                String columnName;
                if (annotation instanceof SQLInteger) {
                    // 如果获取到的字段的SQLInteger注解的name为""，则取字段的名称
                    if (((SQLInteger) annotation).name().equals("")){
                        columnName = field.getName();
                    } else {
                        columnName = ((SQLInteger) annotation).name();
                    }
                    columns.add(columnName + " INT " + getConstraints(((SQLInteger) annotation).constraint()));
                }
                if (annotation instanceof SQLString) {
                    if (((SQLString) annotation).name().equals("")){
                        columnName = field.getName();
                    } else {
                        columnName = ((SQLString) annotation).name();
                    }
                    columns.add(columnName + " VARCHAR(" + ((SQLString) annotation).value() + ")" + getConstraints(((SQLString) annotation).constraint()));
                }
            }
        }
        System.out.println(columns);
        return "123";
    }

    public static void main(String[] args) throws ClassNotFoundException {
        TableCreator.createTable("com.example.annotations.example.pojo.Member");
    }
}
