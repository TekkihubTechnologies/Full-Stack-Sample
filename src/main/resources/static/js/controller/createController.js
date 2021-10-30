app.controller('createCtrl', function($scope, $state, $sessionStorage,  homeFac){
	
	$scope.createUser = {}
	$scope.resposeMsg = "";
	$scope.editmode = false;
	
	$scope.homeNavigate = function(){
		$state.go("home")
	}
	
	$scope.checkEditMode = function(){
		if($sessionStorage.userId!=""){
			$scope.editmode = true;
			homeFac.getUserById($sessionStorage.userId, function(response){
				if(response.status==200){
					$scope.createUser = response.data;
					$scope.editmode = true;
				}
			})
			
		}else{
			$scope.editmode = false;
		}
	}
	
	$scope.createUserSubmit = function(createUser){
		if($scope.editmode){
			homeFac.updateUser(createUser, function(response){
				if(response.status==200){
					if(response.data.serviceStatus="Success"){
						$scope.resposeMsg = response.data.serviceMessage
						$scope.createUser = {}
					}
				}
			})
		}else{
			homeFac.createUser(createUser, function(response){
				if(response.status==200){
					if(response.data.serviceStatus="Success"){
						$scope.resposeMsg = response.data.serviceMessage
						$scope.createUser = {}
					}
				}
			})
		}
	}
	
	$scope.checkEditMode();
	
})