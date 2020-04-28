$(document).ready(function(){

    $('#tabla-productos').DataTable();
    cargarTablaProductos();

});



function cargarTablaProductos(){
    fetch('/api/inventario')
    .then(res => res.json())
    .then(array => {

        let tabla = $('#tabla-productos').DataTable();
        tabla.clear().draw();
        let spanStock;
        let porcentaje = 0;
        let colorSpan = "success";

        array.map(function(item,i){

            porcentaje = item.stockActual * 100 / item.stockPromedio

            if(porcentaje<65 && porcentaje>25){
                colorSpan = "warning";
            }else if(porcentaje<25){
                colorSpan = "danger";
            }
            

            spanStock = `<span class="badge badge-pill badge-${colorSpan}">${item.stockActual}</span>`;

            tabla.row.add([
                i, item.producto.nombre, item.producto.familiaProducto.nombre, spanStock, item.stockPromedio, item.stockVentas, "nada"
            ]).draw(false);

        });
    })
    .catch(error =>{
        console.log(error);
    })
};