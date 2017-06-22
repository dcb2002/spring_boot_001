/**
 * 
 *【1】定义前端controller
 * 
 */


actionApp.controller('View1Controller', ['$rootScope', '$scope', '$http', function($rootScope, $scope,$http) {	//定义控制器，并注入：'$rootScope', '$scope', '$http'
    $scope.$on('$viewContentLoaded', function() {	//使用$scope.$on   监听事件$viewContentLoaded。
    	console.log('页面加载完成');
    });
    
    
    $scope.search = function(){									//在scope内定义一个search方法，在页面里通过 ng-click调用。
      personName = $scope.personName;					//通过$scope.personName,获取页面中通过 ng-model=“personName”绑定的值。
      $http.get('search',{												//$http.get('search',...):get请求。
    	  params:{personName:personName}
      }).success(function(data){
    	 $scope.person=data;
      });;
     
    };
}]);

actionApp.controller('View2Controller', ['$rootScope', '$scope',  function($rootScope, $scope) {
    $scope.$on('$viewContentLoaded', function() {
    	console.log('页面加载完成');
    });
}]);


