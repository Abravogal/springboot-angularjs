app.controller('ngAppControllerBbdd',
['$scope', '$http', '$timeout', 'utilFactory',
  function ($scope, $http, $timeout, utilFactory)
  {

    /**************************************************************************
     * 
     * CONFIG
     * 
     **************************************************************************/
    var select = document.querySelector('#bbdd > select');
    var selectIndex = 0;
    var selectIndexSearch = selectIndex;
    var selectValue = null;


    /**************************************************************************
     * 
     * INI
     * 
     **************************************************************************/

    (function ()
    {
      $http.post('/test',
      {})
      .then(function (response)
      {
        var data = response.data;
        $scope.tables = data;
      });
    })();


    /**************************************************************************
     * 
     * FUNCTIONS MODEL
     * 
     **************************************************************************/

    $scope.test = function (e)
    {
      selectIndex = select.selectedIndex;

      if ((selectIndex !== 0) && (selectIndexSearch !== selectIndex))
      {
        selectIndexSearch = select.selectedIndex;
        selectValue = select.options[selectIndex].value;


        $http.post('/getdatabbdd',
        {
          table: selectValue
        })
        .then(function (response)
        {
          var data = response.data;
          $scope.dataBbdd = data;
        });
      }
    };


    /**************************************************************************
     * 
     * PRIVATE FUNCTIONS
     * 
     **************************************************************************/


  }]);