package com.rays.form;

import java.util.Date;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.AssetDTO;

public class AssetForm extends BaseForm {

    @NotEmpty(message = "Please enter the registration number")
    private String registrationNumber;

    @PastOrPresent(message = "Acquisition date must be today or in the past")
    @NotNull(message = "Please enter acquisition date")
    private Date acquisitionDate;

    @NotNull(message = "Please enter coverage amount")
    @Min(value = 1, message = "Coverage amount should be more than 1")
    @Max(value = 999999, message = "Coverage amount should have only 6 digits")
    private Integer coverageAmount;

    @NotEmpty(message = "Please select a paint color")
    private String paintColor;

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public Date getAcquisitionDate() {
        return acquisitionDate;
    }

    public void setAcquisitionDate(Date acquisitionDate) {
        this.acquisitionDate = acquisitionDate;
    }

    public Integer getCoverageAmount() {
        return coverageAmount;
    }

    public void setCoverageAmount(Integer coverageAmount) {
        this.coverageAmount = coverageAmount;
    }

    public String getPaintColor() {
        return paintColor;
    }

    public void setPaintColor(String paintColor) {
        this.paintColor = paintColor;
    }

    @Override
    public BaseDTO getDto() {
        AssetDTO dto = initDTO(new AssetDTO());
        dto.setRegistrationNumber(registrationNumber);
        dto.setAcquisitionDate(acquisitionDate);
        dto.setCoverageAmount(coverageAmount);
        dto.setPaintColor(paintColor);
        return dto;
    }
}
