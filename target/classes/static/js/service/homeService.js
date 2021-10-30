app.factory('homeFac', function($http, urlRoutePrefix){
	
	var getAllUsers = function(param, callback){
		
		var req = {
			method:"GET",
			url: urlRoutePrefix + "/getAllUsers",
			headers:{
				'Content-type': 'application/json',
				'Accept': 'application/json'
			}
		}
		$http(req).then(function(data){
			callback(data)
		}, function(data){
			callback(data);
		})
	}
	
	var createUser = function(param, callback){
		
		var req = {
			method:"POST",
			url: urlRoutePrefix + "/createUser",
			headers:{
				'Content-type': 'application/json',
				'Accept': 'application/json'
			},
			data: param
		}
		$http(req).then(function(data){
			callback(data)
		}, function(data){
			callback(data);
		})
	}
	
	var getUserById = function(param, callback){
		
		var req = {
			method:"GET",
			url: urlRoutePrefix + "/getUserById/"+param,
			headers:{
				'Content-type': 'application/json',
				'Accept': 'application/json'
			}
		}
		$http(req).then(function(data){
			callback(data)
		}, function(data){
			callback(data);
		})
	}
	
	var updateUser = function(param, callback){
		var req = {
			method: 'PUT',
			url: urlRoutePrefix + "/updateUser",
			headers:{
				'Content-type': 'application/json'
			},
			data: param
		}
		
		$http(req).then(function(data){
			callback(data);
		}, function(data){
			callback(data);
		})
	};
	
	var deleteUser = function(param, callback){
		var req = {
			method: 'DELETE',
			url: urlRoutePrefix + "/deleteByUserId/"+param,
			headers:{
				'Content-type': 'application/json'
			},
			data: {}
			
		}
		
		$http(req).then(function(data){
			callback(data);
		}, function(data){
			callback(data);
		})
	}
	
	
	
	return {
		getAllUsers:getAllUsers,
		createUser:createUser,
		getUserById:getUserById,
		updateUser:updateUser,
		deleteUser:deleteUser
	};
});