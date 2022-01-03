JW_APP_NAME.directive('datatables', ['$rootScope', '$interval', '$timeout', function ($rootScope, $interval, $timeout) {
    return {
        restrict: 'A',
        scope: {
            options: '@options',
            dom: '@dom',
            websocketGroup: '@websocket'
        },

        controllerAs: 'vm',
        //bindToController: true,
        controller: ['$http', '$rootScope', '$scope', function ($http, $rootScope, $scope) {
            $scope.ctrlFn = function (element) {
                var options;
                if ($scope.options !== undefined) {
                    options = JSON.parse($scope.options);
                } else {
                    options = {};
                }

                /*if (options.stateSave) {
                    options.stateSaveCallback = function (settings, data) {
                       // alert('state save');
                        sessionStorage.setItem("DataTables_" + settings.sInstance, JSON.stringify(data));
                        for (var i = 0; i < localStorage.length; i++) {
                            var key = localStorage.key(i);
                            if (key.startsWith("DataTables_DataTables_")) {
                                localStorage.removeItem(key);
                            }
                        }
                    }

                    options.stateLoadCallback = function (settings) {
                      //  alert('state load');
                        return JSON.parse(sessionStorage.getItem("DataTables_" + settings.sInstance))
                    }
                }*/
                if ($scope.dom !== undefined) {
                    options.dom = $scope.dom;
                }
                options.destroy = true;
                //options.deferRender = true;
                // alert('creating datatable');
                $scope.datatable = element.DataTable(options);

                $scope.$on('$destroy', function () {
                    try {
                        $scope.datatable.destroy();
                    }catch(e)
                    {
                        console.log(e);
                    }
                    $scope.datatable = undefined;
                });
            };
        }],

        link: function ($scope, element, attrs) {
            $scope.ctrlFn(element);

            element.on('$destroy', function () {
                try {
                    $scope.datatable.destroy();
                }catch(e)
                {
                    console.log(e);
                }
                $scope.datatable = undefined;
            });
        }

    };
}]);
