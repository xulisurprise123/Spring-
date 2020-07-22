package com.itcast.pojo;

public class PointCut {
    private String employeeid;

    public String getEmployeeid() {
        return employeeid;
    }

    public void setEmployeeid(String employeeid) {
        this.employeeid = employeeid;
    }


    public void beforeISay() {
        System.out.println("before<" + employeeid + ">");
    }

    public void afterISay() {
        System.out.println("after<" + employeeid + ">");
    }
}
