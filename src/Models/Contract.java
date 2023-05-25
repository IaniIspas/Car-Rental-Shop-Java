package Models;

public class Contract {
    private int id;
    private int customer_id;
    private int employee_id;
    private int car_id;
    private String startDate;
    private String endDate;

    public Contract() {}

    public Contract(int id, int customer_id, int employee_id, int car_id, String startDate, String endDate) {
        this.id = id;
        this.customer_id = customer_id;
        this.employee_id = employee_id;
        this.car_id = car_id;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public void setCar_id(int car_id) {
        this.car_id = car_id;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public int getId() {
        return id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public int getCar_id() {
        return car_id;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }
    @Override
    public String toString() {
        return "Contract{" +
                "id=" + id +
                ", customer_id=" + customer_id +
                ", employee_id=" + employee_id +
                ", car_id=" + car_id +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                '}';
    }
}
