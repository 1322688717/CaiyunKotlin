package com.example.caiyunkotlin.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BeanUserInfo {

    @SerializedName("msg")
    private String msg;
    @SerializedName("postGroup")
    private String postGroup;
    @SerializedName("code")
    private Integer code;
    @SerializedName("data")
    private DataDTO data;
    @SerializedName("roleGroup")
    private String roleGroup;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getPostGroup() {
        return postGroup;
    }

    public void setPostGroup(String postGroup) {
        this.postGroup = postGroup;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public DataDTO getData() {
        return data;
    }

    public void setData(DataDTO data) {
        this.data = data;
    }

    public String getRoleGroup() {
        return roleGroup;
    }

    public void setRoleGroup(String roleGroup) {
        this.roleGroup = roleGroup;
    }

    public static class DataDTO {
        @SerializedName("searchValue")
        private Object searchValue;
        @SerializedName("createBy")
        private String createBy;
        @SerializedName("createTime")
        private String createTime;
        @SerializedName("updateBy")
        private Object updateBy;
        @SerializedName("updateTime")
        private Object updateTime;
        @SerializedName("remark")
        private Object remark;
        @SerializedName("params")
        private ParamsDTO params;
        @SerializedName("userId")
        private Integer userId;
        @SerializedName("deptId")
        private Integer deptId;
        @SerializedName("userName")
        private String userName;
        @SerializedName("nickName")
        private String nickName;
        @SerializedName("email")
        private String email;
        @SerializedName("phonenumber")
        private String phonenumber;
        @SerializedName("sex")
        private String sex;
        @SerializedName("avatar")
        private String avatar;
        @SerializedName("password")
        private String password;
        @SerializedName("status")
        private String status;
        @SerializedName("delFlag")
        private String delFlag;
        @SerializedName("loginIp")
        private String loginIp;
        @SerializedName("loginDate")
        private String loginDate;
        @SerializedName("dept")
        private DeptDTO dept;
        @SerializedName("roles")
        private List<RolesDTO> roles;
        @SerializedName("roleIds")
        private Object roleIds;
        @SerializedName("postIds")
        private Object postIds;
        @SerializedName("roleId")
        private Object roleId;
        @SerializedName("admin")
        private Boolean admin;

        public Object getSearchValue() {
            return searchValue;
        }

        public void setSearchValue(Object searchValue) {
            this.searchValue = searchValue;
        }

        public String getCreateBy() {
            return createBy;
        }

        public void setCreateBy(String createBy) {
            this.createBy = createBy;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public Object getUpdateBy() {
            return updateBy;
        }

        public void setUpdateBy(Object updateBy) {
            this.updateBy = updateBy;
        }

        public Object getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(Object updateTime) {
            this.updateTime = updateTime;
        }

        public Object getRemark() {
            return remark;
        }

        public void setRemark(Object remark) {
            this.remark = remark;
        }

        public ParamsDTO getParams() {
            return params;
        }

        public void setParams(ParamsDTO params) {
            this.params = params;
        }

        public Integer getUserId() {
            return userId;
        }

        public void setUserId(Integer userId) {
            this.userId = userId;
        }

        public Integer getDeptId() {
            return deptId;
        }

        public void setDeptId(Integer deptId) {
            this.deptId = deptId;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getNickName() {
            return nickName;
        }

        public void setNickName(String nickName) {
            this.nickName = nickName;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPhonenumber() {
            return phonenumber;
        }

        public void setPhonenumber(String phonenumber) {
            this.phonenumber = phonenumber;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getDelFlag() {
            return delFlag;
        }

        public void setDelFlag(String delFlag) {
            this.delFlag = delFlag;
        }

        public String getLoginIp() {
            return loginIp;
        }

        public void setLoginIp(String loginIp) {
            this.loginIp = loginIp;
        }

        public String getLoginDate() {
            return loginDate;
        }

        public void setLoginDate(String loginDate) {
            this.loginDate = loginDate;
        }

        public DeptDTO getDept() {
            return dept;
        }

        public void setDept(DeptDTO dept) {
            this.dept = dept;
        }

        public List<RolesDTO> getRoles() {
            return roles;
        }

        public void setRoles(List<RolesDTO> roles) {
            this.roles = roles;
        }

        public Object getRoleIds() {
            return roleIds;
        }

        public void setRoleIds(Object roleIds) {
            this.roleIds = roleIds;
        }

        public Object getPostIds() {
            return postIds;
        }

        public void setPostIds(Object postIds) {
            this.postIds = postIds;
        }

        public Object getRoleId() {
            return roleId;
        }

        public void setRoleId(Object roleId) {
            this.roleId = roleId;
        }

        public Boolean getAdmin() {
            return admin;
        }

        public void setAdmin(Boolean admin) {
            this.admin = admin;
        }

        public static class ParamsDTO {
        }

        public static class DeptDTO {
            @SerializedName("searchValue")
            private Object searchValue;
            @SerializedName("createBy")
            private Object createBy;
            @SerializedName("createTime")
            private Object createTime;
            @SerializedName("updateBy")
            private Object updateBy;
            @SerializedName("updateTime")
            private Object updateTime;
            @SerializedName("remark")
            private Object remark;
            @SerializedName("params")
            private ParamsDTO params;
            @SerializedName("deptId")
            private Integer deptId;
            @SerializedName("parentId")
            private Integer parentId;
            @SerializedName("ancestors")
            private String ancestors;
            @SerializedName("deptName")
            private String deptName;
            @SerializedName("orderNum")
            private Integer orderNum;
            @SerializedName("leader")
            private String leader;
            @SerializedName("phone")
            private Object phone;
            @SerializedName("email")
            private Object email;
            @SerializedName("status")
            private String status;
            @SerializedName("delFlag")
            private Object delFlag;
            @SerializedName("parentName")
            private Object parentName;
            @SerializedName("children")
            private List<?> children;

            public Object getSearchValue() {
                return searchValue;
            }

            public void setSearchValue(Object searchValue) {
                this.searchValue = searchValue;
            }

            public Object getCreateBy() {
                return createBy;
            }

            public void setCreateBy(Object createBy) {
                this.createBy = createBy;
            }

            public Object getCreateTime() {
                return createTime;
            }

            public void setCreateTime(Object createTime) {
                this.createTime = createTime;
            }

            public Object getUpdateBy() {
                return updateBy;
            }

            public void setUpdateBy(Object updateBy) {
                this.updateBy = updateBy;
            }

            public Object getUpdateTime() {
                return updateTime;
            }

            public void setUpdateTime(Object updateTime) {
                this.updateTime = updateTime;
            }

            public Object getRemark() {
                return remark;
            }

            public void setRemark(Object remark) {
                this.remark = remark;
            }

            public ParamsDTO getParams() {
                return params;
            }

            public void setParams(ParamsDTO params) {
                this.params = params;
            }

            public Integer getDeptId() {
                return deptId;
            }

            public void setDeptId(Integer deptId) {
                this.deptId = deptId;
            }

            public Integer getParentId() {
                return parentId;
            }

            public void setParentId(Integer parentId) {
                this.parentId = parentId;
            }

            public String getAncestors() {
                return ancestors;
            }

            public void setAncestors(String ancestors) {
                this.ancestors = ancestors;
            }

            public String getDeptName() {
                return deptName;
            }

            public void setDeptName(String deptName) {
                this.deptName = deptName;
            }

            public Integer getOrderNum() {
                return orderNum;
            }

            public void setOrderNum(Integer orderNum) {
                this.orderNum = orderNum;
            }

            public String getLeader() {
                return leader;
            }

            public void setLeader(String leader) {
                this.leader = leader;
            }

            public Object getPhone() {
                return phone;
            }

            public void setPhone(Object phone) {
                this.phone = phone;
            }

            public Object getEmail() {
                return email;
            }

            public void setEmail(Object email) {
                this.email = email;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public Object getDelFlag() {
                return delFlag;
            }

            public void setDelFlag(Object delFlag) {
                this.delFlag = delFlag;
            }

            public Object getParentName() {
                return parentName;
            }

            public void setParentName(Object parentName) {
                this.parentName = parentName;
            }

            public List<?> getChildren() {
                return children;
            }

            public void setChildren(List<?> children) {
                this.children = children;
            }

            public static class ParamsDTO {
            }
        }

        public static class RolesDTO {
            @SerializedName("searchValue")
            private Object searchValue;
            @SerializedName("createBy")
            private Object createBy;
            @SerializedName("createTime")
            private Object createTime;
            @SerializedName("updateBy")
            private Object updateBy;
            @SerializedName("updateTime")
            private Object updateTime;
            @SerializedName("remark")
            private Object remark;
            @SerializedName("params")
            private ParamsDTO params;
            @SerializedName("roleId")
            private Integer roleId;
            @SerializedName("roleName")
            private String roleName;
            @SerializedName("roleKey")
            private String roleKey;
            @SerializedName("roleSort")
            private String roleSort;
            @SerializedName("dataScope")
            private String dataScope;
            @SerializedName("menuCheckStrictly")
            private Boolean menuCheckStrictly;
            @SerializedName("deptCheckStrictly")
            private Boolean deptCheckStrictly;
            @SerializedName("status")
            private String status;
            @SerializedName("delFlag")
            private Object delFlag;
            @SerializedName("flag")
            private Boolean flag;
            @SerializedName("menuIds")
            private Object menuIds;
            @SerializedName("deptIds")
            private Object deptIds;
            @SerializedName("admin")
            private Boolean admin;

            public Object getSearchValue() {
                return searchValue;
            }

            public void setSearchValue(Object searchValue) {
                this.searchValue = searchValue;
            }

            public Object getCreateBy() {
                return createBy;
            }

            public void setCreateBy(Object createBy) {
                this.createBy = createBy;
            }

            public Object getCreateTime() {
                return createTime;
            }

            public void setCreateTime(Object createTime) {
                this.createTime = createTime;
            }

            public Object getUpdateBy() {
                return updateBy;
            }

            public void setUpdateBy(Object updateBy) {
                this.updateBy = updateBy;
            }

            public Object getUpdateTime() {
                return updateTime;
            }

            public void setUpdateTime(Object updateTime) {
                this.updateTime = updateTime;
            }

            public Object getRemark() {
                return remark;
            }

            public void setRemark(Object remark) {
                this.remark = remark;
            }

            public ParamsDTO getParams() {
                return params;
            }

            public void setParams(ParamsDTO params) {
                this.params = params;
            }

            public Integer getRoleId() {
                return roleId;
            }

            public void setRoleId(Integer roleId) {
                this.roleId = roleId;
            }

            public String getRoleName() {
                return roleName;
            }

            public void setRoleName(String roleName) {
                this.roleName = roleName;
            }

            public String getRoleKey() {
                return roleKey;
            }

            public void setRoleKey(String roleKey) {
                this.roleKey = roleKey;
            }

            public String getRoleSort() {
                return roleSort;
            }

            public void setRoleSort(String roleSort) {
                this.roleSort = roleSort;
            }

            public String getDataScope() {
                return dataScope;
            }

            public void setDataScope(String dataScope) {
                this.dataScope = dataScope;
            }

            public Boolean getMenuCheckStrictly() {
                return menuCheckStrictly;
            }

            public void setMenuCheckStrictly(Boolean menuCheckStrictly) {
                this.menuCheckStrictly = menuCheckStrictly;
            }

            public Boolean getDeptCheckStrictly() {
                return deptCheckStrictly;
            }

            public void setDeptCheckStrictly(Boolean deptCheckStrictly) {
                this.deptCheckStrictly = deptCheckStrictly;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public Object getDelFlag() {
                return delFlag;
            }

            public void setDelFlag(Object delFlag) {
                this.delFlag = delFlag;
            }

            public Boolean getFlag() {
                return flag;
            }

            public void setFlag(Boolean flag) {
                this.flag = flag;
            }

            public Object getMenuIds() {
                return menuIds;
            }

            public void setMenuIds(Object menuIds) {
                this.menuIds = menuIds;
            }

            public Object getDeptIds() {
                return deptIds;
            }

            public void setDeptIds(Object deptIds) {
                this.deptIds = deptIds;
            }

            public Boolean getAdmin() {
                return admin;
            }

            public void setAdmin(Boolean admin) {
                this.admin = admin;
            }

            public static class ParamsDTO {
            }
        }
    }
}
