package com.hjm.mod.utils.excel.dao;

import com.hjm.mod.utils.excel.vo.DemoData;

import java.util.List;

/**
 * @author Houjiemu
 * @create 2020-04-19 15:50
 */
public class DemoDAO {
    public void save(List<DemoData> list) {
        // 如果是mybatis,尽量别直接调用多次insert,自己写一个mapper里面新增一个方法batchInsert,所有数据一次性插入
    }
}
