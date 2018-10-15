package com.anjian.app.entity;


import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 系统用户
 */
@TableName("sys_user")
@SuppressWarnings("all")
public class SysUserEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 用户ID
     */
    @TableId
    //@JsonSerialize(using = ToStringSerializer.class)
    private Long userId;
    @TableField(exist = false)
    private String bossDeptName;

    /**
     * 用户名
     */
    @NotBlank(message = "用户名不能为空")
    private String username;

    private String nickName;

    /**
     * 密码
     */
    @NotBlank(message = "密码不能为空")
    //@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @TableField(exist = false)
    private SysDeptEntity sysDeptEntity;

    @TableField(exist = false)
    private Date nowDate;

    /**
     * 部门信息
     */
    @TableField(exist = false)
    private  SysDeptEntity deptInfo;

    /**
     * 部门编码
     */
    @TableField(exist = false)
    private String deptCode;

    /**
     * 登录时间
     */
    private Date loginTime;
    /**
     * 错误次数
     */
    private Integer errorNum;
    /**
     * 是否锁定
     */
    private String isLock;

    public String getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
    }

    public SysDeptEntity getDeptInfo() {
        return deptInfo;
    }

    public void setDeptInfo(SysDeptEntity deptInfo) {
        this.deptInfo = deptInfo;
    }

    public Date getNowDate() {
        return new Date();
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public SysDeptEntity getSysDeptEntity() {
        return sysDeptEntity;
    }

    public void setSysDeptEntity(SysDeptEntity sysDeptEntity) {
        this.sysDeptEntity = sysDeptEntity;
    }

    /**
     * 证件号
     */
    @NotBlank(message = "证件号不能为空")
    private String cardId;

    /**
     * 盐
     */
    private String salt;

    /**
     * 邮箱
     */
//    @NotBlank(message = "邮箱不能为空", groups = {AddGroup.class, UpdateGroup.class})
    @Email(message = "邮箱格式不正确")
    private String email;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 状态  0：禁用   1：正常
     */
    private Integer status;

    /**
     * 职位
     */
    private String position;

    /**
     * 角色ID列表
     */
    @TableField(exist = false)
    private List<Long> roleIdList;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 部门ID
     */
    @NotNull(message = "部门不能为空")
    private Long deptId;

    /**
     * 部门名称
     */
    @TableField(exist = false)
    private String deptName;

    /**
     * 部门列表(包含子部门)
     */
    @TableField(exist = false)
    private Set<Long>  deptIdList;

    /**
     * 排序
     */
    private Integer orderNum;

    private Integer isAdmin;
    @TableField(exist = false)
    HashSet<Long> idSet;

    private String token;//用户token

    private Date expireTime;//token过期时间

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Date expireTime) {
        this.expireTime = expireTime;
    }

    /**
     * 页面展示记录条数
     */
    @TableField(exist = false)
    private int limit;
    /**
     * 当前页面
     */
    @TableField(exist = false)
    private int page;
    /**
     * 开始
     */
    @TableField(exist = false)
    private int startPage;
    /**
     * 结束
     */
    @TableField(exist = false)
    private int endPage;
    /**
     * 是否包含分页
     */
    @TableField(exist = false)
    private String isFlag;

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getStartPage() {
        return startPage;
    }

    public void setStartPage(int startPage) {
        this.startPage = startPage;
    }

    public int getEndPage() {
        return endPage;
    }

    public void setEndPage(int endPage) {
        this.endPage = endPage;
    }

    public String getIsFlag() {
        return isFlag;
    }

    public void setIsFlag(String isFlag) {
        this.isFlag = isFlag;
    }

    public HashSet<Long> getIdSet() {
        return idSet;
    }

    public void setIdSet(HashSet<Long> idSet) {
        this.idSet = idSet;
    }

    public Integer getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(Integer isAdmin) {
        this.isAdmin = isAdmin;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    /**
     * 设置：
     *
     * @param userId
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 获取：
     *
     * @return Long
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 设置：用户名
     *
     * @param username 用户名
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取：用户名
     *
     * @return String
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置：密码
     *
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取：密码
     *
     * @return String
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置：邮箱
     *
     * @param email 邮箱
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取：邮箱
     *
     * @return String
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置：手机号
     *
     * @param mobile 手机号
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * 获取：手机号
     *
     * @return String
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 设置：状态  0：禁用   1：正常
     *
     * @param status 状态  0：禁用   1：正常
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取：状态  0：禁用   1：正常
     *
     * @return Integer
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置：创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取：创建时间
     *
     * @return Date
     */
    public Date getCreateTime() {
        return createTime;
    }

    public List<Long> getRoleIdList() {
        return roleIdList;
    }

    public void setRoleIdList(List<Long> roleIdList) {
        this.roleIdList = roleIdList;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public Set<Long> getDeptIdList() {
        return deptIdList;
    }

    public void setDeptIdList(Set<Long> deptIdList) {
        this.deptIdList = deptIdList;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getBossDeptName() {
        return bossDeptName;
    }

    public void setBossDeptName(String bossDeptName) {
        this.bossDeptName = bossDeptName;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public Integer getErrorNum() {
        return errorNum;
    }

    public void setErrorNum(Integer errorNum) {
        this.errorNum = errorNum;
    }

    public String getIsLock() {
        return isLock;
    }

    public void setIsLock(String isLock) {
        this.isLock = isLock;
    }
}
