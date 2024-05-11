
    function loadData() {
      console.log("ejecutando loadData");
      $.ajax({
        url: "http://localhost:8000/ShoeStore/v1/api/DescripcionVentas",
        method: "GET",
        dataType: "json",
        success: function (response) {
          console.log(response.data);
          var html = "";
          var data = response.data;
          data.forEach(function (item) {
            // Verificar si el campo deletedAt es nulo (no eliminado lógicamente)
              // Construir el HTML para cada objeto
              html +=
                `<tr>
                  <td>${item.venta.id}</td>
                  <td>${item.venta.cliente.id}</td>
                  <td>${item.venta.total}</td>
                  <td>${item.venta.date}</td>
                  <td>${item.venta.state}</td>
                
            
                  
                  <td>
                    <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#staticBackdrop" onclick="detalle(${item.id})">
                    Ver detalle
                    </button>
                   
                  </td>
                </tr>`;
            
          });
    
          $("#resultData").html(html);
        },
        error: function (error) {
          // Función que se ejecuta si hay un error en la solicitud
          console.error("Error en la solicitud:", error);
        },
      });
    }
    
  
  function deleteById(id) {
  
    Swal.fire({
      title: "¿Está seguro de eliminar?",
      text: "Esta acción no se puede revertir",
      icon: "warning",
      showCancelButton: true,
      confirmButtonColor: "#3085d6",
      cancelButtonColor: "#d33",
      confirmButtonText: "si"
    }).then((result) => {
      if (result.isConfirmed) {
        $.ajax({
          url: "http://localhost:8000/ShoeStore/v1/api/productos/" + id,
          method: "delete",
          headers: {
            "Content-Type": "application/json",
          },
        }).done(function (result) {
          loadData();
          Swal.fire({
            title: "Deleted!",
            text: "Your file has been deleted.",
            icon: "success"
          });
        });
      }
    });
  
  }
    
    function update() {
      // Construir el objeto data
      try{
        // var stateValor = $("#state").val();
        // console.log(stateValor);

        // // Convierte el valor a un booleano
        // var stateBooleano;
        
        // if (stateValor === 1) {
        //     stateBooleano = true;
        // } else {
        //     stateBooleano = false;
        // }
        var data = {
          "nombreProducto": $("#nombreProducto").val(),
        "description": $("#description").val(),
        "cantidad": $("#cantidad").val(),
        "precio": $("#precio").val(),
        "procentajeIva": $("#procentajeIva").val(),
        "procentajeDescuento": $("#procentajeDescuento").val(),
        "state": true,
      
         
          
        };
    
        
        var id = $("#id").val();
        var jsonData = JSON.stringify(data);
        $.ajax({
          url: "http://localhost:8000/ShoeStore/v1/api/productos/" + id,
          data: jsonData,
          method: "PUT",
          headers: {
            "Content-Type": "application/json",
          },
        }).done(function (result) {
          Swal.fire({
            title: "perfect!",
            text: "Registro actualizado con éxito!",
            icon: "success",
            timer: 8000, 
            buttons: false 
        }); 
          loadData();
          clearData();
      
          //actualzar boton
          var btnAgregar = $('button[name="btnAgregar"]');
          btnAgregar.text("Agregar");
          btnAgregar.attr("onclick", "save()");
        });
      }catch (error) {
        alert("Error en actualizar user.");
        console.error("Error en la solicitud:", error);
        //actualzar boton
        loadData();
        clearData();
        var btnAgregar = $('button[name="btnAgregar"]');
        btnAgregar.text("Agregar");
        btnAgregar.attr("onclick", "save()");
      }
    }
    
    function detalle(id) {
      $.ajax({
        url: "http://localhost:8000/ShoeStore/v1/api/DescripcionVentas/" + id,
        method: "GET",
        dataType: "json",
        success: function (response) {
          var data=response.data;
          $("#idDescpro").val(data.id);
          $("#idVentas").val(data.venta.id)
          $("#cliente_id").val(data.venta.cliente.nombreCliente);
          $("#selected_cliente_id").val(data.venta.cliente.id);
          
          $("#total").val(data.venta.total);
          $("#fechaDeVenta").val(data.venta.date);


          $("#producto_id").val(data.producto.nombreProducto);
          $("#selected_producto_id").val(data.producto.id);
          $("#cantidad").val(data.cantidad);
          $("#precio").val(data.precio);
          $("#procentajeDescuento").val(data.descuento);
          $("#estado").val(data.venta.state);
          $("#subtotal").val(data.subTotal);
          $("#procentajeIva").val(data.procentajeIva);
   
         
          //Cambiar boton.
          var btnAgregar = $('button[name="btnAgregar"]');
          btnAgregar.text("Actualizar");
          btnAgregar.attr("onclick", "updateDetalle()");
        },
        error: function (error) {
          // Función que se ejecuta si hay un error en la solicitud
          console.error("Error en la solicitud:", error);
        },
      });
    }
    
    function updateDetalle(){
      // Construir el objeto data
      try{
        var nombreProducto = parseInt($("#selected_producto_id").val());
        if (isNaN(nombreProducto) || nombreProducto === null) {
          console.error("ID de product no válido");
          return;
        }
    
        var idV = $("#idVentas").val();
        console.log(idV);
    
      var productoDta = {
        "descuento": $("#procentajeDescuento").val(),
        "subTotal": $("#subtotal").val(),
        "precio": $("#precio").val(),
        "cantidad": $("#cantidad").val(),
        "producto": {
            "id":nombreProducto
        },
        "venta": {
            "id" : idV
        },
        "state": true,
      
      };
      
      var idDes = $("#idDescpro").val();
      
      var jsonData = JSON.stringify(productoDta);
  
      $.ajax({
        url: "http://localhost:8000/ShoeStore/v1/api/DescripcionVentas/"+ idDes,
        
        
      
          data: jsonData,
          method: "PUT",
          headers: {
            "Content-Type": "application/json",
          },
        }).done(function (result) {
          Swal.fire({
            title: "perfect!",
            text: "Registro actualizado con éxito!",
            icon: "success",
            timer: 8000, 
            buttons: false 
        }); 
        updateVenta();
        
          loadData();
          clearData();
      
          //actualzar boton
          var btnAgregar = $('button[name="btnAgregar"]');
          btnAgregar.text("Agregar");
          btnAgregar.attr("onclick", "save()");
        });
      }catch (error) {
        alert("Error en actualizar user.");
        console.error("Error en la solicitud:", error);
        //actualzar boton
        loadData();
        clearData();
        var btnAgregar = $('button[name="btnAgregar"]');
        btnAgregar.text("Agregar");
        btnAgregar.attr("onclick", "save()");
      }
    }

    
    function updateVenta(){
      // Construir el objeto data
      try{
        var estadoSeleccionado = $("#estado").val();

        var nombrecliente = parseInt($("#selected_cliente_id").val());
        if (isNaN(nombrecliente) || nombrecliente === null) {
          console.error("ID de cliente no válido");
          return;
        }
    
        var idV = $("#idVentas").val();
      
    
      var productoDta = {
        "total": $("#total").val(),
        "date": $("#fechaDeVenta").val(),
        "cliente": {
            "id": nombrecliente
        },
        "state": estadoSeleccionado 
      
      };
      
     
      
      var jsonData = JSON.stringify(productoDta);
  
      $.ajax({
        url: "http://localhost:8000/ShoeStore/v1/api/ventas/"+ idV,
        
        
      
          data: jsonData,
          method: "PUT",
          headers: {
            "Content-Type": "application/json",
          },
        }).done(function (result) {
          Swal.fire({
            title: "perfect!",
            text: "Registro actualizado con éxito!",
            icon: "success",
            timer: 8000, 
            buttons: false 
        }); 
          loadData();
          clearData();
      
          //actualzar boton
          var btnAgregar = $('button[name="btnAgregar"]');
          btnAgregar.text("Agregar");
          btnAgregar.attr("onclick", "save()");
        });
      }catch (error) {
        alert("Error en actualizar user.");
        console.error("Error en la solicitud:", error);
        //actualzar boton
        loadData();
        clearData();
        var btnAgregar = $('button[name="btnAgregar"]');
        btnAgregar.text("Agregar");
        btnAgregar.attr("onclick", "save()");
      }
    }
    
    
    function clearData() {
      $("#id").val("");
     
    }
    

    function loadCliente() {
      $.ajax({
        url: "http://localhost:8000/ShoeStore/v1/api/Clientes",
        method: "GET",
        dataType: "json",
        success: function (response) {
          if (response.status && Array.isArray(response.data)) {
            var cities = response.data.map(function (cliente) {
              return {
                label: cliente.nombreCliente,
                value: cliente.id // Agrega el ID como valor
              };
            });
    
          
            $("#cliente_id").autocomplete({
              source: function(request, response) {
                var results = $.ui.autocomplete.filter(cities, request.term);
                if (!results.length) {
                  results = [{ label: 'No se encontraron resultados', value: null }];
                }
                response(results);
              },
              select: function (event, ui) {
                
                $("#selected_cliente_id").val(ui.item.value);
               
                $("#cliente_id").val(ui.item.label);
                console.log("ID de ciudad seleccionada: " + ui.item.value);
                return false;
              }
            });
          } else {
            console.error("Error: No se pudo obtener la lista de ciudades.");
          }
        },
        error: function (error) {
          // Función que se ejecuta si hay un error en la solicitud
          console.error("Error en la solicitud:", error);
        },
      });
    }
    
    
    

  function filters() {
    var fi = $("#filterFechai").val();
    var fe = $("#filterFechad").val();
   
  
    // Verificar si los campos están vacíos y asignar null si es necesario
  
  
    console.log("Ejecutando loadData");
    $.ajax({
      url: "http://localhost:8000/ShoeStore/v1/api/ventas/fil/"+ fi +"/"+fe,
      method: "GET",
      dataType: "json",
  
      
      success: function (response) {
        console.log(response.data);
        var html = "";
        var data = response.data;
        data.forEach(function (item) {
          console.log(item.id);
         
          html +=
          `<tr>
          <td>${item.id}</td>
          <td>${item.cliente.id}</td>
          <td>${item.total}</td>
          <td>${item.date}</td>
          <td>${item.state}</td>
        
    
          
          <td>
            <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#staticBackdrop" onclick="detalle(${item.id})">
            Ver detalle
            </button>
           
          </td>
        </tr>`;
        });
  
        $("#resultData").html(html);
      },
      error: function (error) {
        // Función que se ejecuta si hay un error en la solicitud
        console.error("Error en la solicitud:", error);
      },
    });
  }
  

  
function loadCProducto() {

  console.log("Ejecutando loadCity");
$.ajax({
  url: "http://localhost:8000/ShoeStore/v1/api/productos",
  method: "GET",
  dataType: "json",
  success: function (response) {
      if (response.status && Array.isArray(response.data)) {
          var productos = response.data.map(function (producto) {
              return {
                  label: producto.nombreProducto,
                  value: producto.id,
                  precio: producto.precio 
              };
          });

         
          $("#producto_id").autocomplete({
              source: function(request, response) {
                  var results = $.ui.autocomplete.filter(productos, request.term);
                  if (!results.length) {
                      results = [{ label: 'No se encontraron resultados', value: null, precio: null }];
                  }
                  response(results);
              },
              select: function (event, ui) {
                  
                  $("#selected_producto_id").val(ui.item.value);
                 
                  $("#producto_id").val(ui.item.label);
                  
                  $("#precio").val(ui.item.precio);
                  console.log("ID de producto seleccionado: " + ui.item.value);
                  return false; 
              }
          });
      } else {
          console.error("Error: No se pudo obtener la lista de productos.");
      }
  },
  error: function (error) {
      //
      console.error("Error en la solicitud:", error);
  },
});

}