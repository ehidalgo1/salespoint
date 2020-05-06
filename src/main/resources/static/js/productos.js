$(document).ready(function(){
    $('#tabla-productos').DataTable();
    llenarTablaProductos();
});

function llenarTablaProductos(){

    fetch('/api/producto')
    .then(res => res.json())
    .then(array => {

        let tabla = $('#tabla-productos').DataTable();
        tabla.clear().draw();

        let btnEditar;
        let btnEliminar;

        array.map(function(item,i){

            btnEditar = `<a href="#" onclick="openModalEditar(${item.idProducto})"><i class="fas fa-pencil-alt"></i></a>`;
            btnEliminar = `<a href="#" onclick="openModalEliminar(${item.idProducto})"><i class="far fa-trash-alt"></i></a>`;

            tabla.row.add([
                i+1,item.nombre, item.familiaProducto.nombre,btnEditar+" "+btnEliminar

            ]).draw(false);

        });

    })
    .catch(error => {
        console.log(error);
    })

};


//accion abrir modal
$('#btn-agregar').click(function(){

    $('.modal-title').text('Agregar Producto');
    $('#btn-editar-producto').remove();
    btnAgregar = `<input id="btn-agregar-producto" onclick="agregarProducto()" type="submit" class="btn btn-primary" value="Agregar">`;
    $('.modal-footer').html(btnAgregar);
    $('#modal-agregar').modal('show');
    
});

function agregarProducto(){
    event.preventDefault();
    
    const tipo = $('#select-tipo').val();
    const nombre = $('#nombre').val();

    if(tipo!=='' && nombre !==''){

        let data = {
            "nombre" : nombre,
            "familiaProducto":{
                "idFamilia" : parseInt(tipo)
            }
        }

        fetch('/api/producto/add',{
            method: 'post',
            body: JSON.stringify(data),
            headers: {
                'Content-Type': 'application/json'
            }
        })
        .then(res => res.json())
        .then(response => {
            //si es exitoso llamo nuevamente a la tabla y escondo el modal
            if(response === 200){
                llenarTablaProductos();
                $('#modal-agregar').modal('hide');
                $('#form-agregar').trigger('reset');
            }else if(response === 100){
                alert('No se ha encontrado el producto');
            }else if(response === 500){
                alert('Ocurrio un error de servidor, intentelo nuevamente');
            }
        })
        .catch(error => console.error('Error:', error))

    }

}

function openModalEditar(idProducto){
    event.preventDefault();

    fetch('/api/producto/get/'+idProducto)
    .then(res => res.json())
    .then(producto => {

        $('.modal-title').text('Editar Producto');
        $('#btn-agregar-producto').remove();
        let btnEditar = `<input id="btn-editar-producto" onclick="editarProducto(${idProducto})" type="submit" class="btn btn-primary" value="Editar">`
        $('.modal-footer').html(btnEditar);
        $('#modal-agregar').modal('show');
        $('#select-tipo').val(producto.familiaProducto.idFamilia);
        $('#nombre').val(producto.nombre);
    })
    .catch(error => console.error(error))
}

function editarProducto(idProducto){

    event.preventDefault();
    
    const tipo = $('#select-tipo').val();
    const nombre = $('#nombre').val();

    if(tipo!=='' && nombre !==''){

        let data = {
            "nombre" : nombre,
            "familiaProducto":{
                "idFamilia" : parseInt(tipo)
            }
        }

        fetch('/api/producto/edit/'+idProducto,{
            method: 'PUT',
            body: JSON.stringify(data),
            headers: {
                'Content-Type': 'application/json'
            }
        })
        .then(res => res.json())
        .then(response => {
            //si es exitoso llamo nuevamente a la tabla y escondo el modal
            if(response === 200){
                llenarTablaProductos();
                $('#modal-agregar').modal('hide');
                $('#form-agregar').trigger('reset');
                
            }else if(response === 100){
                alert('No se ha encontrado el producto');
            }else if(response === 500){
                alert('Ocurrio un error de servidor, intentelo nuevamente');
            }
        })
        .catch(error => console.error('Error:', error))

    }//endif

}


//open modal eliminar y funcion eliminar producto

function openModalEliminar(idProducto){
    event.preventDefault();
    const modEliminar = confirm(`seguro que desea eliminar el producto?`);
    if(modEliminar===true){

        fetch('/api/producto/delete/'+idProducto,{
            method: 'DELETE'
        })
        .then(res => res.json())
        .then(response => {
            if(response === 200){
                llenarTablaProductos();
                alert('Se ha eliminado el producto');
            }else if(response === 100){
                alert('No se ha encontrado el producto');
            }else if(response === 500){
                alert('Ocurrio un error de servidor, intentelo nuevamente');
            }
        })
        .catch(error => console.error(error))

    }
}


function eliminarProducto(idProducto){

    fetch('/api/producto/delete/'+idProducto,{
        method: 'DELETE',
        headers: {
            'Content-Type': 'application/json'
        }
    })
    .then(res => res.json())
    .then(response => {
        //si es exitoso llamo nuevamente a la tabla y escondo el modal
        if(response === 200){
            llenarTablaProductos();
            
        }
    })
    .catch(error => console.error('Error:', error))
}