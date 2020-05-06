$(document).ready(function(){
    $('#tabla-facturas').DataTable();
    llenarTablaFacturas();
    $('.popover-dismiss').popover({
        trigger: 'focus'
      });
});

function llenarTablaFacturas(){
    fetch('/api/factura')
    .then(res => res.json())
    .then(array =>{

        let tabla = $('#tabla-facturas').DataTable();
        tabla.clear().draw();
        let popover = `<a tabindex="0" class="btn btn-sm btn-info" role="button" data-toggle="popover" data-trigger="focus" title="Dismissible popover" data-content="And here's some amazing content. It's very engaging. Right?">Dismissible popover</a>`;
        let fecha;
        let formatoFecha;

        array.map(function(item,i){

            fecha = new Date(item.fecha);
            formatoFecha = `${fecha.getDate()}/${fecha.getMonth()+1}/${fecha.getFullYear()}`

            tabla.row.add([
                item.codFactura, formatoFecha, item.productos.length, item.productos.length, popover
            ]).draw(false);

        });

        $('.popover-dismiss').popover({
            trigger: 'focus'
          });
    })
    .catch(error => {
        console.log(error);
    })
}