<%@ include file="comunes/cabecero.jsp"%>

<%@ include file="comunes/navegacion.jsp"%>

<div class="container">
    <div class="text-center" style="margin: 30px">
        <h3>Agregar Empleado</h3>
    </div>
    <form action="${urlAgregar}" modelAttribute="empleadoForma" method="post">
        <div class="mb-3">
            <label for="nombre" class="form-label">Nombre</label>
            <input type="text" class="form-control" id="nombre" required="true" name="nombre">
        </div>
        <div class="mb-3">
            <label for="departamento" class="form-label">Departamento</label>
            <input type="text" class="form-control" id="departamento" required="true" name="departamento">
        </div>
        <div class="mb-3">
            <label for="sueldo" class="form-label">Sueldo</label>
            <input type="number" class="form-control" step="any" id="sueldo" required="true" name="sueldo">
        </div>
        <div class="text-center">
            <button type="submit" class="btn btn-warning btn-sm me-3">Agregar</button>
            <a href="${urlInicio}" class="btn btn-danger btn-sm">Regresar</a>
        </div>

    </form>
</div>



<%@ include file="comunes/pie-pagina.jsp"%>