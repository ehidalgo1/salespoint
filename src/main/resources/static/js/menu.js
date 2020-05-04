$(document).ready(function(){
    menu();
})


function menu(){
    $('#menu').find('li').click(function(e){
        if($(this).context.children[0].href === window.location.href){
            $(this).addAttr('class','active');
        }
    });
}