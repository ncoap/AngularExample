angular.module('ngBoilerplate.client',['ui.router','ngResource'])
.config(function config3 ($stateProvider){
    $stateProvider.state('client',{
        url:'/client',
        views:{
             'main':{
                 templateUrl:'client/client.tpl.html',
                 controller:'clientCtrl'
             }
        },
        data:{
             pageTitle: 'Clients'
        }
    });
 })
.factory('clientService',function($resource){
        var service = {
            getClients : function(success, failure){
                var Clients = $resource('/angular/rest/client');
                var data = Clients.get(
                    {},
                    function () {
                        var clients = data.clients;
                        if(clients.length!==0){
                            success(clients);
                        }else{
                            failure();
                        }
                    },
                    failure
                );
            },
            registerClient : function(client, success, failure){
                var Client = $resource('/basic-web-app/rest/client');
                Client.save({},client,success,failure);
            }
        };
        return service;
    })
.controller('clientCtrl',function($scope,clientService,$modal,$log){
        $scope.clients = [];

        $scope.totalItems = 64;
        $scope.currentPage = 4;

        $scope.setPage = function (pageNo) {
            $scope.currentPage = pageNo;
        };

        $scope.pageChanged = function() {
            $log.log('Page changed to: ' + $scope.currentPage);
        };

        clientService.getClients(
             function(clients){
                 $scope.clients = clients;
             },
             function(){
                 alert("error al obtener los clientes");
             });

        $scope.showModal=function () {
            $scope.nuevo={};
            var modalInstance = $modal.open({
                templateUrl: 'client/newClient.tpl.html',
                controller:'addNewClientCtrl'
            });

            modalInstance.result.then(function(newClient) {
                $log.log("NOOO PUEDE SER es locoo");
                $log.log(newClient);

                clientService.registerClient(newClient,
                    function(returnedData){
                        $log.log("datos retornados");
                        $log.log(returnedData);
                    },
                    function(){
                        alert("se produjo un error al insertar el cliente");
                    });

            });
        };

})
.controller('addNewClientCtrl',function($scope,$modalInstance,$log,clientService){

        $scope.newClient = {};

        $scope.RegisterClient = function(){
            $log.log("REGISTERED NEW CLIENTooo!!!");
            $log.log($scope.newClient);
            $modalInstance.close($scope.newClient);
        };

        $scope.cancel =function(){
            $modalInstance.dismiss('cancel');
        };

    });