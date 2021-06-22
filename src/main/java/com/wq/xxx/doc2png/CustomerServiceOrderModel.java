package com.wq.xxx;


import java.time.LocalTime;

/*
 * 客户服务单
 * Created by wuqiang on 2021/2/2
 */
public class CustomerServiceOrderModel {
    // 工单号
    private String workOrderNum;
    // 设备名称
    private String equipmentName;
    // 序列号
    private String serialNumber;
    // 保修情况
    private String warrantySituation;
    // 服务类型
    private String serviceType;
    // 客户名称
    private String customerName;
    // 联系电话
    private String contactPhone;
    // 联系人
    private String contactPersonName;
    // 设备地址
    private String deviceAddress;
    // 情况描述
    private String situationDesc;
    // 用户签字url
    private String userSign;
    // 日期
    private String userSignDate;
    // 检查过程和分析
    private String inspectionProcessAndAnalysis;
    // 服务开始时间
    private LocalTime startTime;
    // 服务结束时间
    private LocalTime endTime;
    // 服务满意评价
    private String serviceFeedBack;
    // 建议改进
    private String suggests;
    // 客户签字url
    private String customerSign;
    // 日期
    private String customerSignDate;
        
    private CustomerServiceOrderModel() {
    }
    
    public String getWorkOrderNum() {
        return workOrderNum;
    }
    
    public String getEquipmentName() {
        return equipmentName;
    }
    
    public String getSerialNumber() {
        return serialNumber;
    }
    
    public String getWarrantySituation() {
        return warrantySituation;
    }
    
    public String getServiceType() {
        return serviceType;
    }
    
    public String getCustomerName() {
        return customerName;
    }
    
    public String getContactPhone() {
        return contactPhone;
    }
    
    public String getContactPersonName() {
        return contactPersonName;
    }
    
    public String getDeviceAddress() {
        return deviceAddress;
    }
    
    public String getSituationDesc() {
        return situationDesc;
    }
    
    public String getUserSign() {
        return userSign;
    }
    
    public String getUserSignDate() {
        return userSignDate;
    }
    
    public String getInspectionProcessAndAnalysis() {
        return inspectionProcessAndAnalysis;
    }
    
    public LocalTime getStartTime() {
        return startTime;
    }
    
    public LocalTime getEndTime() {
        return endTime;
    }
    
    public String getServiceFeedBack() {
        return serviceFeedBack;
    }
    
    public String getSuggests() {
        return suggests;
    }
    
    public String getCustomerSign() {
        return customerSign;
    }
    
    public String getCustomerSignDate() {
        return customerSignDate;
    }
    
    @Override
    public String toString() {
        return "CustomerServiceOrderModel{" +
                "workOrderNum='" + workOrderNum + '\'' +
                ", equipmentName='" + equipmentName + '\'' +
                ", serialNumber='" + serialNumber + '\'' +
                ", warrantySituation='" + warrantySituation + '\'' +
                ", serviceType='" + serviceType + '\'' +
                ", customerName='" + customerName + '\'' +
                ", contactPhone='" + contactPhone + '\'' +
                ", contactPersonName='" + contactPersonName + '\'' +
                ", deviceAddress='" + deviceAddress + '\'' +
                ", situationDesc='" + situationDesc + '\'' +
                ", userSign='" + userSign + '\'' +
                ", userSignDate='" + userSignDate + '\'' +
                ", inspectionProcessAndAnalysis='" + inspectionProcessAndAnalysis + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", serviceFeedBack='" + serviceFeedBack + '\'' +
                ", suggests='" + suggests + '\'' +
                ", customerSign='" + customerSign + '\'' +
                ", customerSignDate='" + customerSignDate + '\'' +
                '}';
    }
    
    
    
    public static final class Builder {
        // 工单号
        private String workOrderNum = "";
        // 设备名称
        private String equipmentName = "";
        // 序列号
        private String serialNumber = "";
        // 保修情况
        private String warrantySituation = "";
        // 服务类型
        private String serviceType = "";
        // 客户名称
        private String customerName = "";
        // 联系电话
        private String contactPhone = "";
        // 联系人
        private String contactPersonName = "";
        // 设备地址
        private String deviceAddress = "";
        // 情况描述
        private String situationDesc = "";
        // 用户签字url
        private String userSign = "";
        // 日期
        private String userSignDate = "";
        // 检查过程和分析
        private String inspectionProcessAndAnalysis = "";
        // 服务开始时间
        private LocalTime startTime;
        // 服务结束时间
        private LocalTime endTime;
        // 服务满意评价
        private String serviceFeedBack = "";
        // 建议改进
        private String suggests = "";
        // 客户签字url
        private String customerSign = "";
        // 日期
        private String customerSignDate = "";
        
        private Builder() {
        }
        
        public static Builder builder() {
            return new Builder();
        }
        
        public Builder withWorkOrderNum(String workOrderNum) {
            this.workOrderNum = workOrderNum;
            return this;
        }
        
        public Builder withEquipmentName(String equipmentName) {
            this.equipmentName = equipmentName;
            return this;
        }
        
        public Builder withSerialNumber(String serialNumber) {
            this.serialNumber = serialNumber;
            return this;
        }
        
        public Builder withWarrantySituation(String warrantySituation) {
            this.warrantySituation = warrantySituation;
            return this;
        }
        
        public Builder withServiceType(String serviceType) {
            this.serviceType = serviceType;
            return this;
        }
        
        public Builder withCustomerName(String customerName) {
            this.customerName = customerName;
            return this;
        }
        
        public Builder withContactPhone(String contactPhone) {
            this.contactPhone = contactPhone;
            return this;
        }
        
        public Builder withContactPersonName(String contactPersonName) {
            this.contactPersonName = contactPersonName;
            return this;
        }
        
        public Builder withDeviceAddress(String deviceAddress) {
            this.deviceAddress = deviceAddress;
            return this;
        }
        
        public Builder withSituationDesc(String situationDesc) {
            this.situationDesc = situationDesc;
            return this;
        }
        
        public Builder withUserSign(String userSign) {
            this.userSign = userSign;
            return this;
        }
        
        public Builder withUserSignDate(String userSignDate) {
            this.userSignDate = userSignDate;
            return this;
        }
        
        public Builder withInspectionProcessAndAnalysis(String inspectionProcessAndAnalysis) {
            this.inspectionProcessAndAnalysis = inspectionProcessAndAnalysis;
            return this;
        }
        
        public Builder withStartTime(LocalTime startTime) {
            this.startTime = startTime;
            return this;
        }
        
        public Builder withEndTime(LocalTime endTime) {
            this.endTime = endTime;
            return this;
        }
        
        public Builder withServiceFeedBack(String serviceFeedBack) {
            this.serviceFeedBack = serviceFeedBack;
            return this;
        }
        
        public Builder withSuggests(String suggests) {
            this.suggests = suggests;
            return this;
        }
        
        public Builder withCustomerSign(String customerSign) {
            this.customerSign = customerSign;
            return this;
        }
        
        public Builder withCustomerSignDate(String customerSignDate) {
            this.customerSignDate = customerSignDate;
            return this;
        }
        
        public CustomerServiceOrderModel build() {
            CustomerServiceOrderModel customerServiceOrderModel = new CustomerServiceOrderModel();
            customerServiceOrderModel.customerName = this.customerName;
            customerServiceOrderModel.startTime = this.startTime;
            customerServiceOrderModel.serviceType = this.serviceType;
            customerServiceOrderModel.warrantySituation = this.warrantySituation;
            customerServiceOrderModel.customerSignDate = this.customerSignDate;
            customerServiceOrderModel.contactPhone = this.contactPhone;
            customerServiceOrderModel.serialNumber = this.serialNumber;
            customerServiceOrderModel.equipmentName = this.equipmentName;
            customerServiceOrderModel.userSignDate = this.userSignDate;
            customerServiceOrderModel.inspectionProcessAndAnalysis = this.inspectionProcessAndAnalysis;
            customerServiceOrderModel.endTime = this.endTime;
            customerServiceOrderModel.workOrderNum = this.workOrderNum;
            customerServiceOrderModel.customerSign = this.customerSign;
            customerServiceOrderModel.situationDesc = this.situationDesc;
            customerServiceOrderModel.userSign = this.userSign;
            customerServiceOrderModel.serviceFeedBack = this.serviceFeedBack;
            customerServiceOrderModel.deviceAddress = this.deviceAddress;
            customerServiceOrderModel.contactPersonName = this.contactPersonName;
            customerServiceOrderModel.suggests = this.suggests;
            return customerServiceOrderModel;
        }
    }
}