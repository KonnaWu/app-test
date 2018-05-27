
// 10秒后执行
var t1 = window.setTimeout(function () {
    alert("hello");
},10000);
window.clearTimeout(t1);

// 每隔10秒执行
window.setInterval(function () {
    alert("hello");
},10000);