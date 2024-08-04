package ru.javaboys.expoforce.entity;

import io.jmix.core.annotation.DeletedBy;
import io.jmix.core.annotation.DeletedDate;
import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigInteger;
import java.time.OffsetDateTime;
import java.util.UUID;

@JmixEntity
@Table(name = "CLIENT")
@Entity
public class Client {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @Column(name = "GENDER")
    private String gender;

    @Column(name = "AGE")
    private Integer age;

    @Column(name = "EDUCATION")
    private String education;

    @Column(name = "CITY_OF_RESIDENCE")
    private String cityOfResidence;

    @Column(name = "POSITION_")
    private String position;

    @Column(name = "HAVE_FOREIGN_PASSPORT")
    private Boolean haveForeignPassport;

    @Column(name = "HAVE_DRIVER_LICENSE")
    private Boolean haveDriverLicense;

    @Column(name = "SENIORITY")
    private Integer seniority;

    @Column(name = "INCOME_AMOUNT", precision = 19)
    private BigInteger incomeAmount;

    @Column(name = "EMPLOYMENT_TYPE")
    private String employmentType;

    @Column(name = "MARRIED")
    private Boolean married;

    @Column(name = "AMOUNT_OF_CHILDREN")
    private Integer amountOfChildren;

    @Column(name = "HAVE_OWN_HOME")
    private Boolean haveOwnHome;

    @Column(name = "WORK_ORGANIZATION")
    private String workOrganization;

    @InstanceName
    @Column(name = "NAME")
    private String name;

    @Column(name = "MIDDLE_NAME")
    private String middleName;

    @Column(name = "PHONE", length = 20)
    private String phone;

    @Column(name = "EMAIL", length = 100)
    private String email;

    @Column(name = "PASSPORT_NUMBER", length = 20)
    private String passportNumber;

    @Column(name = "DRIVER_LICENSE_NUMBER", length = 20)
    private String driverLicenseNumber;

    @Column(name = "SURNAME")
    private String surname;

    @DeletedBy
    @Column(name = "DELETED_BY")
    private String deletedBy;

    @DeletedDate
    @Column(name = "DELETED_DATE")
    private OffsetDateTime deletedDate;

    public String getWorkOrganization() {
        return workOrganization;
    }

    public void setWorkOrganization(String organization) {
        this.workOrganization = organization;
    }

    public Boolean getHaveOwnHome() {
        return haveOwnHome;
    }

    public void setHaveOwnHome(Boolean haveOwnHome) {
        this.haveOwnHome = haveOwnHome;
    }

    public Integer getAmountOfChildren() {
        return amountOfChildren;
    }

    public void setAmountOfChildren(Integer amountOfChildren) {
        this.amountOfChildren = amountOfChildren;
    }

    public Boolean getMarried() {
        return married;
    }

    public void setMarried(Boolean married) {
        this.married = married;
    }

    public EmploymentType getEmploymentType() {
        return employmentType == null ? null : EmploymentType.fromId(employmentType);
    }

    public void setEmploymentType(EmploymentType employmentType) {
        this.employmentType = employmentType == null ? null : employmentType.getId();
    }

    public BigInteger getIncomeAmount() {
        return incomeAmount;
    }

    public void setIncomeAmount(BigInteger incomeAmount) {
        this.incomeAmount = incomeAmount;
    }

    public Integer getSeniority() {
        return seniority;
    }

    public void setSeniority(Integer seniority) {
        this.seniority = seniority;
    }

    public Boolean getHaveDriverLicense() {
        return haveDriverLicense;
    }

    public void setHaveDriverLicense(Boolean haveDriverLicense) {
        this.haveDriverLicense = haveDriverLicense;
    }

    public Boolean getHaveForeignPassport() {
        return haveForeignPassport;
    }

    public void setHaveForeignPassport(Boolean haveForeignPassport) {
        this.haveForeignPassport = haveForeignPassport;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getCityOfResidence() {
        return cityOfResidence;
    }

    public void setCityOfResidence(String cityOfResidence) {
        this.cityOfResidence = cityOfResidence;
    }

    public Education getEducation() {
        return education == null ? null : Education.fromId(education);
    }

    public void setEducation(Education education) {
        this.education = education == null ? null : education.getId();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender == null ? null : Gender.fromId(gender);
    }

    public void setGender(Gender gender) {
        this.gender = gender == null ? null : gender.getId();
    }

    public String getDriverLicenseNumber() {
        return driverLicenseNumber;
    }

    public void setDriverLicenseNumber(String driverLicenseNumber) {
        this.driverLicenseNumber = driverLicenseNumber;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public OffsetDateTime getDeletedDate() {
        return deletedDate;
    }

    public void setDeletedDate(OffsetDateTime deletedDate) {
        this.deletedDate = deletedDate;
    }

    public String getDeletedBy() {
        return deletedBy;
    }

    public void setDeletedBy(String deletedBy) {
        this.deletedBy = deletedBy;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}