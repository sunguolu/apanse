package com.apanse.icabst.modules.Listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: icabst
 * @Date: 2019/6/9 12:38 PM
 * @Author: sunguolu
 * @Description:
 */
public class ExcelListener<T> extends AnalysisEventListener<T> {


    private List<T> datas = new ArrayList<>();

    @Override
    public void invoke(T t, AnalysisContext analysisContext) {
        datas.add(t);

    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }

    public List<T> getDatas() {
        return datas;
    }

}