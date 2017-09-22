package com.springboot.app.persistence.mappers.jdbctemplates;

import com.springboot.app.persistence.models.TestModel;
import java.util.List;
import java.util.Map;


public interface JDBCBbddMapper
{

  /**
   * OBTIENE TODOS LOS ITEMS ALMACENADOS.
   *
   * @param obj Objeto tipo ItemsModel.
   *
   * @return Lista de objetos tipo Map.
   */
  public List<Map<String, Object>> getDataBBDD(TestModel obj) throws Exception;


}
