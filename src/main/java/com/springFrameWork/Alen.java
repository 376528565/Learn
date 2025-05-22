package com.springFrameWork;

import com.alibaba.excel.EasyExcel;
import lombok.Data;
import org.apache.poi.ss.SpreadsheetVersion;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.lang.reflect.Field;

/**
 * @Author: LQL
 * @Date: 2024/07/23
 * @Description:
 */
@Component
//@Scope("prototype")
@Data
public class Alen {

    private String name;

    public void show(){
        System.out.println("----------------------------bean deal");
    }


}
