package com.anjian.app.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@SuppressWarnings("all")
public class UserEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @TableId
    private Long userId;

    private String username;

    private String openId;

    private String areaId;

    private String mobile;

    @JSONField(serialize = false)
    private String password;

    private Date createTime;

    private String nickName;

    private BigDecimal moneyRent = BigDecimal.ZERO;

    private BigDecimal moneyScore = BigDecimal.ZERO;

    private BigDecimal moneyUsable = BigDecimal.ZERO;
    //0~4
    private String rank = "0";

    private String headPicId;

    private String finishFristPay = "0";

    @TableField(exist = false)
    private BigDecimal sumDecimal = BigDecimal.ZERO;

    private String parentUserId;

    @TableField(exist = false)
    private String waitPayCount;
    @TableField(exist = false)
    private String getCount;
    @TableField(exist = false)
    private String rentCount;
    @TableField(exist = false)
    private String finshCount;
    @TableField(exist = false)
    private String touxiangPath;

    private String aimId;

    private Integer lotteryIs;



    public Integer getLotteryIs() {
        return lotteryIs;
    }

    public void setLotteryIs(Integer lotteryIs) {
        this.lotteryIs = lotteryIs;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getMobile() {
        return mobile;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public BigDecimal getSumDecimal() {
        return sumDecimal;
    }

    public void setSumDecimal(BigDecimal sumDecimal) {
        this.sumDecimal = sumDecimal;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public BigDecimal getMoneyRent() {
        return moneyRent;
    }

    public void setMoneyRent(BigDecimal moneyRent) {
        this.moneyRent = moneyRent;
    }

    public BigDecimal getMoneyScore() {
        return moneyScore;
    }

    public void setMoneyScore(BigDecimal moneyScore) {
        this.moneyScore = moneyScore;
    }

    public BigDecimal getMoneyUsable() {
        return moneyUsable;
    }

    public void setMoneyUsable(BigDecimal moneyUsable) {
        this.moneyUsable = moneyUsable;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getHeadPicId() {
        return headPicId;
    }

    public void setHeadPicId(String headPicId) {
        this.headPicId = headPicId;
    }

    public String getFinishFristPay() {
        return finishFristPay;
    }

    public void setFinishFristPay(String finishFristPay) {
        this.finishFristPay = finishFristPay;
    }

    public String getParentUserId() {
        return parentUserId;
    }

    public void setParentUserId(String parentUserId) {
        this.parentUserId = parentUserId;
    }

    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    public String getWaitPayCount() {
        return waitPayCount;
    }

    public void setWaitPayCount(String waitPayCount) {
        this.waitPayCount = waitPayCount;
    }

    public String getGetCount() {
        return getCount;
    }

    public void setGetCount(String getCount) {
        this.getCount = getCount;
    }

    public String getRentCount() {
        return rentCount;
    }

    public void setRentCount(String rentCount) {
        this.rentCount = rentCount;
    }

    public String getFinshCount() {
        return finshCount;
    }

    public void setFinshCount(String finshCount) {
        this.finshCount = finshCount;
    }

    public String getTouxiangPath() {
        return touxiangPath;
    }

    public void setTouxiangPath(String touxiangPath) {
        this.touxiangPath = touxiangPath;
    }

    public String getAimId() {
        return aimId;
    }

    public void setAimId(String aimId) {
        this.aimId = aimId;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public UserEntity() {
    }
}
