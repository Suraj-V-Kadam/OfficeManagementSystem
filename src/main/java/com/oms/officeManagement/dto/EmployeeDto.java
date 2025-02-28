package com.oms.officeManagement.dto;




public class EmployeeDto {

    private Long id;
    private String name;
    private Integer age;
    private String emailId;
    private Long mobileNumber;

    public EmployeeDto() {
    }

    public EmployeeDto(Long id, String name, Integer age, String emailId, Long mobileNumber) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.emailId = emailId;
        this.mobileNumber = mobileNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public Long getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(Long mobileNumber) {
        this.mobileNumber = mobileNumber;
    }
}
