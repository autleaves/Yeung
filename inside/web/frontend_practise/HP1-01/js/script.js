
function printDate(){
youbi = new Array("日","月","火","水","木","金","土");
myDate = new Date();
theDate = myDate.getDate(); theDay = youbi[myDate.getDay()];
theFyear = myDate.getFullYear();
theYear = myDate.getYear(); theMonth = myDate.getMonth() + 1;
document.write( theFyear + "年" + theMonth + "月" + theDate + "日(" + theDay + ")" );
}
