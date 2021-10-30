app.controller('homeCtrl', function($scope, $state, $sessionStorage, homeFac){
	

	$scope.userList = [];
	$sessionStorage.userId = "";
	$scope.createUserNavigate = function(){
		$state.go("createUser")
	}
	
	$scope.getAllUsersObj = function(){
		homeFac.getAllUsers("", function(response){
			if(response.status==200){
				$scope.userList = response.data;
			}
		})
	}

	$scope.editUser = function(id){
		$sessionStorage.userId = id;
		$state.go("createUser");
	}
	
	$scope.deleteUserReq = function(id){
		homeFac.deleteUser(id, function(response){
			if(response.status==200){
				if(response.data.serviceStatus=="Success"){
					$scope.getAllUsersObj();
				}
			}
		})
	}

	$scope.getAllUsersObj();

})