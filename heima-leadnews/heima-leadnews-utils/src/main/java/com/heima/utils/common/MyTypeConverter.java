package com.heima.utils.common;

import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.config.rules.IColumnType;

public class MyTypeConverter extends MySqlTypeConvert {

    @Override
    public IColumnType processTypeConvert(GlobalConfig config, String fieldType) {
        if (fieldType.toLowerCase().contains("datetime")) {
            return DbColumnType.DATE;
        }
        if (fieldType.toLowerCase().contains("tinyint(1)")) {
            return DbColumnType.BOOLEAN;
        }

        return super.processTypeConvert(config,fieldType);
    }
}
