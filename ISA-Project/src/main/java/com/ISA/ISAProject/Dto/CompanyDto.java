package com.ISA.ISAProject.Dto;

import com.ISA.ISAProject.Model.Company;


public class CompanyDto {
    private Integer id;
    private String name;
    private String adress;
    private String description;
    private String grade;

    //private List<EquipmentDto> equipmentSet;

    // Add default constructor
    public CompanyDto() {
    }

    public CompanyDto(Company company) {
        this.id = company.getId();
        this.name = company.getName();
        this.adress = company.getAddress();
        this.description = company.getDescription();
        this.grade = company.getGrade();

    /*    Hibernate.initialize(company.getEquipment());

        this.equipmentSet = new ArrayList<>(company.getEquipment().stream()
                .map(EquipmentDto::new)
                .collect(Collectors.toList()));*/

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String address){
        this.adress = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

  /*  public List<EquipmentDto> getEquipmentSet() {
        return equipmentSet;
    }

    public void setEquipmentSet(List<EquipmentDto> equipmentSet) {
        this.equipmentSet = equipmentSet;
    }*/

}
