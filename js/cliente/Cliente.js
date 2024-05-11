
  
  
  function save() {
    try {
    

      var clienteData = {
        "nombreCliente": $("#nombreCliente").val(),
        "apellidoCliente": $("#apellidoCliente").val(),
        "telefono": $("#telefono").val(),
        "tipoIndentificacion": $("#tipoIndentificacion").val(),
        "indentificacion": $("#indentificacion").val(),
        "direccion": $("#direccion").val(),
        "ciudad":$("#ciudad").val(),
       
       
        "state":$("#estado").val()
      };
  
  
   
      $.ajax({
        url: "http://localhost:8000/ShoeStore/v1/api/Clientes",
        method: "POST",
        dataType: "json",
        contentType: "application/json",
        data: JSON.stringify(clienteData),
        success: function(data) {
          var id = data.id
          console.log(data.data);
        
  
        
          Swal.fire({
            title: "perfect!",
            text: "Registro agregado con éxito!",
            icon: "success",
            timer: 8000, 
            buttons: false 
        }); 
          clearData();
          loadData();
        },
        error: function(error) {
          alert(error.responseJSON.message);
          //console.log($("#person_id").val());
        },
      });
    } catch (error) {
      console.error("Error obteniendo el cliente:", error);
    }
  
   
  }
  function filters() {
    var nombre = $("#filterNombre").val();
    var ciudad = $("#filterCiudad").val();
    var estado = $("#filterestado").val();

    console.log("ejecutando loadData");

    // Construir la URL de la solicitud AJAX con los parámetros dinámicos
    var url = "http://localhost:8000/ShoeStore/v1/api/Clientes/filters/{nombre}/{ciudad}/{sta}?nombre=" + encodeURIComponent(nombre);

    // Agregar la ciudad solo si tiene un valor
    if (ciudad.trim() !== "") {
        url += "&ciudad=" + encodeURIComponent(ciudad);
    }

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
            data.forEach(function(item) {
                console.log(item.id);
                
                    html +=
                        `<tr>
                            <td>` + item.id + `</td>
                            <td>` + item.tipoIndentificacion + `</td>
                            <td>` + item.indentificacion + `</td>
                            <td>` + item.nombreCliente + `</td>
                            <td>` + item.apellidoCliente + `</td>
                            <td>` + item.telefono + `</td>
                            <td>` + item.direccion + `</td>
                            <td>` + item.ciudad + `</td>
                            <td>` + (item.state == true ? "Activo" : "Inactivo") + `</td>
                            <td> 
                                <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#staticBackdrop" onclick="findById(${item.id})"> 
                                    <img src="/assets/icon/pencil-square.svg" > 
                                </button>
                                <button type="button" class="btn btn-secundary" onclick="deleteById(${item.id})"> 
                                    <img src="/assets/icon/trash3.svg" > 
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


  
  
  function clearData() {
    $("#id").val("");
    $("#firstName").val("");
    $("#lastName").val("");
    $("#t_document").val("");
    $("#document").val("");
    $("#email").val("");
    $("#phone").val("");
    $("#dateOfBirth").val("");
    $("#gender").val("");
    $("#address").val("");
    $("#city_id").val("");
   
    $("#estado").val("");
  }
  
  
  
  function loadData() {
    console.log("ejecutando loadData");
    $.ajax({
      url: "http://localhost:8000/ShoeStore/v1/api/Clientes",
      method: "GET",
      dataType: "json",
      success: function (response) {
        console.log(response.data);
        var html = "";
        var data = response.data;
        data.forEach(function (item) {
  
          console.log(item.id);
          // Construir el HTML para cada objeto
          if (!item.deletedAt) { // Verificar si el campo deletedAt es nulo (no eliminado lógicamente)
  
          html +=
            `<tr>
                    
                    <td>` + item.id + `</td>
                    <td>` + item.tipoIndentificacion + `</td>
                    <td>` + item.indentificacion + `</td>
                    <td>` + item.nombreCliente + `</td>
                    <td>` + item.apellidoCliente + `</td>
                    <td>` + item.telefono + `</td>
                    <td>` + item.direccion + `</td>
                    <td>` + item.ciudad + `</td>
                 
                    <td>` + (item.state == true ? "Activo" : "Inactivo") + `</td>
                    <td> <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#staticBackdrop" onclick="findById(${item.id})"> <img src="/assets/icon/pencil-square.svg" > </button>
                    <button type="button" class="btn btn-secundary" onclick="deleteById(${item.id})"> <img src="/assets/icon/trash3.svg" > </button></td>
                </tr>`;
                         
                         };
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
          url: "http://localhost:8000/ShoeStore/v1/api/Clientes/" + id,
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
   
    
    try{
    


      var data = {
        "nombreCliente": $("#nombreCliente").val(),
        "apellidoCliente": $("#apellidoCliente").val(),
        "telefono": $("#telefono").val(),
        "tipoIndentificacion": $("#tipoIndentificacion").val(),
        "indentificacion": $("#indentificacion").val(),
        "direccion": $("#direccion").val(),
        "ciudad":$("#ciudad").val(),
        
        
       
        "state": $("#estado").val()
      };
  
  
   
  
      console.log(data);
      
      var id = $("#id").val();
      var jsonData = JSON.stringify(data);
  
      $.ajax({
        url: "http://localhost:8000/ShoeStore/v1/api/Clientes/" + id,
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
      });      loadData();
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
      url: "http://localhost:8000/ShoeStore/v1/api/Clientes/" + id,
      method: "GET",
      dataType: "json",
      success: function (response) {
        var data=response.data;
        $("#id").val(data.id);
        $("#nombreCliente").val(data.nombreCliente);
        $("#apellidoCliente").val(data.apellidoCliente);
        $("#telefono").val(data.telefono);
        $('#indentificacion').val(data.indentificacion);
        $('#direccion').val(data.direccion);
        $('#ciudad').val(data.ciudad);
    
        $("#estado").val(data.state == true ? 1 : 0);
  
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
  
  function loadTypeDocument() {
    $.ajax({
        url: "http://localhost:9000/service-security/v1/api/enum/type-document",
        method: "GET",
        dataType: "json",
        success: function (response) {
            console.log(response);
            var html = "";
                response.forEach(function (item) {
                    // Construir el HTML para cada objeto
                    html += `<option value="${item}">${item}</option>`;
                });
                $("#type_document").html(html);
                $("#t_document").html(html);
        },
        error: function (error) {
            // Función que se ejecuta si hay un error en la solicitud
            console.error("Error en la solicitud:", error);
        },
    });
  }