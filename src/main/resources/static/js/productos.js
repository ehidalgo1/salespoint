$(document).ready(function(){
    $('#tabla-productos').DataTable();
    llenarTablaInventario();
});

function llenarTablaInventario(){

    fetch('/api/producto')
    .then(res => res.json())
    .then(array => {

        let tabla = $('#tabla-productos').DataTable();
        tabla.clear().draw();

        array.map(function(item,i){

            tabla.row.add([
                i+1,item.nombre, item.familiaProducto.nombre,""

            ]).draw(false);

        });

    })
    .catch(error => {
        console.log(error);
    })

};


//accion abrir modal
$('#btn-agregar').click(function(){

    $('#modal-agregar').modal('show');

});