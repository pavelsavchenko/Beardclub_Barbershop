var hellopreloader = document.getElementById("hellopreloader_preload");
function fadeOutnojquery(el){el.style.opacity = 1;
var interhellopreloader = setInterval(function(){el.style.opacity = el.style.opacity - 0.05;
if (el.style.opacity <=0.05){
    clearInterval(interhellopreloader);
    hellopreloader.style.display = "none";}},16);}
    window.onload = function(){
    setTimeout(function(){
        fadeOutnojquery(hellopreloader);});};

//
// function search () {
//
//     var search = $('#search').val();
//
//     $.ajax({
//
//         url: '/searchDrink?'+ $('input[name=csrf_name]').val() + "=" + $('input[name=csrf_value]').val(),
//         method: 'GET',
//         data: JSON.stringify(search),
//         success: function(res)
//     })
// }

function changeRange() {

    console.log($('#rangePrice').val());
    document.getElementById('rangeValue').innerHTML=$('#rangePrice').val();
}

//////////////////////
