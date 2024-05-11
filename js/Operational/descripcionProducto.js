function save() {
    try {
      var selectedCityId = parseInt($("#selected_city_id").val());
      if (isNaN(selectedCityId) || selectedCityId === null) {
        Swal.fire({
          title: "Oops!",
          text: "failed registration city!",
          icon: "error",
          timer: 2000, 
          buttons: false 
      });
        return;
      }
  
      var productoDta = {
        "descuento": $("#descuento").val(),
        "subTotal": $("#subTotal").val(),
        "cantidad": $("#t_productoID").val(),
        "productoID": $("#productoID").val(),
        "ventasId": $("#ventasId").val(),
        "porcentajeDescuent": $("#porcentajeDescuent").val(),
        "estado": $("#estado").val(),
      
      };
      
  
  
      $.ajax({
        url: "http://localhost:9000/ecom/v1/api/descripcionProductos",
        method: "POST",
        dataType: "json",
        contentType: "application/json",
        data: JSON.stringify(productoDta),
        success: function(data) {
          var id = data.data.id;
          console.log(data);
         
          User(id); // Aquí se pasa el ID a la función User
         // alert("Registro agregado con éxito" + id);
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
        url: "http://localhost:9000/ecom/v1/api/descripcionProductos",
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
                  <td>${item.descuento}</td>
                  <td>${item.subTotal}</td>
                  <td>${item.ventasId}</td>
                  <td>${item.porcentajeDescuent}</td>
                  <td>${item.estado}</td>
              
            
                 
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
      $.ajax({
        url: "http://localhost:9000/ecom/v1/api/descripcionProductos/" + id,
        method: "delete",
        headers: {
          "Content-Type": "application/json",
        },
      }).done(function (result) {
        alert("Registro eliminado con éxito");
        loadData();
      });
    }
    
    
    function update() {
      // Construir el objeto data
      try{
        var data = {
          "descuento": $("#descuento").val(),
          "subTotal": $("#subTotal").val(),
          "cantidad": $("#t_productoID").val(),
          "productoID": $("#productoID").val(),
          "ventasId": $("#ventasId").val(),
          "porcentajeDescuent": $("#porcentajeDescuent").val(),
          "estado": $("#estado").val(),
         
          
        };
    
        
        var id = $("#id").val();
        var jsonData = JSON.stringify(data);
        $.ajax({
          url: "http://localhost:9000/ecom/v1/api/descripcionProductos/" + id,
          data: jsonData,
          method: "PUT",
          headers: {
            "Content-Type": "application/json",
          },
        }).done(function (result) {
          alert("Registro actualizado con éxito");
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
        url: "http://localhost:9000/ecom/v1/api/descripcionProductos/" + id,
        method: "GET",
        dataType: "json",
        success: function (response) {
          var data=response.data;
          $("#id").val(data.id);
         
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
    