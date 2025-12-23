package com.ramani.model;

public class Student {

    private final int rollNo;
    private final String name;
    private final double totalFee;
    private double paidFee;
    private FeeStatus feeStatus;

    public Student(int rollNo, String name, double totalFee) {
        this.rollNo = rollNo;
        this.name = name;
        this.totalFee = totalFee;
        this.paidFee = 0;
        this.feeStatus = FeeStatus.PENDING;
    }

    public void payFee(double amount){
        this.paidFee += amount;
        if(this.paidFee >= this.totalFee){
            this.feeStatus = FeeStatus.PAID;
        }
    }

    public double getRemainingFee(){
        return totalFee - paidFee;
    }

    public int getRollNo() {
        return rollNo;
    }

    public String getName() {
        return name;
    }

    public double getTotalFee() {
        return totalFee;
    }

    public double getPaidFee() {
        return paidFee;
    }

    public FeeStatus getFeeStatus() {
        return feeStatus;
    }

    @Override
    public String toString() {
        return "Student{" +
                "rollNo=" + rollNo +
                ", name='" + name + '\'' +
                ", totalFee=" + totalFee +
                ", paidFee=" + paidFee +
                ", feeStatus=" + feeStatus +
                '}';
    }
}
