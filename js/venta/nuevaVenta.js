function save() {
    try {
        var estadoSeleccionado = $("#estado").val();

        
        var nombrecliente = parseInt($("#selected_cliente_id").val());
        if (isNaN(nombrecliente) || nombrecliente === null) {
          console.error("ID de ciudad no válido");
          return;
        }
    
      
  
      var productoDta = {
        "total": $("#total").val(),
        "date": $("#fechaDeVenta").val(),
        "cliente": {
            "id": nombrecliente
        },
        "state": estadoSeleccionado 
      
      };
      
  
  
      $.ajax({
        url: "http://localhost:8000/ShoeStore/v1/api/ventas",
        method: "POST",
        dataType: "json",
        contentType: "application/json",
        data: JSON.stringify(productoDta),
        success: function(response) {
            var ventaId = response.data.id;

          console.log(ventaId);
           // Aquí se pasa el ID a la función User
         // alert("Registro agregado con éxito" + id);
         Swal.fire({
          title: "perfect!",
          text: "Registro agregado con éxito!",
          icon: "success",
          timer: 8000, 
          buttons: false })

          clearData();
          loadData();
          saveDetalle(ventaId);
        },
        error: function(error) {
          alert(error.responseJSON.message);
        },
      });
    } catch (error) {
      console.error("Error obteniendo el cliente:", error);
    }
  }
  
  function saveDetalle(id) {
    console.log(id);
    
    try {

        var nombreProducto = parseInt($("#selected_producto_id").val());
        if (isNaN(nombreProducto) || nombreProducto === null) {
          console.error("ID de ciudad no válido");
          return;
        }
    
    
      var productoDta = {
        "descuento": $("#procentajeDescuento").val(),
        "subTotal": $("#subtotal").val(),
        "precio": $("#precio").val(),
        "cantidad": $("#cantidad").val(),
        "producto": {
            "id":nombreProducto
        },
        "venta": {
            "id" : id 
        },
        "state": true,
      
      };
      
  
  
      $.ajax({
        url: "http://localhost:8000/ShoeStore/v1/api/DescripcionVentas",
        method: "POST",
        dataType: "json",
        contentType: "application/json",
        data: JSON.stringify(productoDta),
        success: function(data) {
          
           // Aquí se pasa el ID a la función User
         // alert("Registro agregado con éxito" + id);
         Swal.fire({
          title: "perfect!",
          text: "Registro agregado con éxito!",
          icon: "success",
          timer: 8000, 
          buttons: false })

          clearData();
          loadData();
        },
        error: function(error) {
          alert(error.responseJSON.message);
        },
      });
    } catch (error) {
      console.error("Error obteniendo el cliente:", error);
    }
  }
  
  

function loadCProducto() {
    console.log("Ejecutando loadCity");
    $.ajax({
      url: "http://localhost:8000/ShoeStore/v1/api/productos",
      method: "GET",
      dataType: "json",
      success: function (response) {
        if (response.status && Array.isArray(response.data)) {
          var cities = response.data.map(function (producto) {
            return {
              label: producto.nombreProducto,
              value: producto.id // Agrega el ID como valor
            };
          });
  
          // Inicializar el autocompletado en el campo de entrada de texto
          $("#producto_id").autocomplete({
            source: function(request, response) {
              var results = $.ui.autocomplete.filter(cities, request.term);
              if (!results.length) {
                results = [{ label: 'No se encontraron resultados', value: null }];
              }
              response(results);
            },
            select: function (event, ui) {
              // Al seleccionar un elemento del autocompletado, guarda el ID en un campo oculto
              $("#selected_producto_id").val(ui.item.value);
              // Actualiza el valor del campo de entrada con el nombre de la persona seleccionada
              $("#producto_id").val(ui.item.label);
              console.log("ID de ciudad seleccionada: " + ui.item.value);
              return false; // Evita la propagación del evento y el formulario de envío
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
  
  
  function loadCliente() {
    console.log("Ejecutando loadCity");
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
  
          // Inicializar el autocompletado en el campo de entrada de texto
          $("#cliente_id").autocomplete({
            source: function(request, response) {
              var results = $.ui.autocomplete.filter(cities, request.term);
              if (!results.length) {
                results = [{ label: 'No se encontraron resultados', value: null }];
              }
              response(results);
            },
            select: function (event, ui) {
              // Al seleccionar un elemento del autocompletado, guarda el ID en un campo oculto
              $("#selected_cliente_id").val(ui.item.value);
              // Actualiza el valor del campo de entrada con el nombre de la persona seleccionada
              $("#cliente_id").val(ui.item.label);
              console.log("ID de ciudad seleccionada: " + ui.item.value);
              return false; // Evita la propagación del evento y el formulario de envío
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
  
  
    
  
    
    
    
    
    function clearData() {
      $("").val("");
      $("").val("");
      $("").val("");
      $("").val("");
      $("").val("");
      $("").val("");
     
     
    }
    function loadData() {
      console.log("ejecutando loadData");
      $.ajax({
        url: "http://localhost:8000/ShoeStore/v1/api/productos",
        method: "GET",
        dataType: "json",
        success: function (response) {
          console.log(response.data);
          var html = "";
          var data = response.data;
          data.forEach(function (item) {
            if (!item.deletedAt) { // Verificar si el campo deletedAt es nulo (no eliminado lógicamente)
              // Construir el HTML para cada objeto
              html +=
                `<tr>
                  <td>${item.id}</td>
                  <td>${item.total}</td>
                  <td>${item.date}</td>
                  <td>${item.cliente}</td>
                  <td>${item.precio}</td>
                  <td>${item.procentajeDescuento}</td>
                  <td>${item.procentajeIva}</td>
              
            
                  <td>` + (item.state == true ? "Activo" : "Inactivo") + `</td>
                  <td>
                    <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#staticBackdrop" onclick="findById(${item.id})">
                      <img src="../assets/icon/pencil-square.svg">
                    </button>
                    <button type="button" class="btn btn-primary" onclick="deleteById(${item.id})">
                      <img src="../assets/icon/trash3.svg">
                    </button>
                  </td>
                </tr>`;
            }
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
    
    // function update() {
    //   // Construir el objeto data
    //   try{
    //     // var stateValor = $("#state").val();
    //     // console.log(stateValor);

    //     // // Convierte el valor a un booleano
    //     // var stateBooleano;
        
    //     // if (stateValor === 1) {
    //     //     stateBooleano = true;
    //     // } else {
    //     //     stateBooleano = false;
    //     // }
    //     var data = {
    //       "total": $("#total").val(),
    //     "date": $("#date").val(),
    //     "cliente": $("#cliente").val(),
    //     "precio": $("#precio").val(),
    //     "procentajeIva": $("#procentajeIva").val(),
    //     "procentajeDescuento": $("#procentajeDescuento").val(),
    //     "state": true,
      
         
          
    //     };
    
        
    //     var id = $("#id").val();
    //     var jsonData = JSON.stringify(data);
    //     $.ajax({
    //       url: "http://localhost:8000/ShoeStore/v1/api/productos/" + id,
    //       data: jsonData,
    //       method: "PUT",
    //       headers: {
    //         "Content-Type": "application/json",
    //       },
    //     }).done(function (result) {
    //       Swal.fire({
    //         title: "perfect!",
    //         text: "Registro actualizado con éxito!",
    //         icon: "success",
    //         timer: 8000, 
    //         buttons: false 
    //     }); 
    //       loadData();
    //       clearData();
      
    //       //actualzar boton
    //       var btnAgregar = $('button[name="btnAgregar"]');
    //       btnAgregar.text("Agregar");
    //       btnAgregar.attr("onclick", "save()");
    //     });
    //   }catch (error) {
    //     alert("Error en actualizar user.");
    //     console.error("Error en la solicitud:", error);
    //     //actualzar boton
    //     loadData();
    //     clearData();
    //     var btnAgregar = $('button[name="btnAgregar"]');
    //     btnAgregar.text("Agregar");
    //     btnAgregar.attr("onclick", "save()");
    //   }
    // }
    
    function findById(id) {
      $.ajax({
        url: "http://localhost:8000/ShoeStore/v1/api/productos/" + id,
        method: "GET",
        dataType: "json",
        success: function (response) {
          var data=response.data;
          $("#id").val(data.id);
          $("#total").val(data.total);
          $("#date").val(data.date);
          $("#cliente").val(data.cliente);
          $("#precio").val(data.precio);
          $("#procentajeDescuento").val(data.procentajeDescuento);
          $("#procentajeIva").val(data.procentajeIva);
   
         
          //Cambiar boton.
          var btnAgregar = $('button[name="btnAgregar"]');
          btnAgregar.text("Actualizar");
          btnAgregar.attr("onclick", "update()");
        },
        error: function (error) {
          // Función que se ejecuta si hay un error en la solicitud
          console.error("Error en la solicitud:", error);
        },
      });
    }
    
    
    function clearData() {
      $("#id").val("");
     
    }
    