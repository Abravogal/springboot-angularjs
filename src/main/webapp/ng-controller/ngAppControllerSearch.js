app.controller('ngAppControllerSearch',
['$scope', '$http', '$timeout', 'utilFactory',
  function ($scope, $http, $timeout, utilFactory)
  {

    /**************************************************************************
     * 
     * CONFIG.
     * 
     **************************************************************************/

    var timer =
    {
      search:
      {
        id: null,
        ms: 750
      }
    };

    var msg =
    {
      el: document.querySelector('#msg > span'),
      style:
      {
        classNotFound: 'notFound'
      }
    };

    /**************************************************************************
     * 
     * INI.
     * 
     **************************************************************************/

    (function ()
    {
      $http.post('/getItems', {})
      .then(function (response)
      {
        scopeItems(response.data);
      })
    })();



    /**************************************************************************
     * 
     * FUNCTIONS MODEL.
     * 
     **************************************************************************/

    /**
     * FUNCION PARA REALIZAR UNA BUSQUEDA.
     * 
     * @param {event} e Evento disparado.
     */
    $scope.searchFn = function (e)
    {
      var value = e.target.value;

      $timeout.cancel(timer.search.id);
      timer.search.id = $timeout(function ()
      {
        utilFactory.setContSearchItems(utilFactory.getContSearchItems() + 1);

        $http.post('/searchItems',
        {
          search: value
        })
        .then(function (response)
        {
          scopeItems(response.data);
        });

      }, timer.search.ms);
    };




    /**************************************************************************
     * 
     * PRIVATE FUNCTIONS.
     * 
     **************************************************************************/

    /**
     * MUESTRA LOS RESULTADOS DE LA BUSQUEDA.
     * 
     * @param {array} data Datos obtenidos de la busqueda.
     */
    function scopeItems(data)
    {
      var length = data.length;

      msg.el.classList.remove(msg.style.classNotFound);

      if (length > 0)
      {
        $scope.items = data;
      }
      else
      {
        msg.el.classList.add(msg.style.classNotFound);
      }

      $scope.msg = data.length;
    }

  }]);