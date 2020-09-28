package com.stan.studentadmin.common;

import lombok.Data;

/**
 * @Author：stanzeng
 * @Description：
 * @Date ：Created in 2020/9/28 4:43 下午
 * @Modified By：
 */
@Data
public class RowRequest {
    private int startNo;
    private int offset;

    public RowRequest(int pageNo, int pageSize) {
        this.startNo = (pageNo - 1) * pageSize;
        this.offset = pageSize;
    }
}
