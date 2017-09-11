/**
 * Created by pavelsavchenko on 19.06.17.
 */
$('#addCategory').click(function(){


    console.log('test')

    var category = {
        nameOfCategory: $('#nameCategory').val()
    };

    $.ajax({

        url : '/categoryOfCommodity?'+ $('input[name=csrf_name]').val() + "=" + $('input[name=csrf_value]').val(),
        method : 'POST',
        contentType: 'application/json; charset=UTF-8',
        dataType: 'json',
        data: JSON.stringify(category),
        success: function(res){
            console.log(res);
        }
    })
})
