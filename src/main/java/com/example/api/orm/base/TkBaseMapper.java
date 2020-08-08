package com.example.api.orm.base;

import tk.mybatis.mapper.common.*;

public interface TkBaseMapper<T> extends BaseMapper<T>, Mapper<T>, Marker, MySqlMapper<T>, ExampleMapper<T>, ConditionMapper<T> {
}
