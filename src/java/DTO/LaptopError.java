/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.io.Serializable;

/**
 *
 * @author khang
 */
public class LaptopError implements Serializable{
    private String idError,nameError,priceError,CPUError,RamError,ScreenError,GraphicError,DiskError,OSError,WeightError,RegionError,yearError;

    public LaptopError() {
    }

    public LaptopError(String idError, String nameError, String priceError, String CPUError, String RamError, String ScreenError, String GraphicError, String DiskError, String OSError, String WeightError, String RegionError, String yearError) {
        this.idError = idError;
        this.nameError = nameError;
        this.priceError = priceError;
        this.CPUError = CPUError;
        this.RamError = RamError;
        this.ScreenError = ScreenError;
        this.GraphicError = GraphicError;
        this.DiskError = DiskError;
        this.OSError = OSError;
        this.WeightError = WeightError;
        this.RegionError = RegionError;
        this.yearError = yearError;
    }

    public String getIdError() {
        return idError;
    }

    public void setIdError(String idError) {
        this.idError = idError;
    }

    public String getNameError() {
        return nameError;
    }

    public void setNameError(String nameError) {
        this.nameError = nameError;
    }

    public String getPriceError() {
        return priceError;
    }

    public void setPriceError(String priceError) {
        this.priceError = priceError;
    }

    public String getCPUError() {
        return CPUError;
    }

    public void setCPUError(String CPUError) {
        this.CPUError = CPUError;
    }

    public String getRamError() {
        return RamError;
    }

    public void setRamError(String RamError) {
        this.RamError = RamError;
    }

    public String getScreenError() {
        return ScreenError;
    }

    public void setScreenError(String ScreenError) {
        this.ScreenError = ScreenError;
    }

    public String getGraphicError() {
        return GraphicError;
    }

    public void setGraphicError(String GraphicError) {
        this.GraphicError = GraphicError;
    }

    public String getDiskError() {
        return DiskError;
    }

    public void setDiskError(String DiskError) {
        this.DiskError = DiskError;
    }

    public String getOSError() {
        return OSError;
    }

    public void setOSError(String OSError) {
        this.OSError = OSError;
    }

    public String getWeightError() {
        return WeightError;
    }

    public void setWeightError(String WeightError) {
        this.WeightError = WeightError;
    }

    public String getRegionError() {
        return RegionError;
    }

    public void setRegionError(String RegionError) {
        this.RegionError = RegionError;
    }

    public String getYearError() {
        return yearError;
    }

    public void setYearError(String YearError) {
        this.yearError = YearError;
    }

    @Override
    public String toString() {
        return idError + "=" + nameError + "=" + priceError + "=" + CPUError + "=" + RamError + "=" + ScreenError + "=" + GraphicError + "=" + DiskError + "=" + OSError + "=" + WeightError + "=" + RegionError + "=" + yearError;
    }
    
}
