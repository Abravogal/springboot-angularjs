package com.springboot.app.controllers;

import com.springboot.app.persistence.models.ItemsModel;
import com.springboot.app.services.ItemsService;
import com.springboot.app.utils.UtilStr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;

@Controller
public class ItemsController
{

  @Autowired
  ItemsService iService;

  @ResponseBody
  @RequestMapping(value = "/getItems",
          method = RequestMethod.POST,
          produces = MediaType.APPLICATION_JSON_VALUE)
  public List<ItemsModel> getItems(@RequestBody ItemsModel obj) throws Exception
  {
    List<ItemsModel> x = iService.getItemsService(obj);

    return x;
  }

  @ResponseBody
  @RequestMapping(value = "/searchItems",
          method = RequestMethod.POST,
          produces = MediaType.APPLICATION_JSON_VALUE)
  public List<ItemsModel> searchItems(@RequestBody ItemsModel obj) throws Exception
  {
    List<ItemsModel> x = iService.searchItemsService(obj);

    if ((UtilStr.removeSpacesAll(obj.getSearch()).length() > 0) && (x.size() > 0))
    {
      x = iService.underlineItemsService(obj, x);
    }

    return x;
  }

}
