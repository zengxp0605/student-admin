package com.stan.studentadmin.common;

import lombok.Getter;
import lombok.Setter;

/**
 * @Author：stanzeng
 * @Description：
 * @Date ：Created in 2020/9/29 10:28 上午
 * @Modified By：
 */
@Getter
@Setter
public class CommonResult<T> {
    private int status = 1;
    private int errorCode;
    private String errorMsg = "";
    private T resultBody;

    public CommonResult() {

    }

    public CommonResult(T resultBody) {
        this.resultBody = resultBody;
    }

    public static <T> CommonResult<T> errorResult(int errorCode, String errorMsg) {
        CommonResult<T> commonResult = new CommonResult<>();
        commonResult.setErrorCode(errorCode);
        commonResult.setErrorMsg(errorMsg);
        commonResult.setStatus(-1);
        return commonResult;
    }
}
