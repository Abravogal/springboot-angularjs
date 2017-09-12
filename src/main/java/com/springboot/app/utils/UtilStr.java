package com.springboot.app.utils;

import java.text.Normalizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class UtilStr
{

  /**
   * METODO PARA SUSTITUIR EN UNA CADENA LOS ESPACIOS EN BLANCOS, SALTOS DE
   * CARROS Y TABULADORES POR UN SOLO ESPACIO.
   *
   * @param str Cadena a limpiar.
   *
   * @return Cadena formateada.
   */
  public static String replaceSpacesToOneSpace(String str)
  {
    return str.replaceAll("\\s+", " ").trim();
  }


  /**
   * METODO PARA ELIMINAR EN UNA CADENA LOS ESPACIOS EN BLANCOS, SALTOS DE
   * CARROS Y TABULADORES.
   *
   * @param str Cadena a limpiar.
   *
   * @return Cadena formateada.
   */
  public static String removeSpacesAll(String str)
  {
    return str.replaceAll("\\s+", "").trim();
  }


  /**
   * METODO PARA GENERAR UN PATRON CASE INSENSITIVE.
   *
   * @param str Cadena a insertar en el patron de busqueda.
   *
   * @return Patron generado.
   */
  public static Pattern patternCaseInsensitive(String str)
  {
    return Pattern.compile("(?i)" + str);
  }


  /**
   * METODO PARA COMPARAR DOS CADENAS.
   *
   * @param pattern Patron a comparar.
   * @param str     Cadena a comparar
   *
   * @return Si esw coincidente o no..
   */
  public static Matcher patternMatcher(Pattern pattern, String str)
  {
    return pattern.matcher(str);
  }


  /**
   * METODO PARA REALIZAR UN REMPLAZO DE UNA CADENA POR UN TAG SPAN HTML.
   *
   * @param str Cadena a insertar en el tag.
   *
   * @return tag span generado en html.
   */
  public static String spanHtml(String str)
  {
    return "<span>" + str + "</span>";
  }


  /**
   * METODO PARA REALIZAR UN REMPLAZO DE UNA CADENA POR UN TAG SPAN HTML.
   *
   * @param str      Cadena a insertar en el tag.
   * @param classCss Clase css.
   *
   * @return tag span generado en html.
   */
  public static String spanHtml(String str, String classCss)
  {
    return "<span class=\"" + classCss + "\">" + str + "</span>";
  }


  /**
   * CONVERSION DEL TEXTO A SU FORMA CANONICAL DECOMPOSITION, REPRESENTANDO LOS
   * CARACTERES UTF-8 COMPRENDIDOS ENTRE U+0300 HASTA U+036F.
   * ------------------------------------
   * <p>
   * "[^\\p{ASCII}]"
   * <p>
   * "[\\p{InCombiningDiacriticalMarks}]"
   *
   * -------------------------------------
   *
   *
   * @param str Cadena a procesar.
   *
   * @return Cadena convertida a UTF-8.
   */
  public static String normalizerStr(String str)
  {
    String normalize = str.replace("ñ", "\001");

    normalize = Normalizer.normalize(normalize, Normalizer.Form.NFD);
    normalize = normalize.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");

    normalize = normalize.replace("\001", "ñ");

    return normalize;
  }

}
