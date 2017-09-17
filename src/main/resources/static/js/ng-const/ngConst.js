const GBL_COFG =
{
  protocol: window.location.protocol,

  host: window.location.host,

  url: window.location.protocol + '//' + window.location.host,

  urlTemplate: function (template)
  {
    return this.url + '/ng-templates/' + template;
  }
}; 