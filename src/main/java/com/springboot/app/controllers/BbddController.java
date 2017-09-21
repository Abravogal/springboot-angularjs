package com.springboot.app.controllers;

import com.springboot.app.persistence.models.TestModel;
import com.springboot.app.services.BbddService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class BbddController
{

  @Autowired
  BbddService iService;


  @RequestMapping(value = "/getdatabbdd",
                  method = RequestMethod.POST,
                  produces = MediaType.APPLICATION_JSON_VALUE)
  public List<Map<String, Object>> getItems(@RequestBody TestModel obj) throws Exception
  {
    List<Map<String, Object>> x = iService.getDataBBDD(obj);

    return x;
  }

}
