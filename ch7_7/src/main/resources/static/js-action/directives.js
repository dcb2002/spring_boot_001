/**
 * 
 *【1】自定义指令
 *【2】AC:属性指令、样式指令。
 * 
 */
actionApp.directive('datePicker',function(){
    return {
        restrict: 'AC',
        link:function(scope,elem,attrs){		//使用link 方法来定义指令。
        														//scope：当前scope
        														//elem：当前元素
        														//attrs：当前元素属性
        	
           // scope.treeObj = $.fn.zTree.init(elem, scope.settings);
            
            elem.datepicker();							//调用jqueryUI的功能：$('id').datePicker();
        }
    };
});


