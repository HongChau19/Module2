package org.example;

public class Counter {
    private int counterId;
    private Customer customerCurrent;
    private boolean isBusy;

    public Counter(int counterId, boolean isBusy) {
        this.counterId = counterId;
        this.isBusy = isBusy;
        this.customerCurrent = null;
    }

    public int getCounterId() {
        return counterId;
    }

    public boolean isBusy() {
        return isBusy;
    }

    public Customer getCustomerCurrent() {
        return customerCurrent;
    }

    public void setCustomerCurrent(Customer customerCurrent) {
        this.customerCurrent = customerCurrent;
        this.isBusy = true;
        System.out.println("Quầy" + counterId + "đang phục vụ" + customerCurrent);
    }

    public void finishServing (){
        if (this.customerCurrent != null) {
            System.out.println("Quầy" + counterId + "hoàn tất phục vụ");
            this.customerCurrent = null;
            this.isBusy = false;
        } else {
            this.isBusy = false;
        }
    }
    @Override
    public String toString() {
        String status = isBusy ? "Bận" : "Rảnh";
        String customerInfo = (customerCurrent != null) ? " - " + customerCurrent.toString() : "";
        return "Quầy" + counterId + ": " + status + " - " + customerInfo;
    }
}
