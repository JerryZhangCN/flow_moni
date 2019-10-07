var screenHeight = window.innerHeight  //浏览器窗口的内部高度
 
var component_left = $(".side-nav");
/* var  screenHeight =  document.documentElement.clientHeight; */
var leftScrollHeight = screenHeight-92-40+"px";
component_left.style.height = leftScrollHeight;
 
Ps.initialize(component_left, {
wheelSpeed: 3,
//wheelPropagation: true,
//maxScrollbarLength: middleScrollHeight
});