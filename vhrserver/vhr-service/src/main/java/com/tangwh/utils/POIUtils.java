package com.tangwh.utils;

import com.tangwh.pojo.*;
import org.apache.poi.hpsf.DocumentSummaryInformation;
import org.apache.poi.hpsf.SummaryInformation;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Excel
 * 导出数据
 */
public class POIUtils {

    public static ResponseEntity<byte[]> employee2Excle(List<Employee> list) {

        // 1. 创建Excel文档
        HSSFWorkbook workbook = new HSSFWorkbook();
        // 2. 创建文件摘要
        workbook.createInformationProperties();
        // 3. 获取并配置文档信息
        DocumentSummaryInformation docInfo = workbook.getDocumentSummaryInformation();

        // 文档类别
        docInfo.setCategory("员工信息");
        // 文档管理员
        docInfo.setManager("howe");
        // 设置公司信息
        docInfo.setCompany("....公司...");

        // 4. 获取文档摘要信息
        SummaryInformation summInfo = workbook.getSummaryInformation();

        // 文档标题
        summInfo.setTitle("员工信息表");
        // 文档作者
        summInfo.setAuthor("TangWeiHao");
        // 文档备注
        summInfo.setComments("文档备注.....");

        // 5. 创建样式
        // 创建 标题演示
        CellStyle headerStyle = workbook.createCellStyle();
        // 背景颜色
        headerStyle.setFillForegroundColor(IndexedColors.YELLOW.index);
        // 填充模式
        headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        // 日期格式
        HSSFCellStyle dataCellStyle = workbook.createCellStyle();
        dataCellStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("m/d/yy"));
        // 创建表单 Sheet
        HSSFSheet sheet = workbook.createSheet("员工信息表");
        // 定义列的宽度
        sheet.setColumnWidth(0, 5 * 256);
        sheet.setColumnWidth(1, 12 * 256);
        sheet.setColumnWidth(2, 10 * 256);
        sheet.setColumnWidth(3, 5 * 256);
        sheet.setColumnWidth(4, 12 * 256);
        sheet.setColumnWidth(5, 20 * 256);
        sheet.setColumnWidth(6, 16 * 256);
        sheet.setColumnWidth(7, 10 * 256);
        sheet.setColumnWidth(8, 16 * 256);
        sheet.setColumnWidth(9, 12 * 256);
        sheet.setColumnWidth(10, 15 * 256);
        sheet.setColumnWidth(11, 20 * 256);
        sheet.setColumnWidth(12, 16 * 256);
        sheet.setColumnWidth(13, 14 * 256);
        sheet.setColumnWidth(14, 14 * 256);
        sheet.setColumnWidth(15, 12 * 256);
        sheet.setColumnWidth(16, 8 * 256);
        sheet.setColumnWidth(17, 20 * 256);
        sheet.setColumnWidth(18, 20 * 256);
        sheet.setColumnWidth(19, 15 * 256);
        sheet.setColumnWidth(20, 8 * 256);
        sheet.setColumnWidth(21, 25 * 256);
        sheet.setColumnWidth(22, 14 * 256);
        sheet.setColumnWidth(23, 15 * 256);
        sheet.setColumnWidth(24, 15 * 256);
        sheet.setColumnWidth(25, 20 * 256);
        // 6. 创建标题行
        HSSFRow r0 = sheet.createRow(0);

        // 创建 第一列
        HSSFCell c0 = r0.createCell(0);
        // 列名
        c0.setCellValue("编号");
        // 设置背景颜色
        c0.setCellStyle(headerStyle);

        // 创建第列
        HSSFCell c1 = r0.createCell(1);
        c1.setCellStyle(headerStyle);
        c1.setCellValue("姓名");

        HSSFCell c2 = r0.createCell(2);
        c2.setCellStyle(headerStyle);
        c2.setCellValue("工号");

        HSSFCell c3 = r0.createCell(3);
        c3.setCellStyle(headerStyle);
        c3.setCellValue("性别");

        HSSFCell c4 = r0.createCell(4);
        c4.setCellStyle(headerStyle);
        c4.setCellValue("出生日期");

        HSSFCell c5 = r0.createCell(5);
        c5.setCellStyle(headerStyle);
        c5.setCellValue("身份证号码");

        HSSFCell c6 = r0.createCell(6);
        c6.setCellStyle(headerStyle);
        c6.setCellValue("婚姻状况");

        HSSFCell c7 = r0.createCell(7);
        c7.setCellStyle(headerStyle);
        c7.setCellValue("民族");

        HSSFCell c8 = r0.createCell(8);
        c8.setCellStyle(headerStyle);
        c8.setCellValue("籍贯");

        HSSFCell c9 = r0.createCell(9);
        c9.setCellStyle(headerStyle);
        c9.setCellValue("政治面貌");

        HSSFCell c10 = r0.createCell(10);
        c10.setCellStyle(headerStyle);
        c10.setCellValue("电话号码");

        HSSFCell c11 = r0.createCell(11);
        c11.setCellStyle(headerStyle);
        c11.setCellValue("联系地址");

        HSSFCell c12 = r0.createCell(12);
        c12.setCellStyle(headerStyle);
        c12.setCellValue("所属部门");

        HSSFCell c13 = r0.createCell(13);
        c13.setCellStyle(headerStyle);
        c13.setCellValue("职称");

        HSSFCell c14 = r0.createCell(14);
        c14.setCellStyle(headerStyle);
        c14.setCellValue("职位");

        HSSFCell c15 = r0.createCell(15);
        c15.setCellStyle(headerStyle);
        c15.setCellValue("聘用形式");

        HSSFCell c16 = r0.createCell(16);
        c16.setCellStyle(headerStyle);
        c16.setCellValue("最高学历");

        HSSFCell c17 = r0.createCell(17);
        c17.setCellStyle(headerStyle);
        c17.setCellValue("专业");

        HSSFCell c18 = r0.createCell(18);
        c18.setCellStyle(headerStyle);
        c18.setCellValue("毕业院校");

        HSSFCell c19 = r0.createCell(19);
        c19.setCellStyle(headerStyle);
        c19.setCellValue("入职日期");

        HSSFCell c20 = r0.createCell(20);
        c20.setCellStyle(headerStyle);
        c20.setCellValue("在职状态");

        HSSFCell c21 = r0.createCell(21);
        c21.setCellStyle(headerStyle);
        c21.setCellValue("邮箱");

        HSSFCell c22 = r0.createCell(22);
        c22.setCellStyle(headerStyle);
        c22.setCellValue("合同期限(年)");

        HSSFCell c23 = r0.createCell(23);
        c23.setCellStyle(headerStyle);
        c23.setCellValue("合同起始日期");

        HSSFCell c24 = r0.createCell(24);
        c24.setCellStyle(headerStyle);
        c24.setCellValue("合同终止日期");

        HSSFCell c25 = r0.createCell(25);
        c25.setCellStyle(headerStyle);
        c25.setCellValue("转正日期");

        // 遍历数据 放数据
        for (int i = 0; i < list.size(); i++) {
            Employee emp = list.get(i);
            // 创建行
            HSSFRow row = sheet.createRow(i + 1);
            row.createCell(0).setCellValue(emp.getId());
            row.createCell(1).setCellValue(emp.getName());
            row.createCell(2).setCellValue(emp.getWedlock());
            row.createCell(3).setCellValue(emp.getGender());

            // 日期
            HSSFCell cell4 = row.createCell(4);
            cell4.setCellStyle(dataCellStyle);
            cell4.setCellValue(emp.getBirthday());

            row.createCell(5).setCellValue(emp.getIdCard());
            row.createCell(6).setCellValue(emp.getWedlock());
            row.createCell(7).setCellValue(emp.getNation().getName());
            row.createCell(8).setCellValue(emp.getNativePlace());
            row.createCell(9).setCellValue(emp.getPoliticsstatus().getName());
            row.createCell(10).setCellValue(emp.getPhone());
            row.createCell(11).setCellValue(emp.getAddress());
            row.createCell(12).setCellValue(emp.getDepartment().getName());
            row.createCell(13).setCellValue(emp.getJoblevel().getName());
            row.createCell(14).setCellValue(emp.getPosition().getName());
            row.createCell(15).setCellValue(emp.getEngageForm());
            row.createCell(16).setCellValue(emp.getTiptopDegree());
            row.createCell(17).setCellValue(emp.getSpecialty());
            row.createCell(18).setCellValue(emp.getSchool());

            HSSFCell celll9 = row.createCell(19);
            celll9.setCellStyle(dataCellStyle);
            celll9.setCellValue(emp.getBeginDate());


            row.createCell(20).setCellValue(emp.getWorkState());
            row.createCell(21).setCellValue(emp.getEmail());
            row.createCell(22).setCellValue(emp.getContractTerm());

            HSSFCell cell23 = row.createCell(23);
            cell23.setCellStyle(dataCellStyle);
            cell23.setCellValue(emp.getBeginContract());


            HSSFCell cell24 = row.createCell(24);
            cell24.setCellStyle(dataCellStyle);
            cell24.setCellValue(emp.getEndContract());

            HSSFCell cell25 = row.createCell(25);
            cell25.setCellStyle(dataCellStyle);
            cell25.setCellValue(emp.getConversionTime());
        }
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        HttpHeaders headers = new HttpHeaders();

        try {
            headers.setContentDispositionFormData("attachment", new String("员工表.xls".getBytes("UTF-8"), "ISO-8859-1"));
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            workbook.write(baos);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<byte[]>(baos.toByteArray(), headers, HttpStatus.CREATED);
    }

    /**
     * 解析Excel 成集合
     *
     * @param file
     * @param allNations
     * @param allPoliticsstatus
     * @param allDepartments
     * @param allPositions
     * @param allJobLevels
     * @return
     */
    public static List<Employee> exlce2Employee(MultipartFile file, List<Nation> allNations, List<Politicsstatus> allPoliticsstatus, List<Department> allDepartments, List<Position> allPositions, List<Joblevel> allJobLevels) {

        List<Employee> list = new ArrayList<>();
        Employee employee;

        try {
            // 1. 创建 workbook对象
            HSSFWorkbook workbook = new HSSFWorkbook(file.getInputStream());
            // 2. 获取workbook 中表单数量
            int numberOfSheets = workbook.getNumberOfSheets();
      wei:    for (int i = 0; i < numberOfSheets; i++) {
                // 3. 获取表单
                HSSFSheet sheet = workbook.getSheetAt(i);
                // 4. 获取表单行
                int physicalNumberOfRows = sheet.getPhysicalNumberOfRows();
                for (int j = 0; j < physicalNumberOfRows; j++) {
                    if (j == 0) {
                        continue; // 跳过从行
                    }
                    // 6. 获取行
                    HSSFRow row = sheet.getRow(j);
                    if (row == null  ) {

                        continue; //放值数据中间有空行
                    }
                    // 7.获取列
                    int physicalNumberOfCells = row.getPhysicalNumberOfCells();
                    employee = new Employee();
                    for (int k = 0; k < physicalNumberOfCells; k++) {
                        // 获取列
                        HSSFCell cell = row.getCell(k);
                        if (cell == null){
                            break wei;
                        }
                        // 判断列的类型
                        switch (cell.getCellType()) {
                            // 如果是字符串
                            case STRING:
                                String cellValue = cell.getStringCellValue();
                                // 根据列 去处理数据
                                switch (k){
                                    case 1:
                                        // 如果是第一列 姓名那么给姓名赋值
                                        employee.setName(cellValue);
                                        break;
                                    case 2:
                                        // 工号
                                        employee.setWorkID(cellValue);
                                        break;
                                    case 3:
                                        // 性别
                                        employee.setGender(cellValue);
                                        break;
                                    case 5:
                                        // 身份证
                                        employee.setIdCard(cellValue);
                                        break;
                                    case 6:
                                        // 婚姻状况
                                        employee.setWedlock(cellValue);
                                        break;
                                    case 7:
                                        // 民族
                                        int nationIndex = allNations.indexOf(new Nation(cellValue));
                                        employee.setNationId(allDepartments.get(nationIndex).getId());
                                        break;
                                    case 8:
                                        // 籍贯
                                        employee.setNativePlace(cellValue);
                                        break;
                                    case 9:
                                        // 政治面貌
                                        int allpolitistatusIndex = allPoliticsstatus.indexOf(new Politicsstatus(cellValue));
                                        employee.setPoliticId(allPoliticsstatus.get(allpolitistatusIndex).getId());

                                        break;
                                    case 10:
                                        // 电话号码
                                        employee.setPhone(cellValue);
                                        break;
                                    case 11:
                                        // 联系地址
                                        employee.setAddress(cellValue);
                                        break;
                                    case 12:
                                        // 所属部门
                                        int deptartmentIndex = allDepartments.indexOf(new Department(cellValue));
                                        employee.setDepartmentId(allDepartments.get(deptartmentIndex).getId());
                                        break;
                                    case 13:
                                        // 职称
                                        int joblevelIndex = allJobLevels.indexOf(new Joblevel(cellValue));
                                        employee.setJobLevelId(allJobLevels.get(joblevelIndex).getId());
                                        break;
                                    case 14:
                                        // 职位
                                        int positionsIndex = allPositions.indexOf(new Position(cellValue));
                                        employee.setPosId(allPositions.get(positionsIndex).getId());

                                        break;
                                    case 15:
                                        // 聘用形式
                                        employee.setEngageForm(cellValue);
                                        break;
                                    case 16:
                                        // 最高学历
                                        employee.setTiptopDegree(cellValue);
                                        break;
                                    case 17:
                                        // 专业
                                        employee.setSpecialty(cellValue);
                                        break;
                                    case 18:
                                        // 学校
                                        employee.setSchool(cellValue);
                                        break;
                                    case 19:
                                        // 在职状态
                                        employee.setWorkState(cellValue);
                                        break;
                                    case 20:
                                        // 邮箱
                                        employee.setEmail(cellValue);
                                        break;

                                }
                                break;
                            default: {
                                switch (k){
                                   case 4:
                                        // 出生日期
                                        employee.setBirthday(cell.getDateCellValue());
                                        break;
                                    case 19:
                                        // 入职日期
                                        employee.setBeginDate(cell.getDateCellValue());
                                        break;
                                    case 22:
                                        // 合同年限
                                        employee.setContractTerm(cell.getNumericCellValue());
                                        break;
                                    case 23:
                                        // 合同起始日期
                                        employee.setBeginContract(cell.getDateCellValue());
                                        break;
                                    case 24:
                                        // 合同终止日期
                                        employee.setEndContract(cell.getDateCellValue());
                                        break;
                                    case 25:
                                        // 转正日期
                                        employee.setConversionTime(cell.getDateCellValue());
                                        break;
                                }

                            }
                            break;
                        }
                    }
                    list.add(employee);

                }
            }

        } catch (
                IOException e) {
            e.printStackTrace();
        }


        return list;
    }
}
