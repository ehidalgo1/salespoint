$(document).ready(function(){

    $('#tabla-inventario').DataTable();
    cargarTablaInventario();

});



function cargarTablaInventario(){
    fetch('/api/inventario')
    .then(res => res.json())
    .then(array => {

        let tabla = $('#tabla-inventario').DataTable();
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
                i+1, item.producto.nombre, item.producto.familiaProducto.nombre, spanStock, item.stockPromedio, item.stockVentas, ""
            ]).draw(false);

        });
    })
    .catch(error =>{
        console.log(error);
    })
};