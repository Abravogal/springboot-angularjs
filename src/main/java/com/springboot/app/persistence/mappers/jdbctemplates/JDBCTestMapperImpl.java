package com.springboot.app.persistence.mappers.jdbctemplates;


import com.springboot.app.persistence.models.TestModel;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class JDBCTestMapperImpl implements JDBCTestMapper
{

  @Autowired
  JdbcTemplate JdbcTemplate;


  @Override
  public List<TestModel> testMapper(TestModel obj) throws Exception
  {

    System.out.println("\n\rPARAMETRO RECIBIDO: " + obj.getTable());

    List<TestModel> x = new ArrayList<>();
    DatabaseMetaData data = this.DataBBDD();
    ResultSet rsTables = this.tablesBBDD(data);

    while (rsTables.next())
    {
      TestModel tableModel = new TestModel();
      String table = rsTables.getString("TABLE_NAME");

      tableModel.setTable(table.toUpperCase());

      System.out.printf("___%-12s", tableModel.getTable());

      ResultSet rsColumns = this.columsBBDD(data, table);

      while (rsColumns.next())
      {
        System.out.print(" | " + rsColumns.getString("COLUMN_NAME"));
      }

      System.out.println("\n\r");

      x.add(tableModel);
    }

    return x;
  }


  /**
   * CONEXION BBDD.
   *
   * @return Conexion de la BBDD para recorrer las tablas y columnas.
   */
  private DatabaseMetaData DataBBDD() throws SQLException
  {
    DataSource src = JdbcTemplate.getDataSource();
    Connection conx = src.getConnection();
    return conx.getMetaData();
  }


  /**
   * LECTURA DE LAS TABLAS DE LA BASE DE DATOS.
   *
   * @param data Conexion de la BBDD.
   *
   * @return Tablas de la BBDD.
   */
  private ResultSet tablesBBDD(DatabaseMetaData data) throws SQLException
  {
    String[] table = new String[]
    {
      "TABLE"
    };

    return data.getTables(null, null, null, table);
  }


  /**
   * LECTURA DE LAS COLUMNAS DE UNA TABLA.
   *
   * @param data  Conexion de la BBDD.
   * @param table Tabla a procesar.
   *
   * @return Columnas obtenidas.
   */
  private ResultSet columsBBDD(DatabaseMetaData data, String table) throws SQLException
  {
    return data.getColumns(null, null, table, null);
  }


}
