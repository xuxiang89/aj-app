package com.anjian.app.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableLogic;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.List;


/**
 * 部门管理
 */
@TableName("sys_dept")
public class SysDeptEntity implements Serializable ,Comparable<SysDeptEntity>{
    private static final long serialVersionUID = 1L;

    //部门ID
    @TableId
    //@JsonSerialize(using = ToStringSerializer.class)
    private Long deptId;
    //部门或地区编码
    private String deptCode;
    //部门或地区编码
    @TableField(exist = false)
    private String codeName;
    //上级部门ID，一级部门为0
    //@JsonSerialize(using = ToStringSerializer.class)
    private Long parentId;

    /**
     * 虚拟标识：存在一个虚拟的部门，用来查询所有下级部门中的数据；
     */
    private int virtualFlag;
    //是否可选
    @TableField(exist = false)
    private String isSelect="Y";
    //部门名称
    private String name;
    /**
     * 部门简称
     */
    private String abbName;
    //上级部门名称
    @TableField(exist = false)
    private String parentName;
    //排序
    private Integer orderNum;
    //区域的名称
    private String areaName;
    /**
     * 部门地址
     */
    private String deptAddress;
    /**
     * 部门邮政编码
     */
    private String postCode;
    /**
     * 人民政府
     */
    private String government;
    /**
     * 人民政府地址
     */
    private String governmentAddress;
    /**
     * 复议安监局
     */
    private String bureau;
    /**
     * 复议安监局地址
     */
    private String bureauAddress;
    /**
     * 诉讼人民法院
     */
    private String court;
    /**
     * 诉讼人民法院地址
     */
    private String courtAddress;
    /**
     * 缴款银行
     */
    private String bank;
    /**
     * 缴款银行地址
     */
    private String bankAddress;
    /**
     * 缴款银行账号
     */
    private String bankAccount;
    @TableLogic
    private Integer delFlag;
    /**
     * ztree属性
     */
    @TableField(exist = false)
    private Boolean open;
    @TableField(exist = false)
    private List<SysDeptEntity> list;

    @TableField(exist = false)
    //@JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    @TableField(exist = false)
    //@JsonSerialize(using = ToStringSerializer.class)
    private List<SysDeptEntity> children;

    @TableField(exist = false)
    //@JsonSerialize(using = ToStringSerializer.class)
    private String label;

    /**
     * 上级信息
     */
    @TableField(exist = false)
    private SysDeptEntity parent;
    /**
     * 当前部门的deptCode和所有父级deptCode组成的字符串（逗号分隔），如：
     * 若当前部门code为（32020201），则该字段值为：3202/320202/32020201
     */
    @TableField(exist = false)
    private String deptCodesIncludeUppers;
    /**
     * 部门级别(1-5)，对应省级部门、市级部门、县区级部门、街道部门(省级部门暂时用不到)
     */
    private int level;

    public String getIsSelect() {
        return isSelect;
    }

    public void setIsSelect(String isSelect) {
        this.isSelect = isSelect;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getDeptAddress() {
        return deptAddress;
    }

    public void setDeptAddress(String deptAddress) {
        this.deptAddress = deptAddress;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getAbbName() {
        return abbName;
    }

    public void setAbbName(String abbName) {
        this.abbName = abbName;
    }

    public String getCodeName() {
        return codeName;
    }

    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }

    public Long getId() {
        return deptId;
    }

    public List<SysDeptEntity> getChildren() {
        return list;
    }

    public void setChildren(List<SysDeptEntity> children) {
        this.children = children;
    }

    public String getLabel() {
        return name;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public Long getDeptId() {
        return deptId;
    }

    public String getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
    }

    /**
     * 设置：上级部门ID，一级部门为0
     */
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    /**
     * 获取：上级部门ID，一级部门为0
     */
    public Long getParentId() {
        return parentId;
    }

    /**
     * 设置：部门名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取：部门名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置：排序
     */
    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    /**
     * 获取：排序
     */
    public Integer getOrderNum() {
        return orderNum;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public Boolean getOpen() {
        return open;
    }

    public void setOpen(Boolean open) {
        this.open = open;
    }

    public List<SysDeptEntity> getList() {
        return list;
    }

    public void setList(List<SysDeptEntity> list) {
        this.list = list;
    }

    public int getVirtualFlag() {
        return virtualFlag;
    }

    public void setVirtualFlag(int virtualFlag) {
        this.virtualFlag = virtualFlag;
    }

    public String getGovernment() {
        return government;
    }

    public void setGovernment(String government) {
        this.government = government;
    }

    public String getGovernmentAddress() {
        return governmentAddress;
    }

    public void setGovernmentAddress(String governmentAddress) {
        this.governmentAddress = governmentAddress;
    }

    public String getBureau() {
        return bureau;
    }

    public void setBureau(String bureau) {
        this.bureau = bureau;
    }

    public String getBureauAddress() {
        return bureauAddress;
    }

    public void setBureauAddress(String bureauAddress) {
        this.bureauAddress = bureauAddress;
    }

    public String getCourt() {
        return court;
    }

    public void setCourt(String court) {
        this.court = court;
    }

    public String getCourtAddress() {
        return courtAddress;
    }

    public void setCourtAddress(String courtAddress) {
        this.courtAddress = courtAddress;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getBankAddress() {
        return bankAddress;
    }

    public void setBankAddress(String bankAddress) {
        this.bankAddress = bankAddress;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public SysDeptEntity getParent() {
        return parent;
    }

    public void setParent(SysDeptEntity parent) {
        this.parent = parent;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getDeptCodesIncludeUppers() {
        return deptCodesIncludeUppers;
    }

    public void setDeptCodesIncludeUppers(String deptCodesIncludeUppers) {
        this.deptCodesIncludeUppers = deptCodesIncludeUppers;
    }

    public void genDeptCodesIncludeUppers() {
        String deptCodesStr = this.deptCode;
        SysDeptEntity theDept = this;
        while(theDept.getParent() != null) {
            deptCodesStr = theDept.getParent().getDeptCode() + "," + deptCodesStr;
            theDept = theDept.getParent();
        }
        this.deptCodesIncludeUppers = deptCodesStr;
    }

    @Override
    public int hashCode(){
        return deptId.hashCode();
    }

    @Override
    public boolean equals(Object obj){
        if(obj instanceof SysDeptEntity){
            SysDeptEntity dept=(SysDeptEntity)obj;
            return deptId.equals(dept.deptId);
        }
        return super.equals(obj);
    }

    @Override
    public int compareTo(SysDeptEntity o) {
        if(o.orderNum!=null&&this.orderNum!=null){
            return -o.orderNum + this.orderNum;
        }
        return -1;
    }
}
