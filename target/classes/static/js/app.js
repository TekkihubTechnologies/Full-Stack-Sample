var app = angular.module('sample', ['ui.router', 'ngStorage']);

app.constant('urlRoutePrefix',contextPath);

app.config(['$stateProvider', '$urlRouterProvider', function($stateProvider, $urlRouterProvider){
	
	$urlRouterProvider.otherwise('/home');
	
	$stateProvider.state('home', {
		url:'/home',
		templateUrl: 'pages/home.html',
		controller: 'homeCtrl'
	}).state('createUser', {
		url:'/createUser',
		templateUrl: 'pages/create.html',
		controller: 'createCtrl'
	})
	
}]);