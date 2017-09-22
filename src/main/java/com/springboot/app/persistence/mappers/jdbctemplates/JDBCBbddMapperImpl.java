package com.springboot.app.persistence.mappers.jdbctemplates;


import com.springboot.app.persistence.models.TestModel;
import com.springboot.app.utils.UtilStr;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class JDBCBbddMapperImpl implements JDBCBbddMapper
{

  @Autowired
  JdbcTemplate JdbcTemplate;


  @Override
  public List<Map<String, Object>> getDataBBDD(TestModel obj) throws Exception
  {
    String sql = UtilStr.replaceSpacesToOneSpace(
            " SELECT * " +
            " FROM " + obj.getTable()
    );

    return JdbcTemplate.queryForList(sql);
  }

}
