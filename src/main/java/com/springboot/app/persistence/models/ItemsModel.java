package com.springboot.app.persistence.models;


public class ItemsModel
{

  private int id;
  private String nombre;
  private String descripcion;
  private String url;

  /**
   * EXTRA ATTR MODEL.
   */
  private String search;


  /**
   * GETTERS / SETTERS
   */
  public int getId()
  {
    return id;
  }


  public void setId(int id)
  {
    this.id = id;
  }


  public String getNombre()
  {
    return nombre;
  }


  public void setNombre(String nombre)
  {
    this.nombre = nombre;
  }


  public String getDescripcion()
  {
    return descripcion;
  }


  public void setDescripcion(String descripcion)
  {
    this.descripcion = descripcion;
  }


  public String getUrl()
  {
    return url;
  }


  public void setUrl(String url)
  {
    this.url = url;
  }


  public String getSearch()
  {
    return search;
  }


  public void setSearch(String search)
  {
    this.search = search;
  }

}
