$(document).ready(function(){

    $.ajax({
        url:"http://localhost:8080/AerodromWP/letovi",
        type:"get",
        success: function(response){
            console.log(response)
            
            $.each(JSON.parse(response),function(i,item){
                var $tr = $('<tr>').append(
                    $('<td>').text(item.id),
                    $('<td>').text(item.broj)
                ).appendTo('#tbody')

                console.log(item.broj)
            })

        },
        error: function(error){
            console.log(error);
        }

    })

});