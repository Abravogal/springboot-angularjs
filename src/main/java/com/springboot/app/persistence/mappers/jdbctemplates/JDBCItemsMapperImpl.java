package com.springboot.app.persistence.mappers.jdbctemplates;


import com.springboot.app.persistence.models.ItemsModel;
import com.springboot.app.utils.UtilStr;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class JDBCItemsMapperImpl implements JDBCItemsMapper
{

  @Autowired
  JdbcTemplate JdbcTemplate;


  @Override
  public List<ItemsModel> getItemsMapper(ItemsModel obj) throws Exception
  {
    String sql = UtilStr.replaceSpacesToOneSpace(
            " SELECT * " +
            " FROM items " +
            " ORDER BY id DESC ");

    return JdbcTemplate.query(sql, new BeanPropertyRowMapper(ItemsModel.class));
  }


  @Override
  public List<ItemsModel> searchItemsMapper(ItemsModel obj) throws Exception
  {
    String sql = UtilStr.replaceSpacesToOneSpace(
            " SELECT * " +
            " FROM items " +
            " WHERE (nombre LIKE   '%" + obj.getSearch() + "%') " +
            " OR (descripcion LIKE '%" + obj.getSearch() + "%') " +
            " ORDER BY id DESC ");

    return JdbcTemplate.query(sql, new BeanPropertyRowMapper(ItemsModel.class));
  }


  @Override
  public int insertItemsMapper(ItemsModel obj) throws Exception
  {
    String sql = UtilStr.replaceSpacesToOneSpace(
            " INSERT INTO items " +
            " (nombre, " +
            "  descripcion, " +
            "  url) " +
            " VALUES " +
            " ('" + obj.getNombre() + "'" +
            " ,'" + obj.getDescripcion() + "'" +
            " ,'" + obj.getUrl() + "')");

    return JdbcTemplate.update(sql);
  }


  @Override
  public int updateItemsMapper(ItemsModel obj) throws Exception
  {
    String sql = UtilStr.replaceSpacesToOneSpace(
            " UPDATE items     " +
            " SET nombre=     '" + obj.getNombre() + "'" +
            "    ,descripcion='" + obj.getDescripcion() + "'" +
            "    ,url=        '" + obj.getUrl() + "'" +
            " WHERE id=        " + obj.getId());

    return JdbcTemplate.update(sql);
  }


  @Override
  public int deleteItemsMapper(ItemsModel obj) throws Exception
  {
    String sql = UtilStr.replaceSpacesToOneSpace(
            " DELETE FROM items " +
            " WHERE id=         " + obj.getId());

    return JdbcTemplate.update(sql);
  }

}
