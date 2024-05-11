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
          // Verificar si el campo deletedAt es nulo (no eliminado lógicamente)
            // Construir el HTML para cada objeto
            html +=
            

              `<tr>
              <th scope="row">${item.id}</th>
              
                <td>${item.nombreProducto}</td>
                <td>${item.cantidad}</td>
                
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
  
  function metrica() {
    console.log("Ejecutando loadData");
    $.ajax({
      url: "http://localhost:8000/ShoeStore/v1/api/ventas/dasboard",
      method: "GET",
      dataType: "json",
      success: function (response) {
        var data = response.data;
        $("#clientes").text(data.clientes);
        $("#ventas").text(data.ventas);
        $("#productos").text(data.productos);
      },
      error: function (error) {
        console.error("Error en la solicitud:", error);
      },
    });
}


 