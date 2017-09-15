package com.springboot.app.services;

import com.springboot.app.persistence.models.ItemsModel;
import java.util.List;


public interface ItemsService
{

  /**
   * OBTIENE TODOS LOS ITEMS ALMACENADOS.
   *
   * @param obj Objeto tipo ItemsModel.
   *
   * @return Lista de objetos tipo ItemsModel.
   */
  public List<ItemsModel> getItemsService(ItemsModel obj) throws Exception;


  /**
   * OBTIENE TODOS LOS ITEMS ALMACENADOS BASADOS EN UN CRITERIO DE BUSQUEDA.
   *
   * @param obj Objeto tipo ItemsModel.
   *
   * @return Lista de objetos tipo ItemsModel.
   */
  public List<ItemsModel> searchItemsService(ItemsModel obj) throws Exception;


  /**
   * RESALTA EL TEXTO DE LOS TITULOS Y DESCRIPCIONES DE UNA LISTA DE ITEM
   * BUSCADOS.
   *
   * @param obj   Objeto tipo ItemsModel.
   * @param items Lista de items del tipo ItemsModel.
   *
   * @return Lista de objetos tipo ItemsModel.
   */
  public List<ItemsModel> underlineItemsService(ItemsModel obj, List<ItemsModel> items) throws Exception;

}
