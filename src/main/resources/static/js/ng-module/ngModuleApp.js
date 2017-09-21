var app = angular.module('app', ['ngRoute', 'ngSanitize']);


app.config(['$routeProvider', '$locationProvider',
  function ($routeProvider, $locationProvider)
  {
    $routeProvider.otherwise(
    {
      redirectTo: '/'
    })
    .when('/',
    {
      templateUrl: GBL_COFG.urlTemplate('ini.html')
    })
    .when('/about',
    {
      templateUrl: GBL_COFG.urlTemplate('about.html'),
      controller: 'ngAppControllerAbout'
    })
    .when('/test-bbdd',
    {
      templateUrl: GBL_COFG.urlTemplate('test-bbdd.html'),
      controller: 'ngAppControllerTestBbdd'
    })
    .when('/bbdd',
    {
      templateUrl: GBL_COFG.urlTemplate('bbdd.html'),
      controller: 'ngAppControllerBbdd'
    })
    .when('/kirby',
    {
      templateUrl: GBL_COFG.urlTemplate('kirby.html')
    })
    .when('/search',
    {
      templateUrl: GBL_COFG.urlTemplate('search.html'),
      controller: 'ngAppControllerSearch'
    });
  }]);


