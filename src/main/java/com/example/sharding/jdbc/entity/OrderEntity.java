package com.example.sharding.jdbc.entity;

import java.util.Date;

/**
 * @author niuzheju
 * @date 15:53 2022/5/16
 */
public class OrderEntity {

    private Long id;
    private Long storeNo;
    private String desc;
    private Date createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStoreNo() {
        return storeNo;
    }

    public void setStoreNo(Long storeNo) {
        this.storeNo = storeNo;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "OrderEntity{" +
                "id=" + id +
                ", storeNo='" + storeNo + '\'' +
                ", desc='" + desc + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
