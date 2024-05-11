function save() {
    try {
      var stateValor = $("#state").val();

    
      var stateBooleano;
      
      if (stateValor === 1) {
          stateBooleano = true;
      } else {
          stateBooleano = false;
      }
  
      var productoDta = {
        "nombreProducto": $("#nombreProducto").val(),
        "description": $("#description").val(),
        "cantidad": $("#cantidad").val(),
        "precio": $("#precio").val(),
        "procentajeIva": $("#procentajeIva").val(),
        "procentajeDescuento": $("#procentajeDescuento").val(),
        "state": stateBooleano,
      
      };
      
  
  
      $.ajax({
        url: "http://localhost:8000/ShoeStore/v1/api/productos",
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
                  <td>${item.nombreProducto}</td>
                  <td>${item.description}</td>
                  <td>${item.cantidad}</td>
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
    
    function findById(id) {
      $.ajax({
        url: "http://localhost:8000/ShoeStore/v1/api/productos/" + id,
        method: "GET",
        dataType: "json",
        success: function (response) {
          var data=response.data;
          $("#id").val(data.id);
          $("#nombreProducto").val(data.nombreProducto);
          $("#description").val(data.description);
          $("#cantidad").val(data.cantidad);
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
    

    
  function filters() {
    var nombre = $("#filterNombre").val();
    var ciudad = $("#filterestado").val();


    console.log("ejecutando loadData");

    // Construir la URL de la solicitud AJAX con los parámetros dinámicos
    var url = "http://localhost:8000/ShoeStore/v1/api/Clientes/filters/{nombre}/{ciudad}/{sta}?nombre=" + encodeURIComponent(nombre);

    // Agregar la ciudad solo si tiene un valor
 
    // Agregar el estado solo si tiene un valor
    if (estado.trim() !== "") {
        url += "&sta=" + encodeURIComponent(estado);
    }

    $.ajax({
        url: url,
        method: "GET",
        dataType: "json",
        success: function(response) {
            console.log(response.data);
            var html = "";
            var data = response.data;
            console.log(data);
            data.forEach(function(item) {
                console.log(item.id);
                
                    html +=
                    `<tr>
                    <td>${item.id}</td>
                    <td>${item.nombreProducto}</td>
                    <td>${item.description}</td>
                    <td>${item.cantidad}</td>
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
                
            });

            $("#resultData").html(html);
        },
        error: function(error) {
            // Función que se ejecuta si hay un error en la solicitud
            console.error("Error en la solicitud:", error);
        },
    });
}