package com.springboot.app.persistence.mappers.mybatis;

import com.springboot.app.persistence.models.ItemsModel;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


@Mapper
public interface IBATISItemsMapper
{

  /**
   * OBTIENE TODOS LOS ITEMS ALMACENADOS.
   *
   * @param obj Objeto tipo ItemsModel.
   *
   * @return Lista de objetos tipo ItemsModel.
   */
  public List<ItemsModel> getItemsMapper(@Param("obj") ItemsModel obj) throws Exception;


  /**
   * OBTIENE TODOS LOS ITEMS ALMACENADOS BASADOS EN UN CRITERIO DE BUSQUEDA.
   *
   * @param obj Objeto tipo ItemsModel.
   *
   * @return Lista de objetos tipo ItemsModel.
   */
  public List<ItemsModel> searchItemsMapper(@Param("obj") ItemsModel obj) throws Exception;


  /**
   * INSERTA UN NUEVO ITEM.
   *
   * @param obj Objeto tipo ItemsModel.
   *
   * @return Numero de filas procesadas.
   */
  public int insertItemsMapper(@Param("obj") ItemsModel obj) throws Exception;


  /**
   * ACTUALIZA UN ITEM REFERENCIADO POR SU ID.
   *
   * @param obj Objeto tipo ItemsModel.
   *
   * @return Numero de filas procesadas.
   */
  public int updateItemsMapper(@Param("obj") ItemsModel obj) throws Exception;


  /**
   * ELIMINA UN ITEM REFERENCIADO POR SU ID.
   *
   * @param obj Objeto tipo ItemsModel.
   *
   * @return Numero de filas procesadas.
   */
  public int deleteItemsMapper(@Param("obj") ItemsModel obj) throws Exception;

}
