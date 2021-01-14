package com.alan.cow.vo;

/**
 * @desc：excel每行数据
 * @author: Alan
 * @creat：2021/1/9 17:37
 * @version: v1.0.1
 */
public class Entity {

    /**
     * 姓名
     */
    private String name;

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    /**
     * 专业
     */
    private String specialty;

    /**
     * 电话
     */
    private String phone;

    /**
     * 地址
     */
    private String adds;

    /**
     * 备注
     */
    private String remark;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAdds() {
        return adds;
    }

    public void setAdds(String adds) {
        this.adds = adds;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
