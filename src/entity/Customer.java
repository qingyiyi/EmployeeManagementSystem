package entity;

import java.util.Date;

public class Customer {
    private int id;
    private String interest;
    private Date addTime;
    private String website;
    private String companyName;
    private String companyAddress;
    private String contactPerson;
    private String contactNumber;
    private String contactResult;
    private String employee;

    public int getId() { return id;  }

    public void setId(int id) {this.id = id;}

    public String getInterest() {return interest;}

    public void setInterest(String interest) {this.interest = interest;}

    public Date getAddTime() {return addTime;}

    public void setAddTime(Date addTime) {this.addTime = addTime;}

    public String getWebsite() {return website;}

    public void setWebsite(String website) {this.website = website;}

    public String getCompanyName() {return companyName;}

    public void setCompanyName(String companyName) {this.companyName = companyName;}

    public String getCompanyAddress() {return companyAddress;}

    public void setCompanyAddress(String companyAddress) {this.companyAddress = companyAddress;}

    public String getContactPerson() {return contactPerson;}

    public void setContactPerson(String contactPerson) {this.contactPerson = contactPerson;}

    public String getContactNumber() {return contactNumber;}

    public void setContactNumber(String contactNumber) {this.contactNumber = contactNumber;}

    public String getContactResult() {return contactResult;}

    public void setContactResult(String contactResult) {this.contactResult = contactResult;}

    public String getEmployee() {return employee;}

    public void setEmployee(String employee) {this.employee = employee;}

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", interest='" + interest + '\'' +
                ", addTime=" + addTime +
                ", website='" + website + '\'' +
                ", companyName='" + companyName + '\'' +
                ", companyAddress='" + companyAddress + '\'' +
                ", contactPerson='" + contactPerson + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                ", contactResult='" + contactResult + '\'' +
                ", employee='" + employee + '\'' +
                '}';
    }
}
