package com.springboot.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springboot.app.persistence.models.ItemsModel;
import com.springboot.app.utils.UtilStr;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.springboot.app.persistence.mappers.jdbctemplates.JDBCItemsMapper;
import com.springboot.app.persistence.mappers.mybatis.IBATISItemsMapper;


@Service
public class ItemsServiceImpl implements ItemsService
{

  @Autowired
  JDBCItemsMapper jdbcMapper;

  @Autowired
  IBATISItemsMapper ibatisMapper;


  @Override
  public List<ItemsModel> getItemsService(ItemsModel obj) throws Exception
  {
    List<ItemsModel> x = ibatisMapper.getItemsMapper(obj);

    return x;
  }


  @Override
  public List<ItemsModel> searchItemsService(ItemsModel obj) throws Exception
  {
    List<ItemsModel> x = ibatisMapper.searchItemsMapper(obj);

    return x;
  }


  @Override
  public List<ItemsModel> underlineItemsService(ItemsModel obj, List<ItemsModel> items) throws Exception
  {
    String classCss = "found";
    List<ItemsModel> listRemove = new ArrayList<>();
    String objSearch = UtilStr.normalizerStr(UtilStr.replaceSpacesToOneSpace(obj.getSearch()));
    Pattern pattern = UtilStr.patternCaseInsensitive(objSearch);

    for (ItemsModel item : items)
    {
      boolean bln = false;
      int iElem = 0;
      String[] elms =
      {
        item.getNombre(),
        item.getDescripcion()
      };

      for (String elm : elms)
      {
        String elmSearch = UtilStr.normalizerStr(elm);
        Matcher compare = UtilStr.patternMatcher(pattern, elmSearch);

        if (compare.find())
        {
          elm = elm.substring(compare.start(), compare.end());
          String replace = compare.replaceAll(UtilStr.spanHtml(elm, classCss));

          switch (iElem)
          {
            case 0:
              item.setNombre(replace);
              break;
            case 1:
              item.setDescripcion(replace);
              break;
          }

          bln = true;
        }

        iElem++;
      }

      if (!bln)
      {
        listRemove.add(item);
      }
    }

    items.removeAll(listRemove);

    return items;
  }

}
