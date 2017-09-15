package com.springboot.app.persistence.mappers.jdbctemplates;

import com.springboot.app.persistence.models.TestModel;
import java.util.List;


public interface JDBCTestMapper
{

  public List<TestModel> testMapper(TestModel obj) throws Exception;

}
