package com.ISA.ISAProject.Controller;

import com.ISA.ISAProject.Dto.*;
import com.ISA.ISAProject.Model.Company;
import com.ISA.ISAProject.Services.CompanyService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api/company")
public class CompanyController {

    @Autowired
    private CompanyService _companyService;

    @GetMapping("/getAll")
    public ResponseEntity<List<CompanyEquipmentDto>> getAllCompanies(){
        List<CompanyEquipmentDto> allCompanies = _companyService.getAllCompanies();
        return new ResponseEntity<>(allCompanies, HttpStatus.OK);
    }

    @GetMapping(value = "/{companyId}")
    @PreAuthorize("hasRole('COMPANYADMIN')")
    public ResponseEntity<CompanyEquipmentDto> getCompanyById(@PathVariable Integer companyId){
        Company company = _companyService.getById(companyId);
        CompanyEquipmentDto companyDto = new CompanyEquipmentDto(company);
        return new ResponseEntity<>(companyDto, HttpStatus.OK);
    }

    @GetMapping(value = "/name/{companyName}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<CompanyEquipmentDto> getCompanyByName(@PathVariable String companyName){
        Company company = _companyService.getByName(companyName);
        CompanyEquipmentDto companyDto = new CompanyEquipmentDto(company);
        return new ResponseEntity<>(companyDto, HttpStatus.OK);
    }

    @GetMapping("/getIdNameAll")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<CompanyIdNameDto>> getAllCompaniesIdName(){
        List<CompanyIdNameDto> allCompaniesIdName = _companyService.getAllCompaniesIdName();
        return new ResponseEntity<>(allCompaniesIdName, HttpStatus.OK);
    }

    @GetMapping(value = "/byGrade")
    public ResponseEntity<List<CompanyEquipmentDto>> getByGrade(@RequestParam String grade){
        List<CompanyEquipmentDto> byGradeCompanies = _companyService.getByGradeCompanies(grade);
        return new ResponseEntity<>(byGradeCompanies, HttpStatus.OK);

    }

    @PostMapping(value = "/registerCompany", consumes = "application/json")
    @PreAuthorize("hasRole('ADMIN')")
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<CompanyDto> registerCompany(@Valid @RequestBody CompanyDto companyDto) {
        try {

            CompanyDto newCompany = _companyService.registerCompany(companyDto);

            if (newCompany == null) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }else{
                return new ResponseEntity<>(newCompany, HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    /*
        @PostMapping("/create")
        public ResponseEntity<CompanyDto> createCompany(@RequestBody CompanyDto companyDto) {
            CompanyDto createdCompany = _companyService.createCompany(companyDto);

            if (createdCompany != null) {
                return new ResponseEntity<>(createdCompany, HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }

     */

    @PostMapping("/addEquipment/{companyId}")
    public ResponseEntity<CompanyEquipmentDto> addEquipmentToCompany(
            @PathVariable Integer companyId,
            @RequestBody EquipmentDto equipmentDto) {

        // Call CompanyService to add equipment to the company
        CompanyEquipmentDto updatedCompany = _companyService.addEquipmentToCompany(companyId, equipmentDto);

        if (updatedCompany != null) {
            return new ResponseEntity<>(updatedCompany, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    /*
    @PutMapping("/update/{companyId}")
    public ResponseEntity<CompanyDto> updateCompany(
            @PathVariable Integer companyId,
            @RequestBody CompanyDto updatedCompanyDto) {

        CompanyDto updatedCompany = _companyService.updateCompany(companyId, updatedCompanyDto);

        if (updatedCompany != null) {
            return new ResponseEntity<>(updatedCompany, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

     */

    @CrossOrigin
    @PutMapping(value = "/update/{oldCompanyName}")
    public ResponseEntity<Void> updateCompany(@PathVariable String oldCompanyName, @Valid @RequestBody CompanyDto companyDto) {
        Company company = _companyService.updateCompany(oldCompanyName, companyDto);
        if (company != null) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }



}
