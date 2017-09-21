package com.springboot.app.services;


import com.springboot.app.persistence.mappers.jdbctemplates.BbddMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.springboot.app.persistence.models.TestModel;
import java.util.Map;


@Service
public class BbddServiceImpl implements BbddService
{

  @Autowired
  BbddMapper jdbcMapper;


  @Override
  public List<Map<String, Object>> getDataBBDD(TestModel obj) throws Exception
  {
    return jdbcMapper.getDataBBDD(obj);
  }

}
