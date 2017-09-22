package com.springboot.app.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.springboot.app.persistence.models.TestModel;
import java.util.Map;
import com.springboot.app.persistence.mappers.jdbctemplates.JDBCBbddMapper;


@Service
public class BbddServiceImpl implements BbddService
{

  @Autowired
  JDBCBbddMapper jdbcMapper;


  @Override
  public List<Map<String, Object>> getDataBBDD(TestModel obj) throws Exception
  {
    return jdbcMapper.getDataBBDD(obj);
  }

}
