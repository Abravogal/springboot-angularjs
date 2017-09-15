package com.springboot.app.persistence.mappers.mybatis;

import com.springboot.app.persistence.models.ItemsModel;
import java.util.List;
import org.apache.ibatis.annotations.Select;


public interface IBATISItemsMapper
{

  /**
   * OBTIENE TODOS LOS ITEMS ALMACENADOS.
   *
   * @param obj Objeto tipo ItemsModel.
   *
   * @return Lista de objetos tipo ItemsModel.
   */
  @Select("SELECT * FROM items")
  public List<ItemsModel> getItemsMapper(ItemsModel obj) throws Exception;

}
