package com.hjm.mod.utils.excel.strategy;

import com.alibaba.excel.metadata.Head;
import com.alibaba.excel.util.StyleUtil;
import com.alibaba.excel.write.metadata.style.WriteCellStyle;
import com.alibaba.excel.write.style.AbstractCellStyleStrategy;
import org.apache.poi.ss.usermodel.*;

/**
 * @author Houjiemu
 * @create 2020-04-19 17:22
 */
public class DemoStyleStrategy extends AbstractCellStyleStrategy {
    private WriteCellStyle errorWriteCellStyle;
    private CellStyle erroCellStyle;

    public DemoStyleStrategy(WriteCellStyle headWriteCellStyle) {
        this.errorWriteCellStyle = headWriteCellStyle;
    }


    protected void initCellStyle(Workbook workbook) {
        if (this.errorWriteCellStyle != null) {
            this.erroCellStyle = StyleUtil.buildHeadCellStyle(workbook, this.errorWriteCellStyle);
        }


    }

    protected void setHeadCellStyle(Cell cell, Head head, int relativeRowIndex) {
//        if (this.headCellStyle != null) {
//            cell.setCellStyle(this.headCellStyle);
//        }
    }

    protected void setContentCellStyle(Cell cell, Head head, int relativeRowIndex) {
        if (this.erroCellStyle != null) {
            if (cell.getColumnIndex() == 6 && cell.getCellType() == CellType.NUMERIC.getCode()) {
                if (cell.getNumericCellValue() == 4001) {
                    Cell targetCell = cell.getRow().getCell(1);
                    targetCell.setCellStyle(this.erroCellStyle);
                }
            }
        }
    }
}
